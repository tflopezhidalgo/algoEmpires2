package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import vista.JuegoVista;
import vista.PiezaVista;

public class FinalizarTurnoHandler implements EventHandler<ActionEvent> {
	
	private JuegoVista elJuego;
	private Group piezas;
	
	public FinalizarTurnoHandler(JuegoVista juegoVista, Group piezas) {
		this.piezas = piezas;
		this.elJuego = juegoVista;
	}
	
	@Override
	public void handle(ActionEvent event) {

		elJuego.modelo().finalizarTurno();

		for(int i = 0; i < piezas.getChildren().size(); i++) {
			Node nodoActual = piezas.getChildren().get(i);
			((PiezaVista)nodoActual).nuevoTurno();
		}

		elJuego.actualizarContadores();
		
		PiezaVista piezaAnterior = elJuego.piezaSeleccionada();
		if(piezaAnterior != null) {
			elJuego.piezaSeleccionada().desSeleccionar();
		}

		elJuego.asignarMenuAcciones(new HBox());
	}

}
