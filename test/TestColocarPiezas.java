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
	public void EdificioColocado() {
		
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
		for(int y = 0; y < Plaza.TAMANIO_LADO; y++) {
			for(int x = 0; x < Plaza.TAMANIO_LADO; x++) {
				casillasParaConstruccion.add(miniTablero[2+x][2+y]);
			}
		}
		
		Area zonaDeConstruccion = new Area(casillasParaConstruccion);
		assertEquals(true, zonaDeConstruccion.estaLibre());
		
		Plaza unaPlaza = new Plaza(zonaDeConstruccion);
		assertEquals(false, zonaDeConstruccion.estaLibre());

	}

}
