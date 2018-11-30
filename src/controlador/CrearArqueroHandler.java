package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Area;
import modelo.Arquero;
import modelo.Cuartel;
import modelo.Pieza;
import vista.ArqueroVista;
import vista.MapaVista;

public class CrearArqueroHandler implements EventHandler<ActionEvent> {

	private MapaVista unMapa;
	private Cuartel modelo;

	public CrearArqueroHandler(MapaVista unMapa, Pieza modelo){
		this.unMapa = unMapa;
		this.modelo = (Cuartel)modelo;
	}

	@Override
	public void handle(ActionEvent event) {
		int x0 = unMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = unMapa.casillaSeleccionada().modelo().ejeY();
		
		Area espacioArquero = unMapa.obtenerTablero().definirArea(x0, y0, x0, y0);
		Arquero arquero = modelo.crearArquero(espacioArquero);
		if(arquero != null) {
			ArqueroVista arqueroVista = new ArqueroVista(x0,y0,arquero,unMapa);
			unMapa.aniadirPieza(arqueroVista);
		}
	};
}
