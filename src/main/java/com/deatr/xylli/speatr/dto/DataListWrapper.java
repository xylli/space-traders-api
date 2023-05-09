package com.deatr.xylli.speatr.dto;

import java.util.List;

public record DataListWrapper<T>(List<T> data) {

    public record ListMeta(int total, int page, int limit) {
    }

}
