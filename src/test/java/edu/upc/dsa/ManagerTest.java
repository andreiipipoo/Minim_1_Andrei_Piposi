package edu.upc.dsa;

import edu.upc.dsa.exceptions.JuegoException;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by juan on 16/11/16.
 */

public class ManagerTest {
    final static Logger logger = Logger.getLogger(ManagerTest.class);
    protected Manager manager;

    @Before
    public void setUp() throws JuegoException{
        this.manager = new ManagerImpl();
        this.manager.crearJuego("1", "Prince of Persia", "suuuiiii", 6);
        this.manager.crearJuego("2", "Indiana Jones", "Best game of the year", 3);
        this.manager.crearJuego("3", "Grand Theft Auto 6", "No llegara nunca", 55);
    }
    @After
    public void tearDown() {
        this.manager = null;
    }
    @Test
    public void testCrearJuego() throws JuegoException {
        this.manager.crearJuego("4", "Mario Bros", "El mejor juego de la historia", 8);
        Assert.assertEquals(4, this.manager.numJuegos());
    }
    @Test
    public void testIniciarPartida() throws JuegoException {
        this.manager.iniciarPartida("1", "1");
        Assert.assertEquals(1, this.manager.numUsuarios());
    }
    @Test
    public void testConsultarNivel() throws JuegoException {
        this.manager.iniciarPartida("3", "1");
        Assert.assertEquals(1, this.manager.consultarNivel("3"));
    }
    @Test
    public void testConsultarPuntuacion() throws JuegoException {
        this.manager.iniciarPartida("2", "1");
        Assert.assertEquals(0, this.manager.consultarPuntuacion("2"));
    }
    @Test
    public void testFinalizarPartida() throws JuegoException {
        this.manager.iniciarPartida("1", "1");
        this.manager.finalizarPartida("1");
        Assert.assertEquals(1, this.manager.numUsuarios());
    }
}

