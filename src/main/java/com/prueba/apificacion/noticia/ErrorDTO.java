package com.prueba.apificacion.noticia;

public class ErrorDTO {
    private String codigo;
    private String error;

    public ErrorDTO() {
    }

    public ErrorDTO(String codigo, String error) {
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


}
