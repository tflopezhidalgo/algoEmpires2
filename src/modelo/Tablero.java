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

	private void crearTableroVacio(){

        casillasDelTablero = new HashMap<String, Casilla>();

        for(int y = 0; y < this.alto; y++){
            for(int x = 0; x < this.ancho; x++){
                Casilla nuevaCasilla = new Casilla(x, y);
                casillasDelTablero.put(nuevaCasilla.aString(), nuevaCasilla);
            }
        }
    }

    private List<Pieza> generarPiezasInicialesConAreas(List<Area> listaAreas){

        List<Pieza> piezasNuevas = new ArrayList<Pieza>();

        piezasNuevas.add(new Castillo(listaAreas.get(0)));
        piezasNuevas.add(new Plaza(listaAreas.get(1)));
        piezasNuevas.add(new Aldeano(listaAreas.get(2)));
        piezasNuevas.add(new Aldeano(listaAreas.get(3)));
        piezasNuevas.add(new Aldeano(listaAreas.get(4)));

        return piezasNuevas;
    }

    //  Tablero por defecto: 16 x 16

    //TODO: Validar
	public Tablero(int ancho, int alto){

		this.alto = 16 + alto;
		this.ancho = 16 + ancho;

		crearTableroVacio();
	}

	public Tablero(){

	    this.alto = 16;
		this.ancho = 16;

		crearTableroVacio();
	}
	
	public Area definirArea(int xInicial, int yInicial, int xFinal, int yFinal) throws Exception{

        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
        
        for(int y = yInicial; y <= yFinal; y++) {
            for(int x = xInicial; x <= xFinal; x++) {
                casillasParaConstruccion.add(obtenerCasillaEn(x, y));
            }
        }

        Area zonaDeConstruccion = new Area(casillasParaConstruccion, xInicial, yInicial, xFinal, yFinal);
        return zonaDeConstruccion;
	}

	public List<Pieza> generarPiezasInicialesEquipo1() throws Exception{

	    List<Area> listaAreas = new ArrayList<>();

		Area areaCastillo = definirArea(1,1, 4, 4);
		listaAreas.add(areaCastillo);
		Area areaPlaza = definirArea(7,1,8,2);
		listaAreas.add(areaPlaza);
		Area espacioAldeano1 = definirArea(6,4,6,4);
		listaAreas.add(espacioAldeano1);
		Area espacioAldeano2 = definirArea(7,4,7,4);
		listaAreas.add(espacioAldeano2);
		Area espacioAldeano3 = definirArea(8,4,8,4);
		listaAreas.add(espacioAldeano3);

		return generarPiezasInicialesConAreas(listaAreas);
	}

	public List<Pieza> generarPiezasInicialesEquipo2() throws Exception{

	    List<Area> listaAreas = new ArrayList<>();

		Area areaCastillo = definirArea(ancho-5, alto-5, alto-2, ancho-2);
		listaAreas.add(areaCastillo);
		Area areaPlaza = definirArea(ancho-9,alto-3,ancho-8,alto-2);
        listaAreas.add(areaPlaza);
		Area espacioAldeano1 = definirArea(ancho-9,alto-5,ancho-9,alto-5);
		listaAreas.add(espacioAldeano1);
		Area espacioAldeano2 = definirArea(ancho-8,alto-5,ancho-8,alto-5);
        listaAreas.add(espacioAldeano2);
		Area espacioAldeano3 = definirArea(ancho-7,alto-5,ancho-7,alto-5);
        listaAreas.add(espacioAldeano3);

		return generarPiezasInicialesConAreas(listaAreas);
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

	public Casilla obtenerCasillaEn(int x, int y) throws Exception {
		casillaNoExisteError(x, y);
		String posicion = Casilla.aString(x, y);
		return casillasDelTablero.get(posicion);
	}
	
	//TODO decidir si sacamos esto o no
	private void casillaNoExisteError(int x, int y) throws Exception {
		if(x > ancho-1 | x < 0 | y < 0 | y > alto-1) {
			throw new CasillaInvalidaError();
		}
	}
	
	//---------------PROTOTIPO  V3---------------
	
	public void moverEnDireccion(Unidad unaUnidad, int difX, int difY) throws Exception {
		Area espacioAnterior = unaUnidad.obtenerAreaOcupada();
		Area nuevoEspacio = this.definirArea(espacioAnterior.x0()+difX, espacioAnterior.y0()+difY, espacioAnterior.x1()+difX, espacioAnterior.y1()+difY);

		if(nuevoEspacio.estaLibre()) {
			unaUnidad.mover(nuevoEspacio);
		}
	}

}
