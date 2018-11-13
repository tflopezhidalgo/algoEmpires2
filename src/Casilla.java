public class Casilla {
	
	private boolean ocupada;
	private Posicion posicionActual;

	public Casilla( int x, int y ){
        posicionActual = new Posicion(x, y);
        ocupada = false;
    }

	public Casilla (Posicion unaPosicion) {
		posicionActual = unaPosicion;
		ocupada = false;
	}
	
	public boolean estaOcupada() {
		return ocupada;
	}
	
	//NO USAR ?
	public void colocar(Pieza unaPieza) throws ErrorBasico {
		if(!ocupada) {
			ocupada = true;
		}
		else {
			throw new ErrorBasico("ERROR: Casilla ocupada.");
		}
	}
	
	public void liberar() {
		ocupada = false;
	}
	
	public Posicion obtenerPosicion() {
		return posicionActual;
	}
}
