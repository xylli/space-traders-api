package com.deatr.xylli.speatr.dto;

import jakarta.validation.Valid;

import java.util.List;

@Valid
public record DataListWrapper<T>(List<T> data, ListMeta meta) {

    @Valid
    public record ListMeta(int total, int page, int limit) {
    }

}
