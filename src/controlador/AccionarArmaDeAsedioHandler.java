package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.ArmaDeAsedio;
import modelo.Pieza;

public class AccionarArmaDeAsedioHandler implements EventHandler<ActionEvent> {

	private ArmaDeAsedio arma;

	public AccionarArmaDeAsedioHandler(Pieza arma){
		this.arma = (ArmaDeAsedio)arma;
	}

	@Override
	public void handle(ActionEvent event) {
		//TODO lo podemos accionar infinitas veces por turno? (depende del modelo)
		arma.accionar();
	}
	
}
