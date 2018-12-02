package controlador;

import modelo.Aldeano;
import modelo.Edificio;
import vista.JuegoVista;
import vista.PiezaVista;

public class EdificioRealizarAccion {

	public EdificioRealizarAccion(JuegoVista unMapa, PiezaVista edificio) {
		PiezaVista piezaSeleccionada = unMapa.piezaSeleccionada();
		
		if(piezaSeleccionada.modelo() instanceof Aldeano) {
			//Edificio esta siendo reparado
			((Aldeano)(piezaSeleccionada).modelo()).reparar((Edificio)edificio.modelo());
		}
		else {
			//Edificio esta siendo atacado
			piezaSeleccionada.modelo().atacar(edificio.modelo());
			if(edificio.modelo().estaDestruida()) {
				unMapa.removerPieza(edificio);
			}
		}
		edificio.actualizarVisualizacon();
	}
}
