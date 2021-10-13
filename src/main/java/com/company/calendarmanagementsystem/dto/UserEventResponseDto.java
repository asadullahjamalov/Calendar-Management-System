package com.company.calendarmanagementsystem.dto;

import java.time.LocalDate;

public class UserEventResponseDto {
    private long id;
    private LocalDate date;
    private String color;
    private String eventType;
    private long colorTypeId;
    private long eventTypeId;
    private long userId;

    public UserEventResponseDto() {
    }

    public UserEventResponseDto(long id, LocalDate date, String color, String eventType,
                                long colorTypeId, long eventTypeId, long userId) {
        this.id = id;
        this.date = date;
        this.color = color;
        this.eventType = eventType;
        this.colorTypeId = colorTypeId;
        this.eventTypeId = eventTypeId;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public long getColorTypeId() {
        return colorTypeId;
    }

    public void setColorTypeId(long colorTypeId) {
        this.colorTypeId = colorTypeId;
    }

    public long getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(long eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
