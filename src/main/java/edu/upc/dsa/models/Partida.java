package edu.upc.dsa.models;

import java.util.Date;


public class Partida {
    private String identificador;
    private Juego juego;
    private Usuario usuario;
    private int nivelActual;
    private int puntuacionActual;
    private Date fechaInicio;
    private Date fechaFinalizacion;

    public Partida(String idPartida, Juego juego, Usuario usuario, int nivelActual, int puntuacionActual, Date fechaInicio, Date fechaFinalizacion) {
        this.identificador = idPartida;
        this.juego = juego;
        this.usuario = usuario;
        this.nivelActual = nivelActual;
        this.puntuacionActual = puntuacionActual;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Partida(Juego juego, Usuario usuario) {
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
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

    public int getPuntuacionActual() {
        return puntuacionActual;
    }

    public void setPuntuacionActual(int puntuacionActual) {
        this.puntuacionActual = puntuacionActual;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public void setFechaCambioNivel(String fechaCambioNivel) {

    }
}

