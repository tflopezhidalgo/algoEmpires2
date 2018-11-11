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
    public void seCreaUnAldeano(){

    	Posicion nuevaPosicion = new Posicion();
    	Casilla nuevaCasilla = new Casilla(nuevaPosicion);
        Aldeano unAldeano = new Aldeano(nuevaCasilla);
        Assert.assertNotNull(unAldeano);
    }

    //Lo mismo para cualquier tipo de unidad
    @Test
    public void UnidadColocada() {

        Posicion nuevaPosicion = new Posicion(1,1);
        Casilla casilla = new Casilla(nuevaPosicion);

        Aldeano unAldeano = new Aldeano(casilla);

        Assert.assertEquals(true, casilla.estaOcupada());
        Assert.assertEquals(unAldeano.obtenerUbicacion(), casilla);

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

        Assert.assertEquals(true, casillaAldano.estaOcupada());

        unAldeano.moverArriba();
        Assert.assertEquals(false, casillaAldano.estaOcupada());

        Casilla casillaArriba = miniTablero[2][3];
        Assert.assertEquals(true, casillaArriba.estaOcupada());
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaArriba(){

    	Posicion posicionCero = new Posicion(0,0);
    	Casilla nuevaCasilla = new Casilla(posicionCero);
    	
    	Posicion posicionArriba = new Posicion(0,1);
    	Casilla casillaDeArriba = new Casilla(posicionArriba);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);
        
        unAldeano.moverArriba();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaDeArriba);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaAbajo(){

    	Posicion posicionCero = new Posicion(0,0);
    	Casilla nuevaCasilla = new Casilla(posicionCero);
    	
    	Posicion posicionAbajo = new Posicion(0,-1);
    	Casilla casillaDeAbajo = new Casilla(posicionAbajo);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);

        unAldeano.moverAbajo();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaDeAbajo);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaDerecha(){

    	Posicion posicionCero = new Posicion(0,0);
    	Casilla nuevaCasilla = new Casilla(posicionCero);
    	
    	Posicion posicionDerecha = new Posicion(1,0);
    	Casilla casillaDeLaDerecha = new Casilla(posicionDerecha);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);

        unAldeano.moverDerecha();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaDeLaDerecha);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaIzquierda(){

    	Posicion posicionCero = new Posicion(0,0);
    	Casilla nuevaCasilla = new Casilla(posicionCero);
    	
    	Posicion posicionIzquierda = new Posicion(-1,0);
    	Casilla casillaDeLaIzquierda = new Casilla(posicionIzquierda);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);

        unAldeano.moverIzquierda();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaDeLaIzquierda);
    }

    @Test
    public void moverAldeanoUnaPosicionArribaDerecha(){

    	Posicion posicionCero = new Posicion(0,0);
    	Casilla nuevaCasilla = new Casilla(posicionCero);
    	
    	Posicion posicionArribaDerecha = new Posicion(1,1);
    	Casilla casillaArribaDerecha = new Casilla(posicionArribaDerecha);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);

        unAldeano.moverArribaDerecha();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaArribaDerecha);
    }

    @Test
    public void moverAldeanoUnaPosicionArribaIzquierda(){

    	Posicion posicionCero = new Posicion(0,0);
    	Casilla nuevaCasilla = new Casilla(posicionCero);
    	
    	Posicion posicionArribaIzquierda = new Posicion(-1,1);
    	Casilla casillaArribaIzquierda = new Casilla(posicionArribaIzquierda);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);

        unAldeano.moverArribaIzquierda();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaArribaIzquierda);
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoIzquierda(){

    	Posicion posicionCero = new Posicion(0,0);
    	Casilla nuevaCasilla = new Casilla(posicionCero);
    	
    	Posicion posicionAbajoIzquierda = new Posicion(-1,-1);
    	Casilla casillaAbajoIzquierda = new Casilla(posicionAbajoIzquierda);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);

        unAldeano.moverAbajoIzquierda();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaAbajoIzquierda);
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoDerecha(){

    	Posicion posicionCero = new Posicion(0,0);
    	Casilla nuevaCasilla = new Casilla(posicionCero);
    	
    	Posicion posicionAbajoDerecha = new Posicion(1,-1);
    	Casilla casillaAbajoDerecha = new Casilla(posicionAbajoDerecha);
    	
        Aldeano unAldeano = new Aldeano(nuevaCasilla);

        unAldeano.moverAbajoDerecha();

        Assert.assertEquals(unAldeano.obtenerUbicacion(), casillaAbajoDerecha);
    }

    /*
     *  Test de construcción de Aldeano
     */

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
                    Assert.assertEquals(true, unAldeano.estaOcupado());
                    Assert.assertEquals(false, laNuevaPlaza.necesitaReparacion());
                    Assert.assertEquals(true, laNuevaPlaza.enConstruccion());
                    //TODO hay que comprobar que el de abajo tira error,
                    // como carajo se haceasserThrows?????
                    // assertEquals(0, unAldeano.realizarTrabajoDeTurno());
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
                    Assert.assertEquals(true, unAldeano.estaOcupado());
                    Assert.assertEquals(false, elNuevoCuartel.necesitaReparacion());
                    Assert.assertEquals(true, elNuevoCuartel.enConstruccion());
                    //TODO hay que comprobar que el de abajo tira error,
                    // como carajo se haceasserThrows?????
                    // assertEquals(0, unAldeano.realizarTrabajoDeTurno());
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

