package com.deatr.xylli.speatr.status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiStatusRepository extends JpaRepository<ApiStatus, Long> {

    Optional<ApiStatus> findFirstByOrderByCreatedAtDesc();

}