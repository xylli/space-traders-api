package com.deatr.xylli.speatr.dto;

import com.deatr.xylli.speatr.util.ValidationUtils;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@Valid
public record DataListWrapper<T>(List<T> data, ListMeta meta) {

    @Valid
    public record ListMeta(int total, int page, int limit) {

        public int getLastPage() {
            return Math.ceilDiv(total, limit);
        }
    }

    public Optional<T> findFirst() {
        return data.stream().findFirst();
    }

    public T requireFirst() {
        return findFirst()
                .orElseThrow(ValidationUtils.requiredExceptionSupplier());
    }

}
