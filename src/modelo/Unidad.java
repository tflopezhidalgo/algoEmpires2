package modelo;

import modelo.excepciones.*;

public abstract class Unidad extends Pieza {

	protected boolean ocupado;

    protected void siEstaOcupadoDaError() {
        if(ocupado) {
            throw new PiezaOcupadaNoPuedeAccionarError();
        }
    }
	
	public Unidad(Area unEspacio) {

	    super(unEspacio);
		ocupado = false;
	}
	
	public boolean estaOcupado() {

		return ocupado;
	}

	public void mover(Area nuevoEspacio){

	    this.siYaJugoElTurnoError();
		
        if (!ocupado & nuevoEspacio.estaLibre()) {
            espacioOcupado.liberar();
            espacioOcupado = nuevoEspacio;
            espacioOcupado.ocupar();
			turnoJugado = true;
        }
	}

}
