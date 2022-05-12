package com.prueba.apificacion.noticia;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NoticiaFotoDto {
    private String fecha="";
    private String enlace="";
    private String enlaceFoto="";
    private String titulo="";
    private String resumen="";
    private String contenidoFoto="";
    private String contentTypeFoto="";

    public NoticiaFotoDto() {
    }

    public NoticiaFotoDto(String fecha, String enlace, String enlaceFoto, String titulo, String resumen) {
        this.fecha = fecha;
        this.enlace = enlace;
        this.enlaceFoto = enlaceFoto;
        this.titulo = titulo;
        this.resumen = resumen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    @JsonProperty("enlace_foto")
    public String getEnlaceFoto() {
        return enlaceFoto;
    }

    public void setEnlaceFoto(String enlaceFoto) {
        this.enlaceFoto = enlaceFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    @JsonProperty("contenido_foto")
    public String getContenidoFoto() {
        return contenidoFoto;
    }

    public void setContenidoFoto(String contenidoFoto) {
        this.contenidoFoto = contenidoFoto;
    }

    @JsonProperty("content_type_foto")
    public String getContentTypeFoto() {
        return contentTypeFoto;
    }

    public void setContentTypeFoto(String contentTypeFoto) {
        this.contentTypeFoto = contentTypeFoto;
    }

    @Override
    public String toString() {
        return "NoticiaDto{" +
                "fecha='" + fecha + '\'' +
                ", enlace='" + enlace + '\'' +
                ", enlaceFoto='" + enlaceFoto + '\'' +
                ", titulo='" + titulo + '\'' +
                ", resumen='" + resumen + '\'' +
                ", contenidoFoto='" + contenidoFoto + '\'' +
                ", contentTypeFoto='" + contentTypeFoto + '\'' +
                '}';
    }
}
