package com.example.videojuegopartidas.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ExampleHandler {
    public Mono<ServerResponse> getExample(ServerRequest request) {
        // Tu lógica para manejar la solicitud y generar una respuesta
        return ServerResponse.ok().bodyValue("Ejemplo de respuesta");
    }
}
