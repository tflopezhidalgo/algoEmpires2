package vista;

import controlador.UnidadRealizarAccion;
import modelo.Pieza;
import modelo.Unidad;

public abstract class UnidadVista extends PiezaVista {
	
	protected Unidad modelo;
	
	public UnidadVista(int x, int y, Unidad unModelo, MapaVista unMapa){
		super(x,y,unModelo,unMapa);
		modelo = unModelo;
		crearRepresentacion();
	}
	
	public Unidad modelo() {
		System.out.println("Unidad getModelo : " + (modelo == null)); //TODO BORRAR

		return modelo;
	}
	
	public void reubicar(int x, int y) {
		//calcula la ubicacion
		ultimaX = x;
		ultimaY = y;
		
		//ubica la pieza en la pantalla
		relocate(ultimaX* TAMANIO_CASILLA, ultimaY* TAMANIO_CASILLA);
	}
	
	protected abstract void prepararBotones();
	
	protected abstract void crearRepresentacion();
	
	@Override
	public void realizarAccionSobrePieza() {
		new UnidadRealizarAccion(elMapa, this);
	}

}
