package edu.upc.dsa.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Usuario {
    public static Map<String, Usuario> MapaUsuarios = new HashMap<>();
    String id;
    String nombre;
    int puntuacionTotal;
    private Partida partidaactual;

    public Usuario(String id, String nombre, int puntuacionTotal) {
        this.id = id;
        this.nombre = nombre;
        this.puntuacionTotal = puntuacionTotal;
        this.partidaactual = null;
    }
    public Usuario() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
        MapaUsuarios.put(id, this);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
        MapaUsuarios.put(id, this);
    }

    public int getPuntuacionTotal() {
        return puntuacionTotal;
    }
    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
        MapaUsuarios.put(id, this);
    }
    public Partida getPartidaActual() {
        return partidaactual;
    }
    public void setPartidaActual(Partida partidaactual) {
        this.partidaactual = partidaactual;
        MapaUsuarios.put(id, this);
    }


    public void setJuego(String idJuego) {
        this.partidaactual = new Partida(idJuego);
        MapaUsuarios.put(id, this);
    }

    public int getNivel() {
        return this.partidaactual.getNivel();
    }

    public int getPuntuacion() {
        return this.partidaactual.getPuntuacion();
    }

    public void setNivel() {
        this.partidaactual.setNivel();
        MapaUsuarios.put(id, this);
    }

    public void setPuntuacion(int puntosConseguidos) {
        this.partidaactual.setPuntuacion(puntosConseguidos);
        MapaUsuarios.put(id, this);
    }

    public void setFechaCambioNivel(String fechaCambioNivel) {
        this.partidaactual.setFechaCambioNivel(fechaCambioNivel);
        MapaUsuarios.put(id, this);
    }

    public List<String> getPartidas() {
        List<String> listaPartidas = new ArrayList<>();
        for (Map.Entry<String, Usuario> entry : MapaUsuarios.entrySet()) {
            String key = entry.getKey();
            Usuario value = entry.getValue();
            listaPartidas.add(key);
        }
        return listaPartidas;
    }
}
