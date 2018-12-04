package modelo.estadoJuego;

import java.util.List;

import modelo.Jugador;
import modelo.excepciones.NoExistenJugadoresActualesError;

public class Terminado extends EstadoJuego {

    public Jugador getJugadorActual(List<Jugador> jugadores){

        throw new NoExistenJugadoresActualesError();
    }
    
    public Jugador getJugadorEnemigo(List<Jugador> jugadores){

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
