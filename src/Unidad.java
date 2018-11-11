
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
	
	
	//----------PROTOTIPO-----------------
	
	public void moverArriba() {
		Casilla nuevaCasilla = casillaActual.casillaArriba();
		mover(nuevaCasilla);
	}
	
	public void moverAbajo() {
		Casilla nuevaCasilla = casillaActual.casillaAbajo();
		mover(nuevaCasilla);
	}
	
	public void moverIzquierda() {
		Casilla nuevaCasilla = casillaActual.casillaIzquierda();
		mover(nuevaCasilla);
	}
	
	public void moverDerecha() {
		Casilla nuevaCasilla = casillaActual.casillaDerecha();
		mover(nuevaCasilla);
	}
	
	//----------------DIAGONALES-------
	
	public void moverArribaIzquierda() {
		Casilla nuevaCasilla = casillaActual.casillaArribaIzquiera();
		mover(nuevaCasilla);
	}
	
	public void moverArribaDerecha() {
		Casilla nuevaCasilla = casillaActual.casillaArribaDerecha();
		mover(nuevaCasilla);
	}
	
	public void moverAbajoDerecha() {
		Casilla nuevaCasilla = casillaActual.casillaAbajoDerecha();
		mover(nuevaCasilla);
	}
	
	public void moverAbajoIzquierda() {
		Casilla nuevaCasilla = casillaActual.casillaAbajoIzquierda();
		mover(nuevaCasilla);
	}

}
