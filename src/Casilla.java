public class Casilla {
	
	private boolean ocupada; //TODO: Futuro patrón state
	private int fila;
	private int columna;

	public Casilla(int fila, int columna){
       	this.fila = fila;
       	this.columna = columna;
        ocupada = false;
    }
	
	public boolean estaOcupada() {

		return ocupada;
	}
	
	//NO USAR ?
	public void colocar(Pieza unaPieza) throws Excepcion {
		if(!ocupada) {
			ocupada = true;
		}
		else {
			throw new Excepcion("ERROR: Casilla ocupada.");
		}
	}
	
	public void liberar() {

	    ocupada = false;
	}

	public int obtenerFila() { return fila; }

	public int obtenerColumna() { return columna; }

	public String aString() {

		return ( Integer.toString(fila) + "I" + Integer.toString(columna));
	}

	//USO APTO PARA TODOS
	static public String aString(int x , int y) {
		return ( Integer.toString(x) + "I" + Integer.toString(y));
	}

	public int calcularDistanciaA(Casilla casillaB) {

		int xFinal = this.obtenerFila();
		int yFinal = this.obtenerColumna();
		int xInicial = casillaB.obtenerFila();
		int yInicial = casillaB.obtenerColumna();

		int diferenciaX = Math.abs(xFinal - xInicial);
		int diferenciaY = Math.abs(yFinal - yInicial);

		int diferencia = diferenciaX;

		if(diferenciaX < diferenciaY) {
			diferencia = diferenciaY;
		}
		return diferencia;
	}
}
