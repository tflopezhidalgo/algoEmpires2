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

/*        Tablero unTablero = unJuego.getTablero();

        List<Pieza> piezasJugador1 = new ArrayList<Pieza>();
        List<Pieza> piezasJugador2 = new ArrayList<Pieza>();

        piezasJugador1.add(new Castillo(unTablero.definirArea(0,0,3,3)));
        piezasJugador2.add(new Castillo(unTablero.definirArea(4,4,8,8)));

        unJuego.iniciarJuego(piezasJugador1, piezasJugador2);           */


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

    /*@Test
    public void partidaCompleta() throws Exception{
        Juego unJuego = new Juego("Ailen", "Tomas");
        Tablero unTablero = unJuego.getTablero();

        List<Pieza> piezasJugador1 = new ArrayList<Pieza>();
        List<Pieza> piezasJugador2 = new ArrayList<Pieza>();

        Castillo unCastillo = new Castillo(unTablero.definirArea(0,0,3,3));

        piezasJugador1.add(unCastillo);
        piezasJugador2.add(new Castillo(unTablero.definirArea(4,4,8,8)));

        unJuego.iniciarJuego(piezasJugador1, piezasJugador2);

        Jugador jugador1 = unJuego.getJugadorActual();
        jugador1.finalizarTurno();

        Jugador jugador2 = unJuego.getJugadorActual();
        jugador2.finalizarTurno();

        Castillo castilloJugador1 = (Castillo) piezasJugador1.get(piezasJugador1.lastIndexOf(unCastillo));

        castilloJugador1.recibirDanio(1000);

        Assert.assertEquals(jugador2, unJuego.seleccionarGanador());
    }*/
}
