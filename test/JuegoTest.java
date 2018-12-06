import modelo.*;
import modelo.estadoJuego.Terminado;
import modelo.excepciones.JuegoNoTerminadoError;
import modelo.excepciones.NoExistenJugadoresActualesError;
import modelo.excepciones.NoHayJuegoEnProcesoError;
import modelo.excepciones.PoblacionLimiteSuperadaError;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JuegoTest {

    @Test
    public void juegoNoTerminadoError() {

        Tablero nuevoTablero = new Tablero();

        Juego unJuego = new Juego();

        Jugador jugador1 = new Jugador("Laura");
        Jugador jugador2 = new Jugador("Ailen");

        jugador1.agregar(new Castillo(2, 2));
        jugador2.agregar(new Castillo(10,10));

        unJuego.agregarJugador(jugador1);
        unJuego.agregarJugador(jugador2);

        unJuego.iniciarJuego();

        boolean lanzaUnError = false;

        try{

            unJuego.seleccionarGanador();

        } catch(JuegoNoTerminadoError e){

            lanzaUnError = true;
        }

        Assert.assertTrue(lanzaUnError);
    }

    @Test
    public void noExistenJugadoresActuales() {
        Juego unJuego = new Juego();

        boolean lanzaUnError=false;
        try{
            Jugador jugadorActual = unJuego.getJugadorActual();
        } catch (NoExistenJugadoresActualesError e){
            lanzaUnError=true;
        }

        Assert.assertEquals(true, lanzaUnError);
    }

    @Test
    public void noHayJuegoEnProcesoError() {
        Juego unJuego = new Juego();

        boolean lanzaUnError=false;
        try{
            Jugador ganador = unJuego.seleccionarGanador();
        } catch(NoHayJuegoEnProcesoError e){
            lanzaUnError=true;
        }

        Assert.assertEquals(true, lanzaUnError);
    }

    @Test
    public void ganadorDePartida(){

        Juego unJuego = new Juego();

        Tablero nuevoTablero = new Tablero();

        Jugador jugador1 = new Jugador("Tomas");

        Jugador jugador2 = new Jugador("Laura");

        Castillo unCastillo = new Castillo(0,0);

        jugador1.agregar(unCastillo);

        Castillo otroCastillo = new Castillo(10,10);

        jugador2.agregar(otroCastillo);

        unJuego.agregarJugador(jugador1);
        unJuego.agregarJugador(jugador2);

        unJuego.iniciarJuego();

        unJuego.finalizarTurno();

        unJuego.finalizarTurno(); //El juego ya cambia de jugador cuando le pasa finalizarTurno()

        unCastillo.recibirDanio(1000);

        Assert.assertEquals("Laura", unJuego.seleccionarGanador().obtenerNombre());
    }
}
