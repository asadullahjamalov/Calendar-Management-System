package com.company.calendarmanagementsystem.repository;

import com.company.calendarmanagementsystem.entity.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepo extends JpaRepository<EventType, Long> {
}
