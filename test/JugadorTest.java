import modelo.*;
import org.junit.Test;
import org.junit.Assert;
import java.util.List;
import java.util.ArrayList;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JugadorTest {

    @Test
    public void seCreaJugadorConNombre(){

        Jugador unJugador = new Jugador("Tomas");

        Assert.assertEquals("Tomas", unJugador.obtenerNombre());
        Assert.assertEquals(100, unJugador.obtenerOro());
        Assert.assertEquals(0, unJugador.getPoblacion());
    }

    @Test
    public void seAgregaUnaPiezaAJugador() throws Excepcion{

        Jugador unJugador = new Jugador("Tomas");

        Area unEspacio = new Area(new ArrayList<>(), 0, 0, 2, 2);

        Aldeano unAldeano = new Aldeano(unEspacio);

        unJugador.agregarPieza(unAldeano);

        Assert.assertEquals( 1, unJugador.getPoblacion());
        Assert.assertTrue(unJugador.castilloFueDestruido());

    }

    @Test
    public void castilloNoFueDestruido() throws Excepcion{

        Jugador unJugador = new Jugador("Tomas");

        Area unEspacio = new Area(new ArrayList<>(), 0, 0, 2, 2);

        Edificio unCastillo = new Castillo(unEspacio);

        unJugador.agregarPieza(unCastillo);

        Assert.assertEquals( 0, unJugador.getPoblacion());
        Assert.assertFalse(unJugador.castilloFueDestruido());
    }

    @Test
    public void seActualizaLaPoblacion() throws Excepcion{

        Jugador unJugador = new Jugador("Tomas");

        Area unEspacio = new Area(new ArrayList<>(), 0, 0, 2, 2);

        Edificio unCastillo = new Castillo(unEspacio);

        Aldeano unAldeano = new Aldeano(unEspacio);

        unJugador.agregarPieza(unCastillo);

        Assert.assertEquals(0, unJugador.getPoblacion());

        unJugador.agregarPieza(unAldeano);

        Assert.assertEquals( 1, unJugador.getPoblacion());

        unJugador.agregarPieza(unAldeano);

        Assert.assertEquals(2, unJugador.getPoblacion());
    }

    @Test
    public void seRecolectaOroDeUnAldeano() throws Excepcion{

        Jugador unJugador = new Jugador("Tomas");

        Area unEspacio = new Area(new ArrayList<>(), 0, 0, 2, 2);

        Aldeano unAldeano = new Aldeano(unEspacio);

        Assert.assertEquals(100, unJugador.obtenerOro());

        unJugador.agregarPieza(unAldeano);

        unJugador.finalizarTurno();

        Assert.assertEquals(120, unJugador.obtenerOro());

        unJugador.finalizarTurno();

        Assert.assertEquals(140, unJugador.obtenerOro());

    }

}
