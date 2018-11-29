import modelo.*;
import modelo.excepciones.NoSePuedeConstruirTanLejosError;
import modelo.excepciones.NoSePuedeCrearUnidadesDuranteConstruccionError;
import modelo.excepciones.PiezaYaJugoEnTurnoActualError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class CuartelTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
    @Test
    public void ColocarCuartel() throws Exception {

    	Tablero unTablero = new Tablero(5,5);

        //voy a ocupar a partir de la (2,2)
        //se ocuparan las casillas en (2,2) (2,3) (3,2) (3,3)
        Area zonaDeConstruccion = unTablero.definirArea(2, 2, Cuartel.TAMANIO_LADO+1, Cuartel.TAMANIO_LADO+1);
        Assert.assertEquals(true, zonaDeConstruccion.estaLibre());

        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);
        Assert.assertEquals(false, zonaDeConstruccion.estaLibre());
        Assert.assertEquals(false, unCuartel.obtenerAreaOcupada().estaLibre());
        Assert.assertEquals(zonaDeConstruccion, unCuartel.obtenerAreaOcupada());

        //Las casillas adyacentes deberian estar libres
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(1,1).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(4,4).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(2,1).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(3,4).estaOcupada());
    }
    
    @Test
    public void cuartelCreaEspadachin() throws Exception {

    	Tablero unTablero = new Tablero(5,5);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Cuartel.TAMANIO_LADO-1, Cuartel.TAMANIO_LADO-1);
        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);
        
        //El cuartel debe estar construido para poder crear unidades (3 turnos)
        unCuartel.construir();
        unCuartel.construir();
        unCuartel.construir();

        Area espacioEspadachin = unTablero.definirArea(1,2,1,2);
        Assert.assertEquals(true,espacioEspadachin.estaLibre());
        
        Espadachin nuevoEspadachin = unCuartel.crearEspadachin(espacioEspadachin);
        Assert.assertEquals(false,espacioEspadachin.estaLibre());
        
        //mover espadachin para arriba
        unTablero.moverEnDireccion(nuevoEspadachin,0,1);

        Casilla casillaArriba = unTablero.obtenerCasillaEn(1,3);
        Assert.assertEquals(true,espacioEspadachin.estaLibre());
        Assert.assertEquals(true,casillaArriba.estaOcupada());
        
        //tira error
        //thrown.expect(modelo.Exceptiones.Exception.class);
        //modelo.Espadachin otroEspadachin = unCuartel.crearEspadachin(casillaOtroEspadachin);
        //Assert.assertNull(otroEspadachin);
    }
    
    @Test
    public void cuartelCreaArquero() throws Exception {

    	Tablero unTablero = new Tablero(5,5);

        Area zonaDeConstruccion = unTablero.definirArea(0, 0, Cuartel.TAMANIO_LADO-1, Cuartel.TAMANIO_LADO-1);
        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);
        
        //El cuartel debe estar construido para poder crear unidades (3 turnos)
        unCuartel.construir();
        unCuartel.construir();
        unCuartel.construir();

        Area espacioArquero = unTablero.definirArea(1,2,1,2);
        Assert.assertEquals(true,espacioArquero.estaLibre());
        
        Arquero nuevoArquero = unCuartel.crearArquero(espacioArquero);
        Assert.assertEquals(false,espacioArquero.estaLibre());
        
        //mover arquero para arriba
        unTablero.moverEnDireccion(nuevoArquero,0,1);
        
        Casilla casillaOtroArquero = unTablero.obtenerCasillaEn(1,3);
        Assert.assertEquals(true,espacioArquero.estaLibre());
        Assert.assertEquals(true,casillaOtroArquero.estaOcupada());
        
        //tira error
    	//thrown.expect(modelo.Exceptiones.Exception.class);
    	//modelo.Arquero otroArquero = unCuartel.crearArquero(casillaOtroArquero);
    	//Assert.assertNull(otroArquero);
        
    }

    @Test
    public void noSePuedeCrearArqueroTanLejos() throws Exception{
        Tablero unTablero = new Tablero();
        Cuartel unCuartel = new Cuartel(unTablero.definirArea(0,0,1,1),true);

        Arquero unArquero = unCuartel.crearArquero(unTablero.definirArea(0,2,0,2));

        unCuartel.nuevoTurno();
        boolean lanzaUnError=false;
        try
        {
            Arquero otroArquero = unCuartel.crearArquero(unTablero.definirArea(3,3,3,3));
        } catch (NoSePuedeConstruirTanLejosError e)
        {
            lanzaUnError=true;
        }

        Assert.assertEquals(true, lanzaUnError);
    }

    @Test
    public void noSePuedeCrearEspadachinTanLejos() throws Exception{
        Tablero unTablero = new Tablero();
        Cuartel unCuartel = new Cuartel(unTablero.definirArea(0,0,1,1),true);

        Espadachin unEspadachin = unCuartel.crearEspadachin(unTablero.definirArea(0,2,0,2));

        unCuartel.nuevoTurno();
        boolean lanzaUnError=false;
        try
        {
            Espadachin otroEspadachin = unCuartel.crearEspadachin(unTablero.definirArea(3,3,3,3));
        } catch (NoSePuedeConstruirTanLejosError e)
        {
            lanzaUnError=true;
        }

        Assert.assertEquals(true, lanzaUnError);
    }

    @Test
    public void noSePuedeCrearUnidadDuranteConstruccion() throws Exception{
        Tablero unTablero = new Tablero();
        Aldeano unAldeano = new Aldeano(unTablero.definirArea(0,0,0,0));

        Cuartel unCuartel = unAldeano.crearCuartel(unTablero.definirArea(0,1,1,2));

        //tarda 3 turnos en construirse una plaza
        boolean lanzaUnError=false;
        try {
            unCuartel.crearArquero(unTablero.definirArea(2,1,2,1));
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertEquals(true, lanzaUnError);

        unAldeano.nuevoTurno();
        lanzaUnError=false;
        try {
            unCuartel.crearArquero(unTablero.definirArea(2,1,2,1));
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertEquals(true, lanzaUnError);

        unAldeano.nuevoTurno();
        lanzaUnError=false;
        try {
            unCuartel.crearArquero(unTablero.definirArea(2,1,2,1));
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertEquals(true, lanzaUnError);

        unAldeano.nuevoTurno();
        lanzaUnError=false;
        try {
            unCuartel.crearArquero(unTablero.definirArea(2,1,2,1));
        } catch (NoSePuedeCrearUnidadesDuranteConstruccionError e){
            lanzaUnError=true;
        }
        Assert.assertEquals(false, lanzaUnError);
    }

    @Test
    public void cuartelYaJugoEnEseTurno() throws Exception{
        Tablero unTablero = new Tablero();
        Cuartel unCuartel = new Cuartel(unTablero.definirArea(0,0,1,1), true);

        Arquero unArquero = unCuartel.crearArquero(unTablero.definirArea(2,0,2,0));

        boolean lanzaUnError=false;
        try{
            Espadachin unEspadachin = unCuartel.crearEspadachin(unTablero.definirArea(3,0,3,0));
        } catch (PiezaYaJugoEnTurnoActualError e){
            lanzaUnError=true;
        }

        Assert.assertEquals(true, lanzaUnError);


    }

}
