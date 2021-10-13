package com.company.calendarmanagementsystem.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "event_types")
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String eventType;
    private boolean isHoliday;
    private boolean isWeekend;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventType", fetch = FetchType.LAZY)
    private List<UserEvent> userEvents;

    public EventType() {
    }

    public EventType(long id, String eventType, boolean isHoliday,
                     boolean isWeekend, List<UserEvent> userEvents) {
        this.id = id;
        this.eventType = eventType;
        this.isHoliday = isHoliday;
        this.isWeekend = isWeekend;
        this.userEvents = userEvents;
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

    public List<UserEvent> getUserEvents() {
        return userEvents;
    }

    public void setUserEvents(List<UserEvent> userEvents) {
        this.userEvents = userEvents;
    }
}

