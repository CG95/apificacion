package com.prueba.apificacion.noticia;

import org.springframework.http.HttpStatus;

public class CustomInternalServerErrorException extends RuntimeException{
    private String codigo= "g100";
    private String error= "Error interno del servidor";

    public CustomInternalServerErrorException(String message, String codigo, String error) {
        super(message);
        this.codigo = codigo;
        this.error = error;
    }

    public CustomInternalServerErrorException(String message) {
        super(message);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }


}
