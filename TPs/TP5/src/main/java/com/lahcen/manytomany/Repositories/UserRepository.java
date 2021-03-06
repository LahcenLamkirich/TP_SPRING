package com.lahcen.manytomany.Repositories;

import com.lahcen.manytomany.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Query("select u from User u")
    List<User> findAllUsers();
}
