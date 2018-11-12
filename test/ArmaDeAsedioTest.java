import com.sun.org.apache.xpath.internal.operations.NotEquals;
import junit.framework.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

public class ArmaDeAsedioTest {

    /*
     * Test de movimiento de Arma de Asedio
     */
    @Test
    public void seCreaArmaDeAsedio() throws ErrorBasico {

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(new Casilla(0, 0));

        Assert.assertNotNull(unArmaDeAsedio);
    }

    @Test
    public void ColocarArmaDeAsedio() throws ErrorBasico {

        Casilla casilla = new Casilla(1,1);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(casilla);

        Assert.assertEquals(true, casilla.estaOcupada());
        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casilla);
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaArriba() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0, 0);

        Casilla casillaDeArriba = new Casilla(0, 1);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(nuevaCasilla); //Se inicia en modo mover (se mueve)

        unArmaDeAsedio.moverArriba();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaDeArriba);

        unArmaDeAsedio.accionar();
        unArmaDeAsedio.moverArriba();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaDeArriba);
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaAbajo() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0, 0);

        Casilla casillaDeAbajo = new Casilla(0, -1);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(nuevaCasilla);

        unArmaDeAsedio.moverAbajo();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaDeAbajo);

        unArmaDeAsedio.accionar();
        unArmaDeAsedio.moverAbajo();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaDeAbajo);

    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaDerecha() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0, 0);

        Casilla casillaDeLaDerecha = new Casilla(1, 0);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(nuevaCasilla);

        unArmaDeAsedio.moverDerecha();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaDeLaDerecha);

        unArmaDeAsedio.accionar();
        unArmaDeAsedio.moverDerecha();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaDeLaDerecha);
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaIzquierda() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0,0);

        Casilla casillaDeLaIzquierda = new Casilla(-1, 0);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(nuevaCasilla);

        unArmaDeAsedio.moverIzquierda();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaDeLaIzquierda);

        unArmaDeAsedio.accionar();
        unArmaDeAsedio.moverIzquierda();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaDeLaIzquierda);
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionArribaDerecha() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0 ,0);

        Casilla casillaArribaDerecha = new Casilla(1, 1);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(nuevaCasilla); //Se inicia en modo ataque (no se mueve)

        unArmaDeAsedio.moverArribaDerecha();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaArribaDerecha);

        unArmaDeAsedio.accionar();
        unArmaDeAsedio.moverArribaDerecha();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaArribaDerecha);
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionArribaIzquierda() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0, 0);

        Casilla casillaArribaIzquierda = new Casilla(-1, 1);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(nuevaCasilla);

        unArmaDeAsedio.moverArribaIzquierda();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaArribaIzquierda);

        unArmaDeAsedio.accionar();
        unArmaDeAsedio.moverArribaIzquierda();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaArribaIzquierda);
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionAbajoIzquierda() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0, 0);

        Casilla casillaAbajoIzquierda = new Casilla(-1, -1);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(nuevaCasilla);

        unArmaDeAsedio.moverAbajoIzquierda();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaAbajoIzquierda);

        unArmaDeAsedio.accionar();
        unArmaDeAsedio.moverAbajoIzquierda();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaAbajoIzquierda);
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionAbajoDerecha() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0 ,0);

        Casilla casillaAbajoDerecha = new Casilla(1, -1);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(nuevaCasilla); //Se inicia en modo ataque (no se mueve)

        unArmaDeAsedio.moverAbajoDerecha();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaAbajoDerecha);;

        unArmaDeAsedio.accionar();
        unArmaDeAsedio.moverAbajoDerecha();

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaAbajoDerecha);
    }


    /*
     * Test de ataques de Arma de Asedio
     */
   @Test
    public void armaDeAsedioNoAtacaSiNoFueAccionada() throws ErrorBasico {

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

        Casilla casillaArmaDeAsedio = miniTablero[0][0];
        ArmaDeAsedio unaArmaDeAsedio = new ArmaDeAsedio(casillaArmaDeAsedio);

        //vida de la plaza == 450
        //tira error
        assertThrows(ErrorBasico.class,
                ()->{
                	unaArmaDeAsedio.atacar(miniTablero[6][6]);
                });
        Assert.assertEquals(false, unaPlaza.necesitaReparacion());
        
        unaArmaDeAsedio.accionar();
        
        //vida del aldeano == 50
        //no deberia tirar error
        unaArmaDeAsedio.atacar(miniTablero[6][6]);
        Assert.assertEquals(true, unaPlaza.necesitaReparacion());
    }
   
   @Test
    public void armaDeAsedioNoSeMueveSiFueAccionada() throws ErrorBasico {

        Casilla miniTablero[][] = new Casilla[3][3];

        for(int y = 0; y < 3; y++ ) {
            for(int x = 0; x < 3; x++ ) {
                Posicion unaPosicion = new Posicion(x,y);
                Casilla casilla = new Casilla(unaPosicion);

                miniTablero[x][y] = casilla;
            }
        }

        Casilla casillaCatapulta = miniTablero[0][0];
        ArmaDeAsedio unaArmaDeAsedio = new ArmaDeAsedio(casillaCatapulta);

        //no deberia tirar error
        unaArmaDeAsedio.moverArriba();
        
        unaArmaDeAsedio.accionar();
        
        //tira error
        assertThrows(ErrorBasico.class,
                ()->{
                	unaArmaDeAsedio.moverArriba();
                });
        
        unaArmaDeAsedio.accionar();
        
        //no deberia tirar error
        unaArmaDeAsedio.moverArriba();
    }

    @Test
    public void ataqueArmaDeAsedioAUnidadNoHaceDanio() throws ErrorBasico {

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
        ArmaDeAsedio unaArmaDeAsedio = new ArmaDeAsedio(casillaCatapulta);
        
        unaArmaDeAsedio.accionar();

        //vida del aldeano == 50
        unaArmaDeAsedio.atacar(casillaAldeano);
        //o tambien usando
        //vida del aldeano == 50
        unaArmaDeAsedio.atacar(unAldeano.obtenerUbicacion());


        Assert.assertEquals(true,casillaAldeano.estaOcupada());
        Assert.assertEquals(false,unAldeano.estaDestruida());
    }

    @Test
    public void ataqueArmaDeAsedioAEdificio() throws ErrorBasico {

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
        ArmaDeAsedio unaArmaDeAsedio = new ArmaDeAsedio(casillaCatapulta);

        unaArmaDeAsedio.accionar();
        
        //vida de la plaza == 375
        //Aunque la casilla que indico esta fuera del rango, el edificio que la ocupa no lo esta
        //ya que, por ej tambien ocupa la casilla (5,5) que si esta en rango
        unaArmaDeAsedio.atacar(miniTablero[6][6]);

        Assert.assertEquals(true,unaPlaza.necesitaReparacion());
        Assert.assertEquals(false,unaPlaza.estaDestruida());

        //vida de la plaza == 300
        unaArmaDeAsedio.atacar(miniTablero[5][5]);
        //vida de la plaza == 225
        unaArmaDeAsedio.atacar(miniTablero[6][5]);
        //vida de la plaza == 150
        unaArmaDeAsedio.atacar(miniTablero[5][6]);
        //vida de la plaza == 75
        unaArmaDeAsedio.atacar(miniTablero[6][6]);
        //vida de la plaza == 0
        unaArmaDeAsedio.atacar(miniTablero[5][5]);

        Assert.assertEquals(true,unaPlaza.estaDestruida());
        Assert.assertEquals(true,zonaDeConstruccion.estaLibre());
    }

    @Test
    public void ataqueArmaDeAsedioAEdificioFueraDeRango() throws ErrorBasico {

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
        ArmaDeAsedio unaArmaDeAsedio = new ArmaDeAsedio(casillaCatapulta);

        //vida de la plaza == 450
        //tira error
        assertThrows(ErrorBasico.class,
                ()->{
                	unaArmaDeAsedio.atacar(miniTablero[6][6]);
                });

        Assert.assertEquals(false,unaPlaza.necesitaReparacion());
        Assert.assertEquals(false,unaPlaza.estaDestruida());

    }

}
