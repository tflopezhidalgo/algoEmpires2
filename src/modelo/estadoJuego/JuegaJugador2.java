package modelo.estadoJuego;

import modelo.Jugador;
import java.util.List;

public class JuegaJugador2 extends EstadoJuego {

    public Jugador getJugadorActual(List<Jugador> jugadores){

        return jugadores.get(1);
    }

    @Override
    public EstadoJuego finalizarTurno(){

        return (new JuegaJugador1());
    }


}
