package modelo.estadoJuego;

import java.util.List;

import modelo.Jugador;
import modelo.excepciones.JuegoNoTerminadoError;
import modelo.excepciones.NoHayJuegoEnProcesoError;

public abstract class EstadoJuego {

     abstract public Jugador getJugadorActual(List<Jugador> jugadores);
     
     abstract public Jugador getJugadorEnemigo(List<Jugador> jugadores);

     public EstadoJuego finalizarTurno(List<Jugador> jugadores){

         throw new NoHayJuegoEnProcesoError();
     }

     public Jugador seleccionarGanador(List<Jugador> jugadores){

         throw new JuegoNoTerminadoError();
     }


}
