package modelo;

import modelo.excepciones.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//TODO: Falta implementar decuento de oro por crear Pieza

public class Jugador {

    static final int POBLACION_MAX = 50;

    private List<Pieza> piezas;
    private String nombreJugador;
    private int cantidadDeOro;
    private int poblacion;

    private void recolectarOro() throws Exception{

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
                oroRecolectado = oroRecolectado + ((Aldeano) iterador.next()).realizarTrabajoDeTurno();

        this.cantidadDeOro = cantidadDeOro + oroRecolectado;   */
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

    public void agregarPieza(Pieza nuevaPieza) throws PoblacionLimiteSuperadaError {
        if(nuevaPieza instanceof Unidad && (this.poblacion >= POBLACION_MAX)){
            throw new PoblacionLimiteSuperadaError();
            //TODO: Refactorizar.
        }
        this.piezas.add(nuevaPieza);
        this.actualizarPoblacion();
    }

    public void actualizarPoblacion() {
        this.poblacion = 0;
        Iterator iterador = piezas.iterator();
        while (iterador.hasNext()){
            if (iterador.next() instanceof Unidad) {
                this.poblacion++;
            }
        }
    }

    public int getPoblacion(){

        return this.poblacion;
    }

    public void finalizarTurno() throws Exception{
        this.recolectarOro();
        actualizarPoblacion();
        
        //TODO temporal - ver si usar esto o si crear una clase Turno que lo haga
        finalizarTurnoDePiezas();
    }
    
    private void finalizarTurnoDePiezas() {
    	for(int i = 0; i < piezas.size(); i++) {
    		Pieza piezaActual = piezas.get(i);
    		piezaActual.nuevoTurno();
    	}
    }
    
    public String obtenerNombre() {

    	return nombreJugador;
    }

    public int obtenerOro(){

        return this.cantidadDeOro;
    }
}
