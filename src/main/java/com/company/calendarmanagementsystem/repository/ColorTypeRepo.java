package com.company.calendarmanagementsystem.repository;

import com.company.calendarmanagementsystem.entity.ColorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColorTypeRepo extends JpaRepository<ColorType, Long> {
    @Query("select c from ColorType c where c.isDefault=false and c.isHolidayOrWeekend=false ")
    List<ColorType> getOrdinaryColorTypes();

    @Query("select c from ColorType c where c.isDefault=true ")
    ColorType getDefaultColorType();

    @Query("select c from ColorType c where c.isHolidayOrWeekend=true ")
    ColorType getHolidayOrWeekendColorType();
}
