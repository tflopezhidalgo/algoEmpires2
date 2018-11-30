package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Area;
import modelo.Cuartel;
import modelo.Espadachin;
import modelo.Pieza;
import vista.EspadachinVista;
import vista.MapaVista;

public class CrearEspadachinHandler implements EventHandler<ActionEvent> {

	private MapaVista unMapa;
	private Cuartel modelo;

	public CrearEspadachinHandler(MapaVista unMapa, Pieza modelo){
		this.unMapa = unMapa;
		this.modelo = (Cuartel)modelo;
	}

	@Override
	public void handle(ActionEvent event) {
		int x0 = unMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = unMapa.casillaSeleccionada().modelo().ejeY();
		
		Area espacioEspadachin = unMapa.obtenerTablero().definirArea(x0, y0, x0, y0);
		Espadachin espadachin = ((Cuartel)modelo).crearEspadachin(espacioEspadachin);
		if(espadachin != null) {
			EspadachinVista espadachinVista = new EspadachinVista(x0,y0,espadachin,unMapa);
			unMapa.aniadirPieza(espadachinVista);
		}
	};
}
