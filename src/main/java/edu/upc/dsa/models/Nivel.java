package edu.upc.dsa.models;

public class Nivel {
    String id;
    String nombre;
    int puntuacionNecesaria;

    public Nivel(String id, String nombre, int puntuacionNecesaria) {
        this.id = id;
        this.nombre = nombre;
        this.puntuacionNecesaria = puntuacionNecesaria;
    }

    public Nivel() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getPuntuacionNecesaria() {
        return puntuacionNecesaria;
    }
    public void setPuntuacionNecesaria(int puntuacionNecesaria) {
        this.puntuacionNecesaria = puntuacionNecesaria;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
