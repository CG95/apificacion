package com.prueba.apificacion.noticia;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InternalServerErrorExceptionHandler {

   @ExceptionHandler(CustomInternalServerErrorException.class)
        public ResponseEntity<ErrorDTO> generateInternalServerErrorException(CustomInternalServerErrorException ex) {
            System.out.println(ex.getClass().toString());
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setCodigo(ex.getCodigo());
            errorDTO.setError(String.valueOf(ex.getError()));
            return new ResponseEntity<ErrorDTO>(errorDTO, ex.getStatus());
        }

}
