import modelo.*;
import modelo.excepciones.PiezaFueraDeAlcanceError;
import modelo.excepciones.PiezaYaJugoEnTurnoActualError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;
import modelo.excepciones.CatapultaArmadaNoPuedeMoverseError;
import modelo.excepciones.CatapultaDesarmadaNoPuedeAtacarError;

@SuppressWarnings("deprecation")
public class ArmaDeAsedioTest {


	@Rule
	public ExpectedException thrown = ExpectedException.none();
    /*
     * Test de movimiento de Arma de Asedio
     */
    @Test
    public void seCreaArmaDeAsedio() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(0,0);

        Area espacioArmaDeAsedio = unTablero.definirArea(0, 0, 0, 0);

        Assert.assertNotNull(unArmaDeAsedio);
        Assert.assertFalse(espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(1,espacioArmaDeAsedio.obtenerCantidadDeCasillas());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaArriba() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(1,1); //Se inicia en modo mover (se mueve)

        Assert.assertFalse(espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 2);
        unTablero.moverEnDireccion(unArmaDeAsedio,0,1);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());

        unArmaDeAsedio.nuevoTurno();
        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverArriba(unArmaDeAsedio);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaAbajo() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(1,1); //Se inicia en modo mover (se mueve)

        Assert.assertFalse(espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 0);
        unTablero.moverEnDireccion(unArmaDeAsedio,0,-1);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());

        unArmaDeAsedio.nuevoTurno();
        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverAbajo(unArmaDeAsedio);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaDerecha() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(1,1); //Se inicia en modo mover (se mueve)

        Assert.assertFalse(espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 1);
        unTablero.moverEnDireccion(unArmaDeAsedio,1,0);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());

        unArmaDeAsedio.nuevoTurno();
        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverDerecha(unArmaDeAsedio);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaIzquierda() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(1,1); //Se inicia en modo mover (se mueve)

        Assert.assertFalse(espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 1);
        unTablero.moverEnDireccion(unArmaDeAsedio,-1,0);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());

        unArmaDeAsedio.nuevoTurno();
        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverIzquierda(unArmaDeAsedio);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionArribaDerecha() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(1,1); //Se inicia en modo mover (se mueve)

        Assert.assertFalse(espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 2);
        unTablero.moverEnDireccion(unArmaDeAsedio,1,1);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());

        unArmaDeAsedio.nuevoTurno();
        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverArribaDerecha(unArmaDeAsedio);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionArribaIzquierda() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(1,1); //Se inicia en modo mover (se mueve)

        Assert.assertFalse(espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 2);
        unTablero.moverEnDireccion(unArmaDeAsedio,-1,1);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());

        unArmaDeAsedio.nuevoTurno();
        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverArribaIzquierda(unArmaDeAsedio);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionAbajoIzquierda() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(1,1); //Se inicia en modo mover (se mueve)

        Assert.assertFalse(espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 0);
        unTablero.moverEnDireccion(unArmaDeAsedio,-1,-1);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());

        unArmaDeAsedio.nuevoTurno();
        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverAbajoIzquierda(unArmaDeAsedio);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionAbajoDerecha() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(1,1); //Se inicia en modo mover (se mueve)

        Assert.assertFalse(espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 0);
        unTablero.moverEnDireccion(unArmaDeAsedio,1,-1);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());

        unArmaDeAsedio.nuevoTurno();
        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverAbajoDerecha(unArmaDeAsedio);

        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
        Assert.assertTrue(casillaFinal.estaOcupada());
    }

    /*
     * Test de ataques de Arma de Asedio
     */
   @Test
    public void armaDeAsedioNoAtacaSiNoFueAccionada() throws Exception {
       Tablero unTablero = new Tablero();

       ArmaDeAsedio unArma = new ArmaDeAsedio(2,0);
       Plaza unaPlaza = new Plaza(0,0);

       boolean seLanzaError=false;
       try{
           unArma.atacar(unaPlaza);
       } catch (CatapultaDesarmadaNoPuedeAtacarError e){
           seLanzaError=true;
       }

       Assert.assertTrue(seLanzaError);
   }
   
   @Test
    public void armaDeAsedioNoSeMueveSiFueAccionada() throws Exception {
        Tablero unTablero = new Tablero();
        ArmaDeAsedio unArma = new ArmaDeAsedio(0,0);

        unArma.accionar();
        unArma.nuevoTurno();
        boolean seLanzaError=false;
        try{
            unArma.mover(unTablero.definirArea(1,0,1,0));
        } catch (CatapultaArmadaNoPuedeMoverseError e){
            seLanzaError=true;
        }

       Assert.assertTrue(seLanzaError);


    }
    
    @Test
    public void ataqueArmaDeAsedioAEdificio() throws Exception {
    	Tablero unTablero = new Tablero(7, 7);

        Area zonaDeConstruccion = unTablero.definirArea(5, 5, Plaza.TAMANIO_LADO+4, Plaza.TAMANIO_LADO+4);
        Plaza unaPlaza = new Plaza(5,5);

    	Area espacioArmaDeAsedio = unTablero.definirArea(0,0,0,0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(0,0);

        unArmaDeAsedio.accionar();
        
        //vida de la plaza == 375
        //Aunque la plaza no esta 100% en rango, una de sus casillas lo esta
        //ya que, por ej tambien ocupa la casilla (5,5) que si esta en rango
        unArmaDeAsedio.nuevoTurno();
        unArmaDeAsedio.atacar(unaPlaza);

        Assert.assertTrue(unaPlaza.necesitaReparacion());
        Assert.assertFalse(unaPlaza.estaDestruida());

        //vida de la plaza == 300
        unArmaDeAsedio.nuevoTurno();
        unArmaDeAsedio.atacar(unaPlaza);
        //vida de la plaza == 225
        unArmaDeAsedio.nuevoTurno();
        unArmaDeAsedio.atacar(unaPlaza);
        //vida de la plaza == 150
        unArmaDeAsedio.nuevoTurno();
        unArmaDeAsedio.atacar(unaPlaza);
        //vida de la plaza == 75
        unArmaDeAsedio.nuevoTurno();
        unArmaDeAsedio.atacar(unaPlaza);
        //vida de la plaza == 0
        unArmaDeAsedio.nuevoTurno();
        unArmaDeAsedio.atacar(unaPlaza);

        Assert.assertTrue(unaPlaza.estaDestruida());
        Assert.assertTrue(zonaDeConstruccion.estaLibre());
    }

    @Test
    public void catapultaArmadaNoPuedeMoverse() throws Exception{
       Tablero unTablero = new Tablero();
       Area espacioArmaDeAsedio = unTablero.definirArea(0,0,0,0);
       ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(0,0);
       Area areaNueva = unTablero.definirArea(1, 0, 1,0);

       unArmaDeAsedio.accionar();

       boolean seLanzoError=false;
       try {
           unArmaDeAsedio.mover(areaNueva);
       } catch (CatapultaArmadaNoPuedeMoverseError e){
           seLanzoError=true;
       };

        Assert.assertTrue(seLanzoError);
    }

    @Test
    public void catapultaDesarmadaNoPuedeAtacar() throws Exception{
       Tablero unTablero = new Tablero();
       ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(0,0);
       Plaza unaPlaza = new Plaza(1,0);

       boolean seLanzoError=false;
       try {
           unArmaDeAsedio.atacar(unaPlaza);
        } catch (CatapultaDesarmadaNoPuedeAtacarError e){
           seLanzoError=true;
       };

        Assert.assertTrue(seLanzoError);
    }

    @Test
    public void fueraDeAlcanceParaPoderAtacar() throws Exception{
       Tablero unTablero = new Tablero();
       ArmaDeAsedio unArma = new ArmaDeAsedio(0,0);
       Plaza unaPlaza = new Plaza(6,6);

       unArma.accionar();
       unArma.nuevoTurno();

       boolean seLanzoError=false;
       try {
           unArma.atacar(unaPlaza);
       } catch (PiezaFueraDeAlcanceError e){
           seLanzoError=true;
       }

        Assert.assertTrue(seLanzoError);
    }

    @Test
    public void armaDeAsedioYaJugoEnEseTurno() throws Exception{

       Tablero unTablero = new Tablero();
       ArmaDeAsedio unArma = new ArmaDeAsedio(0,0);
       Plaza unaPlaza = new Plaza(1,1);

       unArma.accionar();
       unArma.nuevoTurno();
       unArma.atacar(unaPlaza);

       boolean lanzaUnError=false;
       try{
           unArma.atacar(unaPlaza);
       } catch (PiezaYaJugoEnTurnoActualError e){
           lanzaUnError=true;
       }

        Assert.assertTrue(lanzaUnError);


    }

    @Test
    public void liberarUbicacionArmaDeAsedio() {
        Tablero unTablero = new Tablero(6,6);

        Area espacioArmaDeAsedio = unTablero.definirArea(0, 0, 0, 0);
        Pieza unaPieza = new ArmaDeAsedio(0,0);

        Assert.assertNotNull(unaPieza);
        Assert.assertFalse(espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(1,espacioArmaDeAsedio.obtenerCantidadDeCasillas());

        unaPieza.recibirDanio(150); //ArmaDeAsedio.VIDA_MAX = 150
        Assert.assertTrue(espacioArmaDeAsedio.estaLibre());
    }

    @Test
    public void catapultaNoAtacaAUnidad() throws Exception{
       Tablero unTablero = new Tablero();
       ArmaDeAsedio unArma = new ArmaDeAsedio(0,0);
       Aldeano unAldeano = new Aldeano(1,0);

       double vidaAldeano = unAldeano.porcentajeVidaActual();

       unArma.accionar();
       unArma.nuevoTurno();
       unArma.atacar(unAldeano);

       Assert.assertEquals(vidaAldeano, unAldeano.porcentajeVidaActual());
    }

    @Test
    public void catapultaPuedeAtacarAEdificioLuegoDeTratarDeAtacarAUnidad() throws Exception{
        Tablero unTablero = new Tablero();
        ArmaDeAsedio unArma = new ArmaDeAsedio(0,0);
        Aldeano unAldeano = new Aldeano(1,0);
        Plaza unaPlaza = new Plaza(1,1);

        unaPlaza.construir();
        unaPlaza.construir();
        unaPlaza.construir();

        unArma.accionar();
        unArma.nuevoTurno();
        unArma.atacar(unAldeano);

        boolean puedeAtacar=false;
        try{
            unArma.atacar(unaPlaza);
        } catch (Exception e){
            puedeAtacar=true;
        }

        Assert.assertTrue(puedeAtacar);
    }

    //ES PRIVADO EL METODO
   /* @Test
    public void distanciaMinimaAUnArea() {

        Tablero unTablero = new Tablero(6,6);

        Area unArea = unTablero.definirArea(0, 0, 1,1);
        Area espacioArmaDeAsedio = unTablero.definirArea(3, 0, 3, 0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3 ,0).estaOcupada());

        Assert.assertEquals(2, unArmaDeAsedio.distanciaMinimaA(unArea));

    }*/

}
