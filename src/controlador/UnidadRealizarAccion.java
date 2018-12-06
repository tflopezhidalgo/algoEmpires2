package controlador;

import modelo.excepciones.PiezaNoEstaEnEquipoEnemigo;
import vista.JuegoVista;
import vista.PiezaVista;
import vista.UnidadVista;

public class UnidadRealizarAccion {

	public UnidadRealizarAccion(JuegoVista unJuego, UnidadVista unidad) {
		//Unidad esta siendo atacada
		
		if(!unJuego.enemigoContieneA(unidad.modelo())) {
			unJuego.playError();
			
			throw new PiezaNoEstaEnEquipoEnemigo();
		}
		
		PiezaVista piezaAtacante = unJuego.piezaSeleccionada();
		
		piezaAtacante.playAccion();
		
		piezaAtacante.modelo().atacar(unidad.modelo());
		if(unidad.modelo().estaDestruida()) {
			
			unidad.playMuerte();
			
			unJuego.remover(unidad);
		}
			
		unidad.actualizarVisualizacon();
	}
}
