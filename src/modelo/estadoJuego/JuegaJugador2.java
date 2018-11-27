package modelo.estadoJuego;

import java.util.List;

import modelo.Jugador;

public class JuegaJugador2 extends EstadoJuego {

    public Jugador getJugadorActual(List<Jugador> jugadores){

        return jugadores.get(1);
    }

    @Override
    public EstadoJuego finalizarTurno(){

        return (new JuegaJugador1());
    }


}
