package com.company.calendarmanagementsystem.dto;

public class EventTypeRequestDto {
    private String eventType;
    private boolean isHoliday;
    private boolean isWeekend;

    public EventTypeRequestDto() {
    }

    public EventTypeRequestDto(String eventType, boolean isHoliday, boolean isWeekend) {
        this.eventType = eventType;
        this.isHoliday = isHoliday;
        this.isWeekend = isWeekend;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public void setHoliday(boolean holiday) {
        isHoliday = holiday;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }
}
