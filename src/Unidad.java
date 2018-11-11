
public abstract class Unidad extends Pieza {

	private Casilla casillaActual;
	
	public Unidad(Casilla unaCasilla) {
		casillaActual = unaCasilla;
		casillaActual.colocar(this);
	}

	public void mover(Casilla nuevaCasilla) {//habria que indicar una de las 8 direcciones posibles
		casillaActual.liberar();
		casillaActual = nuevaCasilla;
		casillaActual.colocar(this);
	}
	
	public Casilla obtenerUbicacion() {
		return casillaActual;
	}
	
}
