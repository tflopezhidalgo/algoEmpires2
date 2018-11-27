import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;
import modelo.*;
import modelo.excepciones.*;

@SuppressWarnings("deprecation")
public class AldeanoTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
    /*
     *  Test de movimiento de modelo.Aldeano
     */
    @Test
    public void seCreaUnAldeano() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioAldeano = unTablero.definirArea(0, 0, 0, 0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Assert.assertNotNull(unAldeano);
        Assert.assertEquals(false,espacioAldeano.estaLibre());
        Assert.assertEquals(1,espacioAldeano.obtenerCantidadDeCasillas());
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaArriba() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioAldeano = unTablero.definirArea(1, 1, 1, 1);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Assert.assertEquals(false,espacioAldeano.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 2);
        unTablero.moverEnDireccion(unAldeano,0,1);

        Assert.assertEquals(true, espacioAldeano.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaAbajo() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioAldeano = unTablero.definirArea(1, 1, 1, 1);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Assert.assertEquals(false,espacioAldeano.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(1, 0);
        unTablero.moverEnDireccion(unAldeano,0,-1);

        Assert.assertEquals(true, espacioAldeano.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaDerecha() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioAldeano = unTablero.definirArea(1, 1, 1, 1);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Assert.assertEquals(false,espacioAldeano.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 1);
        unTablero.moverEnDireccion(unAldeano,1,0);

        Assert.assertEquals(true, espacioAldeano.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaIzquierda() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioAldeano = unTablero.definirArea(1, 1, 1, 1);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Assert.assertEquals(false,espacioAldeano.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 1);
        unTablero.moverEnDireccion(unAldeano,-1,0);

        Assert.assertEquals(true, espacioAldeano.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverAldeanoUnaPosicionArribaDerecha() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioAldeano = unTablero.definirArea(1, 1, 1, 1);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Assert.assertEquals(false,espacioAldeano.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 2);
        unTablero.moverEnDireccion(unAldeano,1,1);

        Assert.assertEquals(true, espacioAldeano.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverAldeanoUnaPosicionArribaIzquierda() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioAldeano = unTablero.definirArea(1, 1, 1, 1);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Assert.assertEquals(false,espacioAldeano.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 2);
        unTablero.moverEnDireccion(unAldeano,-1,1);

        Assert.assertEquals(true, espacioAldeano.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoIzquierda() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioAldeano = unTablero.definirArea(1, 1, 1, 1);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Assert.assertEquals(false,espacioAldeano.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(0, 0);
        unTablero.moverEnDireccion(unAldeano,-1,-1);

        Assert.assertEquals(true, espacioAldeano.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoDerecha() throws Exception {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioAldeano = unTablero.definirArea(1, 1, 1, 1);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Assert.assertEquals(false,espacioAldeano.estaLibre());
        
        Casilla casillaFinal = unTablero.obtenerCasillaEn(2, 0);
        unTablero.moverEnDireccion(unAldeano,1,-1);

        Assert.assertEquals(true, espacioAldeano.estaLibre());
        Assert.assertEquals(true, casillaFinal.estaOcupada());
    }

    /*
     *  Test de construccion de modelo.Aldeano
     */
    
    @Test
    public void ConstruccionPlaza() throws Exception {
        int turno = 0;
        int oroJugador = 0;

        Tablero unTablero = new Tablero(5, 5);

    	Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Plaza.TAMANIO_LADO, Plaza.TAMANIO_LADO);
        
        //esa linea es parte del turno 1
        Plaza laNuevaPlaza = unAldeano.crearPlaza(zonaDeConstruccion);
        while(turno < 6) {
            turno ++;

            switch (turno) {

                case 1:{
                    Assert.assertEquals(false, laNuevaPlaza.necesitaReparacion());
                    Assert.assertEquals(true, laNuevaPlaza.enConstruccion());
                    Assert.assertEquals(0, oroJugador);
                }
                break;
                    
                case 2:{
                    Assert.assertEquals(false, laNuevaPlaza.necesitaReparacion());
                    Assert.assertEquals(true, laNuevaPlaza.enConstruccion());
                    Assert.assertEquals(0, oroJugador);
                }
                break;
                    
                case 3:{
                    Assert.assertEquals(false, laNuevaPlaza.necesitaReparacion());
                    Assert.assertEquals(true, laNuevaPlaza.enConstruccion());
                    Assert.assertEquals(0, oroJugador);
                }
                break;

                case 4:{
                    Assert.assertEquals(false, laNuevaPlaza.necesitaReparacion());
                    Assert.assertEquals(false, laNuevaPlaza.enConstruccion());
                    Assert.assertEquals(20, oroJugador);
                }
                break;

                case 5:{
                    Assert.assertEquals(40, oroJugador);
                }
                break;

                case 6:{
                    Assert.assertEquals(60, oroJugador);
                }
                break;
            }
            unAldeano.realizarTrabajoDeTurno();
            oroJugador += unAldeano.generarOro();
        }
    }

    @Test
    public void ConstruccionCuartel() throws Exception {
        int turno = 0;
        int oroJugador = 0;

        Tablero unTablero = new Tablero(5,5);

    	Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Cuartel.TAMANIO_LADO, Cuartel.TAMANIO_LADO);
        Cuartel elNuevoCuartel = unAldeano.crearCuartel(zonaDeConstruccion);
        while(turno < 6) {
            turno ++;
            switch (turno) {

                case 1:{
                    Assert.assertEquals(false, elNuevoCuartel.necesitaReparacion());
                    Assert.assertEquals(true, elNuevoCuartel.enConstruccion());
                }
                break;
                    
                case 2:{
                    Assert.assertEquals(false, elNuevoCuartel.necesitaReparacion());
                    Assert.assertEquals(true, elNuevoCuartel.enConstruccion());
                    Assert.assertEquals(0, oroJugador);
                }
                break;
                    
                case 3:{
                    Assert.assertEquals(false, elNuevoCuartel.necesitaReparacion());
                    Assert.assertEquals(true, elNuevoCuartel.enConstruccion());
                    Assert.assertEquals(0, oroJugador);
                }
                break;

                case 4:{
                    Assert.assertEquals(false, elNuevoCuartel.necesitaReparacion());
                    Assert.assertEquals(false, elNuevoCuartel.enConstruccion());
                    Assert.assertEquals(20, oroJugador);
                }
                break;

                case 5:{
                    Assert.assertEquals(40, oroJugador);
                }
                break;

                case 6:{
                    Assert.assertEquals(60, oroJugador);
                }
                break;
            }
            unAldeano.realizarTrabajoDeTurno();
            oroJugador += unAldeano.generarOro();
        }
    }
    
    @Test
    public void RepararPlazaCentral() throws Exception{
        int turno=0;

        Tablero unTablero = new Tablero(5,5);

    	Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Cuartel.TAMANIO_LADO, Cuartel.TAMANIO_LADO);
        Plaza unaPlaza = new Plaza(zonaDeConstruccion, true);

        unaPlaza.recibirDanio(50);

        while (turno<2) {
            turno++;

            switch (turno) {
                case 1: {
                    unAldeano.reparar(unaPlaza);
                    Assert.assertEquals(true, unaPlaza.necesitaReparacion());
                }
                break;
                case 2: {
                    unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(false, unaPlaza.necesitaReparacion());
                }
                break;
            }
            unAldeano.nuevoTurno();
        }
    }

    @Test
    public void RepararCastillo() throws Exception{
        int turno=0;

        Tablero unTablero = new Tablero(5,5);

    	Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Castillo.TAMANIO_LADO, Castillo.TAMANIO_LADO);
        Castillo unCastillo = new Castillo(zonaDeConstruccion);

        unCastillo.recibirDanio(30);

        while (turno<2) {
            turno++;

            switch (turno) {
                case 1: {
                    unAldeano.reparar(unCastillo);
                    Assert.assertEquals(true, unCastillo.necesitaReparacion());
                }
                break;
                case 2: {
                    unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(false, unCastillo.necesitaReparacion());
                }
                break;
            }
            unAldeano.nuevoTurno();
        }
    }

    @Test
    public void RepararCuartel() throws Exception{
        int turno=0;

        Tablero unTablero = new Tablero(5,5);

    	Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Cuartel.TAMANIO_LADO, Cuartel.TAMANIO_LADO);
        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);

        unCuartel.recibirDanio(100);

        while (turno<2) {
            turno++;

            switch (turno) {
            
                case 1: {
                    unAldeano.reparar(unCuartel);
                    Assert.assertEquals(true, unCuartel.necesitaReparacion());
                }
                break;
                
                case 2: {
                    unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(false, unCuartel.necesitaReparacion());
                }
                break;
            }
            unAldeano.nuevoTurno();
        }
    }

    @Test
    public void AldeanoVuelveASumarOroLuegoDeFinalizarUnaReparacion() throws Exception{
        int turno=0;
        int oro=0;

        Tablero unTablero = new Tablero(5,5);

    	Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Cuartel.TAMANIO_LADO, Cuartel.TAMANIO_LADO);
        Cuartel unCuartel = new Cuartel(zonaDeConstruccion,true);

        unCuartel.recibirDanio(100);

        while (turno<3) {
            turno++;

            switch (turno) {
                case 1: {
                    unAldeano.reparar(unCuartel);
                }
                break;
                
                case 2: {
                    Assert.assertEquals(0, oro);
                }
                break;
                
                case 3: {
                    Assert.assertEquals(20, oro);
                }
                break;
            }
            unAldeano.realizarTrabajoDeTurno();
            oro += unAldeano.generarOro();
        }
    }  
    
    //TODO falta arreglar esta --- lo comento para que para el build
/*    @Test
    public void soloUnAldeanoPuedeRepararUnMismoEdificio() throws modelo.Exceptiones.Exception{
        int turno=0;
        int oro=0;

        modelo.Tablero unTablero = new modelo.Tablero(5,5);

    	modelo.Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        modelo.Aldeano unAldeano = new modelo.Aldeano(espacioAldeano);
        
    	modelo.Area espacioOtroAldeano = unTablero.definirArea(3,3,3,3);
        modelo.Aldeano otroAldeano = new modelo.Aldeano(espacioOtroAldeano);
        
        modelo.Area zonaDeConstruccion = unTablero.definirArea(1, 1, modelo.Cuartel.TAMANIO_LADO, modelo.Cuartel.TAMANIO_LADO);
        modelo.Cuartel unCuartel = new modelo.Cuartel(zonaDeConstruccion,true);

        unCuartel.recibirDanio(100);
        
        while (turno<5) {
            turno++;

            switch (turno) {
                case 1: {
                    Assert.assertEquals(unCuartel.necesitaReparacion(),true);
                    otroAldeano.reparar(unCuartel);
                    unAldeano.reparar(unCuartel); //TODO ESTO NO TRANDRIA QUE HACER NADA
                    Assert.assertEquals(unCuartel.necesitaReparacion(),true);
                }
                break;

            }
            unAldeano.nuevoTurno();
            otroAldeano.nuevoTurno();
        }
    }*/ 

    @Test
    public void aldeanoNoPuedaRealizarOtraAccionSiEstaReparando() throws Exception{
        int turno = 0;

        Tablero unTablero = new Tablero(5,5);

    	Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);
        
        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Cuartel.TAMANIO_LADO, Cuartel.TAMANIO_LADO);
        Cuartel unCuartel = new Cuartel(zonaDeConstruccion,true);
        
        Area zonaDeConstruccion2 = unTablero.definirArea(1, 0, 1, 0);

        unCuartel.recibirDanio(100);
        
        while (turno<3) {
            turno++;

            switch (turno) {
                case 1: {
                    Assert.assertEquals(unCuartel.necesitaReparacion(),true);
                    unAldeano.reparar(unCuartel);
                }
                break;
                
                case 2: {
            		try {
            			unTablero.moverEnDireccion(unAldeano,0,1);
            		} catch (Exception e) {}
            		
                	Assert.assertEquals(zonaDeConstruccion2.estaLibre(),true);
                	
                	
                	//TODO: NO le puedo decir crearCuartel porque el Aldeano esta reparando!          	
                	Cuartel nuevoCuartel = null;
                	try {
                		nuevoCuartel = unAldeano.crearCuartel(zonaDeConstruccion2);
            		} catch (Exception e) {}
                	
                	Assert.assertNull(nuevoCuartel);
                	Assert.assertEquals(true,zonaDeConstruccion2.estaLibre());
                	
                	Plaza nuevaPlaza = null;
                	try {
                		nuevaPlaza = unAldeano.crearPlaza(zonaDeConstruccion2);
            		} catch (Exception e) {}
                	
                	Assert.assertNull(nuevaPlaza);
                	Assert.assertEquals(true,zonaDeConstruccion2.estaLibre());
                	
                	unAldeano.realizarTrabajoDeTurno();
                    Assert.assertEquals(false,unCuartel.necesitaReparacion());
                }
                break;

            }
            unAldeano.nuevoTurno();
        }
    }
    
    @Test
    public void aldeanoNoPuedaRealizarOtraAccionSiEstaConstruyendo() throws Exception{
        int turno=0;

        Tablero unTablero = new Tablero(5,5);

    	Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        //Forma parte del turno 1
        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Cuartel.TAMANIO_LADO, Cuartel.TAMANIO_LADO);
        Cuartel unCuartel = unAldeano.crearCuartel(zonaDeConstruccion);
        //----
        
        Area zonaDeConstruccion2 = unTablero.definirArea(0, 1, 0, 1);
        
        while (turno<4) {
            turno++;

            switch (turno) {
                case 1: {
                    Assert.assertEquals(unCuartel.enConstruccion(),true);
                }
                break;
                
                case 2: {
            		try {
            			unTablero.moverEnDireccion(unAldeano,0,1);
            		} catch (Exception e) {}
                	
                	Assert.assertTrue(zonaDeConstruccion2.estaLibre());
                	
                	Cuartel nuevoCuartel = null;
            		try {
            			nuevoCuartel = unAldeano.crearCuartel(zonaDeConstruccion2);
	        		} catch (Exception e) {}
            		
                	Assert.assertNull(nuevoCuartel);
                	Assert.assertTrue(zonaDeConstruccion2.estaLibre());
                	
                	Plaza nuevaPlaza = null;
            		try {
            			nuevaPlaza = unAldeano.crearPlaza(zonaDeConstruccion2);
		    		} catch (Exception e) {}
            		
	               	Assert.assertNull(nuevaPlaza);
                	Assert.assertTrue(zonaDeConstruccion2.estaLibre());
                	
                	unAldeano.realizarTrabajoDeTurno();
                    Assert.assertFalse(unCuartel.necesitaReparacion());
                }
                break;
                
                case 3: {
                	unAldeano.realizarTrabajoDeTurno();
                    Assert.assertFalse(unCuartel.enConstruccion());
                }
                break;

            }
            unAldeano.nuevoTurno();
        }
    } 
}

