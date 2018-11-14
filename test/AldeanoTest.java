import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Plaza.TAMANIO_LADO, Plaza.TAMANIO_LADO);
        
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

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Cuartel.TAMANIO_LADO, Cuartel.TAMANIO_LADO);
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

}

