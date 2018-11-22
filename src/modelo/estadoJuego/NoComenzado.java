package modelo.estadoJuego;

import modelo.excepciones.*;
import modelo.*;
import java.util.List;

public class NoComenzado extends EstadoJuego{

    public Jugador getJugadorActual(List<Jugador> jugadores) {

        throw new NoExistenJugadoresActualesError();
    }

    @Override
    public Jugador seleccionarGanador(List<Jugador> jugadores) {

        throw new NoHayJuegoEnProcesoError();
    }
}
