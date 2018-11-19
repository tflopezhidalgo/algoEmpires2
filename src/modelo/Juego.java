package modelo;

import controlador.Controlador;
import java.util.List;

enum Estado {NO_COMENZADO, JUGANDO, TERMINADO};

public class Juego {

    private Controlador controlador;
    private List<Jugador> jugadores;
    private Tablero tablero;
    private Estado estadoJuego;

    public Juego(String nombreJugador1, String nombreJugador2) throws Exception{

        jugadores.add(new Jugador(nombreJugador1));
        jugadores.add(new Jugador(nombreJugador2));
        this.tablero = new Tablero();
        this.estadoJuego = Estado.NO_COMENZADO;
    }

    public void setControlador(Controlador controlador) {

        this.controlador = controlador;
    }

    public void iniciarJuego() throws Excepcion{

        this.estadoJuego = Estado.JUGANDO;

        jugadores.get(0).asignarPiezas(tablero.generarPiezasInicialesEquipo1());
        jugadores.get(1).asignarPiezas(tablero.generarPiezasInicialesEquipo2());

    }

    public void finalizarTurno(){



    }



}
