package com.example.prueba001.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VuelosInDTO {

    private Long idUsuario;
    private Long idVuelo;
    private Long idTiquete;
    private String ciudad;
    private Long idReserva;

}
