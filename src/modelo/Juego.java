package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import modelo.estadoJuego.EstadoJuego;
import modelo.estadoJuego.JuegaJugador1;
import modelo.estadoJuego.JuegaJugador2;
import modelo.estadoJuego.NoComenzado;
import modelo.estadoJuego.Terminado;

public class Juego implements CastilloListener{

    private List<Jugador> jugadores;
    private Tablero tablero;
    private EstadoJuego estado;

    private void seleccionarJugadorInicial(){
        int numeroRandom = ThreadLocalRandom.current().nextInt(0, 2);

        if(numeroRandom == 0) {
            this.estado = new JuegaJugador1();
            System.out.print("Comienza " + this.getJugadorActual().obtenerNombre());
        }else {
            this.estado = new JuegaJugador2();
            System.out.print("Comienza " + this.getJugadorActual().obtenerNombre());
        }

    }

    public Juego(String nombreJugador1, String nombreJugador2){

        jugadores = new ArrayList<>();
        this.tablero = new Tablero();
        jugadores.add(new Jugador(nombreJugador1));
        jugadores.add(new Jugador(nombreJugador2));
        this.estado = new NoComenzado();
    }

    public void iniciarJuego(List<Pieza> piezasJugador1, List<Pieza> piezasJugador2){

        seleccionarJugadorInicial();

        Castillo castilloJugador1 = null;
        Castillo castilloJugador2 = null;

        for(int i = 0; i < piezasJugador1.size(); i++){
            if(piezasJugador1.get(i) instanceof Castillo)
                castilloJugador1 = (Castillo)piezasJugador1.get(i);
        }

        for(int i = 0; i < piezasJugador2.size(); i++){
            if(piezasJugador2.get(i) instanceof Castillo)
                castilloJugador2 = (Castillo)piezasJugador2.get(i);
        }

        castilloJugador1.setCastilloListener(this);
        castilloJugador2.setCastilloListener(this);

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
