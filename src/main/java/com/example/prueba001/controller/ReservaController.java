package com.example.prueba001.controller;

import com.example.prueba001.dto.ResponseDTO;
import com.example.prueba001.dto.VuelosInDTO;
import com.example.prueba001.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping(value = "airline")
    public ResponseDTO findByReserva(@RequestBody VuelosInDTO vuelosInDTO) {
        return reservaService.findByReserva(vuelosInDTO);
    }

}
