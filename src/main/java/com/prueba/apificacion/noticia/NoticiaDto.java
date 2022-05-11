package com.prueba.apificacion.noticia;

public class NoticiaDto {
    private String fecha;
    private String enlace;
    private String enlaceFoto;
    private String titulo;
    private String resumen;
    private String contenidoFoto;
    private String contentTypeFoto;

    public NoticiaDto() {
    }

    public NoticiaDto(String fecha, String enlace, String enlaceFoto, String titulo, String resumen) {
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

    public String getContenidoFoto() {
        return contenidoFoto;
    }

    public void setContenidoFoto(String contenidoFoto) {
        this.contenidoFoto = contenidoFoto;
    }

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
