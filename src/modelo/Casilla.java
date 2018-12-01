package modelo;

import modelo.estadoCasilla.CasillaLibre;
import modelo.estadoCasilla.EstadoCasilla;

public class Casilla {

   	private int posicionX;
   	private int posicionY;
   	private EstadoCasilla estadoActual;

	public Casilla( int x, int y ){

		this.posicionX = x;
		this.posicionY = y;
		this.estadoActual = new CasillaLibre();
	}

	public boolean estaOcupada() {

		return estadoActual.estaOcupada();
	}

	public void ocupar() {

	    estadoActual = estadoActual.ocupar();
	}
	
	public void liberar() {

	    estadoActual = estadoActual.liberar();
	}

	public int ejeX() {

		return posicionX;
	}
	
	public int ejeY() {

		return posicionY;
	}

   	public String aString() {

		return ( Integer.toString(posicionX) + "I" + Integer.toString(posicionY));
	}

	static public String aString(int x , int y) {

		return ( Integer.toString(x) + "I" + Integer.toString(y));
	}

	public int calcularDistanciaA(Casilla casillaB) {

		int xFinal = this.ejeX();
		int yFinal = this.ejeY();
		int xInicial = casillaB.ejeX();
		int yInicial = casillaB.ejeY();
    	System.out.println("Casilla: coor1:" + xFinal+ ","+yFinal + " coor2: "+ xInicial+ "," +yInicial);

		int diferenciaX = Math.abs(xFinal - xInicial);
		int diferenciaY = Math.abs(yFinal - yInicial);
		
		if(diferenciaX < diferenciaY)
			return diferenciaY;

		return diferenciaX;
	}
}
