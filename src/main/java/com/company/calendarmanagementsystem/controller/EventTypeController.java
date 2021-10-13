package com.company.calendarmanagementsystem.controller;

import com.company.calendarmanagementsystem.dto.EventTypeRequestDto;
import com.company.calendarmanagementsystem.dto.EventTypeResponseDto;
import com.company.calendarmanagementsystem.service.inter.EventTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/event-types")
public class EventTypeController {
    private final EventTypeService eventTypeService;

    public EventTypeController(EventTypeService eventTypeService) {
        this.eventTypeService = eventTypeService;
    }

    @PostMapping
    public ResponseEntity<EventTypeResponseDto> createEventType(@RequestBody EventTypeRequestDto requestDto) {
        log.info("Event type created successfully");
        return new ResponseEntity<>(eventTypeService.createEventType(requestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{eventTypeId}")
    public ResponseEntity<EventTypeResponseDto> getEventTypeById(@PathVariable long eventTypeId) {
        log.info("Get Event type by id successfully");
        return new ResponseEntity<>(eventTypeService.getEventTypeById(eventTypeId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EventTypeResponseDto>> getAllEventTypes() {
        log.info("Get all Event types successfully");
        return new ResponseEntity<>(eventTypeService.getAllEventTypes(), HttpStatus.OK);
    }

    @PutMapping("/{eventTypeId}")
    public ResponseEntity<EventTypeResponseDto> updateEventTypeById(@RequestBody EventTypeRequestDto requestDto,
                                                                      @PathVariable long eventTypeId) {
        log.info("Update Event type by id successfully");
        return new ResponseEntity<>(eventTypeService.updateEventTypeById(requestDto, eventTypeId), HttpStatus.OK);
    }

    @DeleteMapping("/{eventTypeId}")
    public ResponseEntity<Void> deleteEventTypeById(@PathVariable long eventTypeId) {
        log.info("Delete event type by id successfully");
        eventTypeService.deleteEventTypeById(eventTypeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
