package com.example.videojuegopartidas.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Jugadores")
public class Jugador {

    @Id
    @jakarta.persistence.Id
    private String id;
    private String nombreInvocador;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private DatosPartida datosPartida;
}
