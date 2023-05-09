package com.deatr.xylli.speatr.config;

import com.deatr.xylli.speatr.client.AgentClient;
import com.deatr.xylli.speatr.client.SystemClient;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.Duration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(AppProperties.class)
@RequiredArgsConstructor
public class AppConfig {

    private final AppProperties appProperties;

    @Bean
    public WebClient spaceTradersApiClient() {
        return WebClient.builder()
                .baseUrl(appProperties.spaceTradersApi().baseUrl())
                .defaultHeaders(
                        httpHeaders -> httpHeaders.setBearerAuth(appProperties.spaceTradersApi().accessToken())
                )
                .build();
    }

    @Bean
    public AgentClient agentClient(WebClient spaceTradersApiClient) {
        return HttpServiceProxyFactory.builder()
                .clientAdapter(WebClientAdapter.forClient(spaceTradersApiClient))
                .blockTimeout(Duration.ofSeconds(30))
                .build()
                .createClient(AgentClient.class);
    }

    @Bean
    public SystemClient systemClient(WebClient spaceTradersApiClient) {
        return HttpServiceProxyFactory.builder()
                .clientAdapter(WebClientAdapter.forClient(spaceTradersApiClient))
                .blockTimeout(Duration.ofSeconds(30))
                .build()
                .createClient(SystemClient.class);
    }

}
