package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Area;
import modelo.Castillo;
import modelo.Pieza;
import modelo.Unidad;
import vista.ArmaDeAsedioVista;
import vista.MapaVista;

public class CrearArmaDeAsedioHandler implements EventHandler<ActionEvent> {

	private MapaVista elMapa;
	private Castillo modelo;
	
	public CrearArmaDeAsedioHandler(MapaVista elMapa, Pieza modelo) {
		this.elMapa = elMapa;
		this.modelo = (Castillo)modelo;
	}

	@Override
	public void handle(ActionEvent event) {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		//TODO los mismos comentarios que en construir Plaza 
		Area espacioArmaDeAsedio = elMapa.obtenerTablero().definirArea(x0, y0, x0, y0);
		
		//TODO chk: almaceno en Arma de asedio y casteo o almaceno en Unidad?
		//ArmaDeAsedio armaDeAsedio = (ArmaDeAsedio)((Castillo)modelo).crearCatapulta(espacioArmaDeAsedio);
		Unidad armaDeAsedio = ((Castillo)modelo).crearCatapulta(espacioArmaDeAsedio);
		if(armaDeAsedio != null) {
			ArmaDeAsedioVista armaVisu = new ArmaDeAsedioVista(x0,y0,armaDeAsedio,elMapa);
			elMapa.aniadirPieza(armaVisu);
		}
	}

}
