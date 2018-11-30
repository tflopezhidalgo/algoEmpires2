
import junit.framework.Assert;
import modelo.*;
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

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Plaza.TAMANIO_LADO-1, Plaza.TAMANIO_LADO-1);

        Edificio unEdificio = new Plaza(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3,3).estaOcupada());

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertTrue(unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioNecesitaReparacionCuartel() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Cuartel.TAMANIO_LADO-1, Cuartel.TAMANIO_LADO-1);

        Edificio unEdificio = new Cuartel(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3, 3).estaOcupada());

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertTrue(unEdificio.necesitaReparacion());

    }


    @Test
    public void edificioRepararCastillo() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);

        Edificio unEdificio = new Castillo(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3, 3).estaOcupada());

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertTrue(unEdificio.necesitaReparacion());

        unEdificio.reparar();

        Assert.assertFalse(unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioRepararPlaza() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Plaza.TAMANIO_LADO-1, Plaza.TAMANIO_LADO-1);

        Edificio unEdificio = new Plaza(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3, 3).estaOcupada());

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertTrue(unEdificio.necesitaReparacion());

        unEdificio.reparar();

        Assert.assertFalse(unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioRepararCuartel() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Cuartel.TAMANIO_LADO-1, Cuartel.TAMANIO_LADO-1);

        Edificio unEdificio = new Cuartel(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3, 3).estaOcupada());

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertTrue(unEdificio.necesitaReparacion());

        unEdificio.reparar();

        Assert.assertFalse(unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioConstruirCastillo() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);

        Edificio unEdificio = new Castillo(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3, 3).estaOcupada());

        Assert.assertFalse(unEdificio.enConstruccion());


    }

    @Test
    public void edificioConstruirPlaza() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Plaza.TAMANIO_LADO-1, Plaza.TAMANIO_LADO-1);

        Edificio unEdificio = new Plaza(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3, 3).estaOcupada());

        unEdificio.construir();

        Assert.assertTrue(unEdificio.enConstruccion());

        unEdificio.construir();

        Assert.assertTrue(unEdificio.enConstruccion());

        unEdificio.construir();

        Assert.assertFalse(unEdificio.enConstruccion());


    }

    @Test
    public void edificioConstruirCuartel() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Cuartel.TAMANIO_LADO-1, Cuartel.TAMANIO_LADO-1);

        Edificio unEdificio = new Cuartel(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3, 3).estaOcupada());

        unEdificio.construir();

        Assert.assertTrue(unEdificio.enConstruccion());

        unEdificio.construir();

        Assert.assertTrue(unEdificio.enConstruccion());

        unEdificio.construir();

        Assert.assertFalse(unEdificio.enConstruccion());

    }

    @Test
    public void edificioRecibirDanioDeArqueroCastillo() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);
        Edificio unEdificio = new Castillo(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3, 3).estaOcupada());

        Area espacioArquero = unTablero.definirArea(4,4,4,4);
        Arquero unArquero = new Arquero(espacioArquero);

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanioDe(unArquero);

        Assert.assertTrue(unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioRecibirDanioDeEspadachinCastillo() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);
        Edificio unEdificio = new Castillo(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3, 3).estaOcupada());

        Area espacioEspadachin = unTablero.definirArea(0, 0, 0, 0);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanioDe(unEspadachin);

        Assert.assertTrue(unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioRecibirDanioDeArqueroPlaza() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Plaza.TAMANIO_LADO-1, Plaza.TAMANIO_LADO-1);
        Edificio unEdificio = new Plaza(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3, 3).estaOcupada());

        Area espacioArquero = unTablero.definirArea(4,4,4,4);
        Arquero unArquero = new Arquero(espacioArquero);

        unEdificio.construir();
        unEdificio.construir();
        unEdificio.construir();

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanioDe(unArquero);

        Assert.assertTrue(unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioRecibirDanioDeEspadachinPlaza() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Plaza.TAMANIO_LADO-1, Plaza.TAMANIO_LADO-1);
        Edificio unEdificio = new Plaza(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3, 3).estaOcupada());

        Area espacioEspadachin = unTablero.definirArea(0, 0, 0, 0);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        unEdificio.construir();
        unEdificio.construir();
        unEdificio.construir();

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanioDe(unEspadachin);

        Assert.assertTrue(unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioRecibirDanioDeArqueroCuartel() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Cuartel.TAMANIO_LADO-1, Cuartel.TAMANIO_LADO-1);
        Edificio unEdificio = new Cuartel(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3, 3).estaOcupada());

        Area espacioArquero = unTablero.definirArea(4,4,4,4);
        Arquero unArquero = new Arquero(espacioArquero);

        unEdificio.construir();
        unEdificio.construir();
        unEdificio.construir();

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanioDe(unArquero);

        Assert.assertTrue(unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioRecibirDanioDeEspadachinCuartel() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Cuartel.TAMANIO_LADO-1, Cuartel.TAMANIO_LADO-1);
        Edificio unEdificio = new Cuartel(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3, 3).estaOcupada());

        Area espacioEspadachin = unTablero.definirArea(0, 0, 0, 0);
        Espadachin unEspadachin = new Espadachin(espacioEspadachin);

        unEdificio.construir();
        unEdificio.construir();
        unEdificio.construir();

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanioDe(unEspadachin);

        Assert.assertTrue(unEdificio.necesitaReparacion());

    }




}