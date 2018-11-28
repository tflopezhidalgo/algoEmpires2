package vista;

import modelo.Atacante;
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
	protected void realizarAccionSobrePieza() {
		//Unidad esta siendo atacada
		PiezaVista piezaAtacante = elMapa.piezaSeleccionada();
		//TODO hace falta el if? ya se lanza excepcion si la piezaAtacante 
		//no es instancia de Atacante , porque no se puede castear
		//if(piezaAtacante.modelo() instanceof Atacante) { 
			((Atacante)(piezaAtacante.modelo())).atacar(modelo);
			if(modelo.estaDestruida()) {
				elMapa.removerPieza(this);
			}
		//}
		actualizarBarraDeVida();
	}

}
