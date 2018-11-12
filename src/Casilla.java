import java.util.HashMap;
import java.util.Map;

public class Casilla {

	private static Map<String, Casilla> casillasDelTablero = new HashMap<String, Casilla>();
	
	private boolean ocupada;
	private Pieza piezaDeJuego;
	private Posicion posicionActual;

	public Casilla( int x, int y ){

        posicionActual = new Posicion(x, y);

        casillasDelTablero.put(posicionActual.aString(), this);

        ocupada = false;
        piezaDeJuego = null;
    }

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
