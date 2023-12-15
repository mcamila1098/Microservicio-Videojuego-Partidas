package com.example.videojuegopartidas.config;

import com.example.videojuegopartidas.handler.ExampleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Configuration
public class WebFluxConfig {

    @Bean
    public RouterFunction<ServerResponse> route(ExampleHandler handler) {
        return RouterFunctions
                .route(GET("/example").and(accept(APPLICATION_JSON)), handler::getExample);
    }
}
