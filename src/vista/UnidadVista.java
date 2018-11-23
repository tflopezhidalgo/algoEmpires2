package vista;

import modelo.Unidad;
import modelo.excepciones.Excepcion;

public abstract class UnidadVista extends PiezaVista {
	
	public UnidadVista(int x, int y, Unidad unModelo, JuegoVista unJuego) throws Excepcion {
		super(x,y,unModelo,unJuego);
	}
	
	public void reubicar(int x, int y) {
		//calcula la ubicacion
		ultimaX = x;
		ultimaY = y;
		
		//ubica la pieza en la pantalla
		relocate(ultimaX* TAMANIO_CASILLA, ultimaY* TAMANIO_CASILLA);
	}
	
	protected abstract void prepararBotones();

}
