package com.company.calendarmanagementsystem.mapper;

import com.company.calendarmanagementsystem.dto.EventTypeRequestDto;
import com.company.calendarmanagementsystem.dto.EventTypeResponseDto;
import com.company.calendarmanagementsystem.entity.EventType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventTypeMapper {

    EventTypeMapper INSTANCE = Mappers.getMapper(EventTypeMapper.class);

    EventType requestDtoToEntity(EventTypeRequestDto dto);

    EventTypeResponseDto entityToResponseDto(EventType entity);

    List<EventTypeResponseDto> entityListToResponseDtoList(List<EventType> entityList);
}
