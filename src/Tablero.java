import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tablero {

	private Map<String, Casilla> casillasDelTablero;
	
	public Tablero(int ancho, int alto){
        casillasDelTablero = new HashMap<String, Casilla>();
		
		for(int y=0;y<alto;y++){
			for(int x=0;x<ancho;x++){
				/*Posicion nuevaPosicion = new Posicion(x,y);*/
				Casilla nuevaCasilla = new Casilla(x,y);
				/*casillasDelTablero.put(nuevaPosicion.aString(),nuevaCasilla);*/
				casillasDelTablero.put(nuevaCasilla.aString(),nuevaCasilla);
			}
		}
		colocarPiezasIniciales();
	}
	
	public Area definirArea(int xInicial, int yInicial, int xFinal, int yFinal) {
        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
        
        for(int y = yInicial; y <= yFinal; y++) {
            for(int x = xInicial; x <= xFinal; x++) {
                casillasParaConstruccion.add(obtenerCasillaEn(x, y));
            }
        }
        Area zonaDeConstruccion = new Area(casillasParaConstruccion);
        return zonaDeConstruccion;
	}
	
	//TODO esto hacerlo aca o en Juego y que llame al metodo "colocar" inidcando las areas y casillas deseadas??
	private void colocarPiezasIniciales(){
		//TODO definir 4 arear random para los castillos(2) y plazas(2)
		//TODO definir 6 casillas random para los 6 aldeanos
	}
	//no podes hacer pull request desde aca fuck
	//TODO check casillos fueron destruidos codearlo aca o en juego?
	
	public void moverHasta(Unidad unaUnidad, Casilla casillaFinal) throws ErrorBasico {
		if(!casillaFinal.estaOcupada()) {
			/*int distancia = unaUnidad.obtenerPosicion().calcularDistanciaA(casillaFinal.obtenerPosicion());*/
			int distancia = unaUnidad.obtenerUbicacion().calcularDistanciaA(casillaFinal);
			if(distancia <= 1) {
				unaUnidad.mover(casillaFinal);
			}
		}
	}
	
	public void ataqueDesdeHasta(Casilla casillaInicial, Casilla casillaFinal) {
		//TODO casilla inicial es un edificio o unidad?
		//TODO casilla final es un edificio o unidad?
	}
	
	public void liberar(Area unArea) {
		unArea.liberar();
	}
	
	public void liberar(Casilla unaCasilla) {
		unaCasilla.liberar();
	}
	
	//TODO verificar q estamos de acuerdo en tener esta funcion
	/*public Casilla obtenerCasillaEn(Posicion unaPosicion) {
		return casillasDelTablero.get(unaPosicion.aString());
	}*/
	
	//TODO verificar q estamos de acuerdo en tener esta funcion
	public Casilla obtenerCasillaEn(int x, int y) {
		String posicion = Integer.toString(x) + "I" + Integer.toString(y);
		return casillasDelTablero.get(posicion);
	}
	
	//---------------PROTOTIPO---------------
	//TODO FIX THIS -  YA SE QUE ESTA HORRIBLE TOM, ESPERA UN TOQUE (?
	//ESTAS 8 FUNCIONES CAPAS NI VAN
	public Casilla casillaArribaDe(Casilla casillaActual) {
		/*Posicion posicionActual = casillaActual.obtenerPosicion();
		String unaPosicion = Posicion.aString(posicionActual.ejeX(), posicionActual.ejeY() + 1);
		Casilla casillaArriba = casillasDelTablero.get(unaPosicion);
		return casillaArriba;*/

		String unaPosicion = casillaActual.aString(casillaActual.obtenerFila(), casillaActual.obtenerColumna()+1);
		Casilla casillaArriba = casillasDelTablero.get(unaPosicion);

		return casillaArriba;
	}
	
	public Casilla casillaAbajoDe(Casilla casillaActual) {
		/*Posicion posicionActual = casillaActual.obtenerPosicion();
		String unaPosicion = Posicion.aString(posicionActual.ejeX(), posicionActual.ejeY() - 1);
		Casilla casillaAbajo = casillasDelTablero.get(unaPosicion);
		return casillaAbajo;*/

		String unaPosicion = casillaActual.aString(casillaActual.obtenerFila(), casillaActual.obtenerColumna()-1);
		Casilla casillaAbajo = casillasDelTablero.get(unaPosicion);

		return casillaAbajo;

	}
	
	public Casilla casillaIzquierdaDe(Casilla casillaActual) {
		/*Posicion posicionActual = casillaActual.obtenerPosicion();
		String unaPosicion = Posicion.aString(posicionActual.ejeX() - 1, posicionActual.ejeY());
		Casilla casillaIzquierda = casillasDelTablero.get(unaPosicion);
		return casillaIzquierda;*/

		String unaPosicion = casillaActual.aString(casillaActual.obtenerFila()-1, casillaActual.obtenerColumna());
		Casilla casillaIzquierda = casillasDelTablero.get(unaPosicion);

		return casillaIzquierda;
	}
	
	public Casilla casillaDerechaDe(Casilla casillaActual) {
		/*Posicion posicionActual = casillaActual.obtenerPosicion();
		String unaPosicion = Posicion.aString(posicionActual.ejeX() + 1, posicionActual.ejeY());
		Casilla casillaDerecha = casillasDelTablero.get(unaPosicion);
		return casillaDerecha;*/

		String unaPosicion = casillaActual.aString(casillaActual.obtenerFila()+1, casillaActual.obtenerColumna());
		Casilla casillaDerecha = casillasDelTablero.get(unaPosicion);

		return casillaDerecha;

	}
	
	//---- diagonales
	
	public Casilla casillaArribaIzquierdaDe(Casilla casillaActual) {
		/*Posicion posicionActual = casillaActual.obtenerPosicion();
		String unaPosicion = Posicion.aString(posicionActual.ejeX()-1, posicionActual.ejeY() + 1);
		Casilla casillaArribaIzquiera = casillasDelTablero.get(unaPosicion);
		return casillaArribaIzquiera;*/

		String unaPosicion = casillaActual.aString(casillaActual.obtenerFila()-1, casillaActual.obtenerColumna()+1);
		Casilla casillaArribaIzquierda = casillasDelTablero.get(unaPosicion);

		return casillaArribaIzquierda;

	}
	
	public Casilla casillaArribaDerechaDe(Casilla casillaActual) {
		/*Posicion posicionActual = casillaActual.obtenerPosicion();
		String unaPosicion = Posicion.aString(posicionActual.ejeX()+1, posicionActual.ejeY() + 1);
		Casilla casillaArribaDerecha = casillasDelTablero.get(unaPosicion);
		return casillaArribaDerecha;*/

		String unaPosicion = casillaActual.aString(casillaActual.obtenerFila()+1, casillaActual.obtenerColumna()+1);
		Casilla casillaArribaDerecha = casillasDelTablero.get(unaPosicion);

		return casillaArribaDerecha;

	}
	
	public Casilla casillaAbajoIzquierdaDe(Casilla casillaActual) {
		/*Posicion posicionActual = casillaActual.obtenerPosicion();
		String unaPosicion = Posicion.aString(posicionActual.ejeX()-1, posicionActual.ejeY()-1);
		Casilla casillaAbajoIzquierda = casillasDelTablero.get(unaPosicion);
		return casillaAbajoIzquierda;*/

		String unaPosicion = casillaActual.aString(casillaActual.obtenerFila()-1, casillaActual.obtenerColumna()-1);
		Casilla casillaAbajoIzquierda = casillasDelTablero.get(unaPosicion);

		return casillaAbajoIzquierda;

	}
	
	public Casilla casillaAbajoDerechaDe(Casilla casillaActual) {
		/*Posicion posicionActual = casillaActual.obtenerPosicion();
		String unaPosicion = Posicion.aString(posicionActual.ejeX() + 1, posicionActual.ejeY() - 1);
		Casilla casillaAbajoDerecha = casillasDelTablero.get(unaPosicion);
		return casillaAbajoDerecha;*/

		String unaPosicion = casillaActual.aString(casillaActual.obtenerFila()+1, casillaActual.obtenerColumna()-1);
		Casilla casillaAbajoDerecha = casillasDelTablero.get(unaPosicion);

		return casillaAbajoDerecha;
	}
	
	//--------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------

}
