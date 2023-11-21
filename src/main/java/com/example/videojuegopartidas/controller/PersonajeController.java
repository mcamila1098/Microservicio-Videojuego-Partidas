package com.example.videojuegopartidas.controller;

import com.example.videojuegopartidas.models.Personaje;
import com.example.videojuegopartidas.service.PersonajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/personajes")
@Tag(name = "Personajes", description = "Operaciones sobre los personajes de la aplicación VideoJuego")
public class PersonajeController {
    final PersonajeService personajeService;

    @PostMapping("/crear")
    @Operation(summary = "Crear un nuevo personaje", description = "Permite crear un nuevo personaje")
    public Mono<Personaje> crearPersonaje(@RequestBody Personaje personaje) {
        return personajeService.save(personaje);
    }

    @GetMapping("")
    @Operation(summary = "Consultar todos los personajes", description = "Permite consultar todos los personajes")
    @ApiResponse(responseCode = "200", description = "Personajes encontrados")
    public Flux<Personaje> consultarPersonajes() {
        return personajeService.findAll();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar personaje por Id", description = "Permite eliminar un personaje por Id")
    public Mono<Personaje> borrarPersonaje(@PathVariable Integer id){
        return personajeService.deleteById(id);
    }
}
