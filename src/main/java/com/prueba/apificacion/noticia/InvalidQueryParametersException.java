package com.prueba.apificacion.noticia;

import org.springframework.http.HttpStatus;

public class InvalidQueryParametersException extends RuntimeException {
    private String codigo;
    private String error;

    public InvalidQueryParametersException(String message, String codigo, String error) {
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
        return HttpStatus.BAD_REQUEST;
    }
}
