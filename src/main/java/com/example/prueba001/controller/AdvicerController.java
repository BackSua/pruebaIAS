package com.example.prueba001.controller;

import com.example.prueba001.dto.ResponseDTO;
import com.example.prueba001.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collection;
import java.util.Collections;

@RestControllerAdvice
public class AdvicerController {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ResponseDTO> apiExceptionHandler(ApiException apiException){

        if(apiException.getHttpStatus()==206){
            return new ResponseEntity<>(
                    ResponseDTO.builder()
                            .data(Collections.emptyMap())
                            .message(apiException.getMensaje())
                            .status(apiException.getHttpStatus())
                            .build(), HttpStatus.PARTIAL_CONTENT);

        }

        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .data(Collections.emptyMap())
                        .message(apiException.getMensaje())
                        .status(apiException.getHttpStatus())
                        .build(), HttpStatus.BAD_REQUEST);
    }

}
