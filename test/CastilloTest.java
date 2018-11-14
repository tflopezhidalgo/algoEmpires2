import junit.framework.Assert;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class CastilloTest {

    @Test
    public void castilloCreaCatapulta() throws ErrorBasico {
    	Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);

        Castillo unCastillo = new Castillo(zonaDeConstruccion);
        Assert.assertEquals(true, unTablero.obtenerCasillaEn(3,3).estaOcupada());

        Casilla casillaParaCatapulta = unTablero.obtenerCasillaEn(4,4);
        Assert.assertEquals(false, casillaParaCatapulta.estaOcupada());

        ArmaDeAsedio nuevaArmaDeAsedio = unCastillo.crearCatapulta(casillaParaCatapulta);
        Assert.assertEquals(true, casillaParaCatapulta.estaOcupada());
        Assert.assertEquals(casillaParaCatapulta, nuevaArmaDeAsedio.obtenerUbicacion());
    }

    @Test
    public void ColocarCastillo()  throws ErrorBasico {
    	Tablero unTablero = new Tablero(5,5);

        Area zonaDeConstruccion = unTablero.definirArea(1, 1, Castillo.TAMANIO_LADO, Castillo.TAMANIO_LADO);
        Assert.assertEquals(true, zonaDeConstruccion.estaLibre());

        Castillo unCastillo = new Castillo(zonaDeConstruccion);
        Assert.assertEquals(false, zonaDeConstruccion.estaLibre());
        Assert.assertEquals(false, unCastillo.areaOcupada().estaLibre());
        Assert.assertEquals(zonaDeConstruccion, unCastillo.areaOcupada());

        Assert.assertEquals(true, unTablero.obtenerCasillaEn(3,4).estaOcupada());
        Assert.assertEquals(true, unTablero.obtenerCasillaEn(4,4).estaOcupada());
        //Las casillas adyacentes deberian estar libres
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(0,0).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(0,2).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(0,3).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(0,4).estaOcupada());
    }
}
