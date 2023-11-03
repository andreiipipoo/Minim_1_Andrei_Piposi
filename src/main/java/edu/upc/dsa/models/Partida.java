package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.Date;


public class Partida {
    String id;
    Juego juego;
    Usuario usuario;
    int nivelActual;
    int puntuacionAcumulada;
    Date fechaInicio;
    Date fechaFin;
    ArrayList<Juego> Partidas = new ArrayList<Juego>();
    public Partida(String id) {
        this.id = id;
        this.juego = juego;
        this.usuario = usuario;
        this.nivelActual = nivelActual;
        this.puntuacionAcumulada = puntuacionAcumulada;
        this.fechaInicio = new Date();
        this.fechaFin = null;
    }
    public Partida(Usuario usuario, Juego juego) {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Juego getJuego() {
        return juego;
    }
    public void setJuego(Juego juego) {
        this.juego = juego;

    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public int getNivelActual() {
        return nivelActual;
    }
    public void setNivelActual(int nivelActual) {
        this.nivelActual = nivelActual;
    }
    public int getPuntuacionAcumulada() {
        return puntuacionAcumulada;
    }
    public void setPuntuacionAcumulada(int puntuacionAcumulada) {
        this.puntuacionAcumulada = puntuacionAcumulada;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public ArrayList<Juego> getPartidas() {
            return Partidas;
    }

    public int getNivel() {
        return this.nivelActual;
    }

    public int getPuntuacion() {
        return this.puntuacionAcumulada;
    }

    public void setNivel() {
        this.nivelActual++;
    }

    public void setPuntuacion(int puntosConseguidos) {
        this.puntuacionAcumulada += puntosConseguidos;
    }

    public void setFechaCambioNivel(String fechaCambioNivel) {
        this.fechaInicio = fechaInicio;
    }
}
