package com.prueba.apificacion.noticia;

import org.springframework.http.HttpStatus;

public class CustomForbiddenErrorException extends RuntimeException{
    private String codigo= "g103";
    private String error= "Error no autorizado";

    public CustomForbiddenErrorException(String message) {
        super(message);
    }

    public CustomForbiddenErrorException(String message, String codigo, String error) {
        super(message);
        this.codigo = codigo;
        this.error = error;
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
        return HttpStatus.FORBIDDEN;
    }

}
