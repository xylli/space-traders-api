package com.deatr.xylli.speatr.security;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationFilterFunction implements ExchangeFilterFunction {
    @Nullable
    private AccessTokenRepository accessTokenRepository;

    @Override
    public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
        return Mono.justOrEmpty(accessTokenRepository)
                .flatMap(AccessTokenRepository::loadAccessToken)
                .map(token -> bearer(request, token))
                .defaultIfEmpty(request)
                .flatMap(next::exchange);
    }


    private ClientRequest bearer(ClientRequest request, String token) {
        return ClientRequest.from(request)
                .headers(headers -> headers.setBearerAuth(token))
                .build();
    }

    @Autowired
    @Lazy
    public void setAccessTokenRepository(AccessTokenRepository accessTokenRepository) {
        this.accessTokenRepository = accessTokenRepository;
    }
}
