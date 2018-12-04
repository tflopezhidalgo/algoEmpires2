package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Aldeano;
import modelo.Edificio;
import modelo.Plaza;
import vista.AldeanoVista;
import vista.JuegoVista;

public class CrearAldeanoHandler implements EventHandler<ActionEvent> {

	private JuegoVista elJuego;
	private Edificio modelo;

	public CrearAldeanoHandler(JuegoVista unJuego, Edificio modelo){
		this.elJuego = unJuego;
		this.modelo = modelo;
		System.out.println("C-CAH : modelo: " + (this.modelo == null));
	}

	@Override
	public void handle(ActionEvent event) {
		int x0 = elJuego.casillaSeleccionada().modelo().ejeX(); 
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
		
		Aldeano aldeano = ((Plaza)this.modelo).crearAldeano(x0,y0); 
		if(aldeano != null) {
			AldeanoVista aldeanoVista = new AldeanoVista(x0,y0,aldeano,elJuego);
			elJuego.agregar(aldeanoVista);
		}
	};
}
