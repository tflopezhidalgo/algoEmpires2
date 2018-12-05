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
        Juego unJuego = new Juego();
        Jugador jugador1 = new Jugador("Ailen");
        Jugador jugador2 = new Jugador("Laura");

        jugador1.setListener(unJuego);
        jugador2.setListener(unJuego);

        unJuego.iniciarJuego();

        unJuego.agregarJugador(jugador1);
        unJuego.agregarJugador(jugador2);

        boolean lanzaUnError=false;
        try{
            Jugador ganador = unJuego.seleccionarGanador();
        } catch(JuegoNoTerminadoError e){
            lanzaUnError=true;
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

        Assert.assertTrue(lanzaUnError);
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

        Assert.assertTrue(lanzaUnError);
    }

    @Test
    public void ganadorDePartida() throws Exception{
        Juego unJuego = new Juego();
        Jugador jugador1 = new Jugador("Ailen");
        Jugador jugador2 = new Jugador("Laura");

        jugador1.setListener(unJuego);
        jugador2.setListener(unJuego);

        unJuego.agregarJugador(jugador1);
        unJuego.agregarJugador(jugador2);

        Aldeano unAldeano = new Aldeano(2,2);
        Castillo unCastillo = new Castillo(5,5);

        jugador1.agregar(unAldeano);
        jugador1.agregar(unCastillo);

        Castillo otroCastillo = new Castillo(10,10);

        jugador2.agregar(otroCastillo);

        unJuego.iniciarJuego();

        unJuego.finalizarTurno();

        unJuego.finalizarTurno(); //El juego ya cambia de jugador cuando le pasa finalizarTurno()

        unCastillo.recibirDanio(1000);

        Assert.assertEquals(jugador1, unJuego.seleccionarGanador());
    }
}
