package edu.upc.dsa.services;


import edu.upc.dsa.Manager;
import edu.upc.dsa.exceptions.JuegoException;
import edu.upc.dsa.*;
import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.Partida;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/juegos", description = "Endpoint to Minimo1 Andrei Service")
@Path("/juegos")
public class Service {

    private Manager manager;

    public Service() throws JuegoException {
        this.manager = ManagerImpl.getInstance();
        if (this.manager.sizeJuegos() == 0) {
            this.manager.crearJuego("1", "LoL", 3);
            this.manager.crearJuego("2", "Minecraft", 2);
            this.manager.crearJuego("3", "YES", 4);
        }
        if (this.manager.sizeUsuarios() == 0) {
            this.manager.crearUsuario("1", "Andrei");
            this.manager.crearUsuario("2", "Pablo");
            this.manager.crearUsuario("3", "Marc");
        }
        if  (this.manager.size() == 0) {
            this.manager.iniciarPartida("1", "1");
            this.manager.iniciarPartida("2", "2");
            this.manager.iniciarPartida("3", "3");
        }
    }
   @POST
   @ApiOperation(value = "Crear un juego", notes = "asdasd")
   @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Juego.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/juegos/crearjuego/{idJuego}/{descripcion}/{numeroNiveles}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearJuego(@PathParam("idJuego") String idJuego, @PathParam("descripcion") String descripcion, @PathParam("numeroNiveles") int numeroNiveles) {
        if (idJuego.isEmpty() || descripcion.isEmpty() || numeroNiveles == 0) return Response.status(500).entity(new JuegoException("Error en los parametros")).build();
        this.manager.crearJuego(idJuego, descripcion, numeroNiveles);
        return Response.status(201).entity(this.manager.getJuego(idJuego)).build();
    }
    @POST
    @ApiOperation(value = "Añadir un usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Juego.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/juegos/crearusuario/{idUsuario}/{nombre}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearUsuario(@PathParam("idUsuario") String idUsuario, @PathParam("nombre") String nombre) {
        if (idUsuario.isEmpty() || nombre.isEmpty()) return Response.status(500).entity(new JuegoException("Error en los parametros")).build();
        this.manager.crearUsuario(idUsuario, nombre);
        return Response.status(201).entity(this.manager.getUsuario(idUsuario)).build();
    }

    @PUT
    @ApiOperation(value = "Iniciar una partida", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Juego.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/juegos/iniciarpartida/{idUsuario}/{idJuego}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response iniciarPartida(@PathParam("idUsuario") String idUsuario, @PathParam("idJuego") String idJuego) {
        if (idUsuario.isEmpty() || idJuego.isEmpty()) return Response.status(500).entity(new JuegoException("Error en los parametros")).build();
        this.manager.iniciarPartida(idUsuario, idJuego);
        return Response.status(201).entity(this.manager.getUsuario(idUsuario)).build();
    }
    @POST
    @ApiOperation(value = "Finalizar una partida", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Juego.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/juegos/finalizarpartida/{idUsuario}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response finalizarPartida(@PathParam("idUsuario") String idUsuario) {
        if (idUsuario.isEmpty()) return Response.status(500).entity(new JuegoException("Error en los parametros")).build();
        this.manager.finalizarPartida(idUsuario);
        return Response.status(201).entity(this.manager.getUsuario(idUsuario)).build();
    }
    @GET
    @ApiOperation(value = "Consultar el nivel actual de un usuario en un juego", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Juego.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/juegos/consultarnivelactual/{idUsuario}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarNivelActual(@PathParam("idUsuario") String idUsuario) {
        if (idUsuario.isEmpty()) return Response.status(500).entity(new JuegoException("Error en los parametros")).build();
        return Response.status(201).entity(this.manager.consultarNivelActual(idUsuario)).build();
    }
    @GET
    @ApiOperation(value = "Consultar la puntuación de un usuario en un juego", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Juego.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/juegos/consultarpuntuacion/{idUsuario}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPuntuacion(@PathParam("idUsuario") String idUsuario) {
        if (idUsuario.isEmpty()) return Response.status(500).entity(new JuegoException("Error en los parametros")).build();
        return Response.status(201).entity(this.manager.consultarPuntuacion(idUsuario)).build();
    }
    @POST
    @ApiOperation(value = "Pasar de nivel", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Juego.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/juegos/pasarnivel/{idUsuario}/{puntos}/{fechaCambioNivel}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response pasarNivel(@PathParam("idUsuario") String idUsuario, @PathParam("puntos") int puntos, @PathParam("fechaCambioNivel") String fechaCambioNivel) {
        if (idUsuario.isEmpty() || puntos == 0 || fechaCambioNivel.isEmpty()) return Response.status(500).entity(new JuegoException("Error en los parametros")).build();
        this.manager.pasarNivel(idUsuario, puntos, fechaCambioNivel);
        return Response.status(201).entity(this.manager.getUsuario(idUsuario)).build();
    }
}