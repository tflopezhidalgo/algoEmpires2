import junit.framework.Assert;


import org.junit.Test;

public class EspadachinTest {

    @Test
    public void seCreaEspadachinEnPosicionCentral() throws ErrorBasico {
        
        Espadachin unEspadachin = new Espadachin(new Casilla(0, 0));
        
        Assert.assertNotNull(unEspadachin);
    }
    
    @Test
    public void moverEspadachinUnaPosicionHaciaArriba() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0, 0);

        Casilla casillaDeArriba = new Casilla(0, 1);

        Espadachin unEspadachin = new Espadachin(nuevaCasilla);

        unEspadachin.moverArriba();

        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaDeArriba);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaAbajo() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0, 0);

        Casilla casillaDeAbajo = new Casilla(0, -1);

        Espadachin unEspadachin = new Espadachin(nuevaCasilla);

        unEspadachin.moverAbajo();

        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaDeAbajo);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaDerecha() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0, 0);

        Casilla casillaDeLaDerecha = new Casilla(1, 0);

        Espadachin unEspadachin = new Espadachin(nuevaCasilla);

        unEspadachin.moverDerecha();

        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaDeLaDerecha);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaIzquierda() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0,0);

        Casilla casillaDeLaIzquierda = new Casilla(-1, 0);

        Espadachin unEspadachin = new Espadachin(nuevaCasilla);

        unEspadachin.moverIzquierda();

        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaDeLaIzquierda);
    }

    @Test
    public void moverAldeanoUnaPosicionArribaDerecha() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0 ,0);

        Casilla casillaArribaDerecha = new Casilla(1, 1);

        Espadachin unEspadachin = new Espadachin(nuevaCasilla);

        unEspadachin.moverArribaDerecha();

        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaArribaDerecha);
    }

    @Test
    public void moverAldeanoUnaPosicionArribaIzquierda() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0, 0);

        Casilla casillaArribaIzquierda = new Casilla(-1, 1);

        Espadachin unEspadachin = new Espadachin(nuevaCasilla);

        unEspadachin.moverArribaIzquierda();

        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaArribaIzquierda);
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoIzquierda() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0, 0);

        Casilla casillaAbajoIzquierda = new Casilla(-1, -1);

        Espadachin unEspadachin = new Espadachin(nuevaCasilla);

        unEspadachin.moverAbajoIzquierda();

        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaAbajoIzquierda);
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoDerecha() throws ErrorBasico {

        Casilla nuevaCasilla = new Casilla(0 ,0);

        Casilla casillaAbajoDerecha = new Casilla(1, -1);

        Espadachin unEspadachin = new Espadachin(nuevaCasilla);

        unEspadachin.moverAbajoDerecha();

        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaAbajoDerecha);
    }
    
    
    
    @Test
    public void ataqueEspadachin() throws ErrorBasico {

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

        Assert.assertEquals(false,casillaAldeano.estaOcupada());
        Assert.assertEquals(true,unAldeano.estaDestruida());
    }
/*
    @Test
    public void ataqueEspadachinFueraDeRango() throws ErrorBasico {

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
        //tira error
        assertThrows(ErrorBasico.class,
                ()->{
                    unEspadachin.atacar(casillaAldeano);
                });
        
        //o tambien usando
        //vida del aldeano == 50
        //tira error
        assertThrows(ErrorBasico.class,
                ()->{
                	unEspadachin.atacar(unAldeano.obtenerUbicacion());
                });

        Assert.assertEquals(true,casillaAldeano.estaOcupada());
        Assert.assertEquals(false,unAldeano.estaDestruida());

    }

    */

}
