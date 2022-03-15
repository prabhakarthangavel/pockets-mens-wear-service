package com.pockets.menswear.service.Impl;

import com.pockets.menswear.entity.Roles;
import com.pockets.menswear.entity.Users;
import com.pockets.menswear.exceptions.UserNameAlreadyExist;
import com.pockets.menswear.repo.UsersRepo;
import com.pockets.menswear.request.RegisterRequest;
import com.pockets.menswear.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public void createNewUser(RegisterRequest request) throws UserNameAlreadyExist {
        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setPassword(request.getPassword());
        Roles role = new Roles();
        role.setRole("USER");
        Set<Roles> set = new HashSet<>();
        set.add(role);
        user.setRoles(set);
        if(this.usersRepo.findByUsername(request.getUsername()) == null) {
            this.usersRepo.save(user);
        }else {
            throw new UserNameAlreadyExist("User Name Already Exist!");
        }
    }
}
