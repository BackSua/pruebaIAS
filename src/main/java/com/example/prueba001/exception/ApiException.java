package com.example.prueba001.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiException extends RuntimeException{

    private final int httpStatus;
    private final String mensaje;

}
