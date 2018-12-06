package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.Cuartel;
import modelo.Pieza;
import modelo.Unidad;
import modelo.factoryCuartel.TipoGuerrero;
import vista.EspadachinVista;
import vista.JuegoVista;

public class CrearEspadachinHandler implements EventHandler<MouseEvent> {

	private JuegoVista elJuego;
	private Cuartel modelo;

	public CrearEspadachinHandler(JuegoVista unJuego, Pieza modelo){
		this.elJuego = unJuego;
		this.modelo = (Cuartel)modelo;
	}

	@Override
	public void handle(MouseEvent event) {
		int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
		
		//TODO chk: almaceno en Espadachin y casteo o almaceno en Unidad?
		Unidad espadachin = ((Cuartel)modelo).crearGuerrero(x0, y0, TipoGuerrero.ESPADACHIN);
		if(espadachin != null) {
			EspadachinVista espadachinVista = new EspadachinVista(x0,y0,espadachin,elJuego);
			elJuego.agregar(espadachinVista);
		}
	};
} 
