package com.deatr.xylli.speatr.dto;

import com.deatr.xylli.speatr.util.CommonUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record DataWrapper<T>(T data) {

    public DataWrapper<T> log() {
        log.info("Data: {}", CommonUtils.prettyPrint(this));
        return this;
    }

}
