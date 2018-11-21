package modelo.estadoJuego;

import modelo.Jugador;
import modelo.excepciones.JuegoNoTerminadoError;
import modelo.excepciones.NoExistenJugadoresActualesError;
import modelo.excepciones.NoHayJuegoEnProcesoError;
import java.util.List;

public abstract class estadoJuego {

     abstract public Jugador getJugadorActual(List<Jugador> jugadores) throws NoExistenJugadoresActualesError;

     public estadoJuego finalizarTurno() throws NoHayJuegoEnProcesoError{

         throw new NoHayJuegoEnProcesoError();
     }

     public Jugador seleccionarGanador(List<Jugador> jugadores) throws Exception{

         throw new JuegoNoTerminadoError();
     }


}
