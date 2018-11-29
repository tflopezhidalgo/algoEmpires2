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
    public void juegoNoTerminadoError() throws Exception{
        Juego unJuego = new Juego("Ailen", "Laura");
        unJuego.iniciarJuego();

        boolean lanzaUnError=false;
        try{
            Jugador ganador = unJuego.seleccionarGanador();
        } catch(JuegoNoTerminadoError e){
            lanzaUnError=true;
        }

        Assert.assertEquals(true, lanzaUnError);
    }

    @Test
    public void noExistenJugadoresActuales() throws Exception{
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
    public void noHayJuegoEnProcesoError() throws Exception{
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
