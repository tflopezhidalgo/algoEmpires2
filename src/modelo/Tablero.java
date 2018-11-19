package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tablero {

	private Map<String, Casilla> casillasDelTablero;
	private int alto;
	private int ancho;
	
	public Tablero(int ancho, int alto){
		this.alto = alto;
		this.ancho = ancho;
		
        casillasDelTablero = new HashMap<String, Casilla>();
		
		for(int y=0;y<alto;y++){
			for(int x=0;x<ancho;x++){
				Casilla nuevaCasilla = new Casilla(x,y);
				casillasDelTablero.put(nuevaCasilla.aString(),nuevaCasilla);
			}
		}
		//TODO no ejecutar esto si permito este constructor?
		//colocarPiezasIniciales();
	}
	
	//Default es 16x16 TODO permitir el otro constructor?
	public Tablero() throws Excepcion{
		this.alto = 16;
		this.ancho = 16;
		
        casillasDelTablero = new HashMap<String, Casilla>();
		
		for(int y=0;y<alto;y++){
			for(int x=0;x<ancho;x++){
				Casilla nuevaCasilla = new Casilla(x,y);
				casillasDelTablero.put(nuevaCasilla.aString(),nuevaCasilla);
			}
		}
	}
	
	public Area definirArea(int xInicial, int yInicial, int xFinal, int yFinal) throws Excepcion {
        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
        
        for(int y = yInicial; y <= yFinal; y++) {
            for(int x = xInicial; x <= xFinal; x++) {
                casillasParaConstruccion.add(obtenerCasillaEn(x, y));
            }
        }

        Area zonaDeConstruccion = new Area(casillasParaConstruccion, xInicial, yInicial, xFinal, yFinal);
        return zonaDeConstruccion;
	}
	
	//TODO esto hacerlo aca o en Juego y que llame al metodo "colocar" inidcando las areas y casillas deseadas??
	public List<Pieza> generarPiezasInicialesEquipo1() throws Excepcion{
		List<Pieza> piezasNuevas = new ArrayList<Pieza>();
		//Castillo 1
		Area areaCastillo = definirArea(1,1, 4, 4);
		Castillo castillo = new Castillo(areaCastillo);
		//-------------------
		piezasNuevas.add(castillo);
		//Plaza 1
		Area areaPlaza = definirArea(7,1,8,2);
		Plaza plaza = new Plaza(areaPlaza);
		//-------------------
		piezasNuevas.add(plaza);
		//Aldeanosx3
		Area espacioAldeano1 = definirArea(6,4,6,4);
		Aldeano aldeano1 = new Aldeano(espacioAldeano1);
		piezasNuevas.add(aldeano1);
		Area espacioAldeano2 = definirArea(7,4,7,4);
		Aldeano aldeano2 = new Aldeano(espacioAldeano2);
		piezasNuevas.add(aldeano2);
		Area espacioAldeano3 = definirArea(8,4,8,4);
		Aldeano aldeano3 = new Aldeano(espacioAldeano3);
		piezasNuevas.add(aldeano3);
		//-------------------
		return piezasNuevas;
	}
	
	//TODO esto hacerlo aca o en Juego y que llame al metodo "colocar" inidcando las areas y casillas deseadas??
	public List<Pieza> generarPiezasInicialesEquipo2() throws Excepcion{
		List<Pieza> piezasNuevas = new ArrayList<Pieza>();
		//Castillo 1
		Area areaCastillo = definirArea(ancho-5, alto-5, alto-2, ancho-2);
		Castillo castillo = new Castillo(areaCastillo);
		//-------------------
		piezasNuevas.add(castillo);
		//Plaza 1
		Area areaPlaza = definirArea(ancho-9,alto-3,ancho-8,alto-2);
		Plaza plaza = new Plaza(areaPlaza);
		//-------------------
		piezasNuevas.add(plaza);
		//Aldeanosx3
		Area espacioAldeano1 = definirArea(ancho-9,alto-5,ancho-9,alto-5);
		Aldeano aldeano1 = new Aldeano(espacioAldeano1);
		piezasNuevas.add(aldeano1);
		Area espacioAldeano2 = definirArea(ancho-8,alto-5,ancho-8,alto-5);
		Aldeano aldeano2 = new Aldeano(espacioAldeano2);
		piezasNuevas.add(aldeano2);
		Area espacioAldeano3 = definirArea(ancho-7,alto-5,ancho-7,alto-5);
		Aldeano aldeano3 = new Aldeano(espacioAldeano3);
		piezasNuevas.add(aldeano3);
		//-------------------
		return piezasNuevas;
	}
	
	//TODO check casillos fueron destruidos codearlo aca o en juego?
	
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
	public Casilla obtenerCasillaEn(int x, int y) throws Excepcion {
		casillaNoExisteError(x, y);
		String posicion = Casilla.aString(x, y);
		return casillasDelTablero.get(posicion);
	}
	
	private void casillaNoExisteError(int x, int y) throws Excepcion {
		if(x > ancho-1 | x < 0 | y < 0 | y > alto-1) {
			throw new Excepcion("ERROR: Casilla no existe.");
		}
	}
	
	//---------------PROTOTIPO  V3---------------
	
	public void moverEnDireccion(Unidad unaUnidad, int difX, int difY) throws Excepcion {
		Area espacioAnterior = unaUnidad.espacioOcupado();
		espacioAnterior.liberar();
		Area nuevoEspacio = this.definirArea(espacioAnterior.x0()+difX, espacioAnterior.y0()+difY, espacioAnterior.x1()+difX, espacioAnterior.y1()+difY);

		if(nuevoEspacio.estaLibre() & !unaUnidad.estaOcupado()) {
			unaUnidad.mover(nuevoEspacio);
		}
		else {
			//NO SE PUEDE MOVER PORQUE EL ESPACIO ESTA OCUPADO
			espacioAnterior.ocupar();
		}
	}
	
	//--------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------

}
