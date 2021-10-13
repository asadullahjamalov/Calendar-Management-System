package com.company.calendarmanagementsystem.dto;

public class ColorTypeRequestDto {
    private String colorType;
    private Integer activationDay;

    public ColorTypeRequestDto() {
    }

    public ColorTypeRequestDto(String colorType, Integer activationDay) {
        this.colorType = colorType;
        this.activationDay = activationDay;
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
