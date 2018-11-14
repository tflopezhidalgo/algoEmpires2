import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class AldeanoTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
    /*
     *  Test de movimiento de Aldeano
     */
    @Test
    public void seCreaUnAldeano() throws ErrorBasico {

    	Casilla nuevaCasilla = new Casilla(new Posicion());

        Aldeano unAldeano = new Aldeano(nuevaCasilla);

        Assert.assertNotNull(unAldeano);
    }

    @Test
    public void ColocarAldeano() throws ErrorBasico {

        Posicion nuevaPosicion = new Posicion(1,1);

        Casilla casilla = new Casilla(nuevaPosicion);

        Aldeano unAldeano = new Aldeano(casilla);

        Assert.assertEquals(true, casilla.estaOcupada());
        Assert.assertEquals(unAldeano.obtenerUbicacion(), casilla);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaArriba() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaAldano = unTablero.obtenerCasillaEn(1, 1);
        Aldeano unAldeano = new Aldeano(casillaAldano);

        Assert.assertEquals(true, casillaAldano.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaAldano);
        unTablero.moverHasta(unAldeano, casillaFinal);

        Assert.assertEquals(false, casillaAldano.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaAbajo() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaAldano = unTablero.obtenerCasillaEn(1, 1);
        Aldeano unAldeano = new Aldeano(casillaAldano);

        Assert.assertEquals(true, casillaAldano.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaAbajoDe(casillaAldano);
        unTablero.moverHasta(unAldeano, casillaFinal);

        Assert.assertEquals(false, casillaAldano.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaDerecha() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaAldano = unTablero.obtenerCasillaEn(1, 1);
        Aldeano unAldeano = new Aldeano(casillaAldano);

        Assert.assertEquals(true, casillaAldano.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaDerechaDe(casillaAldano);
        unTablero.moverHasta(unAldeano, casillaFinal);

        Assert.assertEquals(false, casillaAldano.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaIzquierda() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaAldano = unTablero.obtenerCasillaEn(1, 1);
        Aldeano unAldeano = new Aldeano(casillaAldano);

        Assert.assertEquals(true, casillaAldano.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaIzquierdaDe(casillaAldano);
        unTablero.moverHasta(unAldeano, casillaFinal);

        Assert.assertEquals(false, casillaAldano.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverAldeanoUnaPosicionArribaDerecha() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaAldano = unTablero.obtenerCasillaEn(1, 1);
        Aldeano unAldeano = new Aldeano(casillaAldano);

        Assert.assertEquals(true, casillaAldano.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDerechaDe(casillaAldano);
        unTablero.moverHasta(unAldeano, casillaFinal);

        Assert.assertEquals(false, casillaAldano.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverAldeanoUnaPosicionArribaIzquierda() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaAldano = unTablero.obtenerCasillaEn(1, 1);
        Aldeano unAldeano = new Aldeano(casillaAldano);

        Assert.assertEquals(true, casillaAldano.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaIzquierdaDe(casillaAldano);
        unTablero.moverHasta(unAldeano, casillaFinal);

        Assert.assertEquals(false, casillaAldano.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoIzquierda() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaAldano = unTablero.obtenerCasillaEn(1, 1);
        Aldeano unAldeano = new Aldeano(casillaAldano);

        Assert.assertEquals(true, casillaAldano.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaAbajoIzquierdaDe(casillaAldano);
        unTablero.moverHasta(unAldeano, casillaFinal);

        Assert.assertEquals(false, casillaAldano.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoDerecha() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaAldano = unTablero.obtenerCasillaEn(1, 1);
        Aldeano unAldeano = new Aldeano(casillaAldano);

        Assert.assertEquals(true, casillaAldano.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaAbajoDerechaDe(casillaAldano);
        unTablero.moverHasta(unAldeano, casillaFinal);

        Assert.assertEquals(false, casillaAldano.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaFinal);
    }

    /*
     *  Test de construccion de Aldeano
     */
    
    @Test
    public void ConstruccionPlaza() throws ErrorBasico {
        int turno = 0;
        int oroJugador = 0;

        Tablero unTablero = new Tablero(5, 5);

        Casilla casillaAldeano = unTablero.obtenerCasillaEn(0, 0);
        Aldeano unAldeano = new Aldeano(casillaAldeano);

        //---Definiendo area de construccion
        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
        for(int y = 0; y < Plaza.TAMANIO_LADO; y++) {
            for(int x = 0; x < Plaza.TAMANIO_LADO; x++) {
                casillasParaConstruccion.add(unTablero.obtenerCasillaEn(1+x, 1+y));
            }
        }
        Area zonaDeConstruccion = new Area(casillasParaConstruccion);
        //-----------------------------------
        Plaza laNuevaPlaza = unAldeano.crearPlaza(zonaDeConstruccion);
        while(turno < 6) {
            turno ++;

            switch (turno) {

                case 1:
                    Assert.assertEquals(true, unAldeano.estaOcupado());
                    Assert.assertEquals(false, laNuevaPlaza.necesitaReparacion());
                    Assert.assertEquals(true, laNuevaPlaza.enConstruccion());
                    //tira error
                	thrown.expect(ErrorBasico.class);
                	unAldeano.realizarTrabajoDeTurno();
                    break;
                    
                case 2:
                    Assert.assertEquals(true, unAldeano.estaOcupado());
                    Assert.assertEquals(false, laNuevaPlaza.necesitaReparacion());
                    Assert.assertEquals(true, laNuevaPlaza.enConstruccion());
                    oroJugador += unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(0, oroJugador);
                    break;
                case 3:
                    Assert.assertEquals(true, unAldeano.estaOcupado());
                    Assert.assertEquals(false, laNuevaPlaza.necesitaReparacion());
                    Assert.assertEquals(true, laNuevaPlaza.enConstruccion());
                    oroJugador += unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(0, oroJugador);
                    break;

                case 4:
                    Assert.assertEquals(true, unAldeano.estaOcupado());
                    Assert.assertEquals(false, laNuevaPlaza.necesitaReparacion());
                    Assert.assertEquals(false, laNuevaPlaza.enConstruccion());
                    oroJugador += unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(25, oroJugador);
                    break;

                case 5:
                    Assert.assertEquals(false, unAldeano.estaOcupado());
                    oroJugador += unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(50, oroJugador);
                    break;

                case 6:
                    Assert.assertEquals(false, unAldeano.estaOcupado());
                    oroJugador += unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(75, oroJugador);
                    break;
            }
            unAldeano.nuevoTurno();
        }
    }

    @Test
    public void ConstruccionCuartel() throws ErrorBasico {
        int turno = 0;
        int oroJugador = 0;

        Tablero unTablero = new Tablero(5,5);

        Casilla casillaAldeano = unTablero.obtenerCasillaEn(0,0);
        Aldeano unAldeano = new Aldeano(casillaAldeano);

        //---Definiendo area de construccion
        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
        for(int y = 0; y < Cuartel.TAMANIO_LADO; y++) {
            for(int x = 0; x < Cuartel.TAMANIO_LADO; x++) {
                casillasParaConstruccion.add(unTablero.obtenerCasillaEn(1+x, 1+y));
            }
        }
        Area zonaDeConstruccion = new Area(casillasParaConstruccion);
        //-----------------------------------
        Cuartel elNuevoCuartel = unAldeano.crearCuartel(zonaDeConstruccion);
        while(turno < 6) {
            turno ++;

            switch (turno) {

                case 1:
                    Assert.assertEquals(true, unAldeano.estaOcupado());
                    Assert.assertEquals(false, elNuevoCuartel.necesitaReparacion());
                    Assert.assertEquals(true, elNuevoCuartel.enConstruccion());
                    //tira error
                	thrown.expect(ErrorBasico.class);
                    unAldeano.realizarTrabajoDeTurno();
                    break;
                    
                case 2:
                    Assert.assertEquals(true, unAldeano.estaOcupado());
                    Assert.assertEquals(false, elNuevoCuartel.necesitaReparacion());
                    Assert.assertEquals(true, elNuevoCuartel.enConstruccion());
                    oroJugador += unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(0, oroJugador);
                    break;
                    
                case 3:
                    Assert.assertEquals(true, unAldeano.estaOcupado());
                    Assert.assertEquals(false, elNuevoCuartel.necesitaReparacion());
                    Assert.assertEquals(true, elNuevoCuartel.enConstruccion());
                    oroJugador += unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(0, oroJugador);
                    break;

                case 4:
                    Assert.assertEquals(true, unAldeano.estaOcupado());
                    Assert.assertEquals(false, elNuevoCuartel.necesitaReparacion());
                    Assert.assertEquals(false, elNuevoCuartel.enConstruccion());
                    oroJugador += unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(25, oroJugador);
                    break;

                case 5:
                    Assert.assertEquals(false, unAldeano.estaOcupado());
                    oroJugador += unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(50, oroJugador);
                    break;

                case 6:
                    Assert.assertEquals(false, unAldeano.estaOcupado());
                    oroJugador += unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(75, oroJugador);
                    break;
            }
            unAldeano.nuevoTurno();
        }
    }

    @Test
    public void RepararPlazaCentral() throws ErrorBasico{
        int turno=0;

        Tablero unTablero = new Tablero(5,5);

        Casilla unaCasilla = unTablero.obtenerCasillaEn(0,0);
        Aldeano unAldeano = new Aldeano(unaCasilla);

        List<Casilla> unasCasillas = new ArrayList<Casilla>();

        for(int y = 0; y < Plaza.TAMANIO_LADO; y++) {
            for(int x = 0; x < Plaza.TAMANIO_LADO; x++) {
                unasCasillas.add(unTablero.obtenerCasillaEn(1+x, 1+y));
            }
        }

        Plaza unaPlaza = new Plaza(new Area(unasCasillas), true);

        unaPlaza.recibirDanio(50);

        while (turno<2) {
            turno++;

            switch (turno) {
                case 1: {
                    unAldeano.reparar(unaPlaza);
                    Assert.assertEquals(true, unaPlaza.necesitaReparacion());
                }
                break;
                case 2: {
                    unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(false, unaPlaza.necesitaReparacion());
                }
                break;
            }
            unAldeano.nuevoTurno();
        }
    }

    @Test
    public void RepararCastillo() throws ErrorBasico{
        int turno=0;

        Tablero unTablero = new Tablero(5,5);

        Casilla unaCasilla = unTablero.obtenerCasillaEn(0,0);
        Aldeano unAldeano = new Aldeano(unaCasilla);

        List<Casilla> unasCasillas = new ArrayList<Casilla>();

        for(int y = 0; y < Castillo.TAMANIO_LADO; y++) {
            for(int x = 0; x < Castillo.TAMANIO_LADO; x++) {
                unasCasillas.add(unTablero.obtenerCasillaEn(1+x, 1+y));
            }
        }

       Castillo unCastillo = new Castillo(new Area(unasCasillas));

        unCastillo.recibirDanio(30);

        while (turno<2) {
            turno++;

            switch (turno) {
                case 1: {
                    unAldeano.reparar(unCastillo);
                    Assert.assertEquals(true, unCastillo.necesitaReparacion());
                }
                break;
                case 2: {
                    unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(false, unCastillo.necesitaReparacion());
                }
                break;
            }
            unAldeano.nuevoTurno();
        }
    }

    @Test
    public void RepararCuartel() throws ErrorBasico{
        int turno=0;

        Tablero unTablero = new Tablero(5,5);

        Casilla unaCasilla = unTablero.obtenerCasillaEn(0,0);
        Aldeano unAldeano = new Aldeano(unaCasilla);

        List<Casilla> unasCasillas = new ArrayList<Casilla>();

        for(int y = 0; y < Cuartel.TAMANIO_LADO; y++) {
            for(int x = 0; x < Cuartel.TAMANIO_LADO; x++) {
                unasCasillas.add(unTablero.obtenerCasillaEn(1+x, 1+y));
            }
        }

        Cuartel unCuartel = new Cuartel(new Area(unasCasillas));

        unCuartel.recibirDanio(100);

        while (turno<2) {
            turno++;

            switch (turno) {
                case 1: {
                    unAldeano.reparar(unCuartel);
                    Assert.assertEquals(true, unCuartel.necesitaReparacion());
                }
                break;
                case 2: {
                    unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(false, unCuartel.necesitaReparacion());
                }
                break;
            }
            unAldeano.nuevoTurno();
        }
    }

    @Test
    public void AldeanoVuelveASumarOroLuegoDeFinalizarUnaReparacion() throws ErrorBasico{
        int turno=0;
        int oro=0;

        Tablero unTablero = new Tablero(5,5);

        Casilla unaCasilla = unTablero.obtenerCasillaEn(0,0);
        Aldeano unAldeano = new Aldeano(unaCasilla);

        List<Casilla> unasCasillas = new ArrayList<Casilla>();

        for(int y = 0; y < Cuartel.TAMANIO_LADO; y++) {
            for(int x = 0; x < Cuartel.TAMANIO_LADO; x++) {
                unasCasillas.add(unTablero.obtenerCasillaEn(1+x, 1+y));
            }
        }

        Cuartel unCuartel = new Cuartel(new Area(unasCasillas), true);

        unCuartel.recibirDanio(100);

        while (turno<3) {
            turno++;

            switch (turno) {
                case 1: {
                    unAldeano.reparar(unCuartel);
                    Assert.assertEquals(0, oro);
                }
                break;
                case 2: {
                    oro+=unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(0, oro);
                }
                break;
                case 3: {
                    oro+=unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(25, oro);
                }
                break;
            }
            unAldeano.nuevoTurno();
        }

    }

}

