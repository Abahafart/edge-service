package com.arch.edgeservice.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import reactor.core.publisher.Mono;

@Configuration
public class WebEndpoints {

  @Bean//functional REST endpoints are defined in a bean
  public RouterFunction<ServerResponse> routes() {
    return RouterFunctions.route()
        //fallback response used to handle the GET endpoint
        .GET("catalog-fallback", request -> ServerResponse.ok().body(Mono.just(""), String.class))
        //fallback response used to handle the POST endpoint
        .POST("catalog-fallback", request -> ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).build())
        .build();
  }
}
