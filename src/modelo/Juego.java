package modelo;

import controlador.Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import modelo.estadoJuego.*;
import modelo.excepciones.Excepcion;
import modelo.excepciones.NoExistenJugadoresActualesError;

public class Juego {

    private Controlador controlador;
    private List<Jugador> jugadores;
    private Tablero tablero;
    private estadoJuego estado;

    //TODO: Chequear explícitamente que devuelve valores válidos.
    private void seleccionarJugadorInicial(){
        int numeroRandom = ThreadLocalRandom.current().nextInt(0, 2);

        if(numeroRandom == 0)
            this.estado = new JuegaJugador1();
        else
            this.estado = new JuegaJugador2();
    }

    //TODO: Agregar posibilidad de definir un tamaño inicial de tablero.
    public Juego(String nombreJugador1, String nombreJugador2) throws Exception{

        jugadores = new ArrayList<>();
        jugadores.add(new Jugador(nombreJugador1));
        jugadores.add(new Jugador(nombreJugador2));
        this.tablero = new Tablero();
        this.estado = new NoComenzado();
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void iniciarJuego() throws Excepcion {

        seleccionarJugadorInicial();

        jugadores.get(0).asignarPiezas(tablero.generarPiezasInicialesEquipo1());
        jugadores.get(1).asignarPiezas(tablero.generarPiezasInicialesEquipo2());

    }

    public Tablero getTablero(){
        return this.tablero;
    }

    public Jugador getJugadorActual() throws NoExistenJugadoresActualesError{

        return (this.estado.getJugadorActual(this.jugadores));
    }

    public void finalizarTurno() throws Exception{

        if(estado.getJugadorActual(this.jugadores).castilloFueDestruido())
            this.estado = new Terminado();
        else
            this.estado = estado.finalizarTurno();
    }

    public Jugador seleccionarGanador() throws Exception{

        return (estado.seleccionarGanador(this.jugadores));

    }



}
