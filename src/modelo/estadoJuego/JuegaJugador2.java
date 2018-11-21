package modelo.estadoJuego;

import modelo.Jugador;
import java.util.List;

public class JuegaJugador2 extends estadoJuego {

    public Jugador getJugadorActual(List<Jugador> jugadores){

        return jugadores.get(1);
    }

    @Override
    public estadoJuego finalizarTurno(){

        return (new JuegaJugador1());
    }


}
