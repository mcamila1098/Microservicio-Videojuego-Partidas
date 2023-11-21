package com.example.videojuegopartidas.repositories;

import com.example.videojuegopartidas.models.DatosPartida;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface DatosPartidaRepository extends R2dbcRepository<DatosPartida, Integer> {
}
