package com.company.calendarmanagementsystem.dto;

public class ColorTypeResponseDto {
    private long id;
    private String colorType;
    private Integer activationDay;

    public ColorTypeResponseDto() {
    }

    public ColorTypeResponseDto(long id, String colorType, Integer activationDay) {
        this.id = id;
        this.colorType = colorType;
        this.activationDay = activationDay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public Integer getActivationDay() {
        return activationDay;
    }

    public void setActivationDay(Integer activationDay) {
        this.activationDay = activationDay;
    }
}
