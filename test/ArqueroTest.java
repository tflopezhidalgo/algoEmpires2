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
    public void moverArqueroUnaPosicionHaciaArriba() throws ErrorBasico{
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaArquero = unTablero.obtenerCasillaEn(1, 1);
        Arquero unArquero = new Arquero(casillaArquero);

        Assert.assertEquals(true, casillaArquero.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaArquero);
        unTablero.moverHasta(unArquero, casillaFinal);

        Assert.assertEquals(false, casillaArquero.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverArqueroUnaPosicionHaciaAbajo() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaArquero = unTablero.obtenerCasillaEn(1, 1);
        Arquero unArquero = new Arquero(casillaArquero);

        Assert.assertEquals(true, casillaArquero.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaArquero);
        unTablero.moverHasta(unArquero, casillaFinal);

        Assert.assertEquals(false, casillaArquero.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverArqueroUnaPosicionHaciaDerecha() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaArquero = unTablero.obtenerCasillaEn(1, 1);
        Arquero unArquero = new Arquero(casillaArquero);

        Assert.assertEquals(true, casillaArquero.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaArquero);
        unTablero.moverHasta(unArquero, casillaFinal);

        Assert.assertEquals(false, casillaArquero.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverArqueroUnaPosicionHaciaIzquierda() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaArquero = unTablero.obtenerCasillaEn(1, 1);
        Arquero unArquero = new Arquero(casillaArquero);

        Assert.assertEquals(true, casillaArquero.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaArquero);
        unTablero.moverHasta(unArquero, casillaFinal);

        Assert.assertEquals(false, casillaArquero.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverArqueroUnaPosicionArribaDerecha() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaArquero = unTablero.obtenerCasillaEn(1, 1);
        Arquero unArquero = new Arquero(casillaArquero);

        Assert.assertEquals(true, casillaArquero.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaArquero);
        unTablero.moverHasta(unArquero, casillaFinal);

        Assert.assertEquals(false, casillaArquero.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverArqueroUnaPosicionArribaIzquierda() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaArquero = unTablero.obtenerCasillaEn(1, 1);
        Arquero unArquero = new Arquero(casillaArquero);

        Assert.assertEquals(true, casillaArquero.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaArquero);
        unTablero.moverHasta(unArquero, casillaFinal);

        Assert.assertEquals(false, casillaArquero.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverArqueroUnaPosicionAbajoIzquierda() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaArquero = unTablero.obtenerCasillaEn(1, 1);
        Arquero unArquero = new Arquero(casillaArquero);

        Assert.assertEquals(true, casillaArquero.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaArquero);
        unTablero.moverHasta(unArquero, casillaFinal);

        Assert.assertEquals(false, casillaArquero.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverArqueroUnaPosicionAbajoDerecha() throws ErrorBasico {
    	Tablero unTablero = new Tablero(3,3);

        Casilla casillaArquero = unTablero.obtenerCasillaEn(1, 1);
        Arquero unArquero = new Arquero(casillaArquero);

        Assert.assertEquals(true, casillaArquero.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaArquero);
        unTablero.moverHasta(unArquero, casillaFinal);

        Assert.assertEquals(false, casillaArquero.estaOcupada());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
        Assert.assertEquals(unArquero.obtenerUbicacion(), casillaFinal);
    }

    /*
     * Test ataque arquero
     */
    
    @Test
    public void ataqueArqueroADistancia() throws ErrorBasico {

    	Tablero unTablero = new Tablero(4,4);

        Casilla casillaAldeano = unTablero.obtenerCasillaEn(0,0);
        Aldeano unAldeano = new Aldeano(casillaAldeano);

        Casilla casillaArquero = unTablero.obtenerCasillaEn(0,3);
        Arquero unArquero = new Arquero(casillaArquero);

        //vida del aldeano == 35
        unArquero.atacar(unAldeano);
        //vida del aldeano == 20
        unArquero.atacar(unAldeano);

        Assert.assertEquals(false, unAldeano.estaDestruida());
        Assert.assertEquals(true, casillaAldeano.estaOcupada());

        //vida del aldeano == 5
        unArquero.atacar(unAldeano);
        //vida del aldeano == 0
        unArquero.atacar(unAldeano);

        Assert.assertEquals(false,casillaAldeano.estaOcupada());
        Assert.assertEquals(true,unAldeano.estaDestruida());
    }

    @Test
    public void ataqueArqueroFueraDeRango() throws ErrorBasico {

    	Tablero unTablero = new Tablero(5,5);

        Casilla casillaAldeano = unTablero.obtenerCasillaEn(0,0);
        Aldeano unAldeano = new Aldeano(casillaAldeano);

        Casilla casillaArquero = unTablero.obtenerCasillaEn(0,4);
        Arquero unArquero = new Arquero(casillaArquero);

        //vida del aldeano == 50
        //tira error
        thrown.expect(ErrorBasico.class);
        unArquero.atacar(unAldeano);

        Assert.assertEquals(true,casillaAldeano.estaOcupada());
        Assert.assertEquals(false, unArquero.estaDestruida());
    }

}
