package com.pockets.menswear.auth;

import com.pockets.menswear.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pockets.menswear.entity.Users;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.usersRepo.findByUsername(username);
        MyUserDetails userDetails;
        if (user != null) {
            userDetails = new MyUserDetails();
            userDetails.setUser(user);
            userDetails.getAuthorities().forEach(System.out::println);
        } else {
            throw new UsernameNotFoundException("User not exist with name : " + username);
        }
        return userDetails;
    }

}

