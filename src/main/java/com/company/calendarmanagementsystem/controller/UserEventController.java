package com.company.calendarmanagementsystem.controller;

import com.company.calendarmanagementsystem.dto.UserEventRequestDto;
import com.company.calendarmanagementsystem.dto.UserEventResponseDto;
import com.company.calendarmanagementsystem.service.inter.UserEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


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

    @GetMapping("/all")
    public ResponseEntity<List<UserEventResponseDto>> getUserEvents(@RequestHeader("Authorization") String token) {
        log.info("Getting All User Events");
        return new ResponseEntity<>(userEventService.getAllUserEvents(token.substring(7)), HttpStatus.OK);
    }

    @GetMapping("/{userEventId}")
    public ResponseEntity<UserEventResponseDto> getUserEventById(@RequestHeader("Authorization") String token,
                                                    @PathVariable Long userEventId) {
        log.info("Getting User Event by id");
        return new ResponseEntity<>(userEventService.getUserEventById(token.substring(7), userEventId), HttpStatus.OK);
    }

    @DeleteMapping("/{userEventId}")
    public ResponseEntity<Void> deleteUserEventById(@RequestHeader("Authorization") String token,
                                                    @PathVariable Long userEventId) {
        log.info("Delete User Event by id");
        userEventService.deleteUserEventById(token.substring(7), userEventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{userEventId}")
    public ResponseEntity<UserEventResponseDto> updateUserEventById(@RequestHeader("Authorization") String token,
                                                    @PathVariable Long userEventId, @RequestBody UserEventRequestDto requestDto) {
        log.info("Update User Event by id");
        return new ResponseEntity<>(userEventService.updateUserEventById(token.substring(7), userEventId, requestDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserEventResponseDto>> getUserEventsByDateInterval(@RequestHeader("Authorization") String token,
                                                                                  @RequestParam(value = "from") String from,
                                                                                  @RequestParam(value = "to") String to) {
        log.info("Getting All User Events in Date Interval");
        return new ResponseEntity<>(userEventService.getAllUserEventsByDateInterval(token.substring(7), LocalDate.parse(from), LocalDate.parse(to)), HttpStatus.OK);
    }
}
