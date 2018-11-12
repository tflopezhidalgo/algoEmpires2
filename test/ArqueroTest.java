import junit.framework.Assert;
import org.junit.Test;

public class ArqueroTest {

    /*
     * Test de movimientos de arquero
     */

    @Test
    public void seCreaUnArquero() throws ErrorBasico {

        Arquero unArquero = new Arquero();

        Assert.assertNotNull(unArquero);
    }

    @Test
    public void moverArqueroUnaPosicionHaciaArriba() throws ErrorBasico{

        Casilla nuevaCasilla = new Casilla(0, 0);

        Casilla casillaDeArriba = new Casilla(0, 1);

        Arquero unArquero = new Arquero(nuevaCasilla);

        unArquero.moverArriba();

        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaDeArriba);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaAbajo() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0, 0);

        Casilla casillaDeAbajo = new Casilla(0, -1);

        Arquero unArquero = new Arquero(nuevaCasilla);

        unArquero.moverAbajo();

        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaDeAbajo);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaDerecha() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0, 0);

        Casilla casillaDeLaDerecha = new Casilla(1, 0);

        Arquero unArquero = new Arquero(nuevaCasilla);

        unArquero.moverDerecha();

        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaDeLaDerecha);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaIzquierda() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0,0);

        Casilla casillaDeLaIzquierda = new Casilla(-1, 0);

        Arquero unArquero = new Arquero(nuevaCasilla);

        unArquero.moverIzquierda();

        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaDeLaIzquierda);
    }

    @Test
    public void moverAldeanoUnaPosicionArribaDerecha() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0 ,0);

        Casilla casillaArribaDerecha = new Casilla(1, 1);

         Arquero unArquero = new Arquero(nuevaCasilla);

        unArquero.moverArribaDerecha();

        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaArribaDerecha);
    }

    @Test
    public void moverAldeanoUnaPosicionArribaIzquierda() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0, 0);

        Casilla casillaArribaIzquierda = new Casilla(-1, 1);

        Arquero unArquero = new Arquero(nuevaCasilla);

        unArquero.moverArribaIzquierda();

        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaArribaIzquierda);
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoIzquierda() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0, 0);

        Casilla casillaAbajoIzquierda = new Casilla(-1, -1);

        Arquero unArquero = new Arquero(nuevaCasilla);

        unArquero.moverAbajoIzquierda();

        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaAbajoIzquierda);
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoDerecha() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0 ,0);

        Casilla casillaAbajoDerecha = new Casilla(1, -1);

        Arquero unArquero = new Arquero(nuevaCasilla);

        unArquero.moverAbajoDerecha();

        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaAbajoDerecha);
    }

    /*
     * Test ataque arquero
     */

    @Test
    public void ataqueArqueroADistancia() throws ErrorBasico {

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

        Assert.assertEquals(false, unAldeano.estaDestruida());
        Assert.assertEquals(true, casillaAldeano.estaOcupada());

        //vida del aldeano == 5
        unArquero.atacar(casillaAldeano);
        //vida del aldeano == 0
        unArquero.atacar(casillaAldeano);

        Assert.assertEquals(false,casillaAldeano.estaOcupada());
        Assert.assertEquals(true,unAldeano.estaDestruida());
    }

    @Test
    public void ataqueArqueroFueraDeRango() throws ErrorBasico {

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


        Assert.assertEquals(true,casillaAldeano.estaOcupada());
        Assert.assertEquals(false, unArquero.estaDestruida());
    }


}
