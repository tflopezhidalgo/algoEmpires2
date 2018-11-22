package modelo.estadoJuego;

import modelo.excepciones.*;
import modelo.Jugador;
import java.util.List;

public class Terminado extends EstadoJuego {

    public Jugador getJugadorActual(List<Jugador> jugadores) throws NoExistenJugadoresActualesError{

        throw new NoExistenJugadoresActualesError();
    }

    @Override
    public Jugador seleccionarGanador(List<Jugador> jugadores){

        //Suponemos un ganador SI o SI.
        if(jugadores.get(0).castilloFueDestruido())
            return jugadores.get(0);
        else
            return jugadores.get(1);
    }
}
