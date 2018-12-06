import javafx.scene.control.Tab;
import modelo.*;
import modelo.excepciones.PiezaFueraDeAlcanceError;
import modelo.excepciones.PiezaYaJugoEnTurnoActualError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ArqueroTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

    /*
     * Test de movimientos de arquero
     */

    @Test
    public void seCreaUnArquero() throws Exception {
    	Tablero unTablero = new Tablero();
    	
    	Area espacioArquero = unTablero.definirArea(0, 0, 0, 0);
        Arquero unArquero = new Arquero(0,0);

        Assert.assertNotNull(unArquero);
        Assert.assertFalse(espacioArquero.estaLibre());
        Assert.assertEquals(1,espacioArquero.obtenerCantidadDeCasillas());
    }

    @Test
    public void moverArqueroUnaPosicionHaciaArriba() throws Exception{
    	Tablero unTablero = new Tablero();

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(1,1);

        Assert.assertFalse(espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 2);
        unTablero.moverEnDireccion(unArquero,0,1);

        Assert.assertTrue(espacioArquero.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionHaciaAbajo() throws Exception {
    	Tablero unTablero = new Tablero();

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(1,1);

        Assert.assertFalse(espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 0);
        unTablero.moverEnDireccion(unArquero,0,-1);

        Assert.assertTrue(espacioArquero.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionHaciaDerecha() throws Exception {
    	Tablero unTablero = new Tablero();

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(1,1);

        Assert.assertFalse(espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 1);
        unTablero.moverEnDireccion(unArquero,1,0);

        Assert.assertTrue(espacioArquero.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionHaciaIzquierda() throws Exception {
    	Tablero unTablero = new Tablero();

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(1,1);

        Assert.assertFalse(espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 1);
        unTablero.moverEnDireccion(unArquero,-1,0);

        Assert.assertTrue(espacioArquero.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionArribaDerecha() throws Exception {
    	Tablero unTablero = new Tablero();

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(1,1);

        Assert.assertFalse(espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 2);
        unTablero.moverEnDireccion(unArquero,1,1);

        Assert.assertTrue(espacioArquero.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionArribaIzquierda() throws Exception {
    	Tablero unTablero = new Tablero();

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(1,1);

        Assert.assertFalse(espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 2);
        unTablero.moverEnDireccion(unArquero,-1,1);

        Assert.assertTrue(espacioArquero.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionAbajoIzquierda() throws Exception {
    	Tablero unTablero = new Tablero();

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(1,1);

        Assert.assertFalse(espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 0);
        unTablero.moverEnDireccion(unArquero,-1,-1);

        Assert.assertTrue(espacioArquero.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverArqueroUnaPosicionAbajoDerecha() throws Exception {
    	Tablero unTablero = new Tablero();

    	Area espacioArquero = unTablero.definirArea(1, 1, 1, 1);
        Arquero unArquero = new Arquero(1,1);

        Assert.assertFalse(espacioArquero.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 0);
        unTablero.moverEnDireccion(unArquero,1,-1);

        Assert.assertTrue(espacioArquero.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    /*
     * Test ataque arquero
     */
    
    @Test
    public void ataqueArqueroADistancia() throws Exception {

    	Tablero unTablero = new Tablero();

        Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(0,0);

        Area espacioArquero = unTablero.definirArea(0,3,0,3);
        Arquero unArquero = new Arquero(0,3);

        //vida del aldeano == 35
        unArquero.atacar(unAldeano);
        
        unArquero.nuevoTurno();
        //vida del aldeano == 20
        unArquero.atacar(unAldeano);

        Assert.assertFalse(unAldeano.estaDestruida());
        Assert.assertFalse(espacioAldeano.estaLibre());

        unArquero.nuevoTurno();
        //vida del aldeano == 5
        unArquero.atacar(unAldeano);
        
        unArquero.nuevoTurno();
        //vida del aldeano == 0
        unArquero.atacar(unAldeano);

        Assert.assertTrue(espacioAldeano.estaLibre());
        Assert.assertTrue(unAldeano.estaDestruida());
    }

    @Test
    public void atacarAUnaPieza() throws Exception{
        Tablero unTablero = new Tablero();
        Arquero unArquero = new Arquero(0,4);

        Aldeano unAldeano = new Aldeano(5,5);

        Assert.assertFalse(unAldeano.estaDestruida());
        unAldeano.recibirDanioDe(unArquero);
        Assert.assertFalse(unAldeano.estaDestruida());
        unAldeano.recibirDanioDe(unArquero);
        Assert.assertFalse(unAldeano.estaDestruida());
        unAldeano.recibirDanioDe(unArquero);
        Assert.assertFalse(unAldeano.estaDestruida());
        unAldeano.recibirDanioDe(unArquero);
        Assert.assertTrue(unAldeano.estaDestruida());
    }

    @Test
    public void piezaAAtacarFueraDeRango() throws Exception{
        Tablero unTablero = new Tablero();
        Arquero unArquero = new Arquero(0,0);
        Plaza unaPlaza = new Plaza(4,4);

        unaPlaza.construir();
        unaPlaza.construir();
        unaPlaza.construir();

        boolean lanzaUnError=false;
        try{
            unArquero.atacar(unaPlaza);
        } catch (PiezaFueraDeAlcanceError e){
            lanzaUnError=true;
        }

        Assert.assertTrue(lanzaUnError);
    }

    @Test
    public void arqueroYaJugoEnEseTurno() throws Exception{
        Tablero unTablero = new Tablero();
        Arquero unArquero = new Arquero(0,0);

        unArquero.mover(unTablero.definirArea(1,0,1,0));

        boolean lanzaUnError=false;
        try {
            unArquero.mover(unTablero.definirArea(1,1,1,1));
        } catch (PiezaYaJugoEnTurnoActualError e){
            lanzaUnError=true;
        }

        Assert.assertEquals(true, lanzaUnError);


    }

    @Test
    public void liberarUbicacionArquero() {
        Tablero unTablero = new Tablero();

        Area espacioArquero = unTablero.definirArea(0, 0, 0, 0);
        Pieza unaPieza = new Arquero(0,0);

        Assert.assertNotNull(unaPieza);
        Assert.assertFalse(espacioArquero.estaLibre());
        Assert.assertEquals(1,espacioArquero.obtenerCantidadDeCasillas());

        unaPieza.recibirDanio(75); //Arquero.VIDA_MAX = 75
        Assert.assertTrue(espacioArquero.estaLibre());
    }

    //ES PRIVADO EL METODO
/*    @Test
    public void distanciaMinimaAUnArea() {

        Tablero unTablero = new Tablero(6,6);

        Area unArea = unTablero.definirArea(0, 0, 1,1);
        Area espacioArquero = unTablero.definirArea(3, 0, 3, 0);
        Arquero unArquero = new Arquero(espacioArquero);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3 ,0).estaOcupada());

        Assert.assertEquals(2, unArquero.distanciaMinimaA(unArea));

    }*/

}
