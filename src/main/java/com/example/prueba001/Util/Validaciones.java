package com.example.prueba001.Util;

import com.example.prueba001.exception.ApiException;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;
import java.util.Objects;

public class Validaciones {

    public static void validacionSoloNumeros(String parametro, String nombre){
        validacionNuloVacio(parametro, nombre);
        if (!parametro.matches("^\\d+$")){
            throw new ApiException(HttpStatus.BAD_REQUEST.value(),
                    MessageFormat.format("El parametro {0}, solo debe tener numeros.", nombre));
        }
    }

    public static void validacionSoloLetras(String parametro, String nombre){
        validacionNuloVacio(parametro, nombre);
        if (!parametro.matches("^[a-zA-z]+$")){
            throw new ApiException(HttpStatus.BAD_REQUEST.value(),
                    MessageFormat.format("El parametro {0}, solo debe tener letras.", nombre));
        }
    }

    public static void validacionNuloVacio(String parametro, String nombre){
        if(Objects.isNull(parametro) || parametro.isEmpty()) {
            throw new ApiException(HttpStatus.BAD_REQUEST.value(),
                    MessageFormat.format("El parametro {0}, no puede llegar nulo o vacio.", nombre));
        }
    }

}
