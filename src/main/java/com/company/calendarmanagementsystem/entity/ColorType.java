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
    private boolean isDefault;
    private boolean isHolidayOrWeekend;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colorType", fetch = FetchType.LAZY)
    private List<UserEvent> userEvents;

    public ColorType() {
    }

    public ColorType(long id, String colorType, Integer activationDay, boolean isDefault,
                     boolean isHolidayOrWeekend, List<UserEvent> userEvents) {
        this.id = id;
        this.colorType = colorType;
        this.activationDay = activationDay;
        this.isDefault = isDefault;
        this.isHolidayOrWeekend = isHolidayOrWeekend;
        this.userEvents = userEvents;
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

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public boolean isHolidayOrWeekend() {
        return isHolidayOrWeekend;
    }

    public void setHolidayOrWeekend(boolean holidayOrWeekend) {
        isHolidayOrWeekend = holidayOrWeekend;
    }

    public List<UserEvent> getUserEvents() {
        return userEvents;
    }

    public void setUserEvents(List<UserEvent> userEvents) {
        this.userEvents = userEvents;
    }
}
