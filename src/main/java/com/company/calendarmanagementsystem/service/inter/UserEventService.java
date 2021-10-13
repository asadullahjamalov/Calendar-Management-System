package com.company.calendarmanagementsystem.service.inter;

import com.company.calendarmanagementsystem.dto.UserEventRequestDto;
import com.company.calendarmanagementsystem.dto.UserEventResponseDto;

public interface UserEventService {
    UserEventResponseDto createUserEvent(String token, UserEventRequestDto requestDto);
}
