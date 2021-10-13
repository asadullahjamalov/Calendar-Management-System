package com.company.calendarmanagementsystem.controller;

import com.company.calendarmanagementsystem.dto.ColorTypeRequestDto;
import com.company.calendarmanagementsystem.dto.ColorTypeResponseDto;
import com.company.calendarmanagementsystem.service.inter.ColorTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/color-types")
public class ColorTypeController {
    private final ColorTypeService colorTypeService;

    public ColorTypeController(ColorTypeService colorTypeService) {
        this.colorTypeService = colorTypeService;
    }

    @PostMapping
    public ResponseEntity<ColorTypeResponseDto> createColorType(@RequestBody ColorTypeRequestDto requestDto) {
        log.info("Color type created successfully");
        return new ResponseEntity<>(colorTypeService.createColorType(requestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{colorTypeId}")
    public ResponseEntity<ColorTypeResponseDto> getColorTypeById(@PathVariable long colorTypeId) {
        log.info("Get color type by id successfully");
        return new ResponseEntity<>(colorTypeService.getColorTypeById(colorTypeId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ColorTypeResponseDto>> getAllColorTypes() {
        log.info("Get all color types successfully");
        return new ResponseEntity<>(colorTypeService.getAllColorTypes(), HttpStatus.OK);
    }

    @PutMapping("/{colorTypeId}")
    public ResponseEntity<ColorTypeResponseDto> updateColorTypeById(@RequestBody ColorTypeRequestDto requestDto,
                                                                    @PathVariable long colorTypeId) {
        log.info("Update color type by id successfully");
        return new ResponseEntity<>(colorTypeService.updateColorTypeById(requestDto, colorTypeId), HttpStatus.OK);
    }

    @DeleteMapping("/{colorTypeId}")
    public ResponseEntity<Void> deleteColorTypeById(@PathVariable long colorTypeId) {
        log.info("Delete color type by id successfully");
        colorTypeService.deleteColorTypeById(colorTypeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
