package modelo;

import modelo.excepciones.Excepcion;

public class Casilla {
	
	private boolean ocupada; //TODO: Futuro patrón state
   	private int posicionX;
   	private int posicionY;

	public Casilla( int x, int y ){
		posicionX = x;
		posicionY = y;
        	ocupada = false;
    	}
	public boolean estaOcupada() {
		return ocupada;
	}

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
