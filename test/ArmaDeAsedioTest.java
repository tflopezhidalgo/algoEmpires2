import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class ArmaDeAsedioTest {


	@Rule
	public ExpectedException thrown = ExpectedException.none();
    /*
     * Test de movimiento de Arma de Asedio
     */
    @Test
    public void seCreaArmaDeAsedio() throws ErrorBasico {

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(new Casilla(0, 0));

        Assert.assertNotNull(unArmaDeAsedio);
    }

    @Test
    public void ColocarArmaDeAsedio() throws ErrorBasico {

        Casilla casilla = new Casilla(1,1);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(casilla);

        Assert.assertEquals(true, casilla.estaOcupada());
        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casilla);
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaArriba() throws ErrorBasico {
       	Tablero unTablero = new Tablero(3,3);
       	
        Casilla casillaArmaDeAsedio = unTablero.obtenerCasillaEn(1, 0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(casillaArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(true, casillaArmaDeAsedio.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDe(casillaArmaDeAsedio);
        unTablero.moverHasta(unArmaDeAsedio, casillaFinal);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);

        unArmaDeAsedio.accionar();
        Casilla casillaTope = unTablero.casillaArribaDe(casillaFinal);
        unTablero.moverHasta(unArmaDeAsedio, casillaTope);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaAbajo() throws ErrorBasico {
       	Tablero unTablero = new Tablero(3,3);
       	
        Casilla casillaArmaDeAsedio = unTablero.obtenerCasillaEn(1, 2);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(casillaArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(true, casillaArmaDeAsedio.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaAbajoDe(casillaArmaDeAsedio);
        unTablero.moverHasta(unArmaDeAsedio, casillaFinal);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);

        unArmaDeAsedio.accionar();
        Casilla casillaTope = unTablero.casillaAbajoDe(casillaFinal);
        unTablero.moverHasta(unArmaDeAsedio, casillaTope);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);

    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaDerecha() throws ErrorBasico {
       	Tablero unTablero = new Tablero(3,3);
       	
        Casilla casillaArmaDeAsedio = unTablero.obtenerCasillaEn(0, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(casillaArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(true, casillaArmaDeAsedio.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaDerechaDe(casillaArmaDeAsedio);
        unTablero.moverHasta(unArmaDeAsedio, casillaFinal);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);

        unArmaDeAsedio.accionar();
        Casilla casillaTope = unTablero.casillaDerechaDe(casillaFinal);
        unTablero.moverHasta(unArmaDeAsedio, casillaTope);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionHaciaIzquierda() throws ErrorBasico {
       	Tablero unTablero = new Tablero(3,3);
       	
        Casilla casillaArmaDeAsedio = unTablero.obtenerCasillaEn(2, 1);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(casillaArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(true, casillaArmaDeAsedio.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaIzquierdaDe(casillaArmaDeAsedio);
        unTablero.moverHasta(unArmaDeAsedio, casillaFinal);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);

        unArmaDeAsedio.accionar();
        Casilla casillaTope = unTablero.casillaIzquierdaDe(casillaFinal);
        unTablero.moverHasta(unArmaDeAsedio, casillaTope);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionArribaDerecha() throws ErrorBasico {
       	Tablero unTablero = new Tablero(3,3);
       	
        Casilla casillaArmaDeAsedio = unTablero.obtenerCasillaEn(0, 0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(casillaArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(true, casillaArmaDeAsedio.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaDerechaDe(casillaArmaDeAsedio);
        unTablero.moverHasta(unArmaDeAsedio, casillaFinal);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);

        unArmaDeAsedio.accionar();
        Casilla casillaTope = unTablero.casillaArribaDerechaDe(casillaFinal);
        unTablero.moverHasta(unArmaDeAsedio, casillaTope);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionArribaIzquierda() throws ErrorBasico {
       	Tablero unTablero = new Tablero(3,3);
       	
        Casilla casillaArmaDeAsedio = unTablero.obtenerCasillaEn(2, 0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(casillaArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(true, casillaArmaDeAsedio.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaArribaIzquierdaDe(casillaArmaDeAsedio);
        unTablero.moverHasta(unArmaDeAsedio, casillaFinal);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);

        unArmaDeAsedio.accionar();
        Casilla casillaTope = unTablero.casillaArribaIzquierdaDe(casillaFinal);
        unTablero.moverHasta(unArmaDeAsedio, casillaTope);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionAbajoIzquierda() throws ErrorBasico {
       	Tablero unTablero = new Tablero(3,3);
       	
        Casilla casillaArmaDeAsedio = unTablero.obtenerCasillaEn(2, 2);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(casillaArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(true, casillaArmaDeAsedio.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaAbajoIzquierdaDe(casillaArmaDeAsedio);
        unTablero.moverHasta(unArmaDeAsedio, casillaFinal);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);

        unArmaDeAsedio.accionar();
        Casilla casillaTope = unTablero.casillaAbajoIzquierdaDe(casillaFinal);
        unTablero.moverHasta(unArmaDeAsedio, casillaTope);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);
    }

    @Test
    public void moverArmaDeAsedioUnaPosicionAbajoDerecha() throws ErrorBasico {
       	Tablero unTablero = new Tablero(3,3);
       	
        Casilla casillaArmaDeAsedio = unTablero.obtenerCasillaEn(0, 2);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(casillaArmaDeAsedio); //Se inicia en modo mover (se mueve)
        
        Assert.assertEquals(true, casillaArmaDeAsedio.estaOcupada());
        
        Casilla casillaFinal = unTablero.casillaAbajoDerechaDe(casillaArmaDeAsedio);
        unTablero.moverHasta(unArmaDeAsedio, casillaFinal);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);

        unArmaDeAsedio.accionar();
        Casilla casillaTope = unTablero.casillaAbajoDerechaDe(casillaFinal);
        unTablero.moverHasta(unArmaDeAsedio, casillaTope);

        Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaFinal);
    }


    /*
     * Test de ataques de Arma de Asedio
     */
   @Test
    public void armaDeAsedioNoAtacaSiNoFueAccionada() throws ErrorBasico {

	   	Tablero unTablero = new Tablero(7,7);

        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
        for(int y = 0; y < Plaza.TAMANIO_LADO; y++) {
            for(int x = 0; x < Plaza.TAMANIO_LADO; x++) {
                casillasParaConstruccion.add(unTablero.obtenerCasillaEn(5+x,5+y));
            }
        }
        Area zonaDeConstruccion = new Area(casillasParaConstruccion);
        Plaza unaPlaza = new Plaza(zonaDeConstruccion);

        Casilla casillaArmaDeAsedio = unTablero.obtenerCasillaEn(0,0);
        ArmaDeAsedio unaArmaDeAsedio = new ArmaDeAsedio(casillaArmaDeAsedio);

        //vida de la plaza == 450
        //tira error
    	thrown.expect(ErrorBasico.class);
    	unaArmaDeAsedio.atacar(unaPlaza);
        Assert.assertEquals(false, unaPlaza.necesitaReparacion());
        
        unaArmaDeAsedio.accionar();
        
        //vida del aldeano == 50
        //no deberia tirar error
        unaArmaDeAsedio.atacar(unaPlaza);
        Assert.assertEquals(true, unaPlaza.necesitaReparacion());
    }
   
   @Test
    public void armaDeAsedioNoSeMueveSiFueAccionada() throws ErrorBasico {

        Tablero unTablero = new Tablero(3,3);

        Casilla casillaArmaDeAsedio = unTablero.obtenerCasillaEn(0, 0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(casillaArmaDeAsedio);

        Casilla casillaArriba1 = unTablero.casillaArribaDe(casillaArmaDeAsedio);
        Casilla casillaArriba2 = unTablero.casillaArribaDe(casillaArriba1);
        //no deberia tirar error
        unTablero.moverHasta(unArmaDeAsedio, casillaArriba1);
        
        unArmaDeAsedio.accionar();
        
        //no se mueve
     	unTablero.moverHasta(unArmaDeAsedio, casillaArriba2);
     	Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaArriba1);
     	Assert.assertEquals(true, casillaArriba1.estaOcupada());
     	Assert.assertEquals(false, casillaArriba2.estaOcupada());
 
        unArmaDeAsedio.accionar();
        
        //no deberia tirar error
        unTablero.moverHasta(unArmaDeAsedio, casillaArriba2);
     	Assert.assertEquals(unArmaDeAsedio.obtenerUbicacion(), casillaArriba2);
     	Assert.assertEquals(false, casillaArriba1.estaOcupada());
     	Assert.assertEquals(true, casillaArriba2.estaOcupada());
    }
    
    @Test
    public void ataqueArmaDeAsedioAEdificio() throws ErrorBasico {
    	Tablero unTablero = new Tablero(7, 7);

        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
        for(int y = 0; y < Plaza.TAMANIO_LADO; y++) {
            for(int x = 0; x < Plaza.TAMANIO_LADO; x++) {
                casillasParaConstruccion.add(unTablero.obtenerCasillaEn(5+x, 5+y));
            }
        }
        Area zonaDeConstruccion = new Area(casillasParaConstruccion);
        Plaza unaPlaza = new Plaza(zonaDeConstruccion);

        Casilla casillaArmaDeAsedio = unTablero.obtenerCasillaEn(0, 0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(casillaArmaDeAsedio);

        unArmaDeAsedio.accionar();
        
        //vida de la plaza == 375
        //Aunque la palza no esta 100% en rango, una de sus casillas lo esta
        //ya que, por ej tambien ocupa la casilla (5,5) que si esta en rango
        unArmaDeAsedio.atacar(unaPlaza);

        Assert.assertEquals(true,unaPlaza.necesitaReparacion());
        Assert.assertEquals(false,unaPlaza.estaDestruida());

        //vida de la plaza == 300
        unArmaDeAsedio.atacar(unaPlaza);
        //vida de la plaza == 225
        unArmaDeAsedio.atacar(unaPlaza);
        //vida de la plaza == 150
        unArmaDeAsedio.atacar(unaPlaza);
        //vida de la plaza == 75
        unArmaDeAsedio.atacar(unaPlaza);
        //vida de la plaza == 0
        unArmaDeAsedio.atacar(unaPlaza);

        Assert.assertEquals(true,unaPlaza.estaDestruida());
        Assert.assertEquals(true,zonaDeConstruccion.estaLibre());
    }

    @Test
    public void ataqueArmaDeAsedioAEdificioFueraDeRango() throws ErrorBasico {
    	Tablero unTablero = new Tablero(10, 10);

        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
        for(int y = 0; y < Plaza.TAMANIO_LADO; y++) {
            for(int x = 0; x < Plaza.TAMANIO_LADO; x++) {
                casillasParaConstruccion.add(unTablero.obtenerCasillaEn(6+x, 6+y));
            }
        }
        Area zonaDeConstruccion = new Area(casillasParaConstruccion);
        Plaza unaPlaza = new Plaza(zonaDeConstruccion);

        Casilla casillaCatapulta = unTablero.obtenerCasillaEn(0,0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(casillaCatapulta);

        //vida de la plaza == 450
        //tira error
     	thrown.expect(ErrorBasico.class);
     	unArmaDeAsedio.atacar(unaPlaza);

        Assert.assertEquals(false,unaPlaza.necesitaReparacion());
        Assert.assertEquals(false,unaPlaza.estaDestruida());

    }
}
