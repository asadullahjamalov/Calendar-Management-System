package com.company.calendarmanagementsystem.dto;

public class EventTypeResponseDto {
    private long id;
    private String eventType;
    private boolean isHoliday;
    private boolean isWeekend;

    public EventTypeResponseDto() {
    }

    public EventTypeResponseDto(long id, String eventType,
                                boolean isHoliday, boolean isWeekend) {
        this.id = id;
        this.eventType = eventType;
        this.isHoliday = isHoliday;
        this.isWeekend = isWeekend;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
