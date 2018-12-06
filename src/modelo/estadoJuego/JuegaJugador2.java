package modelo.estadoJuego;

import java.util.List;

import modelo.Jugador;

public class JuegaJugador2 extends EstadoJuego {

    public Jugador getJugadorActual(List<Jugador> jugadores){

        return jugadores.get(1);
    }

    @Override
    public EstadoJuego finalizarTurno(List<Jugador> jugadores){

    	jugadores.get(1).finalizarTurno();
        return (new JuegaJugador1());
    }

	public Jugador getJugadorEnemigo(List<Jugador> jugadores) {

        return jugadores.get(0);
	}


}
