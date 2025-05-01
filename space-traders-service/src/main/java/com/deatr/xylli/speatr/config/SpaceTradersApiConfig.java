package com.deatr.xylli.speatr.config;

import com.deatr.speatr.api.*;
import com.deatr.speatr.invoker.ApiClient;
import com.deatr.xylli.speatr.dto.error.ErrorResponse;
import com.deatr.xylli.speatr.exception.NoContentException;
import com.deatr.xylli.speatr.exception.SpaceTradersApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@EnableConfigurationProperties(SpaceTradersApiProperties.class)
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
class SpaceTradersApiConfig {
    private final SpaceTradersApiProperties properties;

    @Bean
    ApiClient spaceTradersApiClient() {
        var webClient = startBasicSpaceTradersClient().build();
        return new ApiClient(webClient);
    }

    @Bean
    AgentsApi agentsApi(ApiClient apiClient) {
        return new AgentsApi(apiClient);
    }

    @Bean
    ContractsApi contractsApi(ApiClient apiClient) {
        return new ContractsApi(apiClient);
    }

    @Bean
    DataApi dataApi(ApiClient apiClient) {
        return new DataApi(apiClient);
    }

    @Bean
    FactionsApi factionsApi(ApiClient apiClient) {
        return new FactionsApi(apiClient);
    }

    @Bean
    FleetApi fleetApi(ApiClient apiClient) {
        return new FleetApi(apiClient);
    }

    @Bean
    GlobalApi globalApi(ApiClient apiClient) {
        return new GlobalApi(apiClient);
    }

    @Bean
    SystemsApi systemsApi(ApiClient apiClient) {
        return new SystemsApi(apiClient);
    }

    private WebClient.Builder startBasicSpaceTradersClient() {
        return WebClient.builder()
                .baseUrl(properties.baseUrl())
                .defaultStatusHandler(SpaceTradersApiConfig::isNoContentStatus, clientResponse -> Mono.error(new NoContentException()))
                .defaultStatusHandler(
                        HttpStatusCode::is4xxClientError,
                        clientResponse -> clientResponse.bodyToMono(ErrorResponse.class)
                                .flatMap(errorResponse -> Mono.error(new SpaceTradersApiException(errorResponse)))
                );
    }

    private static boolean isNoContentStatus(HttpStatusCode httpStatusCode) {
        return httpStatusCode.equals(HttpStatus.NO_CONTENT);
    }
}
