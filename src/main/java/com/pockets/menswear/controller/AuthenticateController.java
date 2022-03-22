package com.pockets.menswear.controller;

import com.pockets.menswear.auth.JwtUtil;
import com.pockets.menswear.auth.MyUserDetailsService;
import com.pockets.menswear.exceptions.UserNameAlreadyExist;
import com.pockets.menswear.request.LoginRequest;
import com.pockets.menswear.request.RegisterRequest;
import com.pockets.menswear.response.Response;
import com.pockets.menswear.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationService authService;

    @PostMapping("/loginUser")
    public ResponseEntity<Response> loginUser(@RequestBody final LoginRequest request) {
        String jwt = null;
        try {
            this.authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
            final UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUserName());
            jwt = this.jwtUtil.generateToken(userDetails);

        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body(new Response("Incorrect Username/Password"));
        }
        return ResponseEntity.ok(new Response(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<Response> createUser(@RequestBody RegisterRequest request) {
        try {
            request.setPassword(passwordEncoder.encode(request.getPassword()));
            this.authService.createNewUser(request);
            return ResponseEntity.ok().body(new Response("User Created Successfully!"));
        } catch (UserNameAlreadyExist ex) {
            return ResponseEntity.badRequest().body(new Response(ex.getMessage()));
        }
    }

}
