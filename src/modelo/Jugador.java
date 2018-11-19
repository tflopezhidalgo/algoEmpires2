package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jugador {

    static final int POBLACION_MAX = 50;

    private List<Pieza> piezas;
    private String nombreJugador;
    private int cantidadDeOro;
    private int poblacion;

    private void recolectarOro() throws Excepcion{
       
    	for(int i=0; i<piezas.size(); i++) {
    		Pieza piezaActual = piezas.get(i);
    		if(piezaActual instanceof Aldeano) {
    			cantidadDeOro += ((Aldeano)piezaActual).realizarTrabajoDeTurno();
    		}

    	}
    	//TODO perdon tom pero ese codigo me da error en el test, asique lo cambie por el de arriba
        /*Iterator iterador = piezas.iterator();
        while(iterador.hasNext())
            if(iterador.next() instanceof Aldeano)
                oroRecolectado = oroRecolectado + ((Aldeano) iterador.next()).realizarTrabajoDeTurno();*/
    }

    /*          Constructor         */
    public Jugador(String unNombre){
        this.nombreJugador = unNombre;
        this.piezas = new ArrayList<>();
        this.cantidadDeOro = 100;
        this.poblacion = 0;
    }

    public void asignarPiezas(List<Pieza> piezas){
        this.piezas = piezas;
        actualizarPoblacion();
    }
    
    public void asignarPieza(Pieza pieza){
        this.piezas.add(pieza);
        actualizarPoblacion();
    }

    public void actualizarPoblacion(){
        Iterator iterador = piezas.iterator();
        while(iterador.hasNext())
            if(iterador.next() instanceof Unidad)
                this.poblacion++;
    }

    public boolean castilloFueDestruido(){
        Iterator iterator = piezas.iterator();

        while(iterator.hasNext())
            if(iterator.next() instanceof Castillo)
                return false;

        return true;

    }

    public void finalizarTurno() throws Excepcion{
        this.recolectarOro();
        actualizarPoblacion();
        
        //TODO temporal - ver si usar esto o si crear una clase Turno que lo haga
        finalizarTurnoDePiezas();
    }
    
    private void finalizarTurnoDePiezas() {
    	for(int i=0; i<piezas.size(); i++) {
    		Pieza piezaActual = piezas.get(i);
    		piezaActual.nuevoTurno();
    	}
    }
    
    public String obtenerNombre() {
    	return nombreJugador;
    }
}
