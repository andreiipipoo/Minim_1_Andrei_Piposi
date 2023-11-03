package edu.upc.dsa;
import edu.upc.dsa.models.Estado;
import edu.upc.dsa.exceptions.*;

import java.util.List;

public interface Manager {

    //Creación de un juego
    void crearJuego(String id, String nombre, String descripcion, int numeroNiveles) throws JuegoException;

    //Inicio de una partida de un juego por parte de un usuario
    void iniciarPartida(String idUsuario, String idJuego) throws JuegoException;

    //Consulta del nivel actual
    int consultarNivel(String idUsuario) throws JuegoException;

    //Consulta de la puntuación actual
    int consultarPuntuacion(String idUsuario) throws JuegoException;
    //Pasar de nivel
    void pasarNivel(String idUsuario,int puntosConseguidos,String fechaCambioNivel) throws JuegoException;

    //Finalizar partida
    void finalizarPartida(String idUsuario) throws JuegoException;

    //Consulta del estado de un juego
    Estado consultarEstado(String idJuego) throws JuegoException;

    //Consulta de usuario que han participado en un juego ordenados por puntuación (descendentemente)
    List<String> consultarRanking(String idJuego) throws JuegoException;

    //Consulta de los juegos en los que ha participado un usuario
    List<String> consultarPartidas(String idUsuario) throws JuegoException;

     int numUsuarios();
     int numJuegos();
}
