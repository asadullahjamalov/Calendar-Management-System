package com.company.calendarmanagementsystem.service.inter;

import com.company.calendarmanagementsystem.dto.UserEventRequestDto;
import com.company.calendarmanagementsystem.dto.UserEventResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface UserEventService {
    UserEventResponseDto createUserEvent(String token, UserEventRequestDto requestDto);

    List<UserEventResponseDto> getAllUserEvents(String token);

    UserEventResponseDto getUserEventById(String token, long id);

    void deleteUserEventById(String token, long id);

    UserEventResponseDto updateUserEventById(String token, long id, UserEventRequestDto requestDto);

    List<UserEventResponseDto> getAllUserEventsByDateInterval(String token, LocalDate from, LocalDate to);
}
