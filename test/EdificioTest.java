
import junit.framework.Assert;
import modelo.Area;
import modelo.Castillo;
import modelo.Edificio;
import modelo.Tablero;
import org.junit.Test;


@SuppressWarnings("deprecation")
public class EdificioTest {

    @Test
    public void edificioNecesitaReparacion() throws Exception {
    	Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);

        Edificio unEdificio = new Castillo(zonaDeConstruccion);
        Assert.assertEquals(true, unTablero.obtenerCasillaEn(3,3).estaOcupada());

        Assert.assertEquals(false, unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertEquals(true, unEdificio.necesitaReparacion());

        }

/*
    @Test
    public void edificioReparar() throws Exception {

    }

*/

}
