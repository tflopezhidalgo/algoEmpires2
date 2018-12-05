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
        Tablero unTablero = unJuego.getTablero();

        List<Pieza> listaPiezas = new ArrayList<>();
        listaPiezas.add(new Aldeano(2,2));
        Castillo unCastillo = new Castillo(5,5);
        listaPiezas.add(unCastillo);

        List<Pieza> listaPiezas2 = new ArrayList<>();
        Castillo otroCastillo = new Castillo(10,10);
        listaPiezas2.add(otroCastillo);

        unJuego.iniciarJuego(listaPiezas, listaPiezas2);

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

    @Test
    public void ganadorDePartida() throws Exception{
        Juego unJuego = new Juego("Ailen", "Tomas");
        Tablero unTablero = unJuego.getTablero();

        List<Pieza> piezasJugador1 = new ArrayList<Pieza>();
        List<Pieza> piezasJugador2 = new ArrayList<Pieza>();

        Castillo unCastillo = new Castillo(0,0);

        piezasJugador1.add(unCastillo);
        piezasJugador2.add(new Castillo(4,4));

        unJuego.iniciarJuego(piezasJugador1, piezasJugador2);

        unJuego.finalizarTurno();

        unJuego.finalizarTurno(); //El juego ya cambia de jugador cuando le pasa finalizarTurno()

        Castillo castilloJugador1 = unCastillo;

        castilloJugador1.recibirDanio(1000);

        Assert.assertEquals("Tomas", unJuego.seleccionarGanador().obtenerNombre());
    }
}
