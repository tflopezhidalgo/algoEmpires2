package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.ArmaDeAsedio;
import modelo.Pieza;
import vista.ArmaDeAsedioVista;
import vista.PiezaVista;

public class AccionarArmaDeAsedioHandler implements EventHandler<ActionEvent> {

	private ArmaDeAsedioVista arma;

	public AccionarArmaDeAsedioHandler(PiezaVista arma){
		this.arma = (ArmaDeAsedioVista)arma;
	}

	@Override
	public void handle(ActionEvent event) {
		//TODO lo podemos accionar infinitas veces por turno? (depende del modelo)
		System.out.println("ES NULL? " + ((arma.modelo()) == null));
		((ArmaDeAsedio)(arma.modelo())).accionar();
	}
	
}
