package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.Cuartel;
import modelo.Pieza;
import modelo.Unidad;
import modelo.factoryCuartel.TipoGuerrero;
import vista.ArqueroVista;
import vista.JuegoVista;

public class CrearArqueroHandler implements EventHandler<MouseEvent> {

	private JuegoVista elJuego;
	private Cuartel modelo;

	public CrearArqueroHandler(JuegoVista unJuego, Pieza modelo){
		this.elJuego = unJuego;
		this.modelo = (Cuartel)modelo;
	}

	@Override
	public void handle(MouseEvent event) {
		int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
		
		Unidad arquero = modelo.crearGuerrero(x0,y0, TipoGuerrero.ARQUERO);
		if(arquero != null) {
			ArqueroVista arqueroVista = new ArqueroVista(x0,y0,arquero,elJuego);
			elJuego.agregar(arqueroVista);
		}
	};
}
