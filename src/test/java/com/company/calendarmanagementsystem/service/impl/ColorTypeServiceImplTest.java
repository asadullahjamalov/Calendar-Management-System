package com.company.calendarmanagementsystem.service.impl;

import com.company.calendarmanagementsystem.dto.ColorTypeRequestDto;
import com.company.calendarmanagementsystem.dto.ColorTypeResponseDto;
import com.company.calendarmanagementsystem.entity.ColorType;
import com.company.calendarmanagementsystem.mapper.ColorTypeMapper;
import com.company.calendarmanagementsystem.repository.ColorTypeRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

class ColorTypeServiceImplTest {
    @Mock
    private ColorTypeRepo colorTypeRepo;
    @Mock
    private ColorTypeMapper colorTypeMapper;


    private AutoCloseable autoCloseable;
    private ColorTypeServiceImpl underTest;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ColorTypeServiceImpl(colorTypeRepo, colorTypeMapper);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }


    @Test
    void createColorType() {
        ColorTypeRequestDto requestDto = new ColorTypeRequestDto();
        ColorTypeResponseDto responseDto = underTest.createColorType(requestDto);

        ColorType colorType = verify(colorTypeMapper).requestDtoToEntity(requestDto);
        colorType = verify(colorTypeRepo).save(colorType);
        ColorTypeResponseDto responseDto1 = verify(colorTypeMapper).entityToResponseDto(colorType);

        assertThat(responseDto).isEqualTo(responseDto1);
    }

    @Test
    void getColorTypeById() {
    }

    @Test
    void getAllColorTypes() {
        List<ColorTypeResponseDto> responseDtoList = underTest.getAllColorTypes();
        List<ColorType> colorTypeList = verify(colorTypeRepo).findAll();
    }

    @Test
    void updateColorTypeById() {
    }

    @Test
    void deleteColorTypeById() {
    }
}