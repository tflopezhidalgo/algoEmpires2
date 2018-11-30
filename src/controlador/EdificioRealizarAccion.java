package controlador;

import modelo.Aldeano;
import modelo.Edificio;
import vista.MapaVista;
import vista.PiezaVista;

public class EdificioRealizarAccion {

	public EdificioRealizarAccion(MapaVista unMapa, PiezaVista edificio) {
		PiezaVista piezaSeleccionada = unMapa.piezaSeleccionada();
		if(piezaSeleccionada.modelo() instanceof Atacante) {
			//Edificio esta siendo atacado
			((Atacante)(piezaSeleccionada).modelo()).atacar(edificio.modelo());
			if(edificio.modelo().estaDestruida()) {
				unMapa.removerPieza(edificio);
			}
		}
		
		if(piezaSeleccionada.modelo() instanceof Aldeano) {
			//Edificio esta siendo reparado
			((Aldeano)(piezaSeleccionada).modelo()).reparar((Edificio)edificio.modelo());
		}
		edificio.actualizarVisualizacon();
	}
}
