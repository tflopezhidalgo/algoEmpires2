package modelo;

import controlador.Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

enum Estado {NO_COMENZADO, JUEGA_JUGADOR1, JUEGA_JUGADOR2, TERMINADO};

public class Juego {

    private Controlador controlador;
    private List<Jugador> jugadores;
    private Tablero tablero;
    private Estado estadoJuego;

    //TODO: Chequear explícitamente que devuelve valores válidos.
    private Estado seleccionarJugadorInicial(){

        int numeroRandom = ThreadLocalRandom.current().nextInt(0, 2);

        if(numeroRandom == 0)
            return Estado.JUEGA_JUGADOR1;
        else
            return Estado.JUEGA_JUGADOR2;
    }

    //TODO: Agregar posibilidad de definir un tamaño inicial de tablero.
    public Juego(String nombreJugador1, String nombreJugador2) throws Exception{

        jugadores = new ArrayList<>();
        jugadores.add(new Jugador(nombreJugador1));
        jugadores.add(new Jugador(nombreJugador2));
        this.tablero = new Tablero();
        this.estadoJuego = Estado.NO_COMENZADO;
    }

    public void setControlador(Controlador controlador) {

        this.controlador = controlador;
    }

    public void iniciarJuego() throws Excepcion{

        this.estadoJuego = seleccionarJugadorInicial();

        jugadores.get(0).asignarPiezas(tablero.generarPiezasInicialesEquipo1());
        jugadores.get(1).asignarPiezas(tablero.generarPiezasInicialesEquipo2());

    }

    public Tablero getTablero(){

        return this.tablero;
    }

    public Jugador getJugadorActual(){

        if(estadoJuego == Estado.JUEGA_JUGADOR1)

            return jugadores.get(0);
        else if(estadoJuego == Estado.JUEGA_JUGADOR2)

            return jugadores.get(1);
        else

            return null;
    }

    public void finalizarTurno() throws Excepcion{

        if(estadoJuego == Estado.JUEGA_JUGADOR1)

            this.jugadores.get(0).finalizarTurno();

        else if(estadoJuego == Estado.JUEGA_JUGADOR2)

            this.jugadores.get(1).finalizarTurno();

    }



}
