import modelo.*;
import modelo.excepciones.PoblacionLimiteSuperadaError;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/*
public class JugadorTest {

     @Test
    public void seCreaJugadorConNombre(){
         Jugador unJugador = new Jugador("Tomas");
         Assert.assertEquals("Tomas", unJugador.obtenerNombre());
         Assert.assertEquals(100, unJugador.obtenerOro());
         Assert.assertEquals(0, unJugador.getPoblacion());
    }
    @Test
    public void seAgregaUnaPiezaAJugador() throws Exception{
    	 Tablero unTablero = new Tablero();
         Jugador unJugador = new Jugador("Tomas");
         Area espacioAldeano = unTablero.definirArea(0, 0, 0, 0);
         Aldeano unAldeano = new Aldeano(0,0);
         unJugador.agregarPieza(unAldeano);
         Assert.assertEquals( 1, unJugador.getPoblacion());
         Assert.assertTrue(unJugador.castilloFueDestruido());
     }
     @Test
    public void castilloNoFueDestruido() throws Exception {
    	 Tablero unTablero = new Tablero();
         Jugador unJugador = new Jugador("Tomas");
         Area areaCasillo = unTablero.definirArea(0, 0, 3, 3);
         Edificio unCastillo = new Castillo(0,0);
         unJugador.agregarPieza(unCastillo);
         Assert.assertEquals( 0, unJugador.getPoblacion());
        Assert.assertFalse(unJugador.castilloFueDestruido());
    }
     @Test
    public void seActualizaLaPoblacion() throws Exception{
    	 Tablero unTablero = new Tablero();
         Jugador unJugador = new Jugador("Tomas");
         Area areaCasillo = unTablero.definirArea(0, 0, 3, 3);
         Area espacioAldeano = unTablero.definirArea(4, 4, 4, 4);
         Edificio unCastillo = new Castillo(0,0);
         Aldeano unAldeano = new Aldeano(4,4);
         unJugador.agregarPieza(unCastillo);
         Assert.assertEquals(0, unJugador.getPoblacion());
         unJugador.agregarPieza(unAldeano);
         Assert.assertEquals( 1, unJugador.getPoblacion());
         unJugador.agregarPieza(unAldeano);
         Assert.assertEquals(2, unJugador.getPoblacion());
    }
     @Test
    public void seRecolectaOroDeUnAldeano() throws Exception{
    	 Tablero unTablero = new Tablero();
         Jugador unJugador = new Jugador("Tomas");
         Area espacioAldeano = unTablero.definirArea(0, 0, 0, 0);
         Aldeano unAldeano = new Aldeano(0,0);
         Assert.assertEquals(100, unJugador.obtenerOro());
         unJugador.agregarPieza(unAldeano);
         unJugador.finalizarTurno();
         Assert.assertEquals(95, unJugador.obtenerOro()); //100-25+20=95
         unJugador.finalizarTurno();
         Assert.assertEquals(115, unJugador.obtenerOro()); //95+25=115
     }

     @Test
    public void poblacionLimiteSuperada() throws Exception{
         Tablero unTablero = new Tablero();
         Jugador unJugador = new Jugador("Ailen");

         //Le agrego a un jugador 50 aldeanos, siendo 50 el limite de la poblacion
         for(int i=0; i<16; i++){
             unJugador.agregarPieza(new Aldeano(i,0));
         }
         for(int j=1; j<16; j++){
             unJugador.agregarPieza(new Aldeano(0,j));
         }
         for(int k=1; k<16; k++){
             unJugador.agregarPieza(new Aldeano(k,k));
         }
         for(int l=2; l<6; l++){
             unJugador.agregarPieza(new Aldeano(l,1));
         }


         boolean lanzaUnError=false;
         try{
             unJugador.agregarPieza(new Aldeano(6,1));
         } catch (PoblacionLimiteSuperadaError e){
             lanzaUnError=true;
         }

         Assert.assertEquals(true, lanzaUnError);
     }

    @Test
    public void finalizarTurno() throws Exception{
        Tablero unTablero = new Tablero();
        Jugador unJugador = new Jugador("Tomas");
        Area espacioAldeano = unTablero.definirArea(0, 0, 0, 0);
        Aldeano unAldeano = new Aldeano(0,0);
        Assert.assertEquals(100, unJugador.obtenerOro());
        Assert.assertEquals(0, unJugador.getPoblacion());

        unJugador.agregarPieza(unAldeano);
        unJugador.finalizarTurno();
        Assert.assertEquals(95, unJugador.obtenerOro());
        Assert.assertEquals(1, unJugador.getPoblacion());

    }

    @Test
    public void finalizarTurnoJugador() throws Exception{
        Tablero unTablero = new Tablero();
        Jugador unJugador = new Jugador("Tomas");
        Area espacioAldeano = unTablero.definirArea(0, 0, 0, 0);
        Aldeano unAldeano = new Aldeano(0,0);
        Assert.assertEquals(100, unJugador.obtenerOro());
        Assert.assertEquals(0, unJugador.getPoblacion());

        unJugador.agregarPieza(unAldeano);
        unJugador.finalizarTurno();
        Assert.assertEquals(95, unJugador.obtenerOro());
        Assert.assertEquals(1, unJugador.getPoblacion());

    }

    @Test
    public void agregarPiezas() throws Exception{
        Tablero unTablero = new Tablero();
        Jugador unJugador = new Jugador("Tomas");
        Assert.assertEquals(100, unJugador.obtenerOro());
        Assert.assertEquals(0, unJugador.getPoblacion());

        Area espacioAldeano = unTablero.definirArea(0, 0, 0, 0);
        Aldeano unAldeano = new Aldeano(0,0);
        unJugador.agregarPieza(unAldeano);
        unJugador.finalizarTurno();
        Assert.assertEquals(95, unJugador.obtenerOro()); //100-25+20=95
        Assert.assertEquals(1, unJugador.getPoblacion());

        Area espacioOtroAldeano = unTablero.definirArea(0, 1, 0, 1);
        Aldeano otroAldeano = new Aldeano(0,1);
        unJugador.agregarPieza(otroAldeano);
        unJugador.finalizarTurno();
        Assert.assertEquals(110, unJugador.obtenerOro()); //95-25+20+20=110
        Assert.assertEquals(2, unJugador.getPoblacion());

        Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(1,1);
        unJugador.agregarPieza(unArquero);
        unJugador.finalizarTurno();
        Assert.assertEquals(75, unJugador.obtenerOro()); //110-75+20+20=75
        Assert.assertEquals(3, unJugador.getPoblacion());

    }

    @Test
    public void agregarMasPiezas() throws Exception{
        Tablero unTablero = new Tablero();
        Jugador unJugador = new Jugador("Tomas");
        Assert.assertEquals(0, unJugador.getPoblacion());

        Area espacioUnidad = unTablero.definirArea(0, 0, 0, 0);
        Aldeano unAldeano = new Aldeano(0,0);
        unJugador.agregarPieza(unAldeano);
        unJugador.finalizarTurno();
        Assert.assertEquals(1, unJugador.getPoblacion());

        espacioUnidad = unTablero.definirArea(0, 1, 0, 1);
        Aldeano otroAldeano = new Aldeano(0,1);
        unJugador.agregarPieza(otroAldeano);
        unJugador.finalizarTurno();
        Assert.assertEquals(2, unJugador.getPoblacion());

        espacioUnidad = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(1,1);
        unJugador.agregarPieza(unArquero);
        unJugador.finalizarTurno();
        Assert.assertEquals(3, unJugador.getPoblacion());

        espacioUnidad = unTablero.definirArea(1, 2, 1, 2);
        Arquero otroArquero = new Arquero(1,2);
        unJugador.agregarPieza(otroArquero);
        unJugador.finalizarTurno();
        Assert.assertEquals(4, unJugador.getPoblacion());

        espacioUnidad = unTablero.definirArea(2, 2, 2, 2);
        Arquero otroArquero2 = new Arquero(2,2);
        unJugador.agregarPieza(otroArquero2);
        unJugador.finalizarTurno();
        Assert.assertEquals(5, unJugador.getPoblacion());

    }

}
*/
