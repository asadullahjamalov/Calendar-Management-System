package com.company.calendarmanagementsystem.dto;

public class EventTypeResponseDto {
    private long id;
    private String eventType;

    public EventTypeResponseDto() {
    }

    public EventTypeResponseDto(long id, String eventType) {
        this.id = id;
        this.eventType = eventType;
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


}
