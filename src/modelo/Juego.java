package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import modelo.estadoJuego.*;

public class Juego implements CastilloListener{

    public final int JUGADORES_MAXIMOS = 2;

    private List<Jugador> jugadores = new ArrayList<>();
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

        this.estado = new NoComenzado();
    }

    public Juego(String nombreJugador1, String nombreJugado2){

        this.estado = new NoComenzado();
    }
    
    public void agregarJugador(Jugador unJugador) {
    	if(jugadores.size() < JUGADORES_MAXIMOS) {
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
    }

}
