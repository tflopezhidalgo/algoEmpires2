import modelo.*;
import modelo.excepciones.CastilloDeJugadorFueDestruido;
import modelo.excepciones.NoSePuedeConstruirTanLejosError;
import modelo.excepciones.PiezaFueraDeAlcanceError;
import modelo.excepciones.PiezaYaJugoEnTurnoActualError;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class CastilloTest {

    @Test
    public void castilloCreaCatapulta() {
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
    public void ColocarCastillo() {
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

    @Test
    public void recibirDanio() {
        Tablero unTablero = new Tablero();
        Castillo unCastillo = new Castillo(unTablero.definirArea(0,0,3,3));

        Assert.assertEquals(false, unCastillo.necesitaReparacion());

        unCastillo.recibirDanio(50);
        Assert.assertEquals(true, unCastillo.necesitaReparacion());
    }

    @Test
    public void atacarPiezaEnemiga() {
        Tablero unTablero = new Tablero();
        Castillo unCastillo = new Castillo(unTablero.definirArea(0,0,3,3));
        Aldeano unAldeano = new Aldeano(unTablero.definirArea(5,5,5,5));

        Assert.assertEquals(false, unAldeano.estaDestruida());
        unCastillo.atacar(unAldeano);
        Assert.assertEquals(false, unAldeano.estaDestruida());
        unCastillo.atacar(unAldeano);
        Assert.assertEquals(false, unAldeano.estaDestruida());
        unCastillo.atacar(unAldeano);
        Assert.assertEquals(true, unAldeano.estaDestruida());
    }
/*
    @Test //TODO: TE la debo...
    public void castilloDestruido() throws Exception{
        Tablero unTablero = new Tablero();
        Castillo unCastillo = new Castillo(unTablero.definirArea(0,0,3,3));

        unCastillo.recibirDanio(500);
        unCastillo.recibirDanio(499); //El castillo se destruye cuando llega a 0 de vida

        boolean lanzoUnError=false;
        try {
            unCastillo.recibirDanio(10);
        } catch (CastilloDeJugadorFueDestruido e)
        {
            lanzoUnError=true;
        };

        Assert.assertEquals(true, lanzoUnError);
    }
*/
    @Test
    public void noSePuedeConstruirArmaDeAsedioTanLejos() {
        Tablero unTablero = new Tablero();
        Castillo unCastillo = new Castillo(unTablero.definirArea(0,0,3,3));

        ArmaDeAsedio unaCatapulta = unCastillo.crearCatapulta(unTablero.definirArea(4,0,4,0));
        unCastillo.nuevoTurno();

        boolean lanzaUnError=false;
        try {
            ArmaDeAsedio otraCatapulta = unCastillo.crearCatapulta(unTablero.definirArea(7,0,7,0));
        } catch(NoSePuedeConstruirTanLejosError e) {
            lanzaUnError=true;
        }

        Assert.assertEquals(true, lanzaUnError);
    }

    @Test
    public void piezaFueraDeAlcanceParaAtacar() {
        Tablero unTablero = new Tablero();
        Arquero unArquero = new Arquero(unTablero.definirArea(7,7,7,7));
        Castillo unCastillo = new Castillo(unTablero.definirArea(0,0,3, 3));

        boolean lanzaUnError=false;
        try{
            unCastillo.atacar(unArquero);
        } catch (PiezaFueraDeAlcanceError e){
            lanzaUnError=true;
        }

        Assert.assertEquals(true, lanzaUnError);
    }

    @Test
    public void castilloYaJugoEnEseTurno() {
        Tablero unTablero = new Tablero();
        Castillo unCastillo = new Castillo(unTablero.definirArea(0,0,3,3));

        ArmaDeAsedio catapulta = unCastillo.crearCatapulta(unTablero.definirArea(4,0,5,1));

        boolean lanzaUnError=false;
        try {
            ArmaDeAsedio unaCatapulta = unCastillo.crearCatapulta(unTablero.definirArea(4,2,4,2));
        } catch (PiezaYaJugoEnTurnoActualError e){
            lanzaUnError=true;
        }

        Assert.assertEquals(true, lanzaUnError);


    }

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
    public void edificioConstruirCastillo() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Castillo.TAMANIO_LADO-1, Castillo.TAMANIO_LADO-1);

        Edificio unEdificio = new Castillo(zonaDeConstruccion);
        Assert.assertTrue(unTablero.obtenerCasillaEn(3, 3).estaOcupada());

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

}
