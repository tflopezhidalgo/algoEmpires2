import modelo.*;
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
        Juego unJuego = new Juego("Ailen", "Laura");

        List<Pieza> listaPiezas = new ArrayList<>();
        Tablero unTablero = unJuego.getTablero();
        listaPiezas.add(new Aldeano(unTablero.definirArea(2,2,2,2)));
        Castillo unCastillo = new Castillo(unTablero.definirArea(5,5,5,5));
        listaPiezas.add(unCastillo);

        List<Pieza> listaPiezas2 = new ArrayList<>();
        Castillo otroCastillo = new Castillo(unTablero.definirArea(10,10,10,10));
        listaPiezas2.add(otroCastillo);

        unJuego.iniciarJuego(listaPiezas, listaPiezas2);

        unJuego.finalizarTurno();

        unJuego.finalizarTurno();


        boolean lanzaUnError=false;
        try{
            Jugador ganador = unJuego.seleccionarGanador();
        } catch(JuegoNoTerminadoError e){
            lanzaUnError=true;
        }
    }

    @Test
    public void noExistenJugadoresActuales() {
        Juego unJuego = new Juego("Tomas", "Ivo");

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
        Juego unJuego = new Juego("Ailen", "Laura");

        boolean lanzaUnError=false;
        try{
            Jugador ganador = unJuego.seleccionarGanador();
        } catch(NoHayJuegoEnProcesoError e){
            lanzaUnError=true;
        }

        Assert.assertEquals(true, lanzaUnError);
    }
}
