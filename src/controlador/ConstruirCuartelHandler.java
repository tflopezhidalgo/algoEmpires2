package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Aldeano;
import modelo.Area;
import modelo.Edificio;
import modelo.Pieza;
import vista.CuartelVista;
import vista.JuegoVista;

public class ConstruirCuartelHandler implements EventHandler<ActionEvent>{
	
	private JuegoVista elMapa;
	private Aldeano unAldeano;

	public ConstruirCuartelHandler(JuegoVista unMapa, Pieza unAldeano){
		this.elMapa = unMapa;
		this.unAldeano = (Aldeano)unAldeano;
	}

	@Override
	public void handle(ActionEvent event) {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();

		Area areaDeConstruccion = elMapa.obtenerTablero().definirArea(x0, y0, x0+1, y0+1);
		
		//TODO chk: almaceno en Cuartel y casteo o almaceno en Edificio?
		Edificio cuartel = unAldeano.crearCuartel(x0,y0);
		if(cuartel != null) {
			CuartelVista cuartelVisu = new CuartelVista(x0,y0,cuartel,elMapa);
			elMapa.aniadirPieza(cuartelVisu);
		}
	}
	
}
