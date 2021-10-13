package com.company.calendarmanagementsystem.service.impl;

import com.company.calendarmanagementsystem.dto.ColorTypeRequestDto;
import com.company.calendarmanagementsystem.dto.ColorTypeResponseDto;
import com.company.calendarmanagementsystem.entity.ColorType;
import com.company.calendarmanagementsystem.exception.ColorTypeNotFound;
import com.company.calendarmanagementsystem.mapper.ColorTypeMapper;
import com.company.calendarmanagementsystem.model.ExceptionResponse;
import com.company.calendarmanagementsystem.repository.ColorTypeRepo;
import com.company.calendarmanagementsystem.service.inter.ColorTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorTypeServiceImpl implements ColorTypeService {

    private final ColorTypeRepo colorTypeRepo;
    private final ColorTypeMapper colorTypeMapper;

    public ColorTypeServiceImpl(ColorTypeRepo colorTypeRepo, ColorTypeMapper colorTypeMapper) {
        this.colorTypeRepo = colorTypeRepo;
        this.colorTypeMapper = colorTypeMapper;
    }

    @Override
    public ColorTypeResponseDto createColorType(ColorTypeRequestDto requestDto) {
        System.out.println(requestDto);
        return colorTypeMapper.entityToResponseDto(colorTypeRepo.save(colorTypeMapper.requestDtoToEntity(requestDto)));
    }

    @Override
    public ColorTypeResponseDto getColorTypeById(long id) {
        ColorType colorType = colorTypeRepo.findById(id)
                .orElseThrow(() -> new ColorTypeNotFound(
                        new ExceptionResponse("Color type not found", 404)));
        return colorTypeMapper.entityToResponseDto(colorType);
    }

    @Override
    public List<ColorTypeResponseDto> getAllColorTypes() {
        List<ColorType> colorTypeList = colorTypeRepo.findAll();
        return colorTypeMapper.entityListToResponseDtoList(colorTypeList);
    }

    @Override
    public ColorTypeResponseDto updateColorTypeById(ColorTypeRequestDto requestDto, long id) {
        ColorType colorType = colorTypeRepo.findById(id)
                .orElseThrow(() -> new ColorTypeNotFound(
                        new ExceptionResponse("Color type not found", 404)));
        colorType.setColorType(requestDto.getColorType());
        colorType.setActivationDay(requestDto.getActivationDay());
        colorType.setDefault(requestDto.isDefault());
        colorType.setHolidayOrWeekend(requestDto.isHolidayOrWeekend());
        return colorTypeMapper.entityToResponseDto(colorTypeRepo.save(colorType));
    }

    @Override
    public void deleteColorTypeById(long id) {
        if (colorTypeRepo.existsById(id)) {
            colorTypeRepo.deleteById(id);
        } else {
            throw new ColorTypeNotFound(new ExceptionResponse("Color type not found", 404));
        }
    }

}