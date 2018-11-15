import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("deprecation")
public class EspadachinTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

    
    @Test
    public void moverEspadachinUnaPosicionHaciaArriba() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaEspadachin = unTablero.obtenerCasillaEn(1, 1);
        Espadachin unEspadachin = new Espadachin(casillaEspadachin);

        Assert.assertEquals(true, casillaEspadachin.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaEspadachin);
        unTablero.moverHasta(unEspadachin, casillaFinal);

        Assert.assertEquals(false, casillaEspadachin.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverEspadachinUnaPosicionHaciaAbajo() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaEspadachin = unTablero.obtenerCasillaEn(1, 1);
        Espadachin unEspadachin = new Espadachin(casillaEspadachin);

        Assert.assertEquals(true, casillaEspadachin.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaEspadachin);
        unTablero.moverHasta(unEspadachin, casillaFinal);

        Assert.assertEquals(false, casillaEspadachin.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverEspadachinUnaPosicionHaciaDerecha() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaEspadachin = unTablero.obtenerCasillaEn(1, 1);
        Espadachin unEspadachin = new Espadachin(casillaEspadachin);

        Assert.assertEquals(true, casillaEspadachin.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaEspadachin);
        unTablero.moverHasta(unEspadachin, casillaFinal);

        Assert.assertEquals(false, casillaEspadachin.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverEspadachinUnaPosicionHaciaIzquierda() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaEspadachin = unTablero.obtenerCasillaEn(1, 1);
        Espadachin unEspadachin = new Espadachin(casillaEspadachin);

        Assert.assertEquals(true, casillaEspadachin.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaEspadachin);
        unTablero.moverHasta(unEspadachin, casillaFinal);

        Assert.assertEquals(false, casillaEspadachin.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverEspadachinUnaPosicionArribaDerecha() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaEspadachin = unTablero.obtenerCasillaEn(1, 1);
        Espadachin unEspadachin = new Espadachin(casillaEspadachin);

        Assert.assertEquals(true, casillaEspadachin.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaEspadachin);
        unTablero.moverHasta(unEspadachin, casillaFinal);

        Assert.assertEquals(false, casillaEspadachin.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverEspadachinUnaPosicionArribaIzquierda() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaEspadachin = unTablero.obtenerCasillaEn(1, 1);
        Espadachin unEspadachin = new Espadachin(casillaEspadachin);

        Assert.assertEquals(true, casillaEspadachin.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaEspadachin);
        unTablero.moverHasta(unEspadachin, casillaFinal);

        Assert.assertEquals(false, casillaEspadachin.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverEspadachinUnaPosicionAbajoIzquierda() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaEspadachin = unTablero.obtenerCasillaEn(1, 1);
        Espadachin unEspadachin = new Espadachin(casillaEspadachin);

        Assert.assertEquals(true, casillaEspadachin.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaEspadachin);
        unTablero.moverHasta(unEspadachin, casillaFinal);

        Assert.assertEquals(false, casillaEspadachin.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverEspadachinUnaPosicionAbajoDerecha() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaEspadachin = unTablero.obtenerCasillaEn(1, 1);
        Espadachin unEspadachin = new Espadachin(casillaEspadachin);

        Assert.assertEquals(true, casillaEspadachin.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaEspadachin);
        unTablero.moverHasta(unEspadachin, casillaFinal);

        Assert.assertEquals(false, casillaEspadachin.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unEspadachin.obtenerUbicacion(), casillaFinal);
    }
    
    @Test
    public void ataqueEspadachin() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaAldeano = unTablero.obtenerCasillaEn(1,1);
        Aldeano unAldeano = new Aldeano(casillaAldeano);

        Casilla casillaEspadachin = unTablero.obtenerCasillaEn(2,1);
        Espadachin unEspadachin = new Espadachin(casillaEspadachin);

        //vida del aldeano == 25
        unEspadachin.atacar(unAldeano);
        //vida del aldeano == 0
        unEspadachin.atacar(unAldeano);

        Assert.assertEquals(false,casillaAldeano.estaOcupada());
        Assert.assertEquals(true,unAldeano.estaDestruida());
    }

    @Test
    public void ataqueEspadachinFueraDeRango() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaAldeano = unTablero.obtenerCasillaEn(0,0);
        Aldeano unAldeano = new Aldeano(casillaAldeano);

        Casilla casillaEspadachin = unTablero.obtenerCasillaEn(0,2);
        Espadachin unEspadachin = new Espadachin(casillaEspadachin);

        //vida del aldeano == 50
        //tira error
        thrown.expect(ErrorBasico.class);
        unEspadachin.atacar(unAldeano);

        Assert.assertEquals(true,casillaAldeano.estaOcupada());
        Assert.assertEquals(false,unAldeano.estaDestruida());

    }
}
