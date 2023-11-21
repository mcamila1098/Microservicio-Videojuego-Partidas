package com.example.videojuegopartidas.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API para el servicio de Videojuego: Partidas", version = "1.0",
        description = "API que expone los endpoints para las entidades de Personaje, Jugador y Datos Partida de la solución Videojuego (Servicio de Partidas)"))
public class SwaggerConfig {

}
