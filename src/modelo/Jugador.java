package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.excepciones.PoblacionLimiteSuperadaError;

public class Jugador {

    static final int POBLACION_MAX = 50;

    private List<Pieza> piezas;
    private String nombreJugador;
    private int cantidadDeOro;
    private int poblacion;

    private void recolectarOro(){

    	for(int i=0; i < piezas.size(); i++) {
    		Pieza piezaActual = piezas.get(i);
    		if(piezaActual instanceof Aldeano) {
    			cantidadDeOro = cantidadDeOro + ((Aldeano) piezaActual).generarOro();
    		}
    	}
    }

    private void finalizarTurnoDePiezas() {
        for(int i = 0; i < piezas.size(); i++) {
            Pieza piezaActual = piezas.get(i);
            piezaActual.nuevoTurno();
        }
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

    public void agregarPieza(Pieza nuevaPieza) {

        if(nuevaPieza instanceof Unidad && (this.poblacion >= POBLACION_MAX))

            throw new PoblacionLimiteSuperadaError();

        this.cantidadDeOro = this.cantidadDeOro - nuevaPieza.COSTO;
        this.piezas.add(nuevaPieza);
        this.actualizarPoblacion();
    }

    public void actualizarPoblacion() {
        this.poblacion = 0;
        Iterator iterador = piezas.iterator();
        while (iterador.hasNext())
            if (iterador.next() instanceof Unidad)
                this.poblacion++;

    }

    public int getPoblacion(){

        return this.poblacion;
    }

    public void finalizarTurno(){

        this.recolectarOro();
        actualizarPoblacion();

        finalizarTurnoDePiezas();
    }
    
    public String obtenerNombre() {

    	return nombreJugador;
    }

    public int obtenerOro(){

        return this.cantidadDeOro;
    }

    public boolean castilloFueDestruido(){

        Iterator iterador = piezas.iterator();
        while (iterador.hasNext()){
            if (iterador.next() instanceof Castillo)
                return false;
        }
        return true;
    }

}
