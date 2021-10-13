package com.company.calendarmanagementsystem.repository;

import com.company.calendarmanagementsystem.entity.UserEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserEventRepoTest {

    @Autowired
    private UserEventRepo underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void getAllActiveUserEvents() {
        UserEvent userEvent1 = new UserEvent();
        underTest.save(userEvent1);

        UserEvent userEvent2 = new UserEvent();
        underTest.save(userEvent2);

        UserEvent userEvent3 = new UserEvent();
        underTest.save(userEvent3);

        List<UserEvent> userEventList = underTest.getAllActiveUserEvents();

        assertThat(userEventList).isEqualTo(Arrays.asList(userEvent1, userEvent2, userEvent3));
    }

    @Test
    void deleteUserEventById() {
        UserEvent userEvent1 = new UserEvent();
        underTest.save(userEvent1);

        UserEvent userEvent2 = new UserEvent();
        underTest.save(userEvent2);

        UserEvent userEvent3 = new UserEvent();
        underTest.save(userEvent3);

        underTest.deleteUserEventById(userEvent1.getId());

        List<UserEvent> userEventList = underTest.getAllActiveUserEvents();

        assertThat(userEventList).isEqualTo(Arrays.asList(userEvent2, userEvent3));
        assertThat(userEventList).isNotEqualTo(Arrays.asList(userEvent1, userEvent2, userEvent3));

    }

    @Test
    void findUserEventByIdAndWasDeletedIsFalse() {
        UserEvent userEvent1 = new UserEvent();
        underTest.save(userEvent1);

        UserEvent userEvent = underTest.findUserEventByIdAndWasDeletedIsFalse(userEvent1.getId()).get();

        assertThat(userEvent).isEqualTo(userEvent1);
    }

    @Test
    void findAllUserEventsBetweenDate() {
        UserEvent userEvent1 = new UserEvent();
        userEvent1.setDate(LocalDate.parse("2021-10-11"));
        underTest.save(userEvent1);

        UserEvent userEvent2 = new UserEvent();
        userEvent2.setDate(LocalDate.parse("2021-10-15"));
        underTest.save(userEvent2);

        UserEvent userEvent3 = new UserEvent();
        userEvent3.setDate(LocalDate.parse("2021-11-30"));
        underTest.save(userEvent3);

        List<UserEvent> userEventList = underTest
                .findAllUserEventsBetweenDate(LocalDate.parse("2021-10-10"), LocalDate.parse("2021-10-20"));

        assertThat(userEventList).isEqualTo(Arrays.asList(userEvent1, userEvent2));

        assertThat(userEventList).isNotEqualTo(Arrays.asList(userEvent1, userEvent2, userEvent3));

    }
}