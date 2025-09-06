package com.example.biblioteca.Model;

import java.io.Serializable;

public class Libro implements Serializable {
    private final int coverResId;
    private final String titulo;
    private final String autor;
    private final String descripcion;
    private final int anio;

    public Libro(int coverResId, String titulo, String autor, String descripcion, int anio) {
        this.coverResId = coverResId;
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.anio = anio;
    }
    public int getCoverResId() { return coverResId; }
    public String getTitulo()  { return titulo; }
    public String getAutor()   { return autor; }
    public String getDescripcion(){ return descripcion; }
    public int getAnio()       { return anio; }
}
