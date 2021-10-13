package com.company.calendarmanagementsystem.controller;

import com.company.calendarmanagementsystem.dto.UserEventRequestDto;
import com.company.calendarmanagementsystem.dto.UserEventResponseDto;
import com.company.calendarmanagementsystem.service.inter.UserEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("api/user-events")
public class UserEventController {

    private final UserEventService userEventService;

    public UserEventController(UserEventService userEventService) {
        this.userEventService = userEventService;
    }


    @PostMapping
    public ResponseEntity<UserEventResponseDto> createUserEvent(@RequestHeader("Authorization") String token,
                                                                   @RequestBody UserEventRequestDto requestDto) {
        log.info("Posting User Event");
        return new ResponseEntity<>(userEventService.createUserEvent(token.substring(7), requestDto), HttpStatus.CREATED);
    }
}
