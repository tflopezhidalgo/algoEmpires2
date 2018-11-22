package modelo.estadoJuego;

import modelo.*;
import java.util.List;

public class JuegaJugador1 extends EstadoJuego{

    public Jugador getJugadorActual(List<Jugador> jugadores){

        return jugadores.get(0);
    }

    @Override
    public EstadoJuego finalizarTurno(){

        return (new JuegaJugador2());
    }


}
