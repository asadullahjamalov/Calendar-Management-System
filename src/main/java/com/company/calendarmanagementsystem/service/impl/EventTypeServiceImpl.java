package com.company.calendarmanagementsystem.service.impl;

import com.company.calendarmanagementsystem.dto.EventTypeRequestDto;
import com.company.calendarmanagementsystem.dto.EventTypeResponseDto;
import com.company.calendarmanagementsystem.entity.EventType;
import com.company.calendarmanagementsystem.exception.ColorTypeNotFound;
import com.company.calendarmanagementsystem.exception.EventTypeNotFound;
import com.company.calendarmanagementsystem.mapper.EventTypeMapper;
import com.company.calendarmanagementsystem.model.ExceptionResponse;
import com.company.calendarmanagementsystem.repository.EventTypeRepo;
import com.company.calendarmanagementsystem.service.inter.EventTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTypeServiceImpl implements EventTypeService {
    
    private final EventTypeRepo eventTypeRepo;
    private final EventTypeMapper eventTypeMapper;

    public EventTypeServiceImpl(EventTypeRepo eventTypeRepo, EventTypeMapper eventTypeMapper) {
        this.eventTypeRepo = eventTypeRepo;
        this.eventTypeMapper = eventTypeMapper;
    }

    @Override
    public EventTypeResponseDto createEventType(EventTypeRequestDto requestDto) {
        return eventTypeMapper.entityToResponseDto(
                eventTypeRepo.save(eventTypeMapper.requestDtoToEntity(requestDto)));
    }

    @Override
    public EventTypeResponseDto getEventTypeById(long id) {
        EventType eventType = eventTypeRepo.findById(id)
                .orElseThrow(() -> new EventTypeNotFound(
                        new ExceptionResponse("Event type not found", 404)));
        return eventTypeMapper.entityToResponseDto(eventType);
    }

    @Override
    public List<EventTypeResponseDto> getAllEventTypes() {
        List<EventType> eventTypeList = eventTypeRepo.findAll();
        return eventTypeMapper.entityListToResponseDtoList(eventTypeList);
    }

    @Override
    public EventTypeResponseDto updateEventTypeById(EventTypeRequestDto requestDto, long id) {
        EventType eventType = eventTypeRepo.findById(id)
                .orElseThrow(() -> new EventTypeNotFound(
                        new ExceptionResponse("Event type not found", 404)));
        eventType.setEventType(requestDto.getEventType());
        return eventTypeMapper.entityToResponseDto(eventTypeRepo.save(eventType));
    }

    @Override
    public void deleteEventTypeById(long id) {
        if (eventTypeRepo.existsById(id)) {
            eventTypeRepo.deleteById(id);
        } else {
            throw new EventTypeNotFound(new ExceptionResponse("Event type not found", 404));
        }
    }
}
