package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Castillo;
import modelo.Pieza;
import modelo.Unidad;
import vista.ArmaDeAsedioVista;
import vista.JuegoVista;

public class CrearArmaDeAsedioHandler implements EventHandler<ActionEvent> {

	private JuegoVista elJuego;
	private Castillo modelo;
	
	public CrearArmaDeAsedioHandler(JuegoVista unJuego, Pieza modelo) {
		this.elJuego = unJuego;
		this.modelo = (Castillo)modelo;
	}

	@Override
	public void handle(ActionEvent event) {
		int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
		
		//TODO chk: almaceno en Arma de asedio y casteo o almaceno en Unidad?
		//ArmaDeAsedio armaDeAsedio = (ArmaDeAsedio)((Castillo)modelo).crearCatapulta(espacioArmaDeAsedio);
		Unidad armaDeAsedio = ((Castillo)modelo).crearCatapulta(x0,y0);
		if(armaDeAsedio != null) {
			ArmaDeAsedioVista armaVisu = new ArmaDeAsedioVista(x0,y0,armaDeAsedio,elJuego);
			elJuego.agregar(armaVisu);
		}
	}

}
