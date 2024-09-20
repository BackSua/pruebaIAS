package com.example.prueba001.service;

import com.example.prueba001.dto.ResponseDTO;
import com.example.prueba001.dto.VuelosInDTO;

public interface ReservaService {

    /**
     * Mertodo encargado de realizar la busqueda de la reserva por su identificador unico
     *
     * @param vuelosInDTO Parametros de busqueda
     * @return Dto con la informacion de la reserva
     */
    ResponseDTO findByReserva(VuelosInDTO vuelosInDTO);

}
