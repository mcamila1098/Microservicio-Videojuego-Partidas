package com.example.videojuegopartidas.repositories;

import com.example.videojuegopartidas.models.Personaje;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PersonajeRepository extends R2dbcRepository<Personaje, Integer> {

    Flux<Personaje> findPersonajeByRoles(String roles);
}
