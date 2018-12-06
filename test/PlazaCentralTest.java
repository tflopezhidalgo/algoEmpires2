import javafx.scene.control.Tab;
import modelo.*;
import modelo.excepciones.NoSePuedeConstruirTanLejosError;
import modelo.excepciones.NoSePuedeCrearUnidadesDuranteConstruccionError;
import modelo.excepciones.PiezaYaJugoEnTurnoActualError;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class PlazaCentralTest {

    @Test
    public void ColocarPlaza() throws Exception { 
    	Tablero unTablero = new Tablero();

        //voy a ocupar a partir de la (2,2)
        //se ocuparan las casillas en (2,2) (2,3) (3,2) (3,3)
        Area zonaDeConstruccion = unTablero.definirArea(2, 2, Plaza.TAMANIO_LADO+1, Plaza.TAMANIO_LADO+1);
        Assert.assertTrue(zonaDeConstruccion.estaLibre());

        Plaza unaPlaza = new Plaza(2,2);
        Assert.assertFalse(zonaDeConstruccion.estaLibre());
        Assert.assertFalse(unaPlaza.obtenerAreaOcupada().estaLibre());

        //Las casillas adyacentes deberian estar libres
        Assert.assertFalse(unTablero.obtenerCasillaEn(1, 1).estaOcupada());
        Assert.assertFalse(unTablero.obtenerCasillaEn(4, 4).estaOcupada());
        Assert.assertFalse(unTablero.obtenerCasillaEn(2, 1).estaOcupada());
        Assert.assertFalse(unTablero.obtenerCasillaEn(3, 4).estaOcupada());
    }

    @Test
    public void PlazaCentralCreaAldeano() throws Exception {
        Tablero unTablero = new Tablero();

        Plaza unaPlaza = new Plaza(0,0);
        Assert.assertTrue(unTablero.obtenerCasillaEn(1, 1).estaOcupada());
        
        //La Plaza debe estar construida para poder crear unidades (3 turnos)
        unaPlaza.construir();
        unaPlaza.construir();
        unaPlaza.construir();
        
        Area espacioAldeano = unTablero.definirArea(0,2,0,2);
        Assert.assertTrue(espacioAldeano.estaLibre());
        
        Aldeano nuevoAldeano = unaPlaza.crearAldeano(0,2);
        Assert.assertFalse(espacioAldeano.estaLibre());
        Assert.assertNotNull(nuevoAldeano);
    }

    @Test
    public void noSePuedeCrearAldeanoTanLejos() throws Exception{
        Tablero unTablero = new Tablero();
        Plaza unaPlaza = new Plaza(0,0);

        unaPlaza.construir();
        unaPlaza.construir();
        unaPlaza.construir();

        Aldeano unAldeano = unaPlaza.crearAldeano(0,2);

        unaPlaza.nuevoTurno();
        boolean lanzaUnError=false;
        try {
            Aldeano otroAldeano = unaPlaza.crearAldeano(3,3);
        } catch (NoSePuedeConstruirTanLejosError e){
            lanzaUnError=true;
        }

        Assert.assertTrue(lanzaUnError);
    }

    @Test
    public void noSePuedeCrearUnidadDuranteConstruccion() throws Exception{
        Tablero unTablero = new Tablero();
        Aldeano unAldeano = new Aldeano(0,0);

        Plaza unaPlaza = (Plaza)unAldeano.crearPlaza(0,1);

        //tarda 3 turnos en construirse una plaza
        boolean lanzaUnError=false;
        try {
            unaPlaza.crearAldeano(2,1);
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertTrue(lanzaUnError);

        unAldeano.nuevoTurno();
        lanzaUnError=false;
        try {
            unaPlaza.crearAldeano(2,1);
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertTrue(lanzaUnError);

        unAldeano.nuevoTurno();
        lanzaUnError=false;
        try {
            unaPlaza.crearAldeano(2,1);
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertTrue(lanzaUnError);

        unAldeano.nuevoTurno();
        lanzaUnError=false;
        try {
            unaPlaza.crearAldeano(2,1);
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertFalse(lanzaUnError);
    }

    @Test
    public void plazaYaJugoEnEseTurno() throws Exception{
        Tablero unTablero = new Tablero();
        Plaza unaPlaza = new Plaza(0,0);

        unaPlaza.construir();
        unaPlaza.construir();
        unaPlaza.construir();

        Aldeano unAldeano = unaPlaza.crearAldeano(2,0);
        boolean lanzaUnError=false;
        try{
            Aldeano otroAldeano = unaPlaza.crearAldeano(2,1);
        } catch (PiezaYaJugoEnTurnoActualError e){
            lanzaUnError=true;
        }

        Assert.assertTrue(lanzaUnError);
    }

    @Test
    public void edificioNecesitaReparacionPlaza() throws Exception {
        Tablero unTablero = new Tablero();

        Edificio unEdificio = new Plaza(0,0);
        Assert.assertTrue(unTablero.obtenerCasillaEn(1,1).estaOcupada());

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertTrue(unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioRepararPlaza() throws Exception {
        Tablero unTablero = new Tablero();

        Edificio unEdificio = new Plaza(0,0);
        Assert.assertTrue(unTablero.obtenerCasillaEn(1,1).estaOcupada());

        Assert.assertFalse(unEdificio.necesitaReparacion());

        unEdificio.recibirDanio(15);

        Assert.assertTrue(unEdificio.necesitaReparacion());

        unEdificio.reparar();

        Assert.assertFalse(unEdificio.necesitaReparacion());

    }

    @Test
    public void edificioConstruirPlaza() throws Exception {
        Tablero unTablero = new Tablero();

        Edificio unEdificio = new Plaza(0,0);
        Assert.assertTrue(unTablero.obtenerCasillaEn(1,1).estaOcupada());

        unEdificio.construir();

        Assert.assertTrue(unEdificio.enConstruccion());

        unEdificio.construir();

        Assert.assertTrue(unEdificio.enConstruccion());

        unEdificio.construir();

        Assert.assertFalse(unEdificio.enConstruccion());

    }

    @Test
    public void edificioRecibirDanioDeArqueroPlaza() throws Exception {
        Tablero unTablero = new Tablero();

        Edificio unEdificio = new Plaza(0,0);
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
    public void edificioRecibirDanioDeEspadachinPlaza() throws Exception {
        Tablero unTablero = new Tablero();

        Edificio unEdificio = new Plaza(0,0);
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
    public void liberarUbicacionPlaza() {
        Tablero unTablero = new Tablero();

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Plaza.TAMANIO_LADO-1, Plaza.TAMANIO_LADO-1);
        Pieza unaPieza = new Plaza(0,0);
        Assert.assertTrue(unTablero.obtenerCasillaEn(1,1).estaOcupada());

        Assert.assertNotNull(unaPieza);
        Assert.assertFalse(zonaDeConstruccion.estaLibre());
        Assert.assertEquals(4,zonaDeConstruccion.obtenerCantidadDeCasillas());

        unaPieza.recibirDanio(450); //Plaza.VIDA_MAX = 450
        Assert.assertTrue(zonaDeConstruccion.estaLibre());
    }

}
