public class Casilla {
	
	private boolean ocupada; //TODO: Futuro patrón state
   	private int posicionX;
   	private int posicionY;
	
	//TODO cuando este en mi pc pongo "fila y columan " otravez y see 1 seccc

	public Casilla( int x, int y ){
		posicionX = x;
		posicionY = y;
        	ocupada = false;
    	}
	public boolean estaOcupada() {
		return ocupada;
	}
	
	//NO USAR ?
	public void ocupar() throws Excepcion {
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

	//public int obtenerFila() { return fila; }

	//public int obtenerColumna() { return columna; }
	
	//TODO ya se que etsoy copiando lo de arriba pero modificar los nombres en el resto de los archivos es mucha paja, 
	//cuando este en mi pc borro estos 2 y uso los de ailu ( los 2 de arriba )
	public int ejeX() {
		return posicionX;
	}
	
	public int ejeY() {
		return posicionY;
	}
	//-------------------------------------

   	public String aString() {
		return ( Integer.toString(posicionX) + "I" + Integer.toString(posicionY));
    	}

    	//USO APTO PARA TODOS    
    	static public String aString(int x , int y) {
		return ( Integer.toString(x) + "I" + Integer.toString(y));
	}

	public int calcularDistanciaA(Casilla casillaB) {
		int xFinal = this.ejeX();
		int yFinal = this.ejeY();
		int xInicial = casillaB.ejeX();
		int yInicial = casillaB.ejeY();
		
		int diferenciaX = Math.abs(xFinal - xInicial);
		int diferenciaY = Math.abs(yFinal - yInicial);
		
		if(diferenciaX < diferenciaY) {
			return diferenciaY;
		}
		return diferenciaX;
	}
}
