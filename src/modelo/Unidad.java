package modelo;

import modelo.excepciones.CasillaOcupadaError;
import modelo.excepciones.PiezaOcupadaNoPuedeAccionarError;
import modelo.excepciones.PiezaYaJugoEnTurnoActualError;

public abstract class Unidad extends Pieza {

	protected boolean ocupado;

    protected void siEstaOcupadoDaError() throws PiezaOcupadaNoPuedeAccionarError {
        if(ocupado) {
            throw new PiezaOcupadaNoPuedeAccionarError();
        }
    }
	
	public Unidad(Area unEspacio) throws CasillaOcupadaError {

	    super(unEspacio);
		ocupado = false;
	}
	
	public boolean estaOcupado() {

		return ocupado;
	}

	public void mover(Area nuevoEspacio) throws PiezaYaJugoEnTurnoActualError, CasillaOcupadaError{

	    this.siYaJugoElTurnoError();
		
        if (!ocupado & nuevoEspacio.estaLibre()) {
            espacioOcupado.liberar();
            espacioOcupado = nuevoEspacio;
            espacioOcupado.ocupar();
			turnoJugado = true;
        }
	}

}
