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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventType", fetch = FetchType.LAZY)
    private List<Event> events;

    public EventType() {
    }

    public EventType(long id, String eventType, List<Event> events) {
        this.id = id;
        this.eventType = eventType;
        this.events = events;
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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}

