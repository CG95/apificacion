package com.prueba.apificacion.noticia;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {
    private String codigo;
    private String error;

    public NotFoundException(String message, String codigo, String error) {
        super(message);
        this.codigo = codigo;
        this.error = error;
    }

    public NotFoundException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
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
}
