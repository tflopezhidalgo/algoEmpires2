import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TestColocarPiezas {
	
	//Lo mismo para cualquier tipo de unidad
	@Test
	public void UnidadColocada() {

		Posicion nuevaPosicion = new Posicion(1,1);
		Casilla casilla = new Casilla(nuevaPosicion);
		
		Aldeano unAldeano = new Aldeano(casilla);
		
		assertEquals(true, casilla.estaOcupada());
		assertEquals(unAldeano.obtenerUbicacion(), casilla);

	}
	
	@Test
	public void ColocarPlaza() {
		
		Casilla miniTablero[][] = new Casilla[5][5];
		
		for(int y = 0; y < 5; y++ ) {
			for(int x = 0; x < 5; x++ ) {
				Posicion unaPosicion = new Posicion(x,y);
				Casilla casilla = new Casilla(unaPosicion);
				
				miniTablero[x][y] = casilla;	
			}
		}
		
		List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
		
		//voy a ocupar a partir de la (2,2)
		//se ocuparan las casillas en (2,2) (2,3) (3,2) (3,3) 
		for(int y = 0; y < Plaza.TAMANIO_LADO; y++) {
			for(int x = 0; x < Plaza.TAMANIO_LADO; x++) {
				casillasParaConstruccion.add(miniTablero[2+x][2+y]);
			}
		}
		
		Area zonaDeConstruccion = new Area(casillasParaConstruccion);
		assertEquals(true, zonaDeConstruccion.estaLibre());
		
		Plaza unaPlaza = new Plaza(zonaDeConstruccion);
		assertEquals(false, zonaDeConstruccion.estaLibre());
		
		//Las casillas adyacentes deberian estar libres
		assertEquals(false, miniTablero[1][1].estaOcupada());
		assertEquals(false, miniTablero[4][4].estaOcupada());
		assertEquals(false, miniTablero[2][1].estaOcupada());
		assertEquals(false, miniTablero[3][4].estaOcupada());
	}
	
	@Test
	public void ColocarCuartel() {
		
		Casilla miniTablero[][] = new Casilla[5][5];
		
		for(int y = 0; y < 5; y++ ) {
			for(int x = 0; x < 5; x++ ) {
				Posicion unaPosicion = new Posicion(x,y);
				Casilla casilla = new Casilla(unaPosicion);
				
				miniTablero[x][y] = casilla;	
			}
		}
		
		List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
		
		//voy a ocupar a partir de la (2,2)
		//se ocuparan las casillas en (2,2) (2,3) (3,2) (3,3) 
		for(int y = 0; y < Cuartel.TAMANIO_LADO; y++) {
			for(int x = 0; x < Cuartel.TAMANIO_LADO; x++) {
				casillasParaConstruccion.add(miniTablero[2+x][2+y]);
			}
		}
		
		Area zonaDeConstruccion = new Area(casillasParaConstruccion);
		assertEquals(true, zonaDeConstruccion.estaLibre());
		
		Cuartel unCuartel = new Cuartel(zonaDeConstruccion);
		assertEquals(false, zonaDeConstruccion.estaLibre());
		
		//Las casillas adyacentes deberian estar libres
		assertEquals(false, miniTablero[1][1].estaOcupada());
		assertEquals(false, miniTablero[4][4].estaOcupada());
		assertEquals(false, miniTablero[2][1].estaOcupada());
		assertEquals(false, miniTablero[3][4].estaOcupada());
	}
	
	@Test
	public void ColocarCastillo() {
		
		Casilla miniTablero[][] = new Casilla[5][5];
		
		for(int y = 0; y < 5; y++ ) {
			for(int x = 0; x < 5; x++ ) {
				Posicion unaPosicion = new Posicion(x,y);
				Casilla casilla = new Casilla(unaPosicion);
				
				miniTablero[x][y] = casilla;	
			}
		}
		
		List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
		
		//voy a ocupar a partir de la (1,1) + 3 casillas de alto y 3 de ancho
		for(int y = 0; y < Castillo.TAMANIO_LADO; y++) {
			for(int x = 0; x < Castillo.TAMANIO_LADO; x++) {
				casillasParaConstruccion.add(miniTablero[1+x][1+y]);
			}
		}
		
		Area zonaDeConstruccion = new Area(casillasParaConstruccion);
		assertEquals(true, zonaDeConstruccion.estaLibre());
		
		Castillo unCastillo = new Castillo(zonaDeConstruccion);
		assertEquals(false, zonaDeConstruccion.estaLibre());
		
		
		assertEquals(true, miniTablero[3][4].estaOcupada());
		assertEquals(true, miniTablero[4][4].estaOcupada());
		//Las casillas adyacentes deberian estar libres
		assertEquals(false, miniTablero[0][0].estaOcupada());
		assertEquals(false, miniTablero[0][2].estaOcupada());
		assertEquals(false, miniTablero[0][3].estaOcupada());
		assertEquals(false, miniTablero[0][4].estaOcupada());

	}
	
	
	//TODO ESTO NO VA ACA!
	@Test
	public void moverAldeano() throws ErrorBasico {
		
		Casilla miniTablero[][] = new Casilla[5][5];
		
		for(int y = 0; y < 5; y++ ) {
			for(int x = 0; x < 5; x++ ) {
				Posicion unaPosicion = new Posicion(x,y);
				Casilla casilla = new Casilla(unaPosicion);
				
				miniTablero[x][y] = casilla;	
			}
		}
		
		Casilla casillaAldano = miniTablero[2][2];
		Aldeano unAldeano = new Aldeano(casillaAldano);
		
		assertEquals(true, casillaAldano.estaOcupada());
		
		unAldeano.moverArriba();
		assertEquals(false, casillaAldano.estaOcupada());
		
		Casilla casillaArriba = miniTablero[2][3];
		assertEquals(true, casillaArriba.estaOcupada());
	}
	
	

}
