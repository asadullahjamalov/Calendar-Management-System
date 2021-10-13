package com.company.calendarmanagementsystem.mapper;

import com.company.calendarmanagementsystem.dto.UserEventRequestDto;
import com.company.calendarmanagementsystem.dto.UserEventResponseDto;
import com.company.calendarmanagementsystem.entity.UserEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserEventMapper {

    UserEventMapper INSTANCE = Mappers.getMapper(UserEventMapper.class);

    @Mappings({
            @Mapping(target = "eventType.id", source = "dto.eventTypeId"),
    })
    UserEvent requestDtoToEntity(UserEventRequestDto dto);

    @Mappings({
            @Mapping(target = "eventTypeId", source = "eventType.id"),
            @Mapping(target = "colorTypeId", source = "colorType.id"),
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "eventType", source = "eventType.eventType"),
            @Mapping(target = "color", source = "colorType.colorType")
    })
    UserEventResponseDto entityToResponseDto(UserEvent entity);
}
