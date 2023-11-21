package com.example.videojuegopartidas.controller;

import com.example.videojuegopartidas.models.Personaje;
import com.example.videojuegopartidas.service.PersonajeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonajeControllerTest {

    @Mock
    private PersonajeService personajeService;

    @InjectMocks
    private PersonajeController personajeController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultarPersonajesExitoso(){
        Personaje personajeEsperado = new Personaje(4812, "Kayle", "Top","Baja");
        Personaje personajeEsperado2 = new Personaje(4813, "Rakan", "Soporte", "Alta");
        Flux<Personaje> personajesEsperados = Flux.just(personajeEsperado, personajeEsperado2);
        when(personajeService.findAll()).thenReturn(personajesEsperados);

        Flux<Personaje> resultado = personajeController.consultarPersonajes();
        resultado.subscribe(); //Se debe hacer porque estamos con un flujo
        assertEquals(personajesEsperados, resultado);
    }
}
