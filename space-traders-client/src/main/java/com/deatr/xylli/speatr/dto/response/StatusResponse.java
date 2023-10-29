package com.deatr.xylli.speatr.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

public record StatusResponse(
        @NotBlank String status,
        @NotBlank String version,
        @NotNull LocalDate resetDate,
        @NotBlank String description,
        @NotNull Stats stats,
        @NotNull Leaderboard leaderboards,
        @NotNull ServerReset serverResets,
        @NotNull List<@NotNull Announcement> announcements,
        @NotNull List<@NotNull SpeatrLink> links
        ) {

    public record Stats(
        @Positive int agents,
        @Positive int ships,
        @Positive int systems,
        @Positive int waypoints
    ) {}

    public record Leaderboard(
        @NotEmpty List<@NotNull LeaderboardCreditAgent> mostCredits,
        @NotEmpty List<@NotNull LeaderboardChartAgent> mostSubmittedCharts
    ) {
        public record LeaderboardCreditAgent(@NotBlank String agentSymbol, long credits) {}
        public record LeaderboardChartAgent(@NotBlank String agentSymbol, long chartCount) {}


    }

    public record ServerReset(
            @NotBlank String next,
            @NotBlank String frequency
    ) {}

    public record Announcement(
            @NotBlank String title,
            @NotBlank String body
    ){}

    public record SpeatrLink(
            @NotBlank String name,
            @NotBlank String url
    ){}
}
