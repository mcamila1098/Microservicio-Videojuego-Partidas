package com.example.videojuegopartidas.repositories;

import com.example.videojuegopartidas.models.Jugador;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface JugadorRepository extends R2dbcRepository<Jugador, String> {
}
