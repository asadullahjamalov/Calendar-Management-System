package com.company.calendarmanagementsystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "color_types")
public class ColorType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String colorType;
    private Integer activationDay;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colorType", fetch = FetchType.LAZY)
    private List<Event> events;

    public ColorType() {
    }

    public ColorType(long id, String colorType, Integer activationDay, List<Event> events) {
        this.id = id;
        this.colorType = colorType;
        this.activationDay = activationDay;
        this.events = events;
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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
