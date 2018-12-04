package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.Aldeano;
import modelo.Edificio;
import modelo.Pieza;
import vista.JuegoVista;
import vista.PlazaVista;

public class ConstruirPlazaHandler implements EventHandler<MouseEvent>{

	private JuegoVista elJuego;
	private Aldeano unAldeano;

	public ConstruirPlazaHandler(JuegoVista unJuego, Pieza unAldeano){
		this.elJuego = unJuego;
		this.unAldeano = (Aldeano)unAldeano;
	}
	
	@Override
	public void handle(MouseEvent event) {
		int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
		
		Edificio plaza = unAldeano.crearPlaza(x0,y0);
		if(plaza != null) {
			PlazaVista plazaVisu = new PlazaVista(x0,y0,plaza,elJuego);
			elJuego.agregar(plazaVisu);
		}
	}
	
}
