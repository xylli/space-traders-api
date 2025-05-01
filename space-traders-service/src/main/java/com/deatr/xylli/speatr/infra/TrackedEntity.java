package com.deatr.xylli.speatr.infra;

import java.time.LocalDateTime;

public interface TrackedEntity {
    void setCreatedAt(LocalDateTime createdAt);

    LocalDateTime getCreatedAt();

    void setUpdatedAt(LocalDateTime createdAt);

    LocalDateTime getUpdatedAt();

}
