package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import modelo.estadoJuego.*;

public class Juego implements CastilloListener{

    public final int JUGADORES_MAXIMOS = 2;

    private List<Jugador> jugadores;
    private JuegoTerminadoListener juegoListener;
    private Tablero tablero;
    private EstadoJuego estado;

    private void seleccionarJugadorInicial(){

        int numeroRandom = ThreadLocalRandom.current().nextInt(0, 2);

        if(numeroRandom == 0)

            this.estado = new JuegaJugador1();
        else

            this.estado = new JuegaJugador2();

    }

    public Juego(){

        this.juegoListener = null;
        this.estado = new NoComenzado();
        this.jugadores = new ArrayList();
        this.tablero = null;
    }

    public void setListenerJuegoTerminado(JuegoTerminadoListener listener){

        this.juegoListener = listener;
    }


    public void agregarJugador(Jugador unJugador) {
        if(this.jugadores.size() < 2) {

            jugadores.add(unJugador);
            unJugador.setListener(this);
        }
    }
    
    public void agregarTablero(Tablero unTablero) {

    	tablero = unTablero;
    }
    
    public void iniciarJuego(){

        this.seleccionarJugadorInicial();
    }

    public void iniciarJuegoNoRandom(){

        estado = new JuegaJugador1();
    }

    public Jugador getJugadorActual(){
        return (this.estado.getJugadorActual(this.jugadores));
    }
    
    public Jugador getJugadorEnemigo(){
        return (this.estado.getJugadorEnemigo(this.jugadores));
    }

    public void finalizarTurno(){

        this.estado = estado.finalizarTurno(jugadores);
    }

    public Jugador seleccionarGanador(){
        return (estado.seleccionarGanador(this.jugadores));
    }

    public void castilloFueDestruido(){

        estado = new Terminado();
        this.juegoListener.decirGanador();
    }

}
