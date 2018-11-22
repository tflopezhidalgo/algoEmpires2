import junit.framework.Assert;

import modelo.*;
import modelo.excepciones.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("deprecation")
public class CuartelTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
    @Test
    public void ColocarCuartel() throws Exception {

    	Tablero unTablero = new Tablero(5,5);

        //voy a ocupar a partir de la (2,2)
        //se ocuparan las casillas en (2,2) (2,3) (3,2) (3,3)
        Area zonaDeConstruccion = unTablero.definirArea(2, 2, Cuartel.TAMANIO_LADO+1, Cuartel.TAMANIO_LADO+1);
        Assert.assertEquals(true, zonaDeConstruccion.estaLibre());

        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);
        Assert.assertEquals(false, zonaDeConstruccion.estaLibre());
        Assert.assertEquals(false, unCuartel.obtenerAreaOcupada().estaLibre());
        Assert.assertEquals(zonaDeConstruccion, unCuartel.obtenerAreaOcupada());

        //Las casillas adyacentes deberian estar libres
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(1,1).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(4,4).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(2,1).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(3,4).estaOcupada());
    }
    
    @Test
    public void cuartelCreaEspadachin() throws Exception {

    	Tablero unTablero = new Tablero(5,5);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Cuartel.TAMANIO_LADO-1, Cuartel.TAMANIO_LADO-1);
        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);

        Area espacioEspadachin = unTablero.definirArea(1,2,1,2);
        Assert.assertEquals(true,espacioEspadachin.estaLibre());
        
        Espadachin nuevoEspadachin = unCuartel.crearEspadachin(espacioEspadachin);
        Assert.assertEquals(false,espacioEspadachin.estaLibre());
        
        //mover espadachin para arriba
        unTablero.moverEnDireccion(nuevoEspadachin,0,1);

        Casilla casillaArriba = unTablero.obtenerCasillaEn(1,3);
        Assert.assertEquals(true,espacioEspadachin.estaLibre());
        Assert.assertEquals(true,casillaArriba.estaOcupada());
        
        //tira error
        //thrown.expect(modelo.Exceptiones.Exception.class);
        //modelo.Espadachin otroEspadachin = unCuartel.crearEspadachin(casillaOtroEspadachin);
        //Assert.assertNull(otroEspadachin);
    }
    
    @Test
    public void cuartelCreaArquero() throws Exception {

    	Tablero unTablero = new Tablero(5,5);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Cuartel.TAMANIO_LADO-1, Cuartel.TAMANIO_LADO-1);
        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);

        Area espacioArquero = unTablero.definirArea(1,2,1,2);
        Assert.assertEquals(true,espacioArquero.estaLibre());
        
        Arquero nuevoArquero = unCuartel.crearArquero(espacioArquero);
        Assert.assertEquals(false,espacioArquero.estaLibre());
        
        //mover arquero para arriba
        unTablero.moverEnDireccion(nuevoArquero,0,1);
        
        Casilla casillaOtroArquero = unTablero.obtenerCasillaEn(1,3);
        Assert.assertEquals(true,espacioArquero.estaLibre());
        Assert.assertEquals(true,casillaOtroArquero.estaOcupada());
        
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
    	//modelo.Arquero otroArquero = unCuartel.crearArquero(casillaOtroArquero);
    	//Assert.assertNull(otroArquero);
        
    }
}
