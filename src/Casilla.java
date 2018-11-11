import java.util.HashMap;
import java.util.Map;

public class Casilla {

	private static Map<String, Casilla> casillasDelTablero = new HashMap<String, Casilla>();
	
	private boolean ocupada;
	private Pieza piezaDeJuego;
	private Posicion posicionActual;
	
	public Casilla (Posicion unaPosicion) {

		casillasDelTablero.put(unaPosicion.aString(), this);

		posicionActual = unaPosicion;
		ocupada = false;
		piezaDeJuego = null;
	}
	
	public boolean estaOcupada() {
		return ocupada;
	}
	
	//NO USAR ?
	public void colocar(Pieza unaPieza) {
		if(!ocupada) {
			ocupada = true;
			piezaDeJuego = unaPieza;
		}
		else {
			//TODO error
			System.out.println("ERROR");
		}
	}
	
	public void liberar() {
		ocupada = false;
		piezaDeJuego = null;
	}
	
	public Pieza obtenerPieza() {
		return piezaDeJuego;
	}
	
	public Posicion obtenerPosicion() {
		return posicionActual;
	}
	
	//---------------PROTOTIPO---------------
	
	public Casilla casillaArriba() {
		Casilla casillaArriba = casillasDelTablero.get(Posicion.aString(posicionActual.ejeX(), posicionActual.ejeY() + 1));
		return casillaArriba;
	}
	
	public Casilla casillaAbajo() {
		Casilla casillaAbajo = casillasDelTablero.get(Posicion.aString(posicionActual.ejeX(), posicionActual.ejeY() - 1));
		return casillaAbajo;
	}
	
	public Casilla casillaIzquierda() {
		Casilla casillaIzquierda = casillasDelTablero.get(Posicion.aString(posicionActual.ejeX() - 1, posicionActual.ejeY()));
		return casillaIzquierda;
	}
	
	public Casilla casillaDerecha() {
		Casilla casillaDerecha = casillasDelTablero.get(Posicion.aString(posicionActual.ejeX() + 1, posicionActual.ejeY()));
		return casillaDerecha;
	}
	
	//---- diagonales
	
	public Casilla casillaArribaIzquiera() {
		Casilla casillaArribaIzquiera = casillasDelTablero.get(Posicion.aString(posicionActual.ejeX()-1, posicionActual.ejeY() + 1));
		return casillaArribaIzquiera;
	}
	
	public Casilla casillaArribaDerecha() {
		Casilla casillaArribaDerecha = casillasDelTablero.get(Posicion.aString(posicionActual.ejeX()+1, posicionActual.ejeY() + 1));
		return casillaArribaDerecha;
	}
	
	public Casilla casillaAbajoIzquierda() {
		Casilla casillaAbajoIzquierda = casillasDelTablero.get(Posicion.aString(posicionActual.ejeX()-1, posicionActual.ejeY()+1));
		return casillaAbajoIzquierda;
	}
	
	public Casilla casillaAbajoDerecha() {
		Casilla casillaAbajoDerecha = casillasDelTablero.get(Posicion.aString(posicionActual.ejeX() + 1, posicionActual.ejeY() - 1));
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