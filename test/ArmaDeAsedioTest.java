import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;
import modelo.*;
import modelo.excepciones.*;

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

    	Area espacioArmaDeAsedio = unTablero.definirArea(0, 0, 0, 0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio);

        Assert.assertNotNull(unArmaDeAsedio);
        Assert.assertEquals(false,espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(1,espacioArmaDeAsedio.obtenerCantidadDeCasillas());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaArriba() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(false,espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 2);
        unTablero.moverEnDireccion(unArmaDeAsedio,0,1);
        
        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());

        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverArriba(unArmaDeAsedio);

        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaAbajo() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(false,espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 0);
        unTablero.moverEnDireccion(unArmaDeAsedio,0,-1);
        
        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());

        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverAbajo(unArmaDeAsedio);

        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaDerecha() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(false,espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 1);
        unTablero.moverEnDireccion(unArmaDeAsedio,1,0);
        
        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());

        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverDerecha(unArmaDeAsedio);

        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaIzquierda() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(false,espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 1);
        unTablero.moverEnDireccion(unArmaDeAsedio,-1,0);
        
        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());

        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverIzquierda(unArmaDeAsedio);

        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionArribaDerecha() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(false,espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 2);
        unTablero.moverEnDireccion(unArmaDeAsedio,1,1);
        
        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());

        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverArribaDerecha(unArmaDeAsedio);

        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionArribaIzquierda() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(false,espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 2);
        unTablero.moverEnDireccion(unArmaDeAsedio,-1,1);
        
        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());

        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverArribaIzquierda(unArmaDeAsedio);

        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionAbajoIzquierda() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(false,espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 0);
        unTablero.moverEnDireccion(unArmaDeAsedio,-1,-1);
        
        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());

        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverAbajoIzquierda(unArmaDeAsedio);

        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionAbajoDerecha() throws Exception {
    	Tablero unTablero = new Tablero(3,3);
       	
    	Area espacioArmaDeAsedio = unTablero.definirArea(1, 1, 1, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(false,espacioArmaDeAsedio.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 0);
        unTablero.moverEnDireccion(unArmaDeAsedio,1,-1);
        
        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());

        unArmaDeAsedio.accionar();
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
        //unTablero.moverAbajoDerecha(unArmaDeAsedio);

        Assert.assertEquals(true, espacioArmaDeAsedio.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    /*
     * Test de ataques de Arma de Asedio
     */
   @Test
    public void armaDeAsedioNoAtacaSiNoFueAccionada() throws Exception {

	   	Tablero unTablero = new Tablero(7,7);
	   	
        Area zonaDeConstruccion = unTablero.definirArea(5, 5, Plaza.TAMANIO_LADO+4, Plaza.TAMANIO_LADO+4);
        Plaza unaPlaza = new Plaza(zonaDeConstruccion);

    	Area espacioArmaDeAsedio = unTablero.definirArea(0,0,0,0);
        ArmaDeAsedio unaArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio);

        //vida de la plaza == 450
        try {
        unaArmaDeAsedio.atacar(unaPlaza);
		} catch (Exception e) {}
        Assert.assertEquals(false, unaPlaza.necesitaReparacion());
        
        unaArmaDeAsedio.accionar();
        
        //vida de la plaza == 375
        unaArmaDeAsedio.atacar(unaPlaza);
        Assert.assertEquals(true, unaPlaza.necesitaReparacion());
    }
   
   @Test
    public void armaDeAsedioNoSeMueveSiFueAccionada() throws Exception {

        Tablero unTablero = new Tablero(3,3);

    	Area espacioArmaDeAsedio = unTablero.definirArea(0,0,0,0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio);

        Casilla casillaArriba1 = unTablero.obtenerCasillaEn(0, 1);
        Casilla casillaArriba2 = unTablero.obtenerCasillaEn(0, 2);
        
        //no deberia tirar error
        unTablero.moverEnDireccion(unArmaDeAsedio,0,1);
        
        unArmaDeAsedio.accionar();
        
        //no se mueve
        unArmaDeAsedio.nuevoTurno();
		try {
			unTablero.moverEnDireccion(unArmaDeAsedio,0,1);
		} catch (Exception e) {}
     	Assert.assertEquals(true, casillaArriba1.estaOcupada());
     	Assert.assertEquals(false, casillaArriba2.estaOcupada());
 
        unArmaDeAsedio.accionar();
        
        //no hace falta iniciar un nuevo turno
        //no deberia tirar error
        unTablero.moverEnDireccion(unArmaDeAsedio,0,1);
     	Assert.assertEquals(false, casillaArriba1.estaOcupada());
     	Assert.assertEquals(true, casillaArriba2.estaOcupada());
    }
    
    @Test
    public void ataqueArmaDeAsedioAEdificio() throws Exception {
    	Tablero unTablero = new Tablero(7, 7);

        Area zonaDeConstruccion = unTablero.definirArea(5, 5, Plaza.TAMANIO_LADO+4, Plaza.TAMANIO_LADO+4);
        Plaza unaPlaza = new Plaza(zonaDeConstruccion);

    	Area espacioArmaDeAsedio = unTablero.definirArea(0,0,0,0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio);

        unArmaDeAsedio.accionar();
        
        //vida de la plaza == 375
        //Aunque la palza no esta 100% en rango, una de sus casillas lo esta
        //ya que, por ej tambien ocupa la casilla (5,5) que si esta en rango
        unArmaDeAsedio.atacar(unaPlaza);

        Assert.assertEquals(true,unaPlaza.necesitaReparacion());
        Assert.assertEquals(false,unaPlaza.estaDestruida());

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

        Assert.assertEquals(true,unaPlaza.estaDestruida());
        Assert.assertEquals(true,zonaDeConstruccion.estaLibre());
    }

    @Test
    public void ataqueArmaDeAsedioAEdificioFueraDeRango() throws Exception {
    	Tablero unTablero = new Tablero(10, 10);

        Area zonaDeConstruccion = unTablero.definirArea(6, 6, Plaza.TAMANIO_LADO+5, Plaza.TAMANIO_LADO+5);
        Plaza unaPlaza = new Plaza(zonaDeConstruccion);

    	Area espacioArmaDeAsedio = unTablero.definirArea(0,0,0,0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio);

        //vida de la plaza == 450
        unArmaDeAsedio.atacar(unaPlaza);
        unArmaDeAsedio.atacar(unaPlaza);
        unArmaDeAsedio.atacar(unaPlaza);
        unArmaDeAsedio.atacar(unaPlaza);
        unArmaDeAsedio.atacar(unaPlaza);
        unArmaDeAsedio.atacar(unaPlaza);
        unArmaDeAsedio.atacar(unaPlaza);

        Assert.assertEquals(false,unaPlaza.necesitaReparacion());
        Assert.assertEquals(false,unaPlaza.estaDestruida());

    }

    @Test
    public void catapultaArmadaNoPuedeMoverse() throws Exception{
       Tablero unTablero = new Tablero();
       Area espacioArmaDeAsedio = unTablero.definirArea(0,0,0,0);
       ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio);
       Area areaNueva = unTablero.definirArea(1, 0, 1,0);

       unArmaDeAsedio.accionar();

       boolean seLanzoError=false;
       try {
           unArmaDeAsedio.mover(areaNueva);
       } catch (CatapultaArmadaNoPuedeMoverseError e){
           seLanzoError=true;
       };

       Assert.assertEquals(true, seLanzoError);
    }

    @Test
    public void catapultaDesarmadaNoPuedeAtacar() throws Exception{
       Tablero unTablero = new Tablero();
       Area espacioArmaDeAsedio = unTablero.definirArea(0,0,0,0);
       ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(espacioArmaDeAsedio);
       Area espacioDePlaza = unTablero.definirArea(1, 0, Plaza.TAMANIO_LADO, Plaza.TAMANIO_LADO-1);
       Plaza unaPlaza = new Plaza(espacioDePlaza);

       boolean seLanzoError=false;
       try {
           unArmaDeAsedio.atacar(unaPlaza);
        } catch (CatapultaDesarmadaNoPuedeAtacarError e){
           seLanzoError=true;
       };

       Assert.assertEquals(true,seLanzoError);
    }

}
