package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Aldeano;
import modelo.Area;
import modelo.Pieza;
import modelo.Plaza;
import vista.AldeanoVista;
import vista.MapaVista;

public class CrearAldeanoHandler implements EventHandler<ActionEvent> {

	private MapaVista unMapa;
	private Plaza modelo;

	public CrearAldeanoHandler(MapaVista unMapa, Pieza modelo){
		this.unMapa = unMapa;
		this.modelo = (Plaza)modelo;
		System.out.println("C-CAH : modelo: " + (modelo == null));
	}

	@Override
	public void handle(ActionEvent event) {
		int x0 = unMapa.casillaSeleccionada().modelo().ejeX(); 
		int y0 = unMapa.casillaSeleccionada().modelo().ejeY();
		
		//TODO los mismos comentarios que en construir Plaza
		Area espacioAldeano = unMapa.obtenerTablero().definirArea(x0, y0, x0, y0);
		System.out.println("C-CAH : espacio: " +(espacioAldeano == null) + " mapa: " + (unMapa == null) + " modelo: " + (modelo == null));
		Aldeano aldeano = modelo.crearAldeano(espacioAldeano); 
		if(aldeano != null) {
			AldeanoVista aldeanoVista = new AldeanoVista(x0,y0,aldeano,unMapa);
			unMapa.aniadirPieza(aldeanoVista);
		}
	};
}
