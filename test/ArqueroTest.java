import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;
import modelo.Aldeano;
import modelo.Area;
import modelo.Arquero;
import modelo.Casilla;
import modelo.Tablero;

@SuppressWarnings("deprecation")
public class ArqueroTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

    /*
     * Test de movimientos de arquero
     */

    @Test
    public void seCreaUnArquero() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
    	
    	Area espacioArquero = unTablero.definirArea(0, 0, 0, 0);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertNotNull(unArquero);
        Assert.assertEquals(false,espacioArquero.estaLibre());
        Assert.assertEquals(1,espacioArquero.obtenerCantidadDeCasillas());
    }

    @Test
    public void moverArqueroUnaPosicionHaciaArriba() throws Exception{
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 2);
        unTablero.moverEnDireccion(unArquero,0,1);

        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionHaciaAbajo() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 0);
        unTablero.moverEnDireccion(unArquero,0,-1);

        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionHaciaDerecha() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 1);
        unTablero.moverEnDireccion(unArquero,1,0);

        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionHaciaIzquierda() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 1);
        unTablero.moverEnDireccion(unArquero,-1,0);

        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionArribaDerecha() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 2);
        unTablero.moverEnDireccion(unArquero,1,1);

        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionArribaIzquierda() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 2);
        unTablero.moverEnDireccion(unArquero,-1,1);

        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionAbajoIzquierda() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 0);
        unTablero.moverEnDireccion(unArquero,-1,-1);

        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionAbajoDerecha() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertEquals(false, espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 0);
        unTablero.moverEnDireccion(unArquero,1,-1);
        
        Assert.assertEquals(true, espacioArquero.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    /*
     * Test ataque arquero
     */
    
    @Test
    public void ataqueArqueroADistancia() throws Exception {

    	Tablero unTablero = new Tablero(4,4);

        Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area espacioArquero = unTablero.definirArea(0,3,0,3);
        Arquero unArquero = new Arquero(espacioArquero);

        //vida del aldeano == 35
        unArquero.atacar(unAldeano);
        
        unArquero.nuevoTurno();
        //vida del aldeano == 20
        unArquero.atacar(unAldeano);

        Assert.assertEquals(false, unAldeano.estaDestruida());
        Assert.assertEquals(false, espacioAldeano.estaLibre());

        unArquero.nuevoTurno();
        //vida del aldeano == 5
        unArquero.atacar(unAldeano);
        
        unArquero.nuevoTurno();
        //vida del aldeano == 0
        unArquero.atacar(unAldeano);

        Assert.assertEquals(true,espacioAldeano.estaLibre());
        Assert.assertEquals(true,unAldeano.estaDestruida());
    }

    @Test
    public void ataqueArqueroFueraDeRango() throws Exception {

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

    @Test
    public void atacarAUnaPieza() throws Exception{
        Tablero unTablero = new Tablero(10,10);
        Area espacioArquero = unTablero.definirArea(0,4,0,4);
        Arquero unArquero = new Arquero(espacioArquero);

        Aldeano unAldeano = new Aldeano(unTablero.definirArea(5,5,5,5));

        Assert.assertEquals(false, unAldeano.estaDestruida());
        unAldeano.recibirDanioDe(unArquero);
        Assert.assertEquals(false, unAldeano.estaDestruida());
        unAldeano.recibirDanioDe(unArquero);
        Assert.assertEquals(false, unAldeano.estaDestruida());
        unAldeano.recibirDanioDe(unArquero);
        Assert.assertEquals(false, unAldeano.estaDestruida());
        unAldeano.recibirDanioDe(unArquero);
        Assert.assertEquals(true, unAldeano.estaDestruida());
    }

}
