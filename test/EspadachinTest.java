import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;
import modelo.Aldeano;
import modelo.Area;
import modelo.Casilla;
import modelo.Espadachin;
import modelo.Tablero;

@SuppressWarnings("deprecation")
public class EspadachinTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
    @Test
    public void seCreaEspadachin() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
    	
    	Area espacioEspadachin = unTablero.definirArea(0, 0, 0, 0);
    	Espadachin unEspadachin = new Espadachin(espacioEspadachin);
        
        Assert.assertNotNull(unEspadachin);
        Assert.assertEquals(false,espacioEspadachin.estaLibre());
        Assert.assertEquals(1,espacioEspadachin.obtenerCantidadDeCasillas());
    }
    
    @Test
    public void moverEspadachinUnaPosicionHaciaArriba() throws Exception {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 2);
        unTablero.moverEnDireccion(unEspadachin,0,1);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionHaciaAbajo() throws Exception {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 0);
        unTablero.moverEnDireccion(unEspadachin,0,-1);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionHaciaDerecha() throws Exception {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 1);
        unTablero.moverEnDireccion(unEspadachin,1,0);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionHaciaIzquierda() throws Exception {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 1);
        unTablero.moverEnDireccion(unEspadachin,-1,0);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionArribaDerecha() throws Exception {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 2);
        unTablero.moverEnDireccion(unEspadachin,1,1);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionArribaIzquierda() throws Exception {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 2);
        unTablero.moverEnDireccion(unEspadachin,-1,1);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionAbajoIzquierda() throws Exception {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 0);
        unTablero.moverEnDireccion(unEspadachin,-1,-1);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionAbajoDerecha() throws Exception {
    	Tablero unTablero = new Tablero(3,3);    	
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertEquals(false, espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 0);
        unTablero.moverEnDireccion(unEspadachin,1,-1);

        Assert.assertEquals(true, espacioEspadachin.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }
    
    @Test
    public void ataqueEspadachin() throws Exception {
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
    public void ataqueEspadachinFueraDeRango() throws Exception {
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
