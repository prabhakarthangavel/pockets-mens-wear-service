package com.pockets.menswear.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String firstname;
    private String lastname;
    private String password;
}
