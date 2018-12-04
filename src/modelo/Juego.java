package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.estadoJuego.EstadoJuego;
import modelo.estadoJuego.JuegaJugador1;
import modelo.estadoJuego.NoComenzado;
import modelo.estadoJuego.Terminado;

public class Juego implements CastilloListener{

    private List<Jugador> jugadores = new ArrayList<>();
    private Tablero tablero;
    private EstadoJuego estado;
    public final int JUGADORES_MAXIMOS = 2;

    public Juego(){
    	this.estado = new NoComenzado();
    }
    
    public void agregarJugador(Jugador unJugador) {
    	if(jugadores.size()<JUGADORES_MAXIMOS) {
    		jugadores.add(unJugador);
    		unJugador.setListener(this);	
    	}
    }
    
    public void agregarTablero(Tablero unTablero) {
    	tablero = unTablero;
    }
    
    public void iniciarJuego(){
        this.estado = new JuegaJugador1();
        //TODO eliminar Out's
        System.out.println("Juego-Comienza " + this.getJugadorActual().obtenerNombre());
    }
    
//TODO uso el tablero?
    /*public Tablero getTablero(){
        return this.tablero;
    }*/

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
