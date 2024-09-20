package com.example.prueba001.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VuelosOutDTO {

    private Long idReserva;
    private Long idUsuario;
    private Long idVuelo;
    private Long idTiquete;
    private String ciudad;

}
