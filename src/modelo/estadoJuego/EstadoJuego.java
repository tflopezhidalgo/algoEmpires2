package modelo.estadoJuego;

import modelo.Jugador;
import modelo.excepciones.JuegoNoTerminadoError;
import modelo.excepciones.NoExistenJugadoresActualesError;
import modelo.excepciones.NoHayJuegoEnProcesoError;
import java.util.List;

public abstract class EstadoJuego {

     abstract public Jugador getJugadorActual(List<Jugador> jugadores) throws NoExistenJugadoresActualesError;

     public EstadoJuego finalizarTurno() throws NoHayJuegoEnProcesoError{

         throw new NoHayJuegoEnProcesoError();
     }

     public Jugador seleccionarGanador(List<Jugador> jugadores) throws Exception{

         throw new JuegoNoTerminadoError();
     }


}
