import junit.framework.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;


public class AldeanoTest {

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

        Assert.assertEquals(true, casillaAldano.estaOcupada());

        unAldeano.moverArriba();
        Assert.assertEquals(false, casillaAldano.estaOcupada());

        Casilla casillaArriba = miniTablero[2][3];
        Assert.assertEquals(true, casillaArriba.estaOcupada());
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaArriba() throws ErrorBasico {

    	Casilla nuevaCasilla = new Casilla(0, 0);

    	Casilla casillaDeArriba = new Casilla(0, 1);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);
        
        unAldeano.moverArriba();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaDeArriba);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaAbajo() throws ErrorBasico {

    	Casilla nuevaCasilla = new Casilla(0, 0);

    	Casilla casillaDeAbajo = new Casilla(0, -1);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);

        unAldeano.moverAbajo();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaDeAbajo);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaDerecha() throws ErrorBasico {

    	Casilla nuevaCasilla = new Casilla(0, 0);

    	Casilla casillaDeLaDerecha = new Casilla(1, 0);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);

        unAldeano.moverDerecha();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaDeLaDerecha);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaIzquierda() throws ErrorBasico {

    	Casilla nuevaCasilla = new Casilla(0,0);

    	Casilla casillaDeLaIzquierda = new Casilla(-1, 0);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);

        unAldeano.moverIzquierda();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaDeLaIzquierda);
    }

    @Test
    public void moverAldeanoUnaPosicionArribaDerecha() throws ErrorBasico {

    	Casilla nuevaCasilla = new Casilla(0 ,0);

    	Casilla casillaArribaDerecha = new Casilla(1, 1);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);

        unAldeano.moverArribaDerecha();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaArribaDerecha);
    }

    @Test
    public void moverAldeanoUnaPosicionArribaIzquierda() throws ErrorBasico {

    	Casilla nuevaCasilla = new Casilla(0, 0);

    	Casilla casillaArribaIzquierda = new Casilla(-1, 1);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);

        unAldeano.moverArribaIzquierda();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaArribaIzquierda);
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoIzquierda() throws ErrorBasico {

    	Casilla nuevaCasilla = new Casilla(0, 0);

    	Casilla casillaAbajoIzquierda = new Casilla(-1, -1);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);

        unAldeano.moverAbajoIzquierda();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaAbajoIzquierda);
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoDerecha() throws ErrorBasico {

    	Casilla nuevaCasilla = new Casilla(0 ,0);

    	Casilla casillaAbajoDerecha = new Casilla(1, -1);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);

        unAldeano.moverAbajoDerecha();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaAbajoDerecha);
    }

    /*
     *  Test de construccion de Aldeano
     */
    /*
    @Test
    public void ConstruccionPlaza() throws ErrorBasico {
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
                    Assert.assertEquals(true, unAldeano.estaOcupado());
                    Assert.assertEquals(false, laNuevaPlaza.necesitaReparacion());
                    Assert.assertEquals(true, laNuevaPlaza.enConstruccion());
                    //tira error
                    assertThrows(ErrorBasico.class,
                            ()->{
                            	unAldeano.realizarTrabajoDeTurno();
                            });
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
                    Assert.assertEquals(true, unAldeano.estaOcupado());
                    Assert.assertEquals(false, elNuevoCuartel.necesitaReparacion());
                    Assert.assertEquals(true, elNuevoCuartel.enConstruccion());
                    //tira error
                    assertThrows(ErrorBasico.class,
                            ()->{
                            	unAldeano.realizarTrabajoDeTurno();
                            });
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

    */
}

