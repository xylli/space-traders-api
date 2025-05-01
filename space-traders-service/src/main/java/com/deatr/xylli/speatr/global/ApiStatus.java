package com.deatr.xylli.speatr.global;

import com.deatr.xylli.speatr.infra.BaseEntity;
import com.deatr.xylli.speatr.infra.TrackedEntity;
import com.deatr.xylli.speatr.infra.TrackedEntityListener;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(TrackedEntityListener.class)
public class ApiStatus extends BaseEntity implements TrackedEntity {

    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    private String version;
    private String status;
    private LocalDate lastResetDate;

    private LocalDateTime serverResetNextDate;
    private String serverResetFrequency;


}
