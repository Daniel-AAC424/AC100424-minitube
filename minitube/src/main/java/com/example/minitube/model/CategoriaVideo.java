package com.example.minitube.model;

public enum CategoriaVideo {

    PROGRAMACION("Programación"),
    MUSICA("Música"),
    VIDEOJUEGOS("Videojuegos"),
    EDUCACION("Educación"),
    DEPORTES("Deportes"),
    TECNOLOGIA("Tecnología");

    private final String etiqueta;

    CategoriaVideo(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
}