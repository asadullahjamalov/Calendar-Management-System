package com.company.calendarmanagementsystem.service.inter;

import com.company.calendarmanagementsystem.dto.ColorTypeRequestDto;
import com.company.calendarmanagementsystem.dto.ColorTypeResponseDto;

import java.util.List;

public interface ColorTypeService {
    ColorTypeResponseDto createColorType(ColorTypeRequestDto requestDto);

    ColorTypeResponseDto getColorTypeById(long id);

    List<ColorTypeResponseDto> getAllColorTypes();

    ColorTypeResponseDto updateColorTypeById(ColorTypeRequestDto requestDto, long id);

    void deleteColorTypeById(long id);
}

