import junit.framework.Assert;

import modelo.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("deprecation")
public class EspadachinTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
    @Test
    public void seCreaEspadachin() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);
    	
    	Area espacioEspadachin = unTablero.definirArea(0, 0, 0, 0);
    	Espadachin unEspadachin = new Espadachin(espacioEspadachin);
        
        Assert.assertNotNull(unEspadachin);
        Assert.assertEquals(false,espacioEspadachin.estaLibre());
        Assert.assertEquals(1,espacioEspadachin.obtenerTamanio());
    }
    
    @Test
    public void moverEspadachinUnaPosicionHaciaArriba() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 2);
        unTablero.moverArriba(unEspadachin);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionHaciaAbajo() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 0);
        unTablero.moverAbajo(unEspadachin);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionHaciaDerecha() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 1);
        unTablero.moverDerecha(unEspadachin);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionHaciaIzquierda() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 1);
        unTablero.moverIzquierda(unEspadachin);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionArribaDerecha() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 2);
        unTablero.moverArribaDerecha(unEspadachin);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionArribaIzquierda() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 2);
        unTablero.moverArribaIzquierda(unEspadachin);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionAbajoIzquierda() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 0);
        unTablero.moverAbajoIzquierda(unEspadachin);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionAbajoDerecha() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 0);
        unTablero.moverAbajoDerecha(unEspadachin);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }
    
    @Test
    public void ataqueEspadachin() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);

        Area espacioAldeano = unTablero.definirArea(1, 1, 1, 1);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area espacioEspadachin = unTablero.definirArea(2, 1, 2, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        //vida del aldeano == 25
        unEspadachin.atacar(unAldeano);
        
        unEspadachin.nuevoTurno();
        //vida del aldeano == 0
        unEspadachin.atacar(unAldeano);

        Assert.assertEquals(true, unAldeano.estaDestruida());
        Assert.assertEquals(true, espacioAldeano.estaLibre());
    }

    @Test
    public void ataqueEspadachinFueraDeRango() throws Excepcion {
    	Tablero unTablero = new Tablero(3,3);

        Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area espacioEspadachin = unTablero.definirArea(0,2,0,2);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        //vida del aldeano == 50
        unEspadachin.atacar(unAldeano);
        unEspadachin.atacar(unAldeano);
        unEspadachin.atacar(unAldeano);

        Assert.assertEquals(false,espacioAldeano.estaLibre());
        Assert.assertEquals(false,unAldeano.estaDestruida());
    }
}
