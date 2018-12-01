package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.excepciones.CasillaInvalidaError;

public class Tablero {

	private Map<String, Casilla> casillasDelTablero;
	private int alto;
	private int ancho;
	public static Tablero INSTANCIA;

	//TODO: Validar
	public Tablero(int ancho, int alto){
		
		this.alto = 16 + alto;
		this.ancho = 16 + ancho;
		
		crearTableroVacio();
		INSTANCIA = this;
	}
	
    //  Tablero por defecto: 16 x 16
	public Tablero(){

	    this.alto = 16;
		this.ancho = 16;

		crearTableroVacio();
		INSTANCIA = this;
	}
	
	private void crearTableroVacio(){

        casillasDelTablero = new HashMap<String, Casilla>();

        for(int y = 0; y < this.alto; y++){
            for(int x = 0; x < this.ancho; x++){
                Casilla nuevaCasilla = new Casilla(x, y);
                casillasDelTablero.put(nuevaCasilla.aString(), nuevaCasilla);
            }
        }
    }
	
	public Area definirArea(int xInicial, int yInicial, int xFinal, int yFinal){

        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
        
        for(int y = yInicial; y <= yFinal; y++) {
            for(int x = xInicial; x <= xFinal; x++) {
                casillasParaConstruccion.add(obtenerCasillaEn(x, y));
            }
        }

        Area zonaDeConstruccion = new Area(casillasParaConstruccion, xInicial, yInicial, xFinal, yFinal);
        return zonaDeConstruccion;
	}

	public List<Pieza> generarPiezasInicialesEquipo1(){

        List<Pieza> piezasNuevas = new ArrayList<Pieza>();

        piezasNuevas.add(new Castillo(1,1));
        piezasNuevas.add(new Plaza(7,1));
        piezasNuevas.add(new Aldeano(6,4));
        piezasNuevas.add(new Aldeano(7,4));
        piezasNuevas.add(new Aldeano(8,4));

		return piezasNuevas;
	}

	public List<Pieza> generarPiezasInicialesEquipo2(){
		
        List<Pieza> piezasNuevas = new ArrayList<Pieza>();

        piezasNuevas.add(new Castillo(ancho-5, alto-5));
        piezasNuevas.add(new Plaza(ancho-9,alto-3));
        piezasNuevas.add(new Aldeano(ancho-9,alto-5));
        piezasNuevas.add(new Aldeano(ancho-8,alto-5));
        piezasNuevas.add(new Aldeano(ancho-7,alto-5));

		return piezasNuevas;
	}
	
	public void liberar(Area unArea) {
		unArea.liberar();
	}
	
	public void liberar(Casilla unaCasilla) {
		unaCasilla.liberar();
	}

	public Casilla obtenerCasillaEn(int x, int y) {
		casillaNoExisteError(x, y);
		String posicion = Casilla.aString(x, y);
		return casillasDelTablero.get(posicion);
	}
	
	//TODO decidir si sacamos esto o no
	private void casillaNoExisteError(int x, int y) {
		if(x > ancho-1 | x < 0 | y < 0 | y > alto-1) {
			throw new CasillaInvalidaError();
		}
	}
	
	//---------------PROTOTIPO  V3---------------
	
	public void moverEnDireccion(Unidad unaUnidad, int difX, int difY) {
		Area espacioAnterior = unaUnidad.obtenerAreaOcupada();
		Area nuevoEspacio = this.definirArea(espacioAnterior.x0()+difX, espacioAnterior.y0()+difY, espacioAnterior.x1()+difX, espacioAnterior.y1()+difY);

		if(nuevoEspacio.estaLibre()) {
			unaUnidad.mover(nuevoEspacio);
		}
	}

}
