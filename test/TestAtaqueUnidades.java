import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TestAtaqueUnidades {

	@Test
	void ataqueEspadachin() throws ErrorBasico {
		
		Casilla miniTablero[][] = new Casilla[3][3];
		
		for(int y = 0; y < 3; y++ ) {
			for(int x = 0; x < 3; x++ ) {
				Posicion unaPosicion = new Posicion(x,y);
				Casilla casilla = new Casilla(unaPosicion);
				
				miniTablero[x][y] = casilla;	
			}
		}

		Casilla casillaAldeano = miniTablero[1][1];
		Aldeano unAldeano = new Aldeano(casillaAldeano);
		
		Casilla casillaEspadachin = miniTablero[2][1];
		Espadachin unEspadachin = new Espadachin(casillaEspadachin);
		
		//vida del aldeano == 25
		unEspadachin.atacar(casillaAldeano);
		//o tambien usando
		//vida del aldeano == 0
		unEspadachin.atacar(unAldeano.obtenerUbicacion());
		
		assertEquals(false,casillaAldeano.estaOcupada());
		assertEquals(true,unAldeano.estaDestruida());
	}
	
	@Test
	void ataqueEspadachinFueraDeRango() throws ErrorBasico {
		
		Casilla miniTablero[][] = new Casilla[3][3];
		
		for(int y = 0; y < 3; y++ ) {
			for(int x = 0; x < 3; x++ ) {
				Posicion unaPosicion = new Posicion(x,y);
				Casilla casilla = new Casilla(unaPosicion);
				
				miniTablero[x][y] = casilla;	
			}
		}

		Casilla casillaAldeano = miniTablero[0][0];
		Aldeano unAldeano = new Aldeano(casillaAldeano);
		
		Casilla casillaEspadachin = miniTablero[0][2];
		Espadachin unEspadachin = new Espadachin(casillaEspadachin);
		
		//vida del aldeano == 50
		//TODO deberia tirar error (NO SE COMO CHEQUEAR EXCEPCIONES)
		//unEspadachin.atacar(casillaAldeano);
		//o tambien usando
		//vida del aldeano == 50
		//TODO deberia tirar error (NO SE COMO CHEQUEAR EXCEPCIONES)
		//unEspadachin.atacar(unAldeano.obtenerUbicacion());
		
		assertEquals(true,casillaAldeano.estaOcupada());
		assertEquals(false,unAldeano.estaDestruida());

	}
	
	@Test
	void ataqueArqueroADistancia() throws ErrorBasico {
		
		Casilla miniTablero[][] = new Casilla[4][4];
		
		for(int y = 0; y < 4; y++ ) {
			for(int x = 0; x < 4; x++ ) {
				Posicion unaPosicion = new Posicion(x,y);
				Casilla casilla = new Casilla(unaPosicion);
				
				miniTablero[x][y] = casilla;	
			}
		}

		Casilla casillaAldeano = miniTablero[0][0];
		Aldeano unAldeano = new Aldeano(casillaAldeano);
		
		Casilla casillaArquero = miniTablero[0][3];
		Arquero unArquero = new Arquero(casillaArquero);
		
		//vida del aldeano == 35
		unArquero.atacar(casillaAldeano);
		//o tambien usando
		//vida del aldeano == 20
		unArquero.atacar(unAldeano.obtenerUbicacion());
		
		assertEquals(false,unAldeano.estaDestruida());
		assertEquals(true,casillaAldeano.estaOcupada());
		
		//vida del aldeano == 5
		unArquero.atacar(casillaAldeano);
		//vida del aldeano == 0
		unArquero.atacar(casillaAldeano);
		
		assertEquals(false,casillaAldeano.estaOcupada());
		assertEquals(true,unAldeano.estaDestruida());
	}
	
	@Test
	void ataqueArqueroFueraDeRango() throws ErrorBasico {
		
		Casilla miniTablero[][] = new Casilla[5][5];
		
		for(int y = 0; y < 5; y++ ) {
			for(int x = 0; x < 5; x++ ) {
				Posicion unaPosicion = new Posicion(x,y);
				Casilla casilla = new Casilla(unaPosicion);
				
				miniTablero[x][y] = casilla;	
			}
		}

		Casilla casillaAldeano = miniTablero[0][0];
		Aldeano unAldeano = new Aldeano(casillaAldeano);
		
		Casilla casillaArquero = miniTablero[0][4];
		Arquero unArquero = new Arquero(casillaArquero);
		
		//vida del aldeano == 50
		//TODO deberia tirar error (NO SE COMO CHEQUEAR EXCEPCIONES)
		//unArquero.atacar(casillaAldeano);
		//o tambien usando
		//vida del aldeano == 50
		//TODO deberia tirar error (NO SE COMO CHEQUEAR EXCEPCIONES)
		//unArquero.atacar(unAldeano.obtenerUbicacion());

		
		assertEquals(true,casillaAldeano.estaOcupada());
		assertEquals(false,unAldeano.estaDestruida());
	}
	
	
	@Test
	void ataqueCatapultaAUnidadNoHaceDanio() throws ErrorBasico {
		
		Casilla miniTablero[][] = new Casilla[7][7];
		
		for(int y = 0; y < 7; y++ ) {
			for(int x = 0; x < 7; x++ ) {
				Posicion unaPosicion = new Posicion(x,y);
				Casilla casilla = new Casilla(unaPosicion);
				
				miniTablero[x][y] = casilla;	
			}
		}

		Casilla casillaAldeano = miniTablero[0][0];
		Aldeano unAldeano = new Aldeano(casillaAldeano);
		
		Casilla casillaCatapulta = miniTablero[0][5];
		Catapulta unaCatapulta = new Catapulta(casillaCatapulta);
		
		//vida del aldeano == 50
		unaCatapulta.atacar(casillaAldeano);
		//o tambien usando
		//vida del aldeano == 50
		unaCatapulta.atacar(unAldeano.obtenerUbicacion());

		
		assertEquals(true,casillaAldeano.estaOcupada());
		assertEquals(false,unAldeano.estaDestruida());
	}
	
	@Test
	void ataqueCatapultaAEdificio() throws ErrorBasico {
		
		Casilla miniTablero[][] = new Casilla[7][7];
		
		for(int y = 0; y < 7; y++ ) {
			for(int x = 0; x < 7; x++ ) {
				Posicion unaPosicion = new Posicion(x,y);
				Casilla casilla = new Casilla(unaPosicion);
				
				miniTablero[x][y] = casilla;	
			}
		}
		
		
		List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
		for(int y = 0; y < Plaza.TAMANIO_LADO; y++) {
			for(int x = 0; x < Plaza.TAMANIO_LADO; x++) {
				casillasParaConstruccion.add(miniTablero[5+x][5+y]);
			}
		}
		Area zonaDeConstruccion = new Area(casillasParaConstruccion);
		Plaza unaPlaza = new Plaza(zonaDeConstruccion);

		Casilla casillaCatapulta = miniTablero[0][0];
		Catapulta unaCatapulta = new Catapulta(casillaCatapulta);
		
		//vida de la plaza == 375
		//Aunque la casilla que indico esta fuera del rango, el edificio que la ocupa no lo esta
		//ya que, por ej tambien ocupa la casilla (5,5) que si esta en rango
		unaCatapulta.atacar(miniTablero[6][6]);

		assertEquals(true,unaPlaza.necesitaReparacion());
		assertEquals(false,unaPlaza.estaDestruida());
		
		//vida de la plaza == 300
		unaCatapulta.atacar(miniTablero[5][5]);
		//vida de la plaza == 225
		unaCatapulta.atacar(miniTablero[6][5]);
		//vida de la plaza == 150
		unaCatapulta.atacar(miniTablero[5][6]);
		//vida de la plaza == 75
		unaCatapulta.atacar(miniTablero[6][6]);
		//vida de la plaza == 0
		unaCatapulta.atacar(miniTablero[5][5]);

		assertEquals(true,unaPlaza.estaDestruida());
		assertEquals(true,zonaDeConstruccion.estaLibre());
	}
	
	@Test
	void ataqueCatapultaAEdificioFueraDeRango() throws ErrorBasico {
		
		Casilla miniTablero[][] = new Casilla[10][10];
		
		for(int y = 0; y < 10; y++ ) {
			for(int x = 0; x < 10; x++ ) {
				Posicion unaPosicion = new Posicion(x,y);
				Casilla casilla = new Casilla(unaPosicion);
				
				miniTablero[x][y] = casilla;	
			}
		}
		
		
		List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
		for(int y = 0; y < Plaza.TAMANIO_LADO; y++) {
			for(int x = 0; x < Plaza.TAMANIO_LADO; x++) {
				casillasParaConstruccion.add(miniTablero[6+x][6+y]);
			}
		}
		Area zonaDeConstruccion = new Area(casillasParaConstruccion);
		Plaza unaPlaza = new Plaza(zonaDeConstruccion);

		Casilla casillaCatapulta = miniTablero[0][0];
		Catapulta unaCatapulta = new Catapulta(casillaCatapulta);
		
		//vida de la plaza == 450
		//TODO deberia tirar error (NO SE COMO CHEQUEAR EXCEPCIONES)
		//unaCatapulta.atacar(miniTablero[6][6]);

		assertEquals(false,unaPlaza.necesitaReparacion());
		assertEquals(false,unaPlaza.estaDestruida());

	}
	

}
