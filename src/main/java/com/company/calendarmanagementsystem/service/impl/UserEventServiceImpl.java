package com.company.calendarmanagementsystem.service.impl;

import com.company.calendarmanagementsystem.dto.UserEventRequestDto;
import com.company.calendarmanagementsystem.dto.UserEventResponseDto;
import com.company.calendarmanagementsystem.entity.UserEvent;
import com.company.calendarmanagementsystem.mapper.UserEventMapper;
import com.company.calendarmanagementsystem.repository.ColorTypeRepo;
import com.company.calendarmanagementsystem.repository.UserEventRepo;
import com.company.calendarmanagementsystem.repository.UserRepo;
import com.company.calendarmanagementsystem.service.inter.UserEventService;
import com.company.calendarmanagementsystem.util.ColorAssigningUtil;
import com.company.calendarmanagementsystem.util.JwtTokenUtil;
import org.springframework.stereotype.Service;

@Service
public class UserEventServiceImpl implements UserEventService {

    private final UserEventRepo userEventRepo;
    private final UserEventMapper userEventMapper;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepo userRepo;
    private final ColorAssigningUtil colorAssigningUtil;
    private final ColorTypeRepo colorTypeRepo;

    public UserEventServiceImpl(UserEventRepo userEventRepo, UserEventMapper userEventMapper,
                                JwtTokenUtil jwtTokenUtil, UserRepo userRepo,
                                ColorAssigningUtil colorAssigningUtil, ColorTypeRepo colorTypeRepo) {
        this.userEventRepo = userEventRepo;
        this.userEventMapper = userEventMapper;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepo = userRepo;
        this.colorAssigningUtil = colorAssigningUtil;
        this.colorTypeRepo = colorTypeRepo;
    }

    @Override
    public UserEventResponseDto createUserEvent(String token, UserEventRequestDto requestDto) {
        UserEvent userEvent = userEventMapper.requestDtoToEntity(requestDto);
        userEvent.setUser(userRepo.getUserByUsername(jwtTokenUtil.getUsernameFromToken(token)));
        if (userEvent.getEventType().isWeekend() || userEvent.getEventType().isHoliday()) {
            userEvent.setColorType(colorTypeRepo.getHolidayOrWeekendColorType());
        } else {
            userEvent = colorAssigningUtil.setColorTypeByDate(userEvent);
        }
        return userEventMapper.entityToResponseDto(userEventRepo.save(userEvent));
    }
}
