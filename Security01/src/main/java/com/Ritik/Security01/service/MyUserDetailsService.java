package com.Ritik.Security01.service;

import com.Ritik.Security01.model.UserPrincipal;
import com.Ritik.Security01.model.AppUsers; // Renamed custom User entity
import com.Ritik.Security01.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private userRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from the repository
        AppUsers user = repo.findByUsername(username); // Use the renamed entity class

        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println("user found");

        // Return a UserPrincipal object
        return new UserPrincipal(user);
    }
}
