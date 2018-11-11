import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class TestCastilloCreaUnidad {

	@Test
	void castilloCreaCatapulta() {
		
		
		Casilla miniTablero[][] = new Casilla[6][6];
		for(int y = 0; y < 6; y++ ) {
			for(int x = 0; x < 6; x++ ) {
				Posicion unaPosicion = new Posicion(x,y);
				Casilla casilla = new Casilla(unaPosicion);
				
				miniTablero[x][y] = casilla;	
			}
		}
		
		
		List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
		//voy a ocupar a partir de la (0,0)
		for(int y = 0; y < Castillo.TAMANIO_LADO; y++) {
			for(int x = 0; x < Castillo.TAMANIO_LADO; x++) {
				casillasParaConstruccion.add(miniTablero[x][y]);
			}
		}
		Area zonaDeConstruccion = new Area(casillasParaConstruccion);
		
		
		Castillo unCastillo = new Castillo(zonaDeConstruccion);
		Assert.assertEquals(true, miniTablero[3][3].estaOcupada());
		
		Casilla casillaParaCatapulta = miniTablero[4][4];
		Assert.assertEquals(false, casillaParaCatapulta.estaOcupada());
		
		Catapulta nuevaCatapulta = unCastillo.crearCatapulta(casillaParaCatapulta);
		Assert.assertEquals(true, casillaParaCatapulta.estaOcupada());
		Assert.assertEquals(casillaParaCatapulta, nuevaCatapulta.obtenerUbicacion());

	}
}

