
import junit.framework.Assert;
import modelo.*;
import modelo.excepciones.EdificioNoAdmiteAreaIncorrectaError;
import org.junit.Test;


@SuppressWarnings("deprecation")
public class EdificioTest {

    @Test
    public void edificioNecesitaReparacionCastillo() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);

        Edificio unEdificio = new Castillo(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3,3).estaOcupada());

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertTrue(unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioNecesitaReparacionPlaza() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);

        Edificio unEdificio = new Plaza(zonaDeConstruccion);
        Assert.assertEquals(true, unTablero.obtenerCasillaEn(3,3).estaOcupada());

        Assert.assertEquals(false, unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertEquals(true, unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioNecesitaReparacionCuartel() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);

        Edificio unEdificio = new Cuartel(zonaDeConstruccion);
        Assert.assertEquals(true, unTablero.obtenerCasillaEn(3,3).estaOcupada());

        Assert.assertEquals(false, unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertEquals(true, unEdificio.necesitaReparacion());

    }


    @Test
    public void edificioRepararCastillo() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);

        Edificio unEdificio = new Castillo(zonaDeConstruccion);
        Assert.assertEquals(true, unTablero.obtenerCasillaEn(3,3).estaOcupada());

        Assert.assertEquals(false, unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertEquals(true, unEdificio.necesitaReparacion());

        unEdificio.reparar();

        Assert.assertEquals(false, unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioRepararPlaza() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);

        Edificio unEdificio = new Plaza(zonaDeConstruccion);
        Assert.assertEquals(true, unTablero.obtenerCasillaEn(3,3).estaOcupada());

        Assert.assertEquals(false, unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertEquals(true, unEdificio.necesitaReparacion());

        unEdificio.reparar();

        Assert.assertEquals(false, unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioRepararCuartel() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);

        Edificio unEdificio = new Cuartel(zonaDeConstruccion);
        Assert.assertEquals(true, unTablero.obtenerCasillaEn(3,3).estaOcupada());

        Assert.assertEquals(false, unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertEquals(true, unEdificio.necesitaReparacion());

        unEdificio.reparar();

        Assert.assertEquals(false, unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioConstruirCastillo() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);

        Edificio unEdificio = new Castillo(zonaDeConstruccion);
        Assert.assertEquals(true, unTablero.obtenerCasillaEn(3,3).estaOcupada());

        Assert.assertEquals(false, unEdificio.enConstruccion());


    }

    @Test
    public void edificioConstruirPlaza() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);

        Edificio unEdificio = new Plaza(zonaDeConstruccion);
        Assert.assertEquals(true, unTablero.obtenerCasillaEn(3,3).estaOcupada());

        unEdificio.construir();

        Assert.assertEquals(true, unEdificio.enConstruccion());

        unEdificio.construir();

        Assert.assertEquals(true, unEdificio.enConstruccion());

        unEdificio.construir();

        Assert.assertEquals(false, unEdificio.enConstruccion());


    }

    @Test
    public void edificioConstruirCuartel() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);

        Edificio unEdificio = new Cuartel(zonaDeConstruccion);
        Assert.assertEquals(true, unTablero.obtenerCasillaEn(3,3).estaOcupada());

        unEdificio.construir();

        Assert.assertEquals(true, unEdificio.enConstruccion());

        unEdificio.construir();

        Assert.assertEquals(true, unEdificio.enConstruccion());

        unEdificio.construir();

        Assert.assertEquals(false, unEdificio.enConstruccion());


    }

}