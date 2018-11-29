import javafx.scene.control.Tab;
import modelo.excepciones.NoSePuedeConstruirTanLejosError;
import modelo.excepciones.NoSePuedeCrearUnidadesDuranteConstruccionError;
import org.junit.Test;

import junit.framework.Assert;
import modelo.Aldeano;
import modelo.Area;
import modelo.Plaza;
import modelo.Tablero;

@SuppressWarnings("deprecation")
public class PlazaCentralTest {

    @Test
    public void ColocarPlaza() throws Exception { 
    	Tablero unTablero = new Tablero(5,5);

        //voy a ocupar a partir de la (2,2)
        //se ocuparan las casillas en (2,2) (2,3) (3,2) (3,3)
        Area zonaDeConstruccion = unTablero.definirArea(2, 2, Plaza.TAMANIO_LADO+1, Plaza.TAMANIO_LADO+1);
        Assert.assertEquals(true, zonaDeConstruccion.estaLibre());

        Plaza unaPlaza = new Plaza(zonaDeConstruccion);
        Assert.assertEquals(false, zonaDeConstruccion.estaLibre());
        Assert.assertEquals(false, unaPlaza.obtenerAreaOcupada().estaLibre());

        //Las casillas adyacentes deberian estar libres
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(1,1).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(4,4).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(2,1).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(3,4).estaOcupada());
    }

    @Test
    public void PlazaCentralCreaAldeano() throws Exception {
        Tablero unTablero = new Tablero(5,5);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Plaza.TAMANIO_LADO-1, Plaza.TAMANIO_LADO-1);

        Plaza unaPlaza = new Plaza(zonaDeConstruccion);
        Assert.assertEquals(true, unTablero.obtenerCasillaEn(1,1).estaOcupada());
        
        //La Plaza debe estar construida para poder crear unidades (3 turnos)
        unaPlaza.construir();
        unaPlaza.construir();
        unaPlaza.construir();
        
        Area espacioAldeano = unTablero.definirArea(0,2,0,2);
        Assert.assertEquals(true, espacioAldeano.estaLibre());
        
        Aldeano nuevoAldeano = unaPlaza.crearAldeano(espacioAldeano);
        Assert.assertEquals(false, espacioAldeano.estaLibre());
        Assert.assertNotNull(nuevoAldeano);
    }

    @Test
    public void noSePuedeCrearAldeanoTanLejos() throws Exception{
        Tablero unTablero = new Tablero();
        Plaza unaPlaza = new Plaza(unTablero.definirArea(0,0,1,1), true);

        Aldeano unAldeano = unaPlaza.crearAldeano(unTablero.definirArea(0,2,0,2));

        unaPlaza.nuevoTurno();
        boolean lanzaUnError=false;
        try {
            Aldeano otroAldeano = unaPlaza.crearAldeano(unTablero.definirArea(3,3,3,3));
        } catch (NoSePuedeConstruirTanLejosError e){
            lanzaUnError=true;
        }

        Assert.assertEquals(true, lanzaUnError);
    }

    @Test
    public void noSePuedeCrearUnidadDuranteConstruccion() throws Exception{
        Tablero unTablero = new Tablero();
        Aldeano unAldeano = new Aldeano(unTablero.definirArea(0,0,0,0));

        Plaza unaPlaza = unAldeano.crearPlaza(unTablero.definirArea(0,1,1,2));

        //tarda 3 turnos en construirse una plaza
        boolean lanzaUnError=false;
        try {
            unaPlaza.crearAldeano(unTablero.definirArea(2,1,2,1));
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertEquals(true, lanzaUnError);

        unAldeano.nuevoTurno();
        lanzaUnError=false;
        try {
            unaPlaza.crearAldeano(unTablero.definirArea(2,1,2,1));
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertEquals(true, lanzaUnError);

        unAldeano.nuevoTurno();
        lanzaUnError=false;
        try {
            unaPlaza.crearAldeano(unTablero.definirArea(2,1,2,1));
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertEquals(true, lanzaUnError);

        unAldeano.nuevoTurno();
        lanzaUnError=false;
        try {
            unaPlaza.crearAldeano(unTablero.definirArea(2,1,2,1));
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertEquals(false, lanzaUnError);
    }

}
