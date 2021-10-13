package com.company.calendarmanagementsystem.repository;

import com.company.calendarmanagementsystem.entity.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserEventRepo extends JpaRepository<UserEvent, Long> {
    @Query("select u from UserEvent u where u.wasDeleted=false")
    List<UserEvent> getAllActiveUserEvents();

    @Modifying
    @Transactional
    @Query("update UserEvent u set u.wasDeleted=true where u.id= :id")
    void deleteUserEventById(Long id);

    Optional<UserEvent> findUserEventByIdAndWasDeletedIsFalse(long id);

    @Query("select u from UserEvent u where u.wasDeleted=false and u.date >= :first_date and u.date <= :second_date")
    List<UserEvent> findAllUserEventsBetweenDate(LocalDate first_date, LocalDate second_date);
}
