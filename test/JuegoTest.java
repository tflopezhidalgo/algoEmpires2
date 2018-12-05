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
        Jugador jugador1 = new Jugador("Laura");
        Jugador jugador2 = new Jugador("Ailen");

        unJuego.agregarJugador(jugador1);
        unJuego.agregarJugador(jugador2);

        jugador1.setListener(unJuego);
        jugador2.setListener(unJuego);

        unJuego.iniciarJuego();

        boolean lanzaUnError=false;
        try{
            Jugador ganador = unJuego.seleccionarGanador();
        } catch(JuegoNoTerminadoError e){
            lanzaUnError=true;
        }
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
    public void ganadorDePartida() throws Exception{
        Juego unJuego = new Juego();
        Jugador jugador1 = new Jugador("Tomas");
        Jugador jugador2 = new Jugador("Laura");

        Castillo unCastillo = new Castillo(0,0);

        jugador1.agregar(unCastillo);

        Castillo otroCastillo = new Castillo(4,4);

        jugador2.agregar(otroCastillo);

        unJuego.iniciarJuego();

        unJuego.finalizarTurno();

        unJuego.finalizarTurno(); //El juego ya cambia de jugador cuando le pasa finalizarTurno()

        unCastillo.recibirDanio(1000);

        Assert.assertEquals("Laura", unJuego.seleccionarGanador().obtenerNombre());
    }
}
