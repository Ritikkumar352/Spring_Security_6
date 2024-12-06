package com.Ritik.Security01.service;

import com.Ritik.Security01.model.AppUsers;
import com.Ritik.Security01.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private userRepo repo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JWTService jwt;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    public AppUsers register(AppUsers appUsers) {
        appUsers.setPassword(encoder.encode(appUsers.getPassword()));
        return repo.save(appUsers);
    }

    public String verify(AppUsers user){
        Authentication authentication=
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwt.generateToken(user.getUsername());
        }
        return "failed";

    }
}
