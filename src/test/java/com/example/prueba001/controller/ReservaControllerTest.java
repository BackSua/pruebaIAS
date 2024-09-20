package com.example.prueba001.controller;

import com.example.prueba001.dto.ResponseDTO;
import com.example.prueba001.dto.VuelosInDTO;
import com.example.prueba001.service.ReservaService;
import jakarta.persistence.MapKeyJoinColumn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReservaControllerTest {

    @InjectMocks
    private ReservaController reservaController;

    @Mock
    private ReservaService reservaService;

    @Test
    void findByReserva() {
        Mockito.when(reservaService.findByReserva(Mockito.any()))
                .thenReturn(ResponseDTO.builder().build());

        ResponseDTO resp = reservaController.findByReserva(
                VuelosInDTO.builder()
                .idVuelo(1L)
                .idReserva(1L)
                .idUsuario(1L)
                .idTiquete(1L)
                .ciudad("Neiva")
                .build());
        Assertions.assertNotNull(resp);
    }

}