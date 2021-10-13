package com.company.calendarmanagementsystem.repository;

import com.company.calendarmanagementsystem.entity.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEventRepo extends JpaRepository<UserEvent, Long> {
}
