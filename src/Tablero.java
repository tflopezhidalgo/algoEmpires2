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
		int x = (int) (Math.random() * 1);
		int y = (int) (Math.random() * 6);
		
		Area areaCastillo1 = definirArea(x, y, x+Castillo.TAMANIO_LADO-1, y+Castillo.TAMANIO_LADO-1);
		Castillo castillo1 = new Castillo(areaCastillo1);
		//-------------------
		piezasNuevas.add(castillo1);
		//Plaza 1
		x = (int) (Math.random() * 1) + 5;
		y = (int) (Math.random() * 6);
		
		Area areaPlaza1 = definirArea(x, y, x+Plaza.TAMANIO_LADO-1, y+Plaza.TAMANIO_LADO-1);
		Plaza plaza1 = new Plaza(areaPlaza1);
		//-------------------
		piezasNuevas.add(plaza1);
		return piezasNuevas;
		
		//TODO definir 4 arear random para los castillos(2) y plazas(2)
		//TODO definir 6 casillas random para los 6 aldeanos
	}
	
	//TODO esto hacerlo aca o en Juego y que llame al metodo "colocar" inidcando las areas y casillas deseadas??
	public List<Pieza> generarPiezasInicialesEquipo2() throws Excepcion{
		List<Pieza> piezasNuevas = new ArrayList<Pieza>();
		//Castillo 2
		int x = (int) (Math.random() * 1) + 11;
		int y = (int) (Math.random() * 6) + 6;
		
		Area areaCastillo2 = definirArea(x, y, x+Castillo.TAMANIO_LADO-1, y+Castillo.TAMANIO_LADO-1);
		Castillo castillo2 = new Castillo(areaCastillo2);
		//-------------------
		piezasNuevas.add(castillo2);
		//Plaza 2
		x = (int) (Math.random() * 1) + 8;
		y = (int) (Math.random() * 6) + 6;
		
		Area areaPlaza2 = definirArea(x, y, x+Plaza.TAMANIO_LADO-1, y+Plaza.TAMANIO_LADO-1);
		Plaza plaza2 = new Plaza(areaPlaza2);
		//-------------------
		piezasNuevas.add(plaza2);
		return piezasNuevas;

		//TODO definir 4 arear random para los castillos(2) y plazas(2)
		//TODO definir 6 casillas random para los 6 aldeanos
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
	
	//---------------PROTOTIPO  V2---------------
	//TODO FIX THIS -  YA SE QUE ESTA HORRIBLE TOM, ESPERA UN TOQUE (?
	//ESTAS 8 FUNCIONES CAPAS NI VAN
	
	public void moverArriba(Unidad unaUnidad) throws Excepcion {
		Area espacioAnterior = unaUnidad.espacioOcupado();
		espacioAnterior.liberar();
		Area nuevoEspacio = this.definirArea(espacioAnterior.x0(), espacioAnterior.y0()+1, espacioAnterior.x1(), espacioAnterior.y1()+1);

		if(nuevoEspacio.estaLibre() & !unaUnidad.estaOcupado()) {
			unaUnidad.mover(nuevoEspacio);
		}
		else {
			//NO SE PUEDE MOVER PORQUE EL ESPACIO ESTA OCUPADO
			espacioAnterior.ocupar();
		}
	}
	
	public void moverAbajo(Unidad unaUnidad) throws Excepcion {
		Area espacioAnterior = unaUnidad.espacioOcupado();
		espacioAnterior.liberar();
		Area nuevoEspacio = this.definirArea(espacioAnterior.x0(), espacioAnterior.y0()-1, espacioAnterior.x1(), espacioAnterior.y1()-1);

		if(nuevoEspacio.estaLibre() & !unaUnidad.estaOcupado()) {
			unaUnidad.mover(nuevoEspacio);
		}
		else {
			//NO SE PUEDE MOVER PORQUE EL ESPACIO ESTA OCUPADO
			espacioAnterior.ocupar();
		}
	}
	
	public void moverIzquierda(Unidad unaUnidad) throws Excepcion {
		Area espacioAnterior = unaUnidad.espacioOcupado();
		espacioAnterior.liberar();
		Area nuevoEspacio = this.definirArea(espacioAnterior.x0()-1, espacioAnterior.y0(), espacioAnterior.x1()-1, espacioAnterior.y1());

		if(nuevoEspacio.estaLibre() & !unaUnidad.estaOcupado()) {
			unaUnidad.mover(nuevoEspacio);
		}
		else {
			//NO SE PUEDE MOVER PORQUE EL ESPACIO ESTA OCUPADO
			espacioAnterior.ocupar();
		}
	}
		
	public void moverDerecha(Unidad unaUnidad) throws Excepcion {
		Area espacioAnterior = unaUnidad.espacioOcupado();
		espacioAnterior.liberar();
		Area nuevoEspacio = this.definirArea(espacioAnterior.x0()+1, espacioAnterior.y0(), espacioAnterior.x1()+1, espacioAnterior.y1());

		if(nuevoEspacio.estaLibre() & !unaUnidad.estaOcupado()) {
			unaUnidad.mover(nuevoEspacio);
		}
		else {
			//NO SE PUEDE MOVER PORQUE EL ESPACIO ESTA OCUPADO
			espacioAnterior.ocupar();
		}
	}
	
	public void moverArribaDerecha(Unidad unaUnidad) throws Excepcion {
		Area espacioAnterior = unaUnidad.espacioOcupado();
		espacioAnterior.liberar();
		Area nuevoEspacio = this.definirArea(espacioAnterior.x0()+1, espacioAnterior.y0()+1, espacioAnterior.x1()+1, espacioAnterior.y1()+1);

		if(nuevoEspacio.estaLibre() & !unaUnidad.estaOcupado()) {
			unaUnidad.mover(nuevoEspacio);
		}
		else {
			//NO SE PUEDE MOVER PORQUE EL ESPACIO ESTA OCUPADO
			espacioAnterior.ocupar();
		}
	}
	
	public void moverAbajoDerecha(Unidad unaUnidad) throws Excepcion {
		Area espacioAnterior = unaUnidad.espacioOcupado();
		espacioAnterior.liberar();
		Area nuevoEspacio = this.definirArea(espacioAnterior.x0()+1, espacioAnterior.y0()-1, espacioAnterior.x1()+1, espacioAnterior.y1()-1);

		if(nuevoEspacio.estaLibre() & !unaUnidad.estaOcupado()) {
			unaUnidad.mover(nuevoEspacio);
		}
		else {
			//NO SE PUEDE MOVER PORQUE EL ESPACIO ESTA OCUPADO
			espacioAnterior.ocupar();
		}
	}
	
	public void moverArribaIzquierda(Unidad unaUnidad) throws Excepcion {
		Area espacioAnterior = unaUnidad.espacioOcupado();
		espacioAnterior.liberar();
		Area nuevoEspacio = this.definirArea(espacioAnterior.x0()-1, espacioAnterior.y0()+1, espacioAnterior.x1()-1, espacioAnterior.y1()+1);

		if(nuevoEspacio.estaLibre() & !unaUnidad.estaOcupado()) {
			unaUnidad.mover(nuevoEspacio);
		}
		else {
			//NO SE PUEDE MOVER PORQUE EL ESPACIO ESTA OCUPADO
			espacioAnterior.ocupar();
		}
	}
	
	public void moverAbajoIzquierda(Unidad unaUnidad) throws Excepcion {
		Area espacioAnterior = unaUnidad.espacioOcupado();
		espacioAnterior.liberar();
		Area nuevoEspacio = this.definirArea(espacioAnterior.x0()-1, espacioAnterior.y0()-1, espacioAnterior.x1()-1, espacioAnterior.y1()-1);

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

    //TODO ELIMINAR
	public void printMapa() throws Excepcion {
		for(int y = 0;y<alto;y++) {
			for(int x = 0;x<ancho;x++) {
				if(this.obtenerCasillaEn(x, y).estaOcupada()) {
					System.out.print("X");
				}
				else {
					System.out.print("-");
				}
			}
			System.out.println("");
		}
	}
}
