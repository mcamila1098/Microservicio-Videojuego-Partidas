package com.example.videojuegopartidas;

import io.r2dbc.spi.ConnectionFactory;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="API para el servicio de Videojuego: Partidas", version = "1.0",
		description = "API que expone los endpoints para la entidad personaje de la solución VideoJuego (Servicio de Jugadores)"))
public class VideojuegoPartidasApplication {

	@Bean
	ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory){
		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));

		return initializer;
	}

	public static void main(String[] args) {
		SpringApplication.run(VideojuegoPartidasApplication.class, args);
	}

}
