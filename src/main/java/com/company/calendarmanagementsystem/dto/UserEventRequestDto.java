package com.company.calendarmanagementsystem.dto;

import java.time.LocalDate;

public class UserEventRequestDto {
    private LocalDate date;
    private long eventTypeId;

    public UserEventRequestDto() {
    }

    public UserEventRequestDto(LocalDate date, long eventTypeId) {
        this.date = date;
        this.eventTypeId = eventTypeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(long eventTypeId) {
        this.eventTypeId = eventTypeId;
    }
}
