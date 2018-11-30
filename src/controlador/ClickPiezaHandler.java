package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import vista.MapaVista;
import vista.PiezaVista;

public class ClickPiezaHandler implements EventHandler<MouseEvent> {
	
	private PiezaVista laPieza;
	private MapaVista elMapa;
	
	public ClickPiezaHandler(MapaVista elMapa, PiezaVista laPieza) {
		this.elMapa = elMapa;
		this.laPieza = laPieza;
	}
	
	@Override
	public void handle(MouseEvent event) {
		if(event.getButton() == MouseButton.PRIMARY ) {
			seleccionarPieza();
		}
		if(event.getButton() == MouseButton.SECONDARY ) {
			laPieza.realizarAccionSobrePieza();
		}
	}
	
	protected void seleccionarPieza() {
		//sacar efecto a casilla anterior
		PiezaVista piezaAnterior = elMapa.piezaSeleccionada();
		if(piezaAnterior != null) {
			elMapa.piezaSeleccionada().desSeleccionar();
		}
		//agregar efecto a casilla actual
		laPieza.seleccionar();
		elMapa.seleccionarPieza(laPieza);
	}
	
}
