public abstract class Unidad extends Pieza {

	protected boolean ocupado;
	protected Casilla casillaActual;
	
	public Unidad(Casilla unaCasilla) {
		casillaActual = unaCasilla;
		casillaActual.colocar(this);
		turnoJugado = false;
		ocupado = false;
	}

	public void mover(Casilla nuevaCasilla) throws ErrorBasico {//habria que indicar una de las 8 direcciones posibles
		if(nuevaCasilla.estaOcupada()) {
			//TODO ERROR CASILLA OCUPADA
			throw new java.lang.Error("ERROR: Casilla Ocupada.");
		}
		siEstaOcupadoDaError();
		
		casillaActual.liberar();
		casillaActual = nuevaCasilla;
		casillaActual.colocar(this);
	}
	
	public Casilla obtenerUbicacion() {
		return casillaActual;
	}
	
	
	//----------PROTOTIPO-----------------
	
	public void moverArriba() throws ErrorBasico {
		Casilla nuevaCasilla = casillaActual.casillaArriba();
		mover(nuevaCasilla);
	}
	
	public void moverAbajo() throws ErrorBasico {
		Casilla nuevaCasilla = casillaActual.casillaAbajo();
		mover(nuevaCasilla);
	}
	
	public void moverIzquierda() throws ErrorBasico {
		Casilla nuevaCasilla = casillaActual.casillaIzquierda();
		mover(nuevaCasilla);
	}
	
	public void moverDerecha() throws ErrorBasico {
		Casilla nuevaCasilla = casillaActual.casillaDerecha();
		mover(nuevaCasilla);
	}
	
	//----------------DIAGONALES-------
	
	public void moverArribaIzquierda() throws ErrorBasico {
		Casilla nuevaCasilla = casillaActual.casillaArribaIzquiera();
		mover(nuevaCasilla);
	}
	
	public void moverArribaDerecha() throws ErrorBasico {
		Casilla nuevaCasilla = casillaActual.casillaArribaDerecha();
		mover(nuevaCasilla);
	}
	
	public void moverAbajoDerecha() throws ErrorBasico {
		Casilla nuevaCasilla = casillaActual.casillaAbajoDerecha();
		mover(nuevaCasilla);
	}
	
	public void moverAbajoIzquierda() throws ErrorBasico {
		Casilla nuevaCasilla = casillaActual.casillaAbajoIzquierda();
		mover(nuevaCasilla);
	}	
	
	//----------------PRIVATE------------------
	protected void siEstaOcupadoDaError() throws ErrorBasico  {
		if(ocupado) {
			//TODO ERROR
			throw new ErrorBasico("ERROR: La unidad esta ocupada.");
		}
	}
	
	protected void liberarUbicacion() {
		casillaActual.liberar();
	}

}
