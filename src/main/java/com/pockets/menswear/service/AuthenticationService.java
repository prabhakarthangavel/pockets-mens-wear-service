package com.pockets.menswear.service;

import com.pockets.menswear.exceptions.UserNameAlreadyExist;
import com.pockets.menswear.request.RegisterRequest;

public interface AuthenticationService {
    void createNewUser(RegisterRequest request) throws UserNameAlreadyExist;

    String getFullName(String username);
}
