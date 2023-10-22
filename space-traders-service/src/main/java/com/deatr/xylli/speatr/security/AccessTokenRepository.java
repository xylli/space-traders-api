package com.deatr.xylli.speatr.security;

import reactor.core.publisher.Mono;

public interface AccessTokenRepository {

    Mono<String> loadAccessToken();
}
