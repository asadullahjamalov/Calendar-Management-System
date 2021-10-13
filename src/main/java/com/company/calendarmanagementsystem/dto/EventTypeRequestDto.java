package com.company.calendarmanagementsystem.dto;

public class EventTypeRequestDto {
    private String eventType;

    public EventTypeRequestDto() {
    }

    public EventTypeRequestDto(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
