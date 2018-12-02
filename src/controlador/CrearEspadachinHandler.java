package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Area;
import modelo.Cuartel;
import modelo.Pieza;
import modelo.Unidad;
import modelo.factoryCuartel.TipoGuerrero;
import vista.EspadachinVista;
import vista.JuegoVista;

public class CrearEspadachinHandler implements EventHandler<ActionEvent> {

	private JuegoVista elMapa;
	private Cuartel modelo;

	public CrearEspadachinHandler(JuegoVista unMapa, Pieza modelo){
		this.elMapa = unMapa;
		this.modelo = (Cuartel)modelo;
	}

	@Override
	public void handle(ActionEvent event) {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		//TODO chk: almaceno en Espadachin y casteo o almaceno en Unidad?
		Unidad espadachin = ((Cuartel)modelo).crearGuerrero(x0, y0, TipoGuerrero.ESPADACHIN);
		if(espadachin != null) {
			EspadachinVista espadachinVista = new EspadachinVista(x0,y0,espadachin,elMapa);
			elMapa.aniadirPieza(espadachinVista);
		}
	};
} 
