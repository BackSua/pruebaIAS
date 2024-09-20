package com.example.prueba001.service.Impl;

import com.example.prueba001.dto.ResponseDTO;
import com.example.prueba001.dto.VuelosInDTO;
import com.example.prueba001.entity.ReservaEntity;
import com.example.prueba001.exception.ApiException;
import com.example.prueba001.repository.ReservaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReservaServiceImplTest {

    @InjectMocks
    private ReservaServiceImpl reservaService;

    @Mock
    private ReservaRepository reservaRepository;

    @Test
    void findByReserva() {

        Mockito.when(reservaRepository.findByIdUsuarioAndIdVueloAndIdTiqueteAndCiudadAndId(
                Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any()
                ))
                .thenReturn(Optional.of(ReservaEntity.builder().id(1L).build()));


        ResponseDTO resp = reservaService.findByReserva(
                VuelosInDTO.builder()
                        .idVuelo(1L)
                        .idReserva(1L)
                        .idUsuario(1L)
                        .idTiquete(1L)
                        .ciudad("Neiva")
                        .build());
        Assertions.assertNotNull(resp);
        Assertions.assertEquals(HttpStatus.OK.value(), resp.getStatus());

    }

    @Test
    void findByReservaError() {

        Mockito.when(reservaRepository.findByIdUsuarioAndIdVueloAndIdTiqueteAndCiudadAndId(
                        Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any()
                )).thenThrow(new ApiException(HttpStatus.PARTIAL_CONTENT.value(), "No se encontro informacion en base de datos."));

        ApiException ex = Assertions.assertThrows(ApiException.class, () ->
                        reservaService.findByReserva(
                                VuelosInDTO.builder()
                                        .idVuelo(1L)
                                        .idReserva(1L)
                                        .idUsuario(1L)
                                        .idTiquete(1L)
                                        .ciudad("Neiva")
                                        .build())
                );

        Assertions.assertNotNull(ex);

    }

}