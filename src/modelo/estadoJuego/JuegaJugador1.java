package modelo.estadoJuego;

import java.util.List;

import modelo.Jugador;

public class JuegaJugador1 extends EstadoJuego{

    public Jugador getJugadorActual(List<Jugador> jugadores){

        return jugadores.get(0);
    }

    @Override
    public EstadoJuego finalizarTurno(){

        return (new JuegaJugador2());
    }


}
