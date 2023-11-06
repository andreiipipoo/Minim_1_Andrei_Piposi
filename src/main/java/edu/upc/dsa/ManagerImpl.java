package edu.upc.dsa;

import edu.upc.dsa.exceptions.*;
import edu.upc.dsa.models.*;
import edu.upc.dsa.models.Juego;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.apache.log4j.Logger;

public class ManagerImpl implements Manager{
    private static Manager instance;
    private Map<String, Usuario> usuarios;
    private Map<String, Juego> juegos;

    final static Logger logger = Logger.getLogger(ManagerImpl.class);

    public ManagerImpl(){
        this.usuarios = new HashMap<>();
        this.juegos = new HashMap<>();
    }

    public static Manager getInstance(){
        if (instance==null) instance = new ManagerImpl();
        return instance;
    }

    @Override
    public void crearJuego(String identificador, String descripcion, int numeroNiveles) {
        logger.info("Creando juego: identificador=" + identificador + ", descripcion=" + descripcion + ", numeroNiveles=" + numeroNiveles);
        Juego juego = new Juego(identificador, descripcion, numeroNiveles);
        juegos.put(identificador, juego);
    }

    @Override
    public void iniciarPartida(String idUsuario, String idJuego) {
        logger.info("Iniciando partida para el usuario: idUsuario=" + idUsuario + ", idJuego=" + idJuego);
        Usuario usuario = usuarios.get(idUsuario);
        Juego juego = juegos.get(idJuego);

        if (usuario != null && juego != null && usuario.getPartidaActual() == null) {
            Partida partida = new Partida(juego, usuario);
            partida.setNivelActual(1);
            partida.setPuntuacionActual(50);
            usuario.setPartidaActual(partida);
        } else {
            logger.error("Error: El usuario no existe, el juego no existe o el usuario ya tiene una partida en curso.");
        }
    }

    @Override
    public int consultarNivelActual(String idUsuario) {
        logger.info("Consultando nivel actual para el usuario: idUsuario=" + idUsuario);
        Usuario usuario = usuarios.get(idUsuario);

        if (usuario != null && usuario.getPartidaActual() != null) {
            return usuario.getPartidaActual().getNivelActual();
        } else {
            logger.error("Error: El usuario no existe o no tiene una partida en curso.");
            return -1;
        }
    }

    @Override
    public int consultarPuntuacion(String idUsuario) {
        logger.info("Consultando puntuación actual para el usuario: idUsuario=" + idUsuario);
        Usuario usuario = usuarios.get(idUsuario);

        if (usuario != null && usuario.getPartidaActual() != null) {
            return usuario.getPartidaActual().getPuntuacionActual();
        } else {
            logger.error("Error: El usuario no existe o no tiene una partida en curso.");
            return -1;
        }
    }


    @Override
    public void pasarNivel(String idUsuario, int puntos, String fechaCambioNivel) {
        logger.info("Pasando de nivel para el usuario: idUsuario=" + idUsuario + ", puntos=" + puntos + ", fechaCambioNivel=" + fechaCambioNivel);
        Usuario usuario = usuarios.get(idUsuario);
        Partida partida = usuario != null ? usuario.getPartidaActual() : null;

        if (partida != null) {
            int nivelActual = partida.getNivelActual();
            int puntuacionActual = partida.getPuntuacionActual();
            Juego juego = partida.getJuego();

            puntuacionActual += puntos;
            partida.setPuntuacionActual(puntuacionActual);
            partida.setFechaCambioNivel(fechaCambioNivel);

            if (juego != null) {
                if (nivelActual < juego.getNumeroNiveles()) { // Si no es el último nivel
                    nivelActual++; // Incrementa el nivel
                    partida.setNivelActual(nivelActual);
                } else {
                    // Si es el último nivel, otorga un bono de 100 puntos
                    puntuacionActual += 100;
                    partida.setPuntuacionActual(puntuacionActual);
                    finalizarPartida(idUsuario);
                }
            } else {
                logger.error("Error: El juego es nulo en la partida.");
            }
        } else {
            logger.error("Error: El usuario no existe o no tiene una partida en curso.");
        }
    }

    @Override
    public void finalizarPartida(String idUsuario) {
        logger.info("Finalizando partida para el usuario: idUsuario=" + idUsuario);
        Usuario usuario = usuarios.get(idUsuario);

        if (usuario != null) {
            usuario.setPartidaActual(null);
        } else {
            logger.error("Error: El usuario no existe.");
        }
    }

    @Override
    public List<String> consultarRanking(String idJuego) {
        logger.info("Consultando ranking para el juego: idJuego=" + idJuego);
        Juego juego = juegos.get(idJuego);

        if (juego != null) {
            List<Usuario> usuariosPorJuego = new ArrayList<>();
            for (Usuario usuario : usuarios.values()) {
                Partida partida = usuario.getPartidaActual();
                if (partida != null && partida.getJuego().getIdentificador().equals(idJuego)) {
                    usuariosPorJuego.add(usuario);
                }
            }

            usuariosPorJuego.sort((u1, u2) -> Integer.compare(
                    u2.getPartidaActual().getPuntuacionActual(),
                    u1.getPartidaActual().getPuntuacionActual()
            ));

            List<String> ranking = new ArrayList<>();
            usuariosPorJuego.forEach(usuario -> {
                ranking.add(usuario.getIdentificador() + ": " + usuario.getPartidaActual().getPuntuacionActual());
            });
            return ranking;
        } else {
            logger.error("Error: El juego no existe.");
            return new ArrayList<>();
        }
    }

    @Override
    public List<Partida> consultarPartidasPorUsuario(String idUsuario) {
        logger.info("Consultando partidas para el usuario: idUsuario=" + idUsuario);
        Usuario usuario = usuarios.get(idUsuario);

        if (usuario != null) {
            return usuario.getPartidasJugadas(); // Utiliza el método getPartidas de la clase Usuario
        } else {
            logger.error("Error: El usuario no existe.");
            return new ArrayList<>();
        }
    }

    public Usuario crearUsuario(String idUsuario, String nombre) {
        logger.info("Creando usuario: idUsuario=" + idUsuario + ", nombre=" + nombre);

        // Verificar si el usuario ya existe
        if (usuarios.containsKey(idUsuario)) {
            logger.info("El usuario " + idUsuario + " ya existe. No se puede crear.");
            // El usuario ya existe, puedes manejarlo de acuerdo a tus necesidades
            return null; // O lanzar una excepción, etc.
        } else {
            // Crear un nuevo usuario
            Usuario nuevoUsuario = new Usuario(nombre, idUsuario);
            usuarios.put(idUsuario, nuevoUsuario); // Agregar el usuario a la colección (por ejemplo, un mapa)

            logger.info("Usuario " + idUsuario + " creado con éxito.");
            return nuevoUsuario; // Devuelve el usuario recién creado
        }
    }

    public int sizeJuegos(){
        return this.juegos.size();
    }

    public int sizeUsuarios(){
        return this.usuarios.size();
    }

    public int size(){
        return this.juegos.size() + this.usuarios.size();
    }

    public Juego getJuego(String idJuego){
        return this.juegos.get(idJuego);
    }

    public Usuario getUsuario(String idUsuario){
        return this.usuarios.get(idUsuario);
    }
}




