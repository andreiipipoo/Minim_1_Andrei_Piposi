package edu.upc.dsa;

import edu.upc.dsa.exceptions.*;
import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.*;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ManagerImplTest {

        private static Logger logger = Logger.getLogger(ManagerImplTest.class.getName());
        Manager manager;

        @Before
        public void setUp() throws JuegoException {
            this.manager = new ManagerImpl();
            this.manager.crearJuego("1", "Valorant", 3);
            this.manager.crearJuego("2", "League of Legends", 5);
            this.manager.crearJuego("3", "Counter Strike", 67);

            this.manager.crearUsuario("1", "Pepito");

            this.manager.iniciarPartida("1", "1");
            this.manager.consultarPuntuacion("1");
        }

        @After
        public void tearDown() {
            this.manager = null;
        }


        @Test
        public void testCrearJuego() throws JuegoException{
        logger.info("Agregamos un juego nuevo");
        this.manager.crearJuego("4","Fortnite",8);
        Assert.assertEquals(4,this.manager.sizeJuegos());
        }

        @Test
        public void testCrearUsuario() throws JuegoException{
            logger.info("Agregamos un usuario nuevo");
            this.manager.crearUsuario("2","Juanito");
            Assert.assertEquals(2,this.manager.sizeUsuarios());
        }

        @Test
        public void testIniciarPartida() throws JuegoException{
            logger.info("Iniciamos una partida");
            this.manager.iniciarPartida("1","1");
            Assert.assertEquals(1,this.manager.consultarNivelActual("1"));
        }

        @Test
        public void testConsultarNivelActual() throws JuegoException{
            logger.info("Consultamos el nivel actual");
            this.manager.consultarNivelActual("1");
            Assert.assertEquals(1,this.manager.consultarNivelActual("1"));
        }

        @Test
        public void testConsultarPuntuacion() throws JuegoException{
            logger.info("Consultamos la puntuacion");
            this.manager.consultarPuntuacion("1");
            Assert.assertEquals(50,this.manager.consultarPuntuacion("1"));
        }
}

