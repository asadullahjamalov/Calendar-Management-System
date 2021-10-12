package com.company.calendarmanagementsystem.mapper;

import com.company.calendarmanagementsystem.dto.UserRequestDto;
import com.company.calendarmanagementsystem.dto.UserResponseDto;
import com.company.calendarmanagementsystem.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User requestDtoToEntity(UserRequestDto dto);

    UserResponseDto entityToResponseDto(User entity);
}