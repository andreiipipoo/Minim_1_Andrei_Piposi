package edu.upc.dsa.models;
import java.util.ArrayList;
import java.util.List;

public class Juego {
    private String identificador;
    private String descripcion;
    private int numeroNiveles;
    private List<Partida> partidasEnCurso;

    public Juego(String idJuego, String descripcion, int numeroNiveles) {
        this.identificador = idJuego;
        this.descripcion = descripcion;
        this.numeroNiveles = numeroNiveles;
        this.partidasEnCurso = new ArrayList<>();
    }

    public Juego() {
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroNiveles() {
        return numeroNiveles;
    }

    public void setNumeroNiveles(int numeroNiveles) {
        this.numeroNiveles = numeroNiveles;
    }

    public List<Partida> getPartidasEnCurso() {
        return partidasEnCurso;
    }

    public void setPartidasEnCurso(List<Partida> partidasEnCurso) {
        this.partidasEnCurso = partidasEnCurso;
    }

}
