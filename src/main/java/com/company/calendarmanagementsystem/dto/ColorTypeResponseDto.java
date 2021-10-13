package com.company.calendarmanagementsystem.dto;

public class ColorTypeResponseDto {
    private long id;
    private String colorType;
    private Integer activationDay;
    private boolean isDefault;
    private boolean isHolidayOrWeekend;


    public ColorTypeResponseDto() {
    }

    public ColorTypeResponseDto(long id, String colorType, Integer activationDay,
                                boolean isDefault, boolean isHolidayOrWeekend) {
        this.id = id;
        this.colorType = colorType;
        this.activationDay = activationDay;
        this.isDefault = isDefault;
        this.isHolidayOrWeekend = isHolidayOrWeekend;
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
