package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import modelo.Unidad;
import vista.CasillaVista;
import vista.MapaVista;
import vista.PiezaVista;
import vista.UnidadVista;

public class ClickCasillaHandler implements EventHandler<MouseEvent> {

	private CasillaVista laCasilla;
	private MapaVista elMapa;
	
	public ClickCasillaHandler(MapaVista elMapa, CasillaVista laCasilla) {
		this.elMapa = elMapa;
		this.laCasilla = laCasilla;
	}

	@Override
	public void handle(MouseEvent event) {
		if(event.getButton() == MouseButton.PRIMARY ) {
			seleccionarCasilla();
		}
		if(event.getButton() == MouseButton.SECONDARY ) {
			//la casilla esta desocupada asique implica moviemiento
			moverPiezaSeleccionada();
		}
	}
	
	private void seleccionarCasilla() {
		//sacar efecto a casilla anterior
		CasillaVista casillaAnterior = elMapa.casillaSeleccionada();
		if(casillaAnterior != null) {
			elMapa.casillaSeleccionada().desSeleccionar();
		}
		//agregar efecto a casilla actual
		laCasilla.seleccionar();
		elMapa.seleccionarCasilla(laCasilla);
	}

	
	private void moverPiezaSeleccionada(){
		PiezaVista piezaSeleccionada = elMapa.piezaSeleccionada();
		if(piezaSeleccionada instanceof UnidadVista) {
			int x0 = piezaSeleccionada.modelo().obtenerAreaOcupada().x0();
			int y0 = piezaSeleccionada.modelo().obtenerAreaOcupada().y0();
			int x1 = laCasilla.modelo().ejeX();
			int y1 = laCasilla.modelo().ejeY();
			
			int difX = x1 - x0;
			int difY = y1 - y0;
			if( Math.abs(difX) <=1 & Math.abs(difY) <=1 ) {
				UnidadVista unidadVista = (UnidadVista)(piezaSeleccionada);
				Unidad laUnidad = (Unidad)(unidadVista.modelo());
				elMapa.obtenerTablero().moverEnDireccion(laUnidad, difX, difY);
				
				int xActual = laUnidad.obtenerAreaOcupada().x0();
				int yActual = laUnidad.obtenerAreaOcupada().y0();
				//Si el modelo efectivamente se movio, la vista se reubicara correctamente, 
				//de lo contrario se quedara en su lugar
				unidadVista.reubicar(xActual,yActual);
			}
		}
	}
	


}
