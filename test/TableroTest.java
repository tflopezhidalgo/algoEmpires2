import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import modelo.Aldeano;
import modelo.Area;
import modelo.Casilla;
import modelo.Castillo;
import modelo.Pieza;
import modelo.Plaza;
import modelo.Tablero;

public class TableroTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void mapaSeCreaPorDefaultConTamanio16() throws Exception {
		Tablero unTablero = new Tablero();
		Assert.assertNotNull(unTablero.obtenerCasillaEn(15, 15));
		Assert.assertNotNull(unTablero.obtenerCasillaEn(0, 0));
		
		thrown.expect(Exception.class);
		unTablero.obtenerCasillaEn(16, 16);
	}
	
	/*@Test
	public void mapaSeCreaConTamanioIndicado() throws Exception {
		//Desde (0,0) a (4,4), un tablero de 5x5
		Tablero unTablero = new Tablero(5,5);
		Assert.assertNotNull(unTablero.obtenerCasillaEn(4, 4));
		Assert.assertNotNull(unTablero.obtenerCasillaEn(0, 0));
		
		thrown.expect(Exception.class);
		unTablero.obtenerCasillaEn(5, 5);
	}*/
	
	@Test
	public void noPuedoDefinirAreaFueraDeRango() throws Exception {
		Tablero unTablero = new Tablero();
		
		thrown.expect(Exception.class);
		Area area = unTablero.definirArea(0, 0, 16, 16);
		Assert.assertNull(area);
	}
	
	@Test
	public void noSePuedeMoverUnidadesFueraDelMapa() throws Exception {
		//16x16
		Tablero unTablero = new Tablero();
		Area espacioBorde = unTablero.definirArea(15,15,15,15);
		
		Aldeano unAldeano = new Aldeano(15,15);
		Assert.assertNotNull(espacioBorde);
		Assert.assertNotNull(unAldeano);
		
		thrown.expect(Exception.class);
		unTablero.moverEnDireccion(unAldeano,1,0);
	}

	@Test
	public void piezasInicialesDelEquipo1BienGeneradas() throws Exception {

		Tablero unTablero = new Tablero();
		List<Pieza> piezas = unTablero.generarPiezasInicialesEquipo1();
		int cantidadDePiezasIniciales = piezas.size();

		boolean cumple=false;
		for (int i=0; i<cantidadDePiezasIniciales; i++){
			if (piezas.get(i) instanceof Aldeano){
				cumple=true;
			}
			else{
				if (piezas.get(i) instanceof Castillo){
					cumple=true;
				}
				else{
					if (piezas.get(i) instanceof Plaza)
					{
						cumple=true;
					}
				}
			}
		}

		Assert.assertEquals(true, cumple);
	}

	@Test
	public void piezasInicialesDelEquipo2BienGeneradas() throws Exception {

		Tablero unTablero = new Tablero();
		List<Pieza> piezas = unTablero.generarPiezasInicialesEquipo2();
		int cantidadDePiezasIniciales = piezas.size();

		boolean cumple=false;
		for (int i=0; i<cantidadDePiezasIniciales; i++){
			if (piezas.get(i) instanceof Aldeano){
				cumple=true;
			}
			else{
				if (piezas.get(i) instanceof Castillo){
					cumple=true;
				}
				else{
					if (piezas.get(i) instanceof Plaza)
					{
						cumple=true;
					}
				}
			}
		}

		Assert.assertEquals(true, cumple);
	}

	@Test
	public void liberarUnArea() throws Exception {

		Tablero unTablero = new Tablero();
		Area unArea = unTablero.definirArea(0, 0, 5, 5);

		unArea.ocupar();
		Assert.assertEquals(false, unArea.estaLibre());

		unTablero.liberar(unArea);
		Assert.assertEquals(true, unArea.estaLibre());
	}

	@Test
	public void liberarUnaCasilla() throws Exception {

		Tablero unTablero = new Tablero();
		Casilla unaCasilla = new Casilla(1,1);

		unaCasilla.ocupar();
		Assert.assertEquals(true, unaCasilla.estaOcupada());

		unTablero.liberar(unaCasilla);
		Assert.assertEquals(false, unaCasilla.estaOcupada());
	}

	@Test
    public void moverAUnaUnidad() throws Exception{
        Tablero unTablero = new Tablero();
        Aldeano unAldeano = new Aldeano(1,1);
        Casilla unaCasilla = unTablero.obtenerCasillaEn(2,2);

        Assert.assertFalse(unaCasilla.estaOcupada());

        unTablero.moverEnDireccion(unAldeano,1,1);
        Casilla casillaDeAldeano = unaCasilla;

        Assert.assertTrue(casillaDeAldeano.estaOcupada());
    }

    @Test
    public void casillaNoExiste() throws Exception{
        Tablero unTablero = new Tablero();
        Casilla unaCasilla = unTablero.obtenerCasillaEn(1,1);
        Casilla unaCasilla2 = unTablero.obtenerCasillaEn(5,5);
        Casilla unaCasilla3 = unTablero.obtenerCasillaEn(15,15);

        thrown.expect(Exception.class);
        Casilla unaCasilla4 = unTablero.obtenerCasillaEn(18,18);
    }

}
