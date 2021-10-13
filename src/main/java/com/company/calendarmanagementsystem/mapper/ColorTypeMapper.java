package com.company.calendarmanagementsystem.mapper;

import com.company.calendarmanagementsystem.dto.ColorTypeRequestDto;
import com.company.calendarmanagementsystem.dto.ColorTypeResponseDto;
import com.company.calendarmanagementsystem.entity.ColorType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColorTypeMapper {

    ColorTypeMapper INSTANCE = Mappers.getMapper(ColorTypeMapper.class);

    ColorType requestDtoToEntity(ColorTypeRequestDto dto);

    ColorTypeResponseDto entityToResponseDto(ColorType entity);

    List<ColorTypeResponseDto> entityListToResponseDtoList(List<ColorType> entityList);
}
