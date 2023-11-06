package edu.upc.dsa;
import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.Usuario;

import java.util.List;


public interface Manager {

    //Creación de un juego
    void crearJuego(String identificador, String descripcion, int numeroNiveles);

    //Inicio de una partida de un juego por parte de un usuario
    void iniciarPartida(String idUsuario, String idJuego);

    //Consultar el nivel actual de un usuario en un juego
    int consultarNivelActual(String idUsuario);

    //Consultar la puntuación de un usuario en un juego
    int consultarPuntuacion(String idUsuario);

    //Pasar de nivel
    void pasarNivel(String idUsuario, int puntos, String fechaCambioNivel);

    //Finalizar una partida
    void finalizarPartida(String idUsuario);

    //Consulta de usuarios que han participado en un juego ordenado
    //por puntuación (descendente).
    List<String> consultarRanking(String idJuego);

    //Consulta de las partidas en las que ha participado un usuario
    List<Partida> consultarPartidasPorUsuario(String idUsuario);

    Usuario crearUsuario(String number, String nombre);

    int sizeJuegos();

    int sizeUsuarios();

    int size();

    Juego getJuego(String idJuego);

    Usuario getUsuario(String idUsuario);

}
