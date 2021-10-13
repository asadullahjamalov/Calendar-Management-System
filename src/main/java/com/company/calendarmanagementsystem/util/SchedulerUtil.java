package com.company.calendarmanagementsystem.util;

import com.company.calendarmanagementsystem.entity.UserEvent;
import com.company.calendarmanagementsystem.repository.UserEventRepo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerUtil {
    private final UserEventRepo userEventRepo;
    private final ColorAssigningUtil colorAssigningUtil;

    public SchedulerUtil(UserEventRepo userEventRepo, ColorAssigningUtil colorAssigningUtil) {
        this.userEventRepo = userEventRepo;
        this.colorAssigningUtil = colorAssigningUtil;
    }

    @Scheduled(cron = "0 0 1 * * ?", zone = "Asia/Baku")
    public void updateColorOfUserEvents() {
        for (UserEvent userEvent : userEventRepo.findAll()) {
            userEvent = colorAssigningUtil.setColorTypeByDate(userEvent);
            userEventRepo.save(userEvent);
        }
    }
}
