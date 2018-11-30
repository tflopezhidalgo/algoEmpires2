package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import modelo.estadoJuego.*;

public class Juego implements CastilloListener{

    private List<Jugador> jugadores;
    private Tablero tablero;
    private EstadoJuego estado;

    private void seleccionarJugadorInicial(){
        int numeroRandom = ThreadLocalRandom.current().nextInt(0, 2);

        if(numeroRandom == 0)
            this.estado = new JuegaJugador1();
        else
            this.estado = new JuegaJugador2();
    }

    public Juego(String nombreJugador1, String nombreJugador2){

        jugadores = new ArrayList<>();
        jugadores.add(new Jugador(nombreJugador1));
        jugadores.add(new Jugador(nombreJugador2));
        this.estado = new NoComenzado();
    }

    public void iniciarJuego(List<Pieza> piezasJugador1, List<Pieza> piezasJugador2){

        seleccionarJugadorInicial();

        ((Castillo)piezasJugador1.get(piezasJugador1.indexOf(Castillo.class))).setCastilloListener(this);
        ((Castillo)piezasJugador2.get(piezasJugador1.indexOf(Castillo.class))).setCastilloListener(this);

        jugadores.get(0).asignarPiezas(piezasJugador1);
        jugadores.get(1).asignarPiezas(piezasJugador2);
    }

    public Tablero getTablero(){
        return this.tablero;
    }

    public Jugador getJugadorActual(){

        return (this.estado.getJugadorActual(this.jugadores));
    }

    public void finalizarTurno(){

        this.estado.getJugadorActual(jugadores).finalizarTurno();
        this.estado = estado.finalizarTurno();
    }

    public Jugador seleccionarGanador(){

        return (estado.seleccionarGanador(this.jugadores));

    }

    public void castilloFueDestruido(){

        estado = new Terminado();
    }

}
