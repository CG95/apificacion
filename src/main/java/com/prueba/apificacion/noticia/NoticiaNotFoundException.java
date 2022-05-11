package com.prueba.apificacion.noticia;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NoticiaNotFoundException{
        @ExceptionHandler(NotFoundException.class)
        public ResponseEntity<ErrorDTO> generateNotFoundException(NotFoundException ex) {
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setCodigo(ex.getCodigo());
            errorDTO.setError(String.valueOf(ex.getError()));
            return new ResponseEntity<ErrorDTO>(errorDTO, ex.getStatus());
        }

}
