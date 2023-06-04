package org.example.Controlador;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Zelda {
    private int Id;
    private String titulo;
    private String plataforma;
    private Integer anioLanzamiento;
    private String desarrollador;
    private String url;

    public Zelda() {
    }

    public Zelda(int id, String titulo, String plataforma, Integer anioLanzamiento, String desarrollador) {
        Id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.anioLanzamiento = anioLanzamiento;
        this.desarrollador = desarrollador;
    }

    public Zelda(int id, String titulo, String plataforma, Integer anioLanzamiento, String desarrollador, String url) {
        Id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.anioLanzamiento = anioLanzamiento;
        this.desarrollador = desarrollador;
        this.url = url;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Integer getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(Integer anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Fila{" +
                "Id: " + Id +
                ", titulo: '" + titulo + '\'' +
                ", plataforma: '" + plataforma + '\'' +
                ", anioLanzamiento: " + anioLanzamiento +
                ", desarrollador: '" + desarrollador + '\'' +
                ", url: '" + url + '\'' +
                '}';
    }

    public ImageIcon getimagen() throws MalformedURLException {
        URL urlImagen = new URL(this.url);
        return new ImageIcon(urlImagen);
    }
}
