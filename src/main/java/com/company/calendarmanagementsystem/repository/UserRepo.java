package com.company.calendarmanagementsystem.repository;

import com.company.calendarmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "select u from User u where u.username=:username")
    User getUserByUsername(String username);
}
