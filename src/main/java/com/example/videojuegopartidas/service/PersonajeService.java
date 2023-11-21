package com.example.videojuegopartidas.service;

import com.example.videojuegopartidas.models.Personaje;
import com.example.videojuegopartidas.repositories.PersonajeRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PersonajeService {

    private final Logger LOGGER = LoggerFactory.getLogger(PersonajeService.class);

    private final PersonajeRepository personajeRepository;

    public Mono<Personaje> save(Personaje personaje) {return personajeRepository.save(personaje);}

    public Mono<Personaje> findById(Integer id){
        return personajeRepository.findById(id)
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar un personaje con id = "+ id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Personaje con id = "+ id + " no encontrado").getMostSpecificCause()));
    }

    public Flux<Personaje> findAll(){
        return personajeRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar todos los personajes", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ningún personaje encontrado").getMostSpecificCause()));
    }

    public Mono<Personaje> deleteById(Integer id){
        return personajeRepository.findById(id)
                .flatMap(personaje -> personajeRepository.deleteById(personaje.getId()).thenReturn(personaje))
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al borrar un personaje con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Personaje con id= " + id + " no borrado").getMostSpecificCause()));
    }

    public Mono<Void> deleteAll(){
        return personajeRepository.deleteAll()
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al borrar todos los personajes", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Personajes no borrados").getMostSpecificCause()));
    }
}
