package vista;

import controlador.UnidadRealizarAccion;
import modelo.Unidad;
import modelo.excepciones.Excepcion;

public abstract class UnidadVista extends PiezaVista {
	
	public UnidadVista(int x, int y, Unidad unModelo, MapaVista unMapa) throws Excepcion {
		super(x,y,unModelo,unMapa);
	}
	
	public void reubicar(int x, int y) {
		//calcula la ubicacion
		ultimaX = x;
		ultimaY = y;
		
		//ubica la pieza en la pantalla
		relocate(ultimaX* TAMANIO_CASILLA, ultimaY* TAMANIO_CASILLA);
	}
	
	protected abstract void prepararBotones();
	
	@Override
	public void realizarAccionSobrePieza() {
		new UnidadRealizarAccion(elMapa, this);
	}

}
