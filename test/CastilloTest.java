import junit.framework.Assert;
import modelo.*;
import modelo.excepciones.*;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class CastilloTest {

    @Test
    public void castilloCreaCatapulta() throws Exception {
    	Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);

        Castillo unCastillo = new Castillo(zonaDeConstruccion);
        Assert.assertEquals(true, unTablero.obtenerCasillaEn(3,3).estaOcupada());

        Area espacioParaCatapulta = unTablero.definirArea(4,4,4,4);
        Assert.assertEquals(true, espacioParaCatapulta.estaLibre());

        ArmaDeAsedio nuevaArmaDeAsedio = unCastillo.crearCatapulta(espacioParaCatapulta);
        Assert.assertEquals(false, espacioParaCatapulta.estaLibre());
        Assert.assertNotNull(nuevaArmaDeAsedio);
    }

    @Test
    public void ColocarCastillo()  throws Exception {
    	Tablero unTablero = new Tablero(5,5);

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Castillo.TAMANIO_LADO, Castillo.TAMANIO_LADO);
        Assert.assertEquals(true, zonaDeConstruccion.estaLibre());

        Castillo unCastillo = new Castillo(zonaDeConstruccion);
        Assert.assertEquals(false, zonaDeConstruccion.estaLibre());
        Assert.assertEquals(false, unCastillo.obtenerAreaOcupada().estaLibre());

        Assert.assertEquals(true, unTablero.obtenerCasillaEn(3,4).estaOcupada());
        Assert.assertEquals(true, unTablero.obtenerCasillaEn(4,4).estaOcupada());
        //Las casillas adyacentes deberian estar libres
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(0,0).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(0,2).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(0,3).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(0,4).estaOcupada());
    }
}
