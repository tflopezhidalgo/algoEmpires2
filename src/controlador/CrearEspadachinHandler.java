package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Area;
import modelo.Cuartel;
import modelo.Pieza;
import modelo.Unidad;
import modelo.factoryCuartel.TipoGuerrero;
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
		
		//TODO chk: almaceno en Espadachin y casteo o almaceno en Unidad?
		Unidad espadachin = ((Cuartel)modelo).crearGuerrero(espacioEspadachin, TipoGuerrero.ESPADACHIN);
		if(espadachin != null) {
			EspadachinVista espadachinVista = new EspadachinVista(x0,y0,espadachin,unMapa);
			unMapa.aniadirPieza(espadachinVista);
		}
	};
} 
