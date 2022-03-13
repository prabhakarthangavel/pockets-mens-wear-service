package com.pockets.menswear.controller;

import com.pockets.menswear.request.LoginRequest;
import com.pockets.menswear.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthenticateController {

    @PostMapping("/loginUser")
    public ResponseEntity<Response> loginUser(@RequestBody final LoginRequest loginRequest) {
        return ResponseEntity.ok().body(new Response("success"));
    }
}
