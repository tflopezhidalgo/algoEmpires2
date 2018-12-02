import modelo.*;
import modelo.excepciones.NoSePuedeConstruirTanLejosError;
import modelo.excepciones.NoSePuedeCrearUnidadesDuranteConstruccionError;
import modelo.excepciones.PiezaYaJugoEnTurnoActualError;
import modelo.factoryCuartel.TipoGuerrero;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;

import static modelo.factoryCuartel.FactoryGuerrero.crearGuerrero;

@SuppressWarnings("deprecation")
public class CuartelTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
    @Test
    public void ColocarCuartel() {

    	Tablero unTablero = new Tablero(5,5);

        //voy a ocupar a partir de la (2,2)
        //se ocuparan las casillas en (2,2) (2,3) (3,2) (3,3)
        Area zonaDeConstruccion = unTablero.definirArea(2, 2, Cuartel.TAMANIO_LADO+1, Cuartel.TAMANIO_LADO+1);
        Assert.assertTrue(zonaDeConstruccion.estaLibre());

        Cuartel unCuartel = new Cuartel(2,2);
        Assert.assertFalse(zonaDeConstruccion.estaLibre());
        Assert.assertFalse(unCuartel.obtenerAreaOcupada().estaLibre());
        Assert.assertEquals(zonaDeConstruccion, unCuartel.obtenerAreaOcupada());

        //Las casillas adyacentes deberian estar libres
        Assert.assertFalse(unTablero.obtenerCasillaEn(1, 1).estaOcupada());
        Assert.assertFalse(unTablero.obtenerCasillaEn(4, 4).estaOcupada());
        Assert.assertFalse(unTablero.obtenerCasillaEn(2, 1).estaOcupada());
        Assert.assertFalse(unTablero.obtenerCasillaEn(3, 4).estaOcupada());
    }
    
    @Test
    public void cuartelCreaEspadachin() {

    	Tablero unTablero = new Tablero(5,5);

        Cuartel unCuartel = new Cuartel(0,0);
        
        //El cuartel debe estar construido para poder crear unidades (3 turnos)
        unCuartel.construir();
        unCuartel.construir();
        unCuartel.construir();

        Area espacioEspadachin = unTablero.definirArea(1,2,1,2);
        Assert.assertTrue(espacioEspadachin.estaLibre());
        
        Unidad nuevoEspadachin = unCuartel.crearGuerrero(1,2, TipoGuerrero.ESPADACHIN);
        Assert.assertFalse(espacioEspadachin.estaLibre());
        
        //mover espadachin para arriba
        unTablero.moverEnDireccion(nuevoEspadachin,0,1);

        Casilla casillaArriba = unTablero.obtenerCasillaEn(1,3);
        Assert.assertTrue(espacioEspadachin.estaLibre());
        Assert.assertTrue(casillaArriba.estaOcupada());
        
        //tira error
        //thrown.expect(modelo.Exceptiones.Exception.class);
        //modelo.Espadachin otroEspadachin = unCuartel.crearEspadachin(casillaOtroEspadachin);
        //Assert.assertNull(otroEspadachin);
    }
    
    @Test
    public void cuartelCreaArquero() {

    	Tablero unTablero = new Tablero();

        Cuartel unCuartel = new Cuartel(0,0);
        
        //El cuartel debe estar construido para poder crear unidades (3 turnos)
        unCuartel.construir();
        unCuartel.construir();
        unCuartel.construir();

        Area espacioArquero = unTablero.definirArea(2,0,2,0);
        Assert.assertTrue(espacioArquero.estaLibre());
        
        Unidad nuevoArquero = unCuartel.crearGuerrero(2,0, TipoGuerrero.ARQUERO);
        Assert.assertFalse(espacioArquero.estaLibre());

        //mover arquero para arriba
        unTablero.moverEnDireccion(nuevoArquero,0,1);
        
        Casilla casillaOtroArquero = unTablero.obtenerCasillaEn(2,1);
        Assert.assertTrue(espacioArquero.estaLibre());
        Assert.assertTrue(casillaOtroArquero.estaOcupada());
        
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
    	//modelo.Arquero otroArquero = unCuartel.crearArquero(casillaOtroArquero);
    	//Assert.assertNull(otroArquero);
    }

    @Test
    public void noSePuedeCrearArqueroTanLejos() {
        Tablero unTablero = new Tablero();
        Cuartel unCuartel = new Cuartel(0,0);
        unCuartel.construir();
        unCuartel.construir();
        unCuartel.construir();

        Unidad unArquero = unCuartel.crearGuerrero(0,2, TipoGuerrero.ARQUERO);

        unCuartel.nuevoTurno();
        boolean lanzaUnError=false;
        try
        {
            Unidad otroArquero = unCuartel.crearGuerrero(3,3, TipoGuerrero.ARQUERO);
        } catch (NoSePuedeConstruirTanLejosError e)
        {
            lanzaUnError=true;
        }

        Assert.assertTrue(lanzaUnError);
    }

    @Test
    public void noSePuedeCrearEspadachinTanLejos() {
        Tablero unTablero = new Tablero();
        Cuartel unCuartel = new Cuartel(0,0);

        unCuartel.construir();
        unCuartel.construir();
        unCuartel.construir();

        Unidad unEspadachin = unCuartel.crearGuerrero(0,2, TipoGuerrero.ESPADACHIN);

        unCuartel.nuevoTurno();
        boolean lanzaUnError=false;
        try
        {
            Unidad otroEspadachin = unCuartel.crearGuerrero(3,3, TipoGuerrero.ESPADACHIN);
        } catch (NoSePuedeConstruirTanLejosError e)
        {
            lanzaUnError=true;
        }

        Assert.assertTrue(lanzaUnError);
    }

    @Test
    public void noSePuedeCrearUnidadDuranteConstruccion() {
        Tablero unTablero = new Tablero();
        Aldeano unAldeano = new Aldeano(0,0);

        Cuartel unCuartel = (Cuartel) unAldeano.crearCuartel(0,1);

        //tarda 3 turnos en construirse una plaza
        boolean lanzaUnError=false;
        try {
            unCuartel.crearGuerrero(2,1, TipoGuerrero.ARQUERO);
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertTrue(lanzaUnError);

        unAldeano.nuevoTurno();
        lanzaUnError=false;
        try {
            unCuartel.crearGuerrero(2,1, TipoGuerrero.ARQUERO);
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertTrue(lanzaUnError);

        unAldeano.nuevoTurno();
        lanzaUnError=false;
        try {
            unCuartel.crearGuerrero(2,1, TipoGuerrero.ARQUERO);
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertTrue(lanzaUnError);

        unAldeano.nuevoTurno();
        lanzaUnError=false;
        try {
            unCuartel.crearGuerrero(2,1, TipoGuerrero.ARQUERO);
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertFalse(lanzaUnError);
    }

    @Test
    public void cuartelYaJugoEnEseTurno() {
        Tablero unTablero = new Tablero();
        Cuartel unCuartel = new Cuartel(0,0);

        unCuartel.construir();
        unCuartel.construir();
        unCuartel.construir();

        Unidad unArquero = unCuartel.crearGuerrero(2,0, TipoGuerrero.ARQUERO);

        boolean lanzaUnError=false;
        try{
            Unidad unEspadachin = unCuartel.crearGuerrero(0,2, TipoGuerrero.ESPADACHIN);
        } catch (PiezaYaJugoEnTurnoActualError e){
            lanzaUnError=true;
        }

        Assert.assertTrue(lanzaUnError);

    }

    @Test
    public void edificioNecesitaReparacionCuartel() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Edificio unEdificio = new Cuartel(0,0);
        Assert.assertTrue(unTablero.obtenerCasillaEn(1,1).estaOcupada());

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertTrue(unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioRepararCuartel() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Edificio unEdificio = new Cuartel(0,0);
        Assert.assertTrue(unTablero.obtenerCasillaEn(1,1).estaOcupada());

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertTrue(unEdificio.necesitaReparacion());

        unEdificio.reparar();

        Assert.assertFalse(unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioConstruirCuartel() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Edificio unEdificio = new Cuartel(0,0);
        Assert.assertTrue(unTablero.obtenerCasillaEn(1,1).estaOcupada());

        unEdificio.construir();

        Assert.assertTrue(unEdificio.enConstruccion());

        unEdificio.construir();

        Assert.assertTrue(unEdificio.enConstruccion());

        unEdificio.construir();

        Assert.assertFalse(unEdificio.enConstruccion());

    }

    @Test
    public void edificioRecibirDanioDeArqueroCuartel() throws Exception {
        Tablero unTablero = new Tablero(6,6);

        Edificio unEdificio = new Cuartel(0,0);
        Assert.assertTrue(unTablero.obtenerCasillaEn(1,1).estaOcupada());

        Arquero unArquero = new Arquero(4,4);

        unEdificio.construir();
        unEdificio.construir();
        unEdificio.construir();

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanioDe(unArquero);

        Assert.assertTrue(unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioRecibirDanioDeEspadachinCuartel() throws Exception {
        Tablero unTablero = new Tablero();

        Edificio unEdificio = new Cuartel(0,0);
        Assert.assertTrue(unTablero.obtenerCasillaEn(1,1).estaOcupada());

        Espadachin unEspadachin = new Espadachin(2,0);

        unEdificio.construir();
        unEdificio.construir();
        unEdificio.construir();

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanioDe(unEspadachin);

        Assert.assertTrue(unEdificio.necesitaReparacion());

    }

    @Test
    public void liberarUbicacionCuartel() {
        Tablero unTablero = new Tablero(6,6);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Cuartel.TAMANIO_LADO-1, Cuartel.TAMANIO_LADO-1);
        Pieza unaPieza = new Cuartel(0,0);
        Assert.assertTrue(unTablero.obtenerCasillaEn(1,1).estaOcupada());

        Assert.assertNotNull(unaPieza);
        Assert.assertFalse(zonaDeConstruccion.estaLibre());
        Assert.assertEquals(4,zonaDeConstruccion.obtenerCantidadDeCasillas());

        unaPieza.recibirDanio(250); //Cuartel.VIDA_MAX = 250
        Assert.assertTrue(zonaDeConstruccion.estaLibre());
    }

}
