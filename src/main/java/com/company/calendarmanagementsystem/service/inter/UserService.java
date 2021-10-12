package com.company.calendarmanagementsystem.service.inter;

import com.company.calendarmanagementsystem.dto.UserRequestDto;
import com.company.calendarmanagementsystem.dto.UserResponseDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserResponseDto addUser(UserRequestDto requestDto);

    UserDetails loadUserByUsername(String username);
}