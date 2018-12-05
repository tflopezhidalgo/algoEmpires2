import modelo.*;
import modelo.excepciones.PoblacionLimiteSuperadaError;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JugadorTest {

     @Test
    public void seCreaJugadorConNombre(){
         Jugador unJugador = new Jugador("Tomas");
         Assert.assertEquals("Tomas", unJugador.obtenerNombre());
         Assert.assertEquals(100, unJugador.obtenerOro());
         Assert.assertEquals(0, unJugador.getPoblacion());
    }
    @Test
    public void seAgregaUnaPiezaAJugador() {
    	 Tablero unTablero = new Tablero();
    	 Juego nuevoJuego = new Juego();
         Jugador unJugador = new Jugador("Tomas");
         Aldeano unAldeano = new Aldeano(0,0);
         unJugador.agregar(unAldeano);
         unJugador.agregar(new Castillo(10, 10));
         nuevoJuego.agregarJugador(unJugador);

         nuevoJuego.iniciarJuego();

         Assert.assertEquals( 1, unJugador.getPoblacion());
         Assert.assertFalse(unJugador.tieneCastilloDestruido());
     }

     //TODO: Chequear que está usandoe el agregar(Castillo instancia)
    /*
     @Test
    public void castilloNoFueDestruido() throws Exception {
         Tablero unTablero = new Tablero();
         Jugador unJugador = new Jugador("Tomas");
         Edificio unCastillo = new Castillo(0,0);
         unJugador.agregar(unCastillo);

         Assert.assertEquals( 0, unJugador.getPoblacion());
         Assert.assertFalse(unJugador.tieneCastilloDestruido());
    }*/
     @Test
    public void seActualizaLaPoblacion(){

    	 Tablero unTablero = new Tablero();
         Jugador unJugador = new Jugador("Tomas");
         Edificio unCastillo = new Castillo(0,0);
         Aldeano unAldeano = new Aldeano(4,4);

         unJugador.agregar(unCastillo);

         Assert.assertEquals(0, unJugador.getPoblacion());

         unJugador.agregar(unAldeano);

         Assert.assertEquals( 1, unJugador.getPoblacion());

         unJugador.agregar(unAldeano);

         Assert.assertEquals(2, unJugador.getPoblacion());

    }

    //TODO: Chequear porque depende del random().
   /*  @Test
    public void seRecolectaOroDeUnAldeano(){

    	 Tablero unTablero = new Tablero();
         Jugador unJugador = new Jugador("Tomas");
         Aldeano unAldeano = new Aldeano(0,0);
         unJugador.agregar(new Castillo(10,10));
         Juego nuevoJuego = new Juego();
         nuevoJuego.agregarJugador(unJugador);
         nuevoJuego.iniciarJuegoNoRandom();

         Assert.assertEquals(100, unJugador.obtenerOro());

         unJugador.agregar(unAldeano);
         unJugador.finalizarTurno();

         Assert.assertEquals(120, unJugador.obtenerOro());

         unJugador.finalizarTurno();

         Assert.assertEquals(140, unJugador.obtenerOro());
     }*/

     @Test
    public void poblacionLimiteSuperada() {
         Tablero unTablero = new Tablero();
         Jugador unJugador = new Jugador("Ailen");

         //Le agrego a un jugador 50 aldeanos, siendo 50 el limite de la poblacion
         for(int i=0; i<16; i++){
             unJugador.agregar(new Aldeano(i,0));
         }
         for(int j=1; j<16; j++){
             unJugador.agregar(new Aldeano(0,j));
         }
         for(int k=1; k<16; k++){
             unJugador.agregar(new Aldeano(k,k));
         }
         for(int l=2; l<6; l++){
             unJugador.agregar(new Aldeano(l,1));
         }


         boolean lanzaUnError=false;
         try{
             unJugador.agregar(new Aldeano(6,1));
         } catch (PoblacionLimiteSuperadaError e){
             lanzaUnError=true;
         }

         Assert.assertEquals(true, lanzaUnError);
     }

    @Test
    public void finalizarTurnoJugador() {
        Tablero unTablero = new Tablero();
        Jugador unJugador = new Jugador("Tomas");
        unJugador.agregar(new Castillo(10, 10));
        Aldeano unAldeano = new Aldeano(0,0);
        Juego nuevoJuego = new Juego();
        nuevoJuego.agregarJugador(unJugador);
        nuevoJuego.iniciarJuegoNoRandom();

        Assert.assertEquals(100, unJugador.obtenerOro());
        Assert.assertEquals(0, unJugador.getPoblacion());

        unJugador.agregar(unAldeano);
        unJugador.finalizarTurno();

        Assert.assertEquals(120, unJugador.obtenerOro());
        Assert.assertEquals(1, unJugador.getPoblacion());
    }
    //TODO: Arreglar cosas poque tira excepcion
    /*
    @Test
    public void agregarPiezas(){

         Juego unJuego = new Juego();
         Tablero unTablero = new Tablero();
         Jugador unJugador = new Jugador("Tomas");
         unJugador.agregar(new Castillo(10 , 10));
         unJuego.agregarJugador(unJugador);
         unJuego.iniciarJuego();

         Assert.assertEquals(100, unJugador.obtenerOro());
         Assert.assertEquals(0, unJugador.getPoblacion());

         Aldeano unAldeano = new Aldeano(0,0);
         unJugador.agregar(unAldeano);
         unJugador.finalizarTurno();

         Assert.assertEquals(120, unJugador.obtenerOro());
         Assert.assertEquals(1, unJugador.getPoblacion());

         Aldeano otroAldeano = new Aldeano(0,1);
         unJugador.agregar(otroAldeano);
         unJugador.finalizarTurno();

         Assert.assertEquals(160, unJugador.obtenerOro());
         Assert.assertEquals(2, unJugador.getPoblacion());

         Arquero unArquero = new Arquero(1,1);
         unJugador.agregar(unArquero);
         unJugador.finalizarTurno();

         Assert.assertEquals(160, unJugador.obtenerOro());
         Assert.assertEquals(3, unJugador.getPoblacion());

    }

    @Test
    public void agregarMasPiezas() throws Exception{
        Tablero unTablero = new Tablero();
        Jugador unJugador = new Jugador("Tomas");
        Assert.assertEquals(0, unJugador.getPoblacion());

        Area espacioUnidad = unTablero.definirArea(0, 0, 0, 0);
        Aldeano unAldeano = new Aldeano(0,0);
        unJugador.agregar(unAldeano);
        unJugador.finalizarTurno();
        Assert.assertEquals(1, unJugador.getPoblacion());

        espacioUnidad = unTablero.definirArea(0, 1, 0, 1);
        Aldeano otroAldeano = new Aldeano(0,1);
        unJugador.agregar(otroAldeano);
        unJugador.finalizarTurno();
        Assert.assertEquals(2, unJugador.getPoblacion());

        espacioUnidad = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(1,1);
        unJugador.agregar(unArquero);
        unJugador.finalizarTurno();
        Assert.assertEquals(3, unJugador.getPoblacion());

        espacioUnidad = unTablero.definirArea(1, 2, 1, 2);
        Arquero otroArquero = new Arquero(1,2);
        unJugador.agregar(otroArquero);
        unJugador.finalizarTurno();
        Assert.assertEquals(4, unJugador.getPoblacion());

        espacioUnidad = unTablero.definirArea(2, 2, 2, 2);
        Arquero otroArquero2 = new Arquero(2,2);
        unJugador.agregar(otroArquero2);
        unJugador.finalizarTurno();
        Assert.assertEquals(5, unJugador.getPoblacion());

    }
*/
}
