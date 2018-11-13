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
	public void colocar(Pieza unaPieza) throws ErrorBasico {
		if(!ocupada) {
			ocupada = true;
			piezaDeJuego = unaPieza;
		}
		else {
			//TODO error
			throw new ErrorBasico("ERROR: Casilla ocupada.");
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
