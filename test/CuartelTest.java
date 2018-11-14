import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("deprecation")
public class CuartelTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
    @Test
    public void ColocarCuartel() throws ErrorBasico {

    	Tablero unTablero = new Tablero(5,5);

        //voy a ocupar a partir de la (2,2)
        //se ocuparan las casillas en (2,2) (2,3) (3,2) (3,3)
        Area zonaDeConstruccion = unTablero.definirArea(2, 2, Cuartel.TAMANIO_LADO+1, Cuartel.TAMANIO_LADO+1);
        Assert.assertEquals(true, zonaDeConstruccion.estaLibre());

        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);
        Assert.assertEquals(false, zonaDeConstruccion.estaLibre());
        Assert.assertEquals(false, unCuartel.areaOcupada().estaLibre());
        Assert.assertEquals(zonaDeConstruccion, unCuartel.areaOcupada());

        //Las casillas adyacentes deberian estar libres
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(1,1).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(4,4).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(2,1).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(3,4).estaOcupada());
    }
    
    @Test
    public void cuartelCreaEspadachin() throws ErrorBasico {

    	Tablero unTablero = new Tablero(5,5);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Cuartel.TAMANIO_LADO-1, Cuartel.TAMANIO_LADO-1);
        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);

        Casilla casillaEspadachin = unTablero.obtenerCasillaEn(1,2);
        Assert.assertEquals(false,casillaEspadachin.estaOcupada());
        
        Espadachin nuevoEspadachin = unCuartel.crearEspadachin(casillaEspadachin);
        Assert.assertEquals(true,casillaEspadachin.estaOcupada());
        
        //mover espadachin para arriba
        unTablero.moverHasta(nuevoEspadachin, unTablero.casillaArribaDe(casillaEspadachin));

        Casilla casillaOtroEspadachin = unTablero.obtenerCasillaEn(1,3);
        Assert.assertEquals(false,casillaEspadachin.estaOcupada());
        Assert.assertEquals(true,casillaOtroEspadachin.estaOcupada());
        
        //tira error
        thrown.expect(ErrorBasico.class);                	
        Espadachin otroEspadachin = unCuartel.crearEspadachin(casillaOtroEspadachin);    
    	Assert.assertNull(otroEspadachin);
    }
    
    @Test
    public void cuartelCreaArquero() throws ErrorBasico {

    	Tablero unTablero = new Tablero(5,5);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Cuartel.TAMANIO_LADO-1, Cuartel.TAMANIO_LADO-1);
        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);

        Casilla casillaArquero = unTablero.obtenerCasillaEn(1,2);
        Assert.assertEquals(false,casillaArquero.estaOcupada());
        
        Arquero nuevoArquero = unCuartel.crearArquero(casillaArquero);
        Assert.assertEquals(true,casillaArquero.estaOcupada());
        
        //mover arquero para arriba
        unTablero.moverHasta(nuevoArquero, unTablero.casillaArribaDe(casillaArquero));
        
        Casilla casillaOtroArquero = unTablero.obtenerCasillaEn(1,3);
        Assert.assertEquals(false,casillaArquero.estaOcupada());
        Assert.assertEquals(true,casillaOtroArquero.estaOcupada());
        
        //tira error
    	thrown.expect(ErrorBasico.class);
    	Arquero otroArquero = unCuartel.crearArquero(casillaOtroArquero);
    	Assert.assertNull(otroArquero);
        
    }
}
