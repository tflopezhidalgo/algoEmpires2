import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestConstruccionAldeano {

	@Test
	void ConstruccionPlaza() throws ErrorBasico {
		int turno = 0;
		int oroJugador = 0;
		
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
		
		//---Definiendo area de construccion
		List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
		for(int y = 0; y < Plaza.TAMANIO_LADO; y++) {
			for(int x = 0; x < Plaza.TAMANIO_LADO; x++) {
				casillasParaConstruccion.add(miniTablero[1+x][1+y]);
			}
		}
		Area zonaDeConstruccion = new Area(casillasParaConstruccion);
		//-----------------------------------
		Plaza laNuevaPlaza = unAldeano.crearPlaza(zonaDeConstruccion);
		while(turno < 6) {
			turno ++;
			
			switch (turno) {
			
            case 1: 
					assertEquals(true, unAldeano.estaOcupado());
					assertEquals(false, laNuevaPlaza.necesitaReparacion());
					assertEquals(true, laNuevaPlaza.enConstruccion());
					//TODO hay que comprobar que el de abajo tira error, 
					// como carajo se haceasserThrows?????
					// assertEquals(0, unAldeano.realizarTrabajoDeTurno());
            		break;
            case 2: 
    				assertEquals(true, unAldeano.estaOcupado());
					assertEquals(false, laNuevaPlaza.necesitaReparacion());
					assertEquals(true, laNuevaPlaza.enConstruccion());
					oroJugador += unAldeano.realizarTrabajoDeTurno();
            		assertEquals(0, oroJugador);
        			break;
            case 3: 
        			assertEquals(true, unAldeano.estaOcupado());
					assertEquals(false, laNuevaPlaza.necesitaReparacion());
					assertEquals(true, laNuevaPlaza.enConstruccion());
					oroJugador += unAldeano.realizarTrabajoDeTurno();
					assertEquals(0, oroJugador);
        			break;
            		
            case 4: 
					assertEquals(true, unAldeano.estaOcupado());
					assertEquals(false, laNuevaPlaza.necesitaReparacion());
					assertEquals(false, laNuevaPlaza.enConstruccion());
					oroJugador += unAldeano.realizarTrabajoDeTurno();
					assertEquals(25, oroJugador);
            		break;
            		
            case 5: 
            		assertEquals(false, unAldeano.estaOcupado());
            		oroJugador += unAldeano.realizarTrabajoDeTurno();
            		assertEquals(50, oroJugador);
            		break;
           	
            case 6: 
        		assertEquals(false, unAldeano.estaOcupado());
        		oroJugador += unAldeano.realizarTrabajoDeTurno();
        		assertEquals(75, oroJugador);
        		break;
			}
			
			
			unAldeano.nuevoTurno();
		}
	}
	
	@Test
	void ConstruccionCuartel() throws ErrorBasico {
		int turno = 0;
		int oroJugador = 0;
		
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
		
		//---Definiendo area de construccion
		List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
		for(int y = 0; y < Cuartel.TAMANIO_LADO; y++) {
			for(int x = 0; x < Cuartel.TAMANIO_LADO; x++) {
				casillasParaConstruccion.add(miniTablero[1+x][1+y]);
			}
		}
		Area zonaDeConstruccion = new Area(casillasParaConstruccion);
		//-----------------------------------
		Cuartel elNuevoCuartel = unAldeano.crearCuartel(zonaDeConstruccion);
		while(turno < 6) {
			turno ++;
			
			switch (turno) {
			
            case 1: 
					assertEquals(true, unAldeano.estaOcupado());
					assertEquals(false, elNuevoCuartel.necesitaReparacion());
					assertEquals(true, elNuevoCuartel.enConstruccion());
					//TODO hay que comprobar que el de abajo tira error, 
					// como carajo se haceasserThrows?????
					// assertEquals(0, unAldeano.realizarTrabajoDeTurno());
            		break;
            case 2: 
    				assertEquals(true, unAldeano.estaOcupado());
					assertEquals(false, elNuevoCuartel.necesitaReparacion());
					assertEquals(true, elNuevoCuartel.enConstruccion());
					oroJugador += unAldeano.realizarTrabajoDeTurno();
            		assertEquals(0, oroJugador);
        			break;
            case 3: 
        			assertEquals(true, unAldeano.estaOcupado());
					assertEquals(false, elNuevoCuartel.necesitaReparacion());
					assertEquals(true, elNuevoCuartel.enConstruccion());
					oroJugador += unAldeano.realizarTrabajoDeTurno();
					assertEquals(0, oroJugador);
        			break;
            		
            case 4: 
					assertEquals(true, unAldeano.estaOcupado());
					assertEquals(false, elNuevoCuartel.necesitaReparacion());
					assertEquals(false, elNuevoCuartel.enConstruccion());
					oroJugador += unAldeano.realizarTrabajoDeTurno();
					assertEquals(25, oroJugador);
            		break;
            		
            case 5: 
            		assertEquals(false, unAldeano.estaOcupado());
            		oroJugador += unAldeano.realizarTrabajoDeTurno();
            		assertEquals(50, oroJugador);
            		break;
           	
            case 6: 
        		assertEquals(false, unAldeano.estaOcupado());
        		oroJugador += unAldeano.realizarTrabajoDeTurno();
        		assertEquals(75, oroJugador);
        		break;
			}
			
			
			unAldeano.nuevoTurno();
		}
	}

}
