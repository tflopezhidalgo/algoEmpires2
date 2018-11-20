import modelo.*;
import org.junit.Test;
import org.junit.Assert;
import java.util.List;
import java.util.ArrayList;
import org.mockito.Mockito;
/*
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
*/
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
    	 Tablero unTablero = new Tablero();
         Jugador unJugador = new Jugador("Tomas");
         Area espacioAldeano = unTablero.definirArea(0, 0, 0, 0);
         Aldeano unAldeano = new Aldeano(espacioAldeano);
         unJugador.agregarPieza(unAldeano);
         Assert.assertEquals( 1, unJugador.getPoblacion());
         Assert.assertTrue(unJugador.castilloFueDestruido());
     }
     @Test
    public void castilloNoFueDestruido() throws Excepcion{
    	 Tablero unTablero = new Tablero();
         Jugador unJugador = new Jugador("Tomas");
         Area areaCasillo = unTablero.definirArea(0, 0, 3, 3);
         Edificio unCastillo = new Castillo(areaCasillo);
         unJugador.agregarPieza(unCastillo);
         Assert.assertEquals( 0, unJugador.getPoblacion());
        Assert.assertFalse(unJugador.castilloFueDestruido());
    }
     @Test
    public void seActualizaLaPoblacion() throws Excepcion{
    	 Tablero unTablero = new Tablero();
         Jugador unJugador = new Jugador("Tomas");
         Area areaCasillo = unTablero.definirArea(0, 0, 3, 3);
         Area espacioAldeano = unTablero.definirArea(4, 4, 4, 4);
         Edificio unCastillo = new Castillo(areaCasillo);
         Aldeano unAldeano = new Aldeano(espacioAldeano);
         unJugador.agregarPieza(unCastillo);
         Assert.assertEquals(0, unJugador.getPoblacion());
         unJugador.agregarPieza(unAldeano);
         Assert.assertEquals( 1, unJugador.getPoblacion());
         unJugador.agregarPieza(unAldeano);
         Assert.assertEquals(2, unJugador.getPoblacion());
    }
     @Test
    public void seRecolectaOroDeUnAldeano() throws Excepcion{
    	 Tablero unTablero = new Tablero();
         Jugador unJugador = new Jugador("Tomas");
         Area espacioAldeano = unTablero.definirArea(0, 0, 0, 0);
         Aldeano unAldeano = new Aldeano(espacioAldeano);
         Assert.assertEquals(100, unJugador.obtenerOro());
         unJugador.agregarPieza(unAldeano);
         unJugador.finalizarTurno();
         Assert.assertEquals(120, unJugador.obtenerOro());
         unJugador.finalizarTurno();
         Assert.assertEquals(140, unJugador.obtenerOro());
     }

}
