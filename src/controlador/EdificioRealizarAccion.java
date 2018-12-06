package controlador;

import modelo.Aldeano;
import modelo.excepciones.PiezaNoEstaEnEquipoAliado;
import modelo.excepciones.PiezaNoEstaEnEquipoEnemigo;
import vista.EdificioVista;
import vista.JuegoVista;
import vista.PiezaVista;

public class EdificioRealizarAccion {

	public EdificioRealizarAccion(JuegoVista unJuego, EdificioVista edificio) {
		PiezaVista piezaSeleccionada = unJuego.piezaSeleccionada();
		
		if(piezaSeleccionada.modelo() instanceof Aldeano) {
			//Edificio esta siendo reparado
			
			if(!unJuego.aliadoContieneA(edificio.modelo())) {
				unJuego.playError();
				
				throw new PiezaNoEstaEnEquipoAliado();
			}
			
			piezaSeleccionada.playAccion();
			
			((Aldeano)(piezaSeleccionada).modelo()).reparar(edificio.modelo());
		}
		else {
			//Edificio esta siendo atacado
			
			if(!unJuego.enemigoContieneA(edificio.modelo())) {
				unJuego.playError();
				
				throw new PiezaNoEstaEnEquipoEnemigo();
			}
			
			piezaSeleccionada.playAccion();
			
			piezaSeleccionada.modelo().atacar(edificio.modelo());
			if(edificio.modelo().estaDestruida()) {
				edificio.playMuerte();
				
				unJuego.remover(edificio);
			}
		}
		edificio.actualizarVisualizacon();
	}
}
