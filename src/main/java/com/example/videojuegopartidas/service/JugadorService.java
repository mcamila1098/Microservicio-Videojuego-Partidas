package com.example.videojuegopartidas.service;

import com.example.videojuegopartidas.dto.DTOJugadorEntrada;
import com.example.videojuegopartidas.models.DatosPartida;
import com.example.videojuegopartidas.models.Jugador;
import com.example.videojuegopartidas.repositories.DatosPartidaRepository;
import com.example.videojuegopartidas.repositories.JugadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class JugadorService {

    private final JugadorRepository jugadorRepository;
    private final DatosPartidaRepository datosPartidaRepository;

    public Mono<DTOJugadorEntrada> crearJugador(DTOJugadorEntrada dtoJugadorEntrada){
        DatosPartida datosPartida = new DatosPartida();
        datosPartida.setTipoPartida(dtoJugadorEntrada.tipoPartida());
        datosPartida.setRolPartida(dtoJugadorEntrada.rolPartida());
        datosPartida.setLigaPartida(dtoJugadorEntrada.ligaPartida());

        Jugador jugador = new Jugador();
        jugador.setId(dtoJugadorEntrada.id());
        jugador.setNombreInvocador(dtoJugadorEntrada.nombreInvocador());
        jugador.setDatosPartida(datosPartida);

        return Mono.zip(
                datosPartidaRepository.save(datosPartida),
                jugadorRepository.save(jugador)
        ).map(tupla -> {
            DatosPartida datosPartidaCreado = tupla.getT1();
            Jugador jugadorCreado = tupla.getT2();
            return new DTOJugadorEntrada(
                    jugadorCreado.getId(),
                    jugadorCreado.getNombreInvocador(),
                    datosPartidaCreado.getTipoPartida(),
                    datosPartidaCreado.getRolPartida(),
                    datosPartidaCreado.getLigaPartida()
            );
        });
    }
}
