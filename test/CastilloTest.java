import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class CastilloTest {

    @Test
    public void castilloCreaCatapulta() throws ErrorBasico {
    	Tablero unTablero = new Tablero(6,6);

        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
        //voy a ocupar a partir de la (0,0)
        for(int y = 0; y < Castillo.TAMANIO_LADO; y++) {
            for(int x = 0; x < Castillo.TAMANIO_LADO; x++) {
                casillasParaConstruccion.add(unTablero.obtenerCasillaEn(x,y));
            }
        }
        Area zonaDeConstruccion = new Area(casillasParaConstruccion);

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

        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();

        //voy a ocupar a partir de la (1,1) + 3 casillas de alto y 3 de ancho
        for(int y = 0; y < Castillo.TAMANIO_LADO; y++) {
            for(int x = 0; x < Castillo.TAMANIO_LADO; x++) {
                casillasParaConstruccion.add(unTablero.obtenerCasillaEn(1+x,1+y));
            }
        }

        Area zonaDeConstruccion = new Area(casillasParaConstruccion);
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
