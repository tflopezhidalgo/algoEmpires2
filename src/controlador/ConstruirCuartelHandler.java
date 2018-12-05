package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.Aldeano;
import modelo.Edificio;
import modelo.Pieza;
import vista.CuartelVista;
import vista.JuegoVista;

public class ConstruirCuartelHandler implements EventHandler<MouseEvent>{
	
	private JuegoVista elJuego;
	private Aldeano unAldeano;

	public ConstruirCuartelHandler(JuegoVista unJuego, Pieza unAldeano){
		this.elJuego = unJuego;
		this.unAldeano = (Aldeano)unAldeano;
	}

	@Override
	public void handle(MouseEvent event) {
		int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
		
		Edificio cuartel = unAldeano.crearCuartel(x0,y0);
		if(cuartel != null) {
			CuartelVista cuartelVisu = new CuartelVista(x0,y0,cuartel,elJuego);
			elJuego.agregar(cuartelVisu);
		}
	}
	
}
