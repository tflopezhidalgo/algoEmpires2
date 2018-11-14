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
    

}
