package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Aldeano;
import modelo.Area;
import modelo.Edificio;
import modelo.Pieza;
import vista.JuegoVista;
import vista.PlazaVista;

public class ConstruirPlazaHandler implements EventHandler<ActionEvent>{

	private JuegoVista elMapa;
	private Aldeano unAldeano;

	public ConstruirPlazaHandler(JuegoVista unMapa, Pieza unAldeano){
		this.elMapa = unMapa;
		this.unAldeano = (Aldeano)unAldeano;
	}
	
	@Override
	public void handle(ActionEvent event) {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		//TODO chk: almaceno en Plaza y casteo o almaceno en Edificio?
		Edificio plaza = unAldeano.crearPlaza(x0,y0);
		if(plaza != null) {
			PlazaVista plazaVisu = new PlazaVista(x0,y0,plaza,elMapa);
			elMapa.aniadirPieza(plazaVisu);
		}
	}
	
}
