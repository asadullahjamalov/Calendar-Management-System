package com.company.calendarmanagementsystem.service.inter;

import com.company.calendarmanagementsystem.dto.EventTypeRequestDto;
import com.company.calendarmanagementsystem.dto.EventTypeResponseDto;

import java.util.List;

public interface EventTypeService {
    EventTypeResponseDto createEventType(EventTypeRequestDto requestDto);

    EventTypeResponseDto getEventTypeById(long id);

    List<EventTypeResponseDto> getAllEventTypes();

    EventTypeResponseDto updateEventTypeById(EventTypeRequestDto requestDto, long id);

    void deleteEventTypeById(long id);
}
