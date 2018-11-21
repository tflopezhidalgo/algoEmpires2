package modelo.estadoJuego;

import modelo.*;
import java.util.List;

public class JuegaJugador1 extends estadoJuego{

    public Jugador getJugadorActual(List<Jugador> jugadores){

        return jugadores.get(0);
    }

    @Override
    public estadoJuego finalizarTurno(){

        return (new JuegaJugador2());
    }


}
