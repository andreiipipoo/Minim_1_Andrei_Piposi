package edu.upc.dsa;

import edu.upc.dsa.exceptions.*;
import edu.upc.dsa.models.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class ManagerImpl implements Manager{
    private static Manager instance;
    private Juego juego;
    protected Map<String, Usuario> usuario;
    HashMap<String,String> Juegos = new HashMap<String,String>();
    HashMap<String,String> Partidas = new HashMap<String,String>();

    LinkedList<String> listaJuegos = new LinkedList<String>();
    LinkedList<String> listaPartidas = new LinkedList<String>();
    LinkedList<String> listaUsuarios = new LinkedList<String>();

    final static Logger logger = Logger.getLogger(ManagerImpl.class);


    public ManagerImpl() {
        this.usuario = new HashMap<>();
        this.juego = new Juego(id, descripcion, numeroNiveles, numeroUsuarios);
    }
    public static Manager getInstance() {
        if (instance==null) instance = new ManagerImpl();
        return instance;
    }

    @Override
    public void crearJuego(String id, String nombre, String descripcion, int numeroNiveles) throws JuegoException {
        if (this.Juegos.containsKey(id)) {
            logger.error("Este juego ya existe");
            throw new JuegoException("Este juego ya existe");
        }
        else {
            this.juego = new Juego(id, nombre, descripcion, numeroNiveles);
            this.Juegos.put(id, nombre);
            this.listaJuegos.add(id);
            logger.info("Juego creado");
        }
    }
    @Override
    public void iniciarPartida(String idUsuario, String idJuego) throws JuegoException {
        if (this.usuario.containsKey(idUsuario)) {
            if (this.Juegos.containsKey(idJuego)) {
                this.usuario.get(idUsuario).setJuego(idJuego);
                this.Partidas.put(idUsuario, idJuego);
                this.listaPartidas.add(idUsuario);
                logger.info("Partida iniciada");
            }
            else {
                logger.error("Este juego no existe");
                throw new JuegoException("Este juego no existe");
            }
        }
        else {
            logger.error("Este usuario no existe");
            throw new JuegoException("Este usuario no existe");
        }
    }

    @Override
    public int consultarNivel(String idUsuario) throws JuegoException {
        if (this.usuario.containsKey(idUsuario)) {
            logger.info("Nivel consultado");
            return this.usuario.get(idUsuario).getNivel();
        }
        else {
            logger.error("Este usuario no existe");
            throw new JuegoException("Este usuario no existe");
        }
    }
    @Override
    public int consultarPuntuacion(String idUsuario) throws JuegoException {
        if (this.usuario.containsKey(idUsuario)) {
            logger.info("Puntuacion consultada");
            return this.usuario.get(idUsuario).getPuntuacion();
        }
        else {
            logger.error("Este usuario no existe");
            throw new JuegoException("Este usuario no existe");
        }
    }
    @Override
    public void pasarNivel(String idUsuario,int puntosConseguidos,String fechaCambioNivel) throws JuegoException {
        if (this.usuario.containsKey(idUsuario)) {
            this.usuario.get(idUsuario).setNivel();
            this.usuario.get(idUsuario).setPuntuacion(puntosConseguidos);
            this.usuario.get(idUsuario).setFechaCambioNivel(fechaCambioNivel);
            logger.info("Nivel pasado");
        }
        else {
            logger.error("Este usuario no existe");
            throw new JuegoException("Este usuario no existe");
        }
    }
    @Override
    public void finalizarPartida(String idUsuario) throws JuegoException {
        if (this.usuario.containsKey(idUsuario)) {
            this.usuario.get(idUsuario).setJuego(null);
            this.Partidas.remove(idUsuario);
            this.listaPartidas.remove(idUsuario);
            logger.info("Partida finalizada");
        }
        else {
            logger.error("Este usuario no existe");
            throw new JuegoException("Este usuario no existe");
        }
    }
    @Override
    public Estado consultarEstado(String idJuego) throws JuegoException {
        if (this.Juegos.containsKey(idJuego)) {
            logger.info("Estado consultado");
            return this.juego.getEstado();
        }
        else {
            logger.error("Este juego no existe");
            throw new JuegoException("Este juego no existe");
        }
    }
    @Override
    public List<String> consultarRanking(String idJuego) throws JuegoException {
        if (this.Juegos.containsKey(idJuego)) {
            logger.info("Ranking consultado");
            return this.juego.getRanking();
        }
        else {
            logger.error("Este juego no existe");
            throw new JuegoException("Este juego no existe");
        }
    }
    @Override
    public List<String> consultarPartidas(String idUsuario) throws JuegoException {
        if (this.usuario.containsKey(idUsuario)) {
            logger.info("Partidas consultadas");
            return this.usuario.get(idUsuario).getPartidas();
        }
        else {
            logger.error("Este usuario no existe");
            throw new JuegoException("Este usuario no existe");
        }
    }
    @Override
    public int numUsuarios() {
        int ret = this.usuario.size();
        logger.info("Usuarios contados");
        return ret;
    }
    @Override
    public int numJuegos() {
        int ret = this.Juegos.size();
        logger.info("Juegos contados");
        return ret;
    }
}




