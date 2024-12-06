package com.Ritik.Security01.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ritik.Security01.model.AppUsers;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<AppUsers, Integer> {

    AppUsers findByUsername(String username);

}
