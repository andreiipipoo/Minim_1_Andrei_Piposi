package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;

public class Usuario {
    private String identificador;
    private String nombre;
    private Partida partidaActual;
    private List<Partida> partidasJugadas;

    public Usuario(String idUsuario, String nombre) {
        this.identificador = idUsuario;
        this.nombre = nombre;
        this.partidaActual = null;
        this.partidasJugadas = new ArrayList<>();
    }

    public Usuario() {
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Partida getPartidaActual() {
        return partidaActual;
    }

    public void setPartidaActual(Partida partidaActual) {
        this.partidaActual = partidaActual;
    }

    public List<Partida> getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(List<Partida> partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public void addPartidaJugada(Partida partida) {
        this.partidasJugadas.add(partida);
    }
}
