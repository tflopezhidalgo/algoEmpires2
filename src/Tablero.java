import java.util.HashMap;
import java.util.Map;

public class Tablero {

	private static Map<String, Casilla> casillasDelTablero;
	
	public Tablero(int ancho, int alto){
        	casillasDelTablero = new HashMap<String, Casilla>();
		
		for(int y=0;y<alto;y++){
			for(int x=0;x<alto;x++){
				Posicion nuevaPosicion = new Posicion(x,y);
				Casilla nuevaCasilla = new Casilla(nuevaPosicion);
				casillasDelTablero.add(nuevaPosicion.aString(),nuevaCasilla);
			}
		}
	}
	
	public void colocar(Pieza unaPieza, Casilla unaCasilla) throws ErrorBasico {
		unaCasilla.colocar(unaPieza);
	}
	
	public void liberar(Area unArea) {
		unArea.liberar()
	}
	
	public void liberar(Casilla unaCasilla) {
		unaCasilla.liberar()
	}
	
	//TODO verificar q estamos de acuerdo en tener esta funcion
	public Pieza obtenerPieza(Casilla unaCasilla) {
		return unaCasilla.obtenerPieza();
	}
	
	//TODO verificar q estamos de acuerdo en tener esta funcion
	public Posicion obtenerPosicion(Casilla unaCasilla) {
		return unaCasilla.obtenerPosicion();
	}
	
	//---------------PROTOTIPO---------------
	
	public Casilla casillaArriba() {
		String unaPosicion = Posicion.aString(posicionActual.ejeX(), posicionActual.ejeY() + 1);
		Casilla casillaArriba = casillasDelTablero.get(unaPosicion);
		return casillaArriba;
	}
	
	public Casilla casillaAbajo() {
		String unaPosicion = Posicion.aString(posicionActual.ejeX(), posicionActual.ejeY() - 1);
		Casilla casillaAbajo = casillasDelTablero.get(unaPosicion);
		return casillaAbajo;
	}
	
	public Casilla casillaIzquierda() {
		String unaPosicion = Posicion.aString(posicionActual.ejeX() - 1, posicionActual.ejeY());
		Casilla casillaIzquierda = casillasDelTablero.get(unaPosicion);
		return casillaIzquierda;
	}
	
	public Casilla casillaDerecha() {
		String unaPosicion = Posicion.aString(posicionActual.ejeX() + 1, posicionActual.ejeY());
		Casilla casillaDerecha = casillasDelTablero.get(unaPosicion);
		return casillaDerecha;
	}
	
	//---- diagonales
	
	public Casilla casillaArribaIzquiera() {
		String unaPosicion = Posicion.aString(posicionActual.ejeX()-1, posicionActual.ejeY() + 1);
		Casilla casillaArribaIzquiera = casillasDelTablero.get(unaPosicion);
		return casillaArribaIzquiera;
	}
	
	public Casilla casillaArribaDerecha() {
		String unaPosicion = Posicion.aString(posicionActual.ejeX()+1, posicionActual.ejeY() + 1);
		Casilla casillaArribaDerecha = casillasDelTablero.get(unaPosicion);
		return casillaArribaDerecha;
	}
	
	public Casilla casillaAbajoIzquierda() {
		String unaPosicion = Posicion.aString(posicionActual.ejeX()-1, posicionActual.ejeY()-1);
		Casilla casillaAbajoIzquierda = casillasDelTablero.get(unaPosicion);
		return casillaAbajoIzquierda;
	}
	
	public Casilla casillaAbajoDerecha() {
		String unaPosicion = Posicion.aString(posicionActual.ejeX() + 1, posicionActual.ejeY() - 1);
		Casilla casillaAbajoDerecha = casillasDelTablero.get(unaPosicion);
		return casillaAbajoDerecha;
	}
	
	/*
	public void recibirDanio(int danio) {
		if(!ocupada) {
			piezaDeJuego.recibirDanio(danio);
			//si fue destruido/eliminado liberar casilla
			//si era el castillo cagaste y perdiste
		}
		else {
			//error
		}
	}
	 */
}
