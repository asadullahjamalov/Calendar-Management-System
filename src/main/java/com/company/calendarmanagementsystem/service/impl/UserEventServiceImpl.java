package com.company.calendarmanagementsystem.service.impl;

import com.company.calendarmanagementsystem.dto.UserEventRequestDto;
import com.company.calendarmanagementsystem.dto.UserEventResponseDto;
import com.company.calendarmanagementsystem.entity.UserEvent;
import com.company.calendarmanagementsystem.exception.EventTypeNotFound;
import com.company.calendarmanagementsystem.exception.UserEventNotFound;
import com.company.calendarmanagementsystem.mapper.UserEventMapper;
import com.company.calendarmanagementsystem.model.ExceptionResponse;
import com.company.calendarmanagementsystem.repository.ColorTypeRepo;
import com.company.calendarmanagementsystem.repository.EventTypeRepo;
import com.company.calendarmanagementsystem.repository.UserEventRepo;
import com.company.calendarmanagementsystem.repository.UserRepo;
import com.company.calendarmanagementsystem.service.inter.UserEventService;
import com.company.calendarmanagementsystem.util.ColorAssigningUtil;
import com.company.calendarmanagementsystem.util.JwtTokenUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserEventServiceImpl implements UserEventService {

    private final UserEventRepo userEventRepo;
    private final UserEventMapper userEventMapper;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepo userRepo;
    private final ColorAssigningUtil colorAssigningUtil;
    private final ColorTypeRepo colorTypeRepo;
    private final EventTypeRepo eventTypeRepo;

    public UserEventServiceImpl(UserEventRepo userEventRepo, UserEventMapper userEventMapper,
                                JwtTokenUtil jwtTokenUtil, UserRepo userRepo,
                                ColorAssigningUtil colorAssigningUtil, ColorTypeRepo colorTypeRepo, EventTypeRepo eventTypeRepo) {
        this.userEventRepo = userEventRepo;
        this.userEventMapper = userEventMapper;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepo = userRepo;
        this.colorAssigningUtil = colorAssigningUtil;
        this.colorTypeRepo = colorTypeRepo;
        this.eventTypeRepo = eventTypeRepo;
    }

    @Override
    public UserEventResponseDto createUserEvent(String token, UserEventRequestDto requestDto) {
        UserEvent userEvent = userEventMapper.requestDtoToEntity(requestDto);
        userEvent.setUser(userRepo.getUserByUsername(jwtTokenUtil.getUsernameFromToken(token)));

        System.out.println(userEvent.getEventType().isWeekend());
        System.out.println(userEvent.getEventType().isHoliday());

        if (userEvent.getEventType().isWeekend() || userEvent.getEventType().isHoliday()) {
            userEvent.setColorType(colorTypeRepo.getHolidayOrWeekendColorType());
        } else {
            userEvent = colorAssigningUtil.setColorTypeByDate(userEvent);
        }
        return userEventMapper.entityToResponseDto(userEventRepo.save(userEvent));
    }

    @Override
    public List<UserEventResponseDto> getAllUserEvents(String token) {
        updateUserEventReadStatus(userEventRepo.getAllActiveUserEvents());
        return userEventMapper.entityListToResponseDtoList(userEventRepo.getAllActiveUserEvents());
    }

    @Override
    public UserEventResponseDto getUserEventById(String token, long id) {
        updateUserEventReadStatus(userEventRepo.findUserEventByIdAndWasDeletedIsFalse(id).orElseThrow(() ->
                new UserEventNotFound(new ExceptionResponse("User Event not found", 404))));
        return userEventMapper.entityToResponseDto(userEventRepo.findUserEventByIdAndWasDeletedIsFalse(id).get());
    }

    @Override
    public void deleteUserEventById(String token, long id) {
        userEventRepo.deleteUserEventById(id);
    }

    @Override
    public UserEventResponseDto updateUserEventById(String token, long id, UserEventRequestDto requestDto) {
        UserEvent userEvent = userEventRepo.findById(id).orElseThrow(() ->
                new UserEventNotFound(new ExceptionResponse("User Event not found", 404)));

        userEvent.setEventType(eventTypeRepo.findById(requestDto.getEventTypeId()).orElseThrow(() ->
                new EventTypeNotFound(new ExceptionResponse("Event type not found", 404))));
        userEvent.setDate(requestDto.getDate());

        if (userEvent.getEventType().isWeekend() || userEvent.getEventType().isHoliday()) {
            userEvent.setColorType(colorTypeRepo.getHolidayOrWeekendColorType());
        } else {
            userEvent = colorAssigningUtil.setColorTypeByDate(userEvent);
        }

        return userEventMapper.entityToResponseDto(userEventRepo.save(userEvent));
    }

    @Override
    public List<UserEventResponseDto> getAllUserEventsByDateInterval(String token, LocalDate from, LocalDate to) {
        updateUserEventReadStatus(userEventRepo.findAllUserEventsBetweenDate(from, to));
        return userEventMapper.entityListToResponseDtoList(userEventRepo.findAllUserEventsBetweenDate(from, to));
    }

    public void updateUserEventReadStatus(UserEvent userEvent){
        userEvent.setWasRead(true);
    }

    public void updateUserEventReadStatus(List<UserEvent> userEvents){
        userEvents.forEach(userEvent -> userEvent.setWasRead(true));
    }
}
