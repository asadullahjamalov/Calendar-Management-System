package com.company.calendarmanagementsystem.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class UserEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Boolean wasRead = false;
    private Boolean wasDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_type_id", referencedColumnName = "id")
    private EventType eventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_type_id", referencedColumnName = "id")
    private ColorType colorType;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public UserEvent() {
    }

    public UserEvent(Long id, LocalDate date, Boolean wasRead, Boolean wasDeleted,
                     EventType eventType, ColorType colorType, User user) {
        this.id = id;
        this.date = date;
        this.wasRead = wasRead;
        this.wasDeleted = wasDeleted;
        this.eventType = eventType;
        this.colorType = colorType;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getWasRead() {
        return wasRead;
    }

    public void setWasRead(Boolean wasRead) {
        this.wasRead = wasRead;
    }

    public Boolean getWasDeleted() {
        return wasDeleted;
    }

    public void setWasDeleted(Boolean wasDeleted) {
        this.wasDeleted = wasDeleted;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
