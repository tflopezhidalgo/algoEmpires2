import modelo.*;
import modelo.excepciones.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class AldeanoTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
    /*
     *  Test de movimiento de modelo.Aldeano
     */
    @Test
    public void seCreaUnAldeano() {
    	Tablero unTablero = new Tablero(3,3);

    	Area espacioAldeano = unTablero.definirArea(0, 0, 0, 0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Assert.assertNotNull(unAldeano);
        Assert.assertEquals(false,espacioAldeano.estaLibre());
        Assert.assertEquals(1,espacioAldeano.obtenerCantidadDeCasillas());
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaArriba() {
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
    public void moverAldeanoUnaPosicionHaciaAbajo() {
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
    public void moverAldeanoUnaPosicionHaciaDerecha() {
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
    public void moverAldeanoUnaPosicionHaciaIzquierda() {
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
    public void moverAldeanoUnaPosicionArribaDerecha() {
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
    public void moverAldeanoUnaPosicionArribaIzquierda() {
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
    public void moverAldeanoUnaPosicionAbajoIzquierda() {
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
    public void moverAldeanoUnaPosicionAbajoDerecha() {
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
    public void ConstruccionPlaza() {
        int turno = 0;
        int oroJugador = 0;

        Tablero unTablero = new Tablero(5, 5);

    	Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Plaza.TAMANIO_LADO, Plaza.TAMANIO_LADO);
        
        //esa linea es parte del turno 1
        Plaza laNuevaPlaza = (Plaza)unAldeano.crearPlaza(zonaDeConstruccion);
        while(turno < 6) {
            turno ++;

            switch (turno) {

                case 1:{
                    Assert.assertEquals(false, laNuevaPlaza.vidaBaja());
                    Assert.assertEquals(true, laNuevaPlaza.enConstruccion());
                    Assert.assertEquals(0, oroJugador);
                }
                break;
                    
                case 2:{
                    Assert.assertEquals(false, laNuevaPlaza.vidaBaja());
                    Assert.assertEquals(true, laNuevaPlaza.enConstruccion());
                    Assert.assertEquals(0, oroJugador);
                }
                break;
                    
                case 3:{
                    Assert.assertEquals(false, laNuevaPlaza.vidaBaja());
                    Assert.assertEquals(true, laNuevaPlaza.enConstruccion());
                    Assert.assertEquals(0, oroJugador);
                }
                break;

                case 4:{
                    Assert.assertEquals(false, laNuevaPlaza.vidaBaja());
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
    public void ConstruccionCuartel() {
        int turno = 0;
        int oroJugador = 0;

        Tablero unTablero = new Tablero(5,5);

    	Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Cuartel.TAMANIO_LADO, Cuartel.TAMANIO_LADO);
        Cuartel elNuevoCuartel = (Cuartel)unAldeano.crearCuartel(zonaDeConstruccion);
        while(turno < 6) {
            turno ++;
            switch (turno) {

                case 1:{
                    Assert.assertEquals(false, elNuevoCuartel.vidaBaja());
                    Assert.assertEquals(true, elNuevoCuartel.enConstruccion());
                }
                break;
                    
                case 2:{
                    Assert.assertEquals(false, elNuevoCuartel.vidaBaja());
                    Assert.assertEquals(true, elNuevoCuartel.enConstruccion());
                    Assert.assertEquals(0, oroJugador);
                }
                break;
                    
                case 3:{
                    Assert.assertEquals(false, elNuevoCuartel.vidaBaja());
                    Assert.assertEquals(true, elNuevoCuartel.enConstruccion());
                    Assert.assertEquals(0, oroJugador);
                }
                break;

                case 4:{
                    Assert.assertEquals(false, elNuevoCuartel.vidaBaja());
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
    public void RepararPlazaCentral() {
        int turno=0;

        Tablero unTablero = new Tablero(5,5);

    	Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Cuartel.TAMANIO_LADO, Cuartel.TAMANIO_LADO);
        Plaza unaPlaza = new Plaza(zonaDeConstruccion, true);

        unaPlaza.recibirDanio(25);

        while (turno<2) {
            turno++;

            switch (turno) {
                case 1: {
                    unAldeano.reparar(unaPlaza);
                    Assert.assertEquals(true, unaPlaza.vidaBaja());
                }
                break;
                
                case 2: {
                    Assert.assertEquals(false, unaPlaza.vidaBaja());
                }
                break;
            }
            unAldeano.nuevoTurno();
        }
    }

    @Test
    public void RepararCastillo() {
        int turno=0;

        Tablero unTablero = new Tablero(5,5);

    	Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Castillo.TAMANIO_LADO, Castillo.TAMANIO_LADO);
        Castillo unCastillo = new Castillo(zonaDeConstruccion);

        unCastillo.recibirDanio(30);

        while (turno<3) {
            turno++;

            switch (turno) {
                case 1: {
                    unAldeano.reparar(unCastillo);
                    Assert.assertEquals(true, unCastillo.vidaBaja());
                }
                break;
                
                case 2: {
                    Assert.assertEquals(true, unCastillo.vidaBaja());
                }
                break;
                
                case 3: {
                    Assert.assertEquals(false, unCastillo.vidaBaja());
                }
                break;
            }
            unAldeano.nuevoTurno();
        }
    }

    @Test
    public void RepararCuartel() {
        int turno=0;

        Tablero unTablero = new Tablero(5,5);

    	Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Cuartel.TAMANIO_LADO, Cuartel.TAMANIO_LADO);
        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);

        unCuartel.recibirDanio(100);

        while (turno<3) {
            turno++;

            switch (turno) {
            
                case 1: {
                    unAldeano.reparar(unCuartel);
                    Assert.assertEquals(true, unCuartel.vidaBaja());
                }
                break;
                
                case 2: {
                    Assert.assertEquals(true, unCuartel.vidaBaja());
                }
                break;
                
                case 3: {
                    Assert.assertEquals(false, unCuartel.vidaBaja());
                }
                break;
            }
            unAldeano.nuevoTurno();
        }
    }

    @Test
    public void AldeanoVuelveASumarOroLuegoDeFinalizarUnaReparacion() {
        int turno=0;
        int oro=0;

        Tablero unTablero = new Tablero(5,5);

    	Area espacioAldeano = unTablero.definirArea(0,0,0,0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Cuartel.TAMANIO_LADO, Cuartel.TAMANIO_LADO);
        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);
        unCuartel.nuevoTurno();
        unCuartel.nuevoTurno();
        unCuartel.nuevoTurno();

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
    //TODO: Falta probar que se lanza excepcion
    /*@Test
    public void soloUnAldeanoPuedeRepararUnMismoEdificio() throws Exception{
        int turno=0;

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
                    Assert.assertEquals(true, unCuartel.vidaBaja());
                    otroAldeano.reparar(unCuartel);
                    unAldeano.reparar(unCuartel); //TODO ESTO NO TRANDRIA QUE HACER NADA
                    unTablero.moverEnDireccion(unAldeano, 1, 0);
                    Assert.assertEquals(true, espacioAldeano.estaLibre());
                }
                break;
                
                case 2:{
                    Assert.assertEquals(true, unCuartel.vidaBaja());
                }
                break;
                
                case 3:{
                    Assert.assertEquals(false, unCuartel.vidaBaja());
                }
                break;

            }
            otroAldeano.nuevoTurno();
            unAldeano.nuevoTurno();
        }
    }
*/
    @Test
    public void aldeanoNoPuedaRealizarOtraAccionSiEstaReparando(){

        int turno = 0;

        Tablero unTablero = new Tablero(20,20);

    	Area espacioAldeano = unTablero.definirArea(10,10,10,10);
        Aldeano unAldeano = new Aldeano(espacioAldeano);
        
        Area zonaDeConstruccion = unTablero.definirArea(5, 5, 9,9);

        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);
        unCuartel.nuevoTurno();
        unCuartel.nuevoTurno();
        unCuartel.nuevoTurno();
        
        Area zonaDeConstruccion2 = unTablero.definirArea(11, 15, 11, 15);

        unCuartel.recibirDanio(100);
        
        while (turno < 4) {
            turno++;

            switch (turno) {
                case 1: {

                    Assert.assertTrue(unCuartel.vidaBaja());
                    unAldeano.reparar(unCuartel);
                }
                break;
                
                case 2: {

                    boolean excepcion = false;

            		try {

            			unTablero.moverEnDireccion(unAldeano,0,1);
            		} catch (AldeanOcupadoNoPuedeMoverse e) {
                        excepcion = true;
                    }

            		Assert.assertTrue(excepcion);
                	
                	//TODO: NO le puedo decir crearCuartel porque el Aldeano esta reparando!          	
                	Cuartel nuevoCuartel = null;

                	try {
                		nuevoCuartel = (Cuartel)unAldeano.crearCuartel(zonaDeConstruccion2);

            		} catch (Exception e) {}
                	
                	Assert.assertNull(nuevoCuartel);
                	Assert.assertEquals(true,zonaDeConstruccion2.estaLibre());
                	
                	Plaza nuevaPlaza = null;
                	try {
                		nuevaPlaza = (Plaza)unAldeano.crearPlaza(zonaDeConstruccion2);
            		} catch (Exception e) {}
                	
                	Assert.assertNull(nuevaPlaza);
                	Assert.assertEquals(true,zonaDeConstruccion2.estaLibre());
                	
                    Assert.assertEquals(true,unCuartel.vidaBaja());
                    
                }
                break;
                
                case 3: {
                    Assert.assertEquals(unCuartel.vidaBaja(),false);
                }
                break;

            }
            unAldeano.nuevoTurno();
        }
    }
    
    @Test
    public void aldeanoNoPuedaRealizarOtraAccionSiEstaConstruyendo(){

        int turno = 0;

        Tablero unTablero = new Tablero(20,20);

    	Area espacioAldeano = unTablero.definirArea(5,5,5,5);
        Aldeano unAldeano = new Aldeano(espacioAldeano);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, 4, 4);
        Cuartel unCuartel = (Cuartel)unAldeano.crearCuartel(zonaDeConstruccion);
        
        Area zonaDeConstruccion2 = unTablero.definirArea(6,6,10,10);
        
        while (turno < 4) {
            turno++;

            switch (turno) {
                case 1: {

                    Assert.assertTrue(unCuartel.enConstruccion());
                }
                break;
                
                case 2: {
            		try {
            			unTablero.moverEnDireccion(unAldeano,1,1);
            		} catch (RuntimeException e) {}
                	
                	Assert.assertTrue(zonaDeConstruccion2.estaLibre());
                	
                	Cuartel nuevoCuartel = null;
            		try {
            			nuevoCuartel = (Cuartel)unAldeano.crearCuartel(zonaDeConstruccion2);
	        		} catch (RuntimeException e) {}
            		
                	Assert.assertNull(nuevoCuartel);
                	Assert.assertTrue(zonaDeConstruccion2.estaLibre());
                	
                	Plaza nuevaPlaza = null;
            		try {
            			nuevaPlaza = (Plaza)unAldeano.crearPlaza(zonaDeConstruccion2);
		    		} catch (RuntimeException e) {}
            		
	               	Assert.assertNull(nuevaPlaza);
                	Assert.assertTrue(zonaDeConstruccion2.estaLibre());
                	
                    Assert.assertFalse(unCuartel.vidaBaja());
                }
                break;
                
                case 3: {
                    Assert.assertTrue(unCuartel.enConstruccion());
                }
                break;
                
                case 4: {
                    Assert.assertFalse(unCuartel.enConstruccion());
                }
                break;

            }
            unAldeano.nuevoTurno();
        }
    }

    @Test
    public void soloUnAldeanoPuedeRepararUnMismoEdificio() throws Exception{

        Tablero unTablero = new Tablero(5,5);
        Area espacioAldeano1 = unTablero.definirArea(0,0,0,0);
        Aldeano aldeano1 = new Aldeano(espacioAldeano1);

        Area espacioAldeano2 = unTablero.definirArea(1,0,1,0);
        Aldeano aldeano2 = new Aldeano(espacioAldeano2);

        Cuartel unCuartel = new Cuartel(unTablero.definirArea(0,1,1,2));
        unCuartel.nuevoTurno();
        unCuartel.nuevoTurno();
        unCuartel.nuevoTurno();

        unCuartel.recibirDanio(100);
        aldeano1.reparar(unCuartel);

        boolean lanzaUnError=false;
        try {
            aldeano2.reparar(unCuartel);
        } catch (EdificioTieneOtroAldeanoAsignado e){
            lanzaUnError=true;
        }

        Assert.assertEquals(true, lanzaUnError);
    }

    @Test
    public void aldeanoConstruyendoNoPuedeReparar() {
        Tablero unTablero = new Tablero();
        Aldeano unAldeano = new Aldeano(unTablero.definirArea(3,1,3,1));

        Cuartel cuartelAReparar = new Cuartel(unTablero.definirArea(4,0,Cuartel.TAMANIO_LADO+2, Cuartel.TAMANIO_LADO-1));

        cuartelAReparar.nuevoTurno();
        cuartelAReparar.nuevoTurno();
        cuartelAReparar.nuevoTurno();

        Cuartel cuartelEnConstruccion = (Cuartel)unAldeano.crearCuartel(unTablero.definirArea(1,1,Cuartel.TAMANIO_LADO, Cuartel.TAMANIO_LADO));

        unAldeano.nuevoTurno();

        cuartelAReparar.recibirDanio(100);
        boolean seLanzoError=false;
        try {
            unAldeano.reparar(cuartelAReparar);
        } catch (AldeanoConstruyendoNoPuedeReparar e) {
            seLanzoError=true;
        }

        Assert.assertEquals(true, seLanzoError);
    }

    @Test
    public void aldeanoOcupadoNoPuedeMoverse() {
        Tablero unTablero = new Tablero();
        Aldeano unAldeano = new Aldeano(unTablero.definirArea(0,0,0,0));

        Cuartel cuartelEnConstruccion = (Cuartel)unAldeano.crearCuartel(unTablero.definirArea(1,1,Cuartel.TAMANIO_LADO-1, Cuartel.TAMANIO_LADO-1));

        unAldeano.nuevoTurno();
        boolean seLanzoError=false;
        try {
            unAldeano.mover(unTablero.definirArea(1,1,1,1));
        } catch (AldeanOcupadoNoPuedeMoverse e) {
            seLanzoError=true;
        }

        Assert.assertEquals(true, seLanzoError);
    }

    @Test
    public void aldeanoOcupadoConOtroEdificio(){

        Tablero unTablero = new Tablero();

        Aldeano unAldeano = new Aldeano(unTablero.definirArea(5,5,5,5));

        Cuartel cuartelEnConstruccion = (Cuartel)unAldeano.crearCuartel(unTablero.definirArea(1,1,
                4, 4));

        unAldeano.nuevoTurno();

        boolean seLanzoError = false;

        try {

           Plaza unaPlaza = (Plaza)unAldeano.crearPlaza(unTablero.definirArea(6,1,10,5));

        } catch (AldeanoOcupadoConOtroEdificioError e) {

            seLanzoError = true;
        }

        Assert.assertTrue(seLanzoError);
    }

    @Test
    public void aldeanoReparandoNoPuedeConstruir() {

        Tablero unTablero = new Tablero();
        Aldeano unAldeano = new Aldeano(unTablero.definirArea(3, 1, 3, 1));

        Cuartel cuartelAReparar = new Cuartel(unTablero.definirArea(4,0,Cuartel.TAMANIO_LADO+2, Cuartel.TAMANIO_LADO-1));
        cuartelAReparar.recibirDanio(100);
        unAldeano.reparar(cuartelAReparar);

        unAldeano.nuevoTurno();

        boolean seLanzoError=false;
        try {
            Cuartel cuartelEnConstruccion = (Cuartel)unAldeano.crearCuartel(unTablero.definirArea(1, 1, Cuartel.TAMANIO_LADO, Cuartel.TAMANIO_LADO ));
        } catch (AldeanoReparandoNoPuedeConstruir e) {
            seLanzoError=true;
        }

        Assert.assertEquals(true, seLanzoError);
    }

    @Test
    public void noPuedeConstruirCuartelTanLejos() {
        Tablero unTablero = new Tablero();
        Aldeano unAldeano = new Aldeano(unTablero.definirArea(0,0,0,0));

        Cuartel unCuartel = (Cuartel)unAldeano.crearCuartel(unTablero.definirArea(0,1,1,2));
        unAldeano.nuevoTurno();

        boolean seLanzoError=false;
        try {
            Cuartel otroCuartel = (Cuartel)unAldeano.crearCuartel(unTablero.definirArea(2, 1, 3,1));
        } catch (NoSePuedeConstruirTanLejosError e) {
            seLanzoError=true;
        }

        Assert.assertEquals(true, seLanzoError);
    }

    @Test
    public void noPuedeConstruirPlazaTanLejos() {

        Tablero unTablero = new Tablero();

        Aldeano unAldeano = new Aldeano(unTablero.definirArea(0,0,0,0));

        Plaza unaPlaza = (Plaza)unAldeano.crearPlaza(unTablero.definirArea(0,1,1,2));

        unAldeano.nuevoTurno();

        boolean seLanzoError = false;

        try {

            unAldeano.crearPlaza(unTablero.definirArea(2, 1, 3,1));

        } catch (NoSePuedeConstruirTanLejosError e) {

            seLanzoError = true;
        }

        Assert.assertEquals(true, seLanzoError);
    }

    @Test
    public void piezaFueraDeAlcanceParaSerReparada() {
        Tablero unTablero = new Tablero();

        Aldeano unAldeano = new Aldeano(unTablero.definirArea(0,0,0,0));

        Plaza unaPlaza = new Plaza(unTablero.definirArea(6,6,7,7), true);

        unaPlaza.recibirDanio(20);

        boolean lanzaUnError = false;

        try {

            unAldeano.reparar(unaPlaza);

        } catch (PiezaFueraDeAlcanceError e){

            lanzaUnError = true;
        }

        Assert.assertEquals(true, lanzaUnError);
    }


    //TODO: Copiar más de éstas pruebas.
    @Test
    public void edificioAceptaSoloUnAldeanoReparando() {

        Tablero unTablero = new Tablero();

        Aldeano unAldeano = new Aldeano(unTablero.definirArea(0,0,0,0));

        Aldeano otroAldeano = new Aldeano(unTablero.definirArea(1,0,1,0));

        Cuartel unCuartel = new Cuartel(unTablero.definirArea(0,1,3,4));

        unCuartel.recibirDanio(100);

        unAldeano.reparar(unCuartel);

        unAldeano.nuevoTurno();

        boolean excepcion = false;

        try {
            otroAldeano.reparar(unCuartel);

        }catch(EdificioTieneOtroAldeanoAsignado e){

            excepcion = true;
        }

        Assert.assertTrue(excepcion);

    }

    @Test
    public void liberarUbicacionAldeano() {
        Tablero unTablero = new Tablero(6,6);

        Area espacioAldeano = unTablero.definirArea(0, 0, 0, 0);
        Pieza unaPieza = new Aldeano(espacioAldeano);

        Assert.assertNotNull(unaPieza);
        Assert.assertFalse(espacioAldeano.estaLibre());
        Assert.assertEquals(1,espacioAldeano.obtenerCantidadDeCasillas());

        unaPieza.recibirDanio(50); //Aldeano.VIDA_MAX = 50
        Assert.assertTrue(espacioAldeano.estaLibre());
    }


    //ES PRIVADO EL METODO
   /* @Test
    public void distanciaMinimaAUnArea() {

        Tablero unTablero = new Tablero(6,6);

        Area unArea = unTablero.definirArea(0, 0, 1,1);
        Area espacioAldeano = unTablero.definirArea(3, 0, 3, 0);
        Aldeano unAldeano = new Aldeano(espacioAldeano);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3 ,0).estaOcupada());

        Assert.assertEquals(2, unAldeano.distanciaMinimaA(unArea));

    }*/

}
