package com.example.videojuegopartidas.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Getter
@Setter
@Entity(name="personajes")
@Schema(description = "Personajes de la solución de VideoJuego")
public class Personaje {
    @Id
    @Schema(description = "Id unico del personaje", example = "2015")
    private Integer id;
    @Schema(description = "Nombre del personaje", example = "Miss Fortune" )
    private String nombre;
    @Schema(description = "Rol(es) del personaje", example = "ADC, Soporte" )
    private String roles;
    @Schema(description = "Dificultad del personaje", example = "Alta" )
    private String dificultad;
}
