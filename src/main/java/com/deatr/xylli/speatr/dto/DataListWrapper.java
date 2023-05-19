package com.deatr.xylli.speatr.dto;

import java.util.List;

public record DataListWrapper<T>(List<T> data, ListMeta meta) {

    public record ListMeta(int total, int page, int limit) {
    }

}
