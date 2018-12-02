package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Area;
import modelo.Cuartel;
import modelo.Pieza;
import modelo.Unidad;
import modelo.factoryCuartel.TipoGuerrero;
import vista.ArqueroVista;
import vista.JuegoVista;

public class CrearArqueroHandler implements EventHandler<ActionEvent> {

	private JuegoVista elMapa;
	private Cuartel modelo;

	public CrearArqueroHandler(JuegoVista unMapa, Pieza modelo){
		this.elMapa = unMapa;
		this.modelo = (Cuartel)modelo;
	}

	@Override
	public void handle(ActionEvent event) {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		Unidad arquero = modelo.crearGuerrero(x0,y0, TipoGuerrero.ARQUERO);
		if(arquero != null) {
			ArqueroVista arqueroVista = new ArqueroVista(x0,y0,arquero,elMapa);
			elMapa.aniadirPieza(arqueroVista);
		}
	};
}
