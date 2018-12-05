import javafx.scene.control.Tab;
import modelo.*;
import modelo.excepciones.PiezaFueraDeAlcanceError;
import modelo.excepciones.PiezaYaJugoEnTurnoActualError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;

import static junit.framework.Assert.*;

@SuppressWarnings("deprecation")
public class EspadachinTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
    @Test
    public void seCreaEspadachin() throws Exception {
    	Tablero unTablero = new Tablero();
    	
    	Area espacioEspadachin = unTablero.definirArea(0, 0, 0, 0);
    	Espadachin unEspadachin = new Espadachin(0,0);
        
        Assert.assertNotNull(unEspadachin);
        Assert.assertFalse(espacioEspadachin.estaLibre());
        assertEquals(1,espacioEspadachin.obtenerCantidadDeCasillas());
    }
    
    @Test
    public void moverEspadachinUnaPosicionHaciaArriba() throws Exception {
    	Tablero unTablero = new Tablero();
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(1,1);

        assertFalse(espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 2);
        unTablero.moverEnDireccion(unEspadachin,0,1);

        assertTrue(espacioEspadachin.estaLibre());
        assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionHaciaAbajo() throws Exception {
    	Tablero unTablero = new Tablero();
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(1,1);

        assertFalse(espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 0);
        unTablero.moverEnDireccion(unEspadachin,0,-1);

        assertTrue(espacioEspadachin.estaLibre());
        assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionHaciaDerecha() throws Exception {
    	Tablero unTablero = new Tablero();
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(1,1);

        assertFalse(espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 1);
        unTablero.moverEnDireccion(unEspadachin,1,0);

        assertTrue(espacioEspadachin.estaLibre());
        assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionHaciaIzquierda() throws Exception {
    	Tablero unTablero = new Tablero();
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(1,1);

        assertFalse(espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 1);
        unTablero.moverEnDireccion(unEspadachin,-1,0);

        assertTrue(espacioEspadachin.estaLibre());
        assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionArribaDerecha() throws Exception {
    	Tablero unTablero = new Tablero();
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(1,1);

        assertFalse(espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 2);
        unTablero.moverEnDireccion(unEspadachin,1,1);

        assertTrue(espacioEspadachin.estaLibre());
        assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionArribaIzquierda() throws Exception {
    	Tablero unTablero = new Tablero();
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(1,1);

        assertFalse(espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 2);
        unTablero.moverEnDireccion(unEspadachin,-1,1);

        assertTrue(espacioEspadachin.estaLibre());
        assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionAbajoIzquierda() throws Exception {
    	Tablero unTablero = new Tablero();
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(1,1);

        assertFalse(espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 0);
        unTablero.moverEnDireccion(unEspadachin,-1,-1);

        assertTrue(espacioEspadachin.estaLibre());
        assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverEspadachinUnaPosicionAbajoDerecha() throws Exception {
    	Tablero unTablero = new Tablero();
    	
        Area espacioEspadachin = unTablero.definirArea(1, 1, 1, 1);
        Espadachin unEspadachin = new Espadachin(1,1);

        assertFalse(espacioEspadachin.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 0);
        unTablero.moverEnDireccion(unEspadachin,1,-1);

        assertTrue(espacioEspadachin.estaLibre());
        assertTrue(casillaFinal.estaOcupada());
    }
    
    @Test
    public void ataqueEspadachin() throws Exception {
    	Tablero unTablero = new Tablero();

        Area espacioAldeano = unTablero.definirArea(1, 1, 1, 1);
        Aldeano unAldeano = new Aldeano(1,1);

        Area espacioEspadachin = unTablero.definirArea(2, 1, 2, 1);
        Espadachin unEspadachin = new Espadachin(2,1);

        //vida del aldeano == 25
        unEspadachin.atacar(unAldeano);
        
        unEspadachin.nuevoTurno();

        //vida del aldeano == 0
        unEspadachin.atacar(unAldeano);

        assertEquals(true, unAldeano.estaDestruida());
        assertEquals(true, espacioAldeano.estaLibre());
    }

    @Test
    public void ataqueAUnaPiezaFueraDeRangoError() throws Exception{
        Tablero unTablero = new Tablero();
        Espadachin unEspadachin = new Espadachin(0,0);
        Plaza unaPlaza = new Plaza(2,2);
        unaPlaza.construir();
        unaPlaza.construir();
        unaPlaza.construir();

        boolean lanzaUnError=false;
        try{
            unEspadachin.atacar(unaPlaza);
        }catch (PiezaFueraDeAlcanceError e){
            lanzaUnError=true;
        }

        assertEquals(true, lanzaUnError);
    }

    @Test
    public void espadachinYaJugoEnEseTurno() throws Exception{
        Tablero unTablero = new Tablero();
        Espadachin unEspadachin = new Espadachin(0,0);
        Espadachin espadachinAAtacar = new Espadachin(0,1);

        unEspadachin.mover(unTablero.definirArea(1,0,1,0));

        boolean lanzaUnError=false;
        try {
            unEspadachin.atacar(espadachinAAtacar);
        } catch (PiezaYaJugoEnTurnoActualError e){
            lanzaUnError=true;
        }

        assertEquals(true, lanzaUnError);
    }

    @Test
    public void liberarUbicacionEspadachin() {
        Tablero unTablero = new Tablero();

        Area espacioEspadachin = unTablero.definirArea(0, 0, 0, 0);
        Pieza unaPieza = new Espadachin(0,0);

        Assert.assertNotNull(unaPieza);
        Assert.assertFalse(espacioEspadachin.estaLibre());
        assertEquals(1,espacioEspadachin.obtenerCantidadDeCasillas());

        unaPieza.recibirDanio(100); //Espadachin.VIDA_MAX = 100
        Assert.assertTrue(espacioEspadachin.estaLibre());
    }

    //ES PRIVADO EL METODO
/*    @Test
    public void distanciaMinimaAUnArea() {

        Tablero unTablero = new Tablero(6,6);

        Area unArea = unTablero.definirArea(0, 0, 1,1);
        Area espacioEspadachin = unTablero.definirArea(3, 0, 3, 0);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3 ,0).estaOcupada());

        Assert.assertEquals(2, unEspadachin.distanciaMinimaA(unArea));

    }*/

}
