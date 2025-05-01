package com.deatr.xylli.speatr.infra;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class TrackedEntityListener {


    @PrePersist
    void onSave(TrackedEntity trackedEntity) {
        trackedEntity.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    void onUpdate(TrackedEntity trackedEntity) {
        trackedEntity.setUpdatedAt(LocalDateTime.now());
    }

}

