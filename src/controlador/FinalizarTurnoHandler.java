package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import vista.PiezaVista;

public class FinalizarTurnoHandler implements EventHandler<ActionEvent> {
	
	private Group piezas;
	
	public FinalizarTurnoHandler(Group piezas) {
		this.piezas = piezas;
	}
	
	@Override
	public void handle(ActionEvent event) {
		for(int i = 0; i<piezas.getChildren().size(); i++) {
			Node nodoActual = piezas.getChildren().get(i);
			//TODO modificar esto despues, tiene que ser para todas las PIEZAS del ultimo jugador
			((PiezaVista)nodoActual).nuevoTurno();
		}
	}

}
