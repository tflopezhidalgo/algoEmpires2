import junit.framework.Assert;
import modelo.*;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class PiezaTest {

    @Test
    public void liberarUbicacionAldeano() {
        Tablero unTablero = new Tablero(3,3);

        Area espacioAldeano = unTablero.definirArea(0, 0, 0, 0);
        Pieza unaPieza = new Aldeano(espacioAldeano);

        Assert.assertNotNull(unaPieza);
        Assert.assertFalse(espacioAldeano.estaLibre());
        Assert.assertEquals(1,espacioAldeano.obtenerCantidadDeCasillas());

        unaPieza.recibirDanio(50); //Aldeano.VIDA_MAX = 50
        Assert.assertTrue(espacioAldeano.estaLibre());
    }

    @Test
    public void liberarUbicacionCuartel() {
        Tablero unTablero = new Tablero(3,3);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Cuartel.TAMANIO_LADO-1, Cuartel.TAMANIO_LADO-1);
        Edificio unaPieza = new Cuartel(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(1,1).estaOcupada());

        Assert.assertNotNull(unaPieza);
        Assert.assertFalse(zonaDeConstruccion.estaLibre());
        Assert.assertEquals(4,zonaDeConstruccion.obtenerCantidadDeCasillas());

        unaPieza.recibirDanio(250); //Aldeano.VIDA_MAX = 250
        Assert.assertTrue(zonaDeConstruccion.estaLibre());
    }


}
