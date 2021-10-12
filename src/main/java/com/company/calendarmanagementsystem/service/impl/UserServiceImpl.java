package com.company.calendarmanagementsystem.service.impl;

import com.company.calendarmanagementsystem.dto.UserRequestDto;
import com.company.calendarmanagementsystem.dto.UserResponseDto;
import com.company.calendarmanagementsystem.entity.User;
import com.company.calendarmanagementsystem.exception.UserNotFound;
import com.company.calendarmanagementsystem.exception.UsernameIsNotUnique;
import com.company.calendarmanagementsystem.mapper.UserMapper;
import com.company.calendarmanagementsystem.model.ExceptionResponse;
import com.company.calendarmanagementsystem.repository.UserRepo;
import com.company.calendarmanagementsystem.service.inter.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDto addUser(UserRequestDto requestDto) {
        User foundUser = userRepo.getUserByUsername(requestDto.getUsername());
        if (foundUser != null) {
            throw new UsernameIsNotUnique(new ExceptionResponse("Username is not unique", 400));
        }

        String encPassword = new BCryptPasswordEncoder().encode(requestDto.getPassword());
        requestDto.setPassword(encPassword);

        User user = userRepo.save(userMapper.requestDtoToEntity(requestDto));
        return userMapper.entityToResponseDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.getUserByUsername(username);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(username, user.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UserNotFound(new ExceptionResponse("User not found with username: " + username, 404));
        }
    }
}
