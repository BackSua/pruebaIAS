package com.example.prueba001.service.Impl;

import com.example.prueba001.Util.Validaciones;
import com.example.prueba001.dto.ResponseDTO;
import com.example.prueba001.dto.VuelosInDTO;
import com.example.prueba001.dto.VuelosOutDTO;
import com.example.prueba001.entity.ReservaEntity;
import com.example.prueba001.exception.ApiException;
import com.example.prueba001.repository.ReservaRepository;
import com.example.prueba001.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    @Override
    public ResponseDTO findByReserva(VuelosInDTO vuelosInDTO) {

        Validaciones.validacionSoloNumeros(vuelosInDTO.getIdReserva().toString(), "idReserva");
        Validaciones.validacionSoloNumeros(vuelosInDTO.getIdUsuario().toString(), "idUsuario");
        Validaciones.validacionSoloNumeros(vuelosInDTO.getIdVuelo().toString(), "idVuelo");
        Validaciones.validacionSoloNumeros(vuelosInDTO.getIdTiquete().toString(), "idTiquete");
        Validaciones.validacionSoloLetras(vuelosInDTO.getCiudad(), "ciudad");

        ReservaEntity reserva = reservaRepository.findByIdUsuarioAndIdVueloAndIdTiqueteAndCiudadAndId(
                vuelosInDTO.getIdUsuario(),
                vuelosInDTO.getIdVuelo(),
                vuelosInDTO.getIdTiquete(),
                vuelosInDTO.getCiudad(),
                vuelosInDTO.getIdReserva()
        ).orElseThrow(
                () -> new ApiException(HttpStatus.PARTIAL_CONTENT.value(), "No se encontro informacion en base de datos."));

        return ResponseDTO.builder()
                .data(map(reserva))
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .build();
    }

    private VuelosOutDTO map(ReservaEntity reserva) {
        return VuelosOutDTO.builder()
                .idReserva(reserva.getId())
                .idUsuario(reserva.getIdUsuario())
                .idVuelo(reserva.getIdVuelo())
                .idTiquete(reserva.getIdTiquete())
                .ciudad(reserva.getCiudad())
                .build();
    }

}
