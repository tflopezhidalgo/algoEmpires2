package modelo.estadoJuego;

import java.util.List;

import modelo.Jugador;
import modelo.excepciones.NoExistenJugadoresActualesError;
import modelo.excepciones.NoHayJuegoEnProcesoError;

public class NoComenzado extends EstadoJuego{

    public Jugador getJugadorActual(List<Jugador> jugadores) {

        throw new NoExistenJugadoresActualesError();
    }
    
    public Jugador getJugadorEnemigo(List<Jugador> jugadores) {

        throw new NoExistenJugadoresActualesError();
    }

    @Override
    public Jugador seleccionarGanador(List<Jugador> jugadores) {

        throw new NoHayJuegoEnProcesoError();
    }
}
