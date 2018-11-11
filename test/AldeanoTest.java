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

        Aldeano unAldeano = new Aldeano(new Posicion());
        Assert.assertNotNull(unAldeano);
    }

    //Lo mismo para cualquier tipo de unidad
    @Test
    public void UnidadColocada() {

        Posicion nuevaPosicion = new Posicion(1,1);
        Casilla casilla = new Casilla(nuevaPosicion);

        Aldeano unAldeano = new Aldeano(casilla);

        assertEquals(true, casilla.estaOcupada());
        assertEquals(unAldeano.obtenerUbicacion(), casilla);

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

    @Test
    public void moverAldeanoUnaPosicionHaciaArriba(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(0, 1);

        unAldeano.moverArriba();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaAbajo(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(0, -1);

        unAldeano.moverAbajo();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaDerecha(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(1, 0);

        unAldeano.moverDerecha();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaIzquierda(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(-1, 0);

        unAldeano.moverIzquierda();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
    }

    @Test
    public void moverAldeanoUnaPosicionArribaDerecha(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(1, 1);

        unAldeano.moverArribaDerecha();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
    }

    @Test
    public void moverAldeanoUnaPosicionArribaIzquierda(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(-1, 1);

        unAldeano.moverArribaIzquierda();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoIzquierda(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(-1, -1);

        unAldeano.moverAbajoIzquierda();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoDerecha(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(1, -1);

        unAldeano.moverAbajoDerecha();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
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

