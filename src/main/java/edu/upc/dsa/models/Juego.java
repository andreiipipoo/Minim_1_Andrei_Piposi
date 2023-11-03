package edu.upc.dsa.models;
import java.util.ArrayList;
import java.util.List;

public class Juego {
    String identificador;
    String descripcion;
    private List<Nivel> niveles;
    private List<Usuario> usuariosParticipantes;
    private Estado estado;

    public Juego(String identificador, String descripcion,int numeroNiveles, int numeroUsuarios) {
        this.identificador = identificador;
        this.descripcion = this.descripcion;
        this.niveles = new ArrayList<>();
        this.usuariosParticipantes = new ArrayList<>();
    }

    public Juego(String identificador, String descripcion, int numeroNiveles) {this.estado= Estado.No_Iniciado;}
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
    public List<Nivel> getNiveles() {
        return niveles;
    }
    public void setNiveles(List<Nivel> niveles) {
        this.niveles = niveles;
    }
    public List<Usuario> getUsuariosParticipantes() {
        return usuariosParticipantes;
    }
    public void setUsuariosParticipantes(List<Usuario> usuariosParticipantes) {
        this.usuariosParticipantes = usuariosParticipantes;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void addNivel(Nivel nivel) {
        this.niveles.add(nivel);
    }
    public void addUsuario(Usuario usuario) {
        this.usuariosParticipantes.add(usuario);
    }

    @Override
    public String toString() {
        return "Juego [identificador=" + identificador + ", descripcion=" + descripcion + ", niveles=" + niveles
                + ", usuariosParticipantes=" + usuariosParticipantes + ", estado=" + estado + "]";
    }

    public List<String> getRanking() {
        return null;
    }
}
