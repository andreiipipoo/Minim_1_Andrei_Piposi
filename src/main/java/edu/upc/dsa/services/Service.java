package edu.upc.dsa.services;


import edu.upc.dsa.Manager;
import edu.upc.dsa.ManagerImpl;
import edu.upc.dsa.exceptions.JuegoException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Api(value = "/juego", description = "Endpoint to Text Service")
@Path("/juego")

public class Service {
    private final Manager manager;
    public Service() throws JuegoException{
        this.manager = ManagerImpl.getInstance();
        if (this.manager.numJuegos()==0) {
            this.manager.crearJuego("1", "Juego1", "Juego de prueba", 3);
            this.manager.crearJuego("2", "Juego2", "Juego de prueba", 3);
            this.manager.crearJuego("3", "Juego3", "Juego de prueba", 3);
        }
    }

    @POST
    @ApiOperation(value = "Crea un Juego", notes = "Crear Juego")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Juego creado!"),
            @ApiResponse(code = 404, message = "Este juego ya existe")
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)




}
