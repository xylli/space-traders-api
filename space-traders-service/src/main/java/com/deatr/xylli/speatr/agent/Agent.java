package com.deatr.xylli.speatr.agent;

import com.deatr.speatr.model.FactionSymbol;
import com.deatr.xylli.speatr.infra.BaseEntity;
import com.deatr.xylli.speatr.infra.TrackedEntity;
import com.deatr.xylli.speatr.infra.TrackedEntityListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EntityListeners(TrackedEntityListener.class)
public class Agent extends BaseEntity implements TrackedEntity {

    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    private String symbol;
    @Enumerated(EnumType.STRING)
    private FactionSymbol faction;
    private String email;
    @Column(length = 3000)
    private String token;
}
