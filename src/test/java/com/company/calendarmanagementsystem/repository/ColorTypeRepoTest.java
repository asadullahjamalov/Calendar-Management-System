package com.company.calendarmanagementsystem.repository;

import com.company.calendarmanagementsystem.entity.ColorType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ColorTypeRepoTest {

    @Autowired
    private ColorTypeRepo underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void getOrdinaryColorTypes() {
        ColorType colorType1 = new ColorType();
        colorType1.setDefault(true);
        underTest.save(colorType1);

        ColorType colorType2 = new ColorType();
        underTest.save(colorType2);

        ColorType colorType3 = new ColorType();
        underTest.save(colorType3);

        List<ColorType> colorTypeList = underTest.getOrdinaryColorTypes();

        assertThat(colorTypeList).isEqualTo(Arrays.asList(colorType2, colorType3));
    }

    @Test
    void getDefaultColorType() {
        ColorType colorType1 = new ColorType();
        colorType1.setDefault(true);
        underTest.save(colorType1);

        ColorType colorType2 = new ColorType();
        colorType2.setHolidayOrWeekend(true);
        underTest.save(colorType2);

        ColorType colorType3 = new ColorType();
        underTest.save(colorType3);

        ColorType colorType = underTest.getDefaultColorType();

        assertThat(colorType).isEqualTo(colorType1);
        assertThat(colorType).isNotEqualTo(colorType2);
        assertThat(colorType).isNotEqualTo(colorType3);
    }

    @Test
    void getHolidayOrWeekendColorType() {
        ColorType colorType1 = new ColorType();
        colorType1.setDefault(true);
        underTest.save(colorType1);

        ColorType colorType2 = new ColorType();
        colorType2.setHolidayOrWeekend(true);
        underTest.save(colorType2);

        ColorType colorType3 = new ColorType();
        underTest.save(colorType3);

        ColorType colorType = underTest.getHolidayOrWeekendColorType();

        assertThat(colorType).isNotEqualTo(colorType1);
        assertThat(colorType).isEqualTo(colorType2);
        assertThat(colorType).isNotEqualTo(colorType3);
    }
}