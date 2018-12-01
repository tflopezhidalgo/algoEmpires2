package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Aldeano;
import modelo.Area;
import modelo.Edificio;
import modelo.Plaza;
import vista.AldeanoVista;
import vista.MapaVista;

public class CrearAldeanoHandler implements EventHandler<ActionEvent> {

	private MapaVista elMapa;
	private Edificio modelo;

	public CrearAldeanoHandler(MapaVista unMapa, Edificio modelo){
		this.elMapa = unMapa;
		this.modelo = modelo;
		System.out.println("C-CAH : modelo: " + (this.modelo == null));
	}

	@Override
	public void handle(ActionEvent event) {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX(); 
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		//TODO los mismos comentarios que en construir Plaza
		Area espacioAldeano = elMapa.obtenerTablero().definirArea(x0, y0, x0, y0);
		Aldeano aldeano = ((Plaza)this.modelo).crearAldeano(espacioAldeano); 
		if(aldeano != null) {
			AldeanoVista aldeanoVista = new AldeanoVista(x0,y0,aldeano,elMapa);
			elMapa.aniadirPieza(aldeanoVista);
		}
	};
}
