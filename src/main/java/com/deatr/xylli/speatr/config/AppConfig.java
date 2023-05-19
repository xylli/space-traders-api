package com.deatr.xylli.speatr.config;

import com.deatr.xylli.speatr.client.*;
import com.deatr.xylli.speatr.exception.NoContentException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(AppProperties.class)
@RequiredArgsConstructor
public class AppConfig {

    private final AppProperties appProperties;

    @Bean
    public WebClient spaceTradersApiClient() {
        return WebClient.builder()
                .baseUrl(appProperties.spaceTradersApi().baseUrl())
                .defaultHeaders(this::setDefaultHeaders)
                .defaultStatusHandler(AppConfig::isNoContentStatus, clientResponse -> Mono.error(new NoContentException()))
                .build();
    }

    private static boolean isNoContentStatus(HttpStatusCode httpStatusCode) {
        return httpStatusCode.equals(HttpStatus.NO_CONTENT);
    }

    private void setDefaultHeaders(HttpHeaders httpHeaders) {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBearerAuth(appProperties.spaceTradersApi().accessToken());
    }

    @Bean
    public AgentClient agentClient(WebClient spaceTradersApiClient) {
        return setupProxyClient(spaceTradersApiClient, AgentClient.class);
    }

    @Bean
    public SystemClient systemClient(WebClient spaceTradersApiClient) {
        return setupProxyClient(spaceTradersApiClient, SystemClient.class);
    }

    @Bean
    public ContractClient contractClient(WebClient spaceTradersApiClient) {
        return setupProxyClient(spaceTradersApiClient, ContractClient.class);
    }

    @Bean
    public FactionClient factionClient(WebClient spaceTradersApiClient) {
        return setupProxyClient(spaceTradersApiClient, FactionClient.class);
    }

    @Bean
    public FleetClient fleetClient(WebClient spaceTradersApiClient) {
        return setupProxyClient(spaceTradersApiClient, FleetClient.class);
    }

    private static <T> T setupProxyClient(WebClient spaceTradersApiClient, Class<T> clazz) {
        return HttpServiceProxyFactory.builder()
                .clientAdapter(WebClientAdapter.forClient(spaceTradersApiClient))
                .blockTimeout(Duration.ofSeconds(30))
                .build()
                .createClient(clazz);
    }

}
