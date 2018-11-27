package modelo.estadoJuego;

import java.util.List;

import modelo.Jugador;
import modelo.excepciones.JuegoNoTerminadoError;
import modelo.excepciones.NoHayJuegoEnProcesoError;

public abstract class EstadoJuego {

     abstract public Jugador getJugadorActual(List<Jugador> jugadores);

     public EstadoJuego finalizarTurno(){

         throw new NoHayJuegoEnProcesoError();
     }

     public Jugador seleccionarGanador(List<Jugador> jugadores){

         throw new JuegoNoTerminadoError();
     }


}
