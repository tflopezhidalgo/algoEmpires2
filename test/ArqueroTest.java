import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("deprecation")
public class ArqueroTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

    /*
     * Test de movimientos de arquero
     */

    @Test
    public void seCreaUnArquero() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);
    	
    	Area espacioArquero = unTablero.definirArea(0, 0, 0, 0);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertNotNull(unArquero);
        Assert.assertEquals(false,espacioArquero.estaLibre());
        Assert.assertEquals(1,espacioArquero.obtenerTamanio());
    }

    @Test
    public void moverArqueroUnaPosicionHaciaArriba() throws Excepcion{
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 2);
        unTablero.moverArriba(unArquero);

        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionHaciaAbajo() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 0);
        unTablero.moverAbajo(unArquero);

        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionHaciaDerecha() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 1);
        unTablero.moverDerecha(unArquero);

        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionHaciaIzquierda() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 1);
        unTablero.moverIzquierda(unArquero);

        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionArribaDerecha() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 2);
        unTablero.moverArribaDerecha(unArquero);

        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionArribaIzquierda() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 2);
        unTablero.moverArribaIzquierda(unArquero);

        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionAbajoIzquierda() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 0);
        unTablero.moverAbajoIzquierda(unArquero);

        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionAbajoDerecha() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 0);
        unTablero.moverAbajoDerecha(unArquero);

        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    /*
     * Test ataque arquero
     */
    
    @Test
    public void ataqueArqueroADistancia() throws Excepcion {

    	Tablero unTablero = new Tablero(4,4);

        Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area espacioArquero = unTablero.definirArea(0,3,0,3);
        Arquero unArquero = new Arquero(espacioArquero);

        //vida del aldeano == 35
        unArquero.atacar(unAldeano);
        //vida del aldeano == 20
        unArquero.atacar(unAldeano);

        Assert.assertEquals(false, unAldeano.estaDestruida());
        Assert.assertEquals(false, espacioAldeano.estaLibre());

        //vida del aldeano == 5
        unArquero.atacar(unAldeano);
        //vida del aldeano == 0
        unArquero.atacar(unAldeano);

        Assert.assertEquals(true,espacioAldeano.estaLibre());
        Assert.assertEquals(true,unAldeano.estaDestruida());
    }

    @Test
    public void ataqueArqueroFueraDeRango() throws Excepcion {

    	Tablero unTablero = new Tablero(5,5);

    	Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area espacioArquero = unTablero.definirArea(0,4,0,4);
        Arquero unArquero = new Arquero(espacioArquero);

        //vida del aldeano == 50
        unArquero.atacar(unAldeano);
        unArquero.atacar(unAldeano);
        unArquero.atacar(unAldeano);
        unArquero.atacar(unAldeano);

        Assert.assertEquals(false,espacioAldeano.estaLibre());
        Assert.assertEquals(false, unAldeano.estaDestruida());
    }

}
