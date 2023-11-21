package com.example.videojuegopartidas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import jakarta.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "datos_partida")
public class DatosPartida {

    @Id
    @jakarta.persistence.Id
    private Integer id;
    private String tipoPartida;
    private String rolPartida;
    private String ligaPartida;

    @OneToOne(mappedBy = "datos_partida")
    private Jugador jugador;
}
