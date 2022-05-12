package com.prueba.apificacion.noticia;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ForbidenErrorExceptionHandler {
    @ExceptionHandler(CustomForbiddenErrorException.class)
    public ResponseEntity<ErrorDTO> generateForbiddenErrorException(CustomForbiddenErrorException ex) {
        System.out.println(ex.getClass().toString());
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCodigo(ex.getCodigo());
        errorDTO.setError(String.valueOf(ex.getError()));
        return new ResponseEntity<ErrorDTO>(errorDTO, ex.getStatus());
    }
}
