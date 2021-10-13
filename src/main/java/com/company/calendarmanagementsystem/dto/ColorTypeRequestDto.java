package com.company.calendarmanagementsystem.dto;

public class ColorTypeRequestDto {
    private String colorType;
    private Integer activationDay;
    private boolean isDefault;
    private boolean isHolidayOrWeekend;

    public ColorTypeRequestDto() {
    }

    public ColorTypeRequestDto(String colorType, Integer activationDay,
                               boolean isDefault, boolean isHolidayOrWeekend) {
        this.colorType = colorType;
        this.activationDay = activationDay;
        this.isDefault = isDefault;
        this.isHolidayOrWeekend = isHolidayOrWeekend;
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

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public boolean isHolidayOrWeekend() {
        return isHolidayOrWeekend;
    }

    public void setHolidayOrWeekend(boolean holidayOrWeekend) {
        isHolidayOrWeekend = holidayOrWeekend;
    }
}
