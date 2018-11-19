import modelo.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TableroTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void mapaSeCreaPorDefaultConTamanio16() throws Excepcion {
		Tablero unTablero = new Tablero();
		Assert.assertNotNull(unTablero.obtenerCasillaEn(15, 15));
		Assert.assertNotNull(unTablero.obtenerCasillaEn(0, 0));
		
		thrown.expect(Excepcion.class);
		unTablero.obtenerCasillaEn(16, 16);
	}
	
	@Test
	public void mapaSeCreaConTamanioIndicado() throws Excepcion {
		//Desde (0,0) a (4,4), un tablero de 5x5
		Tablero unTablero = new Tablero(5,5);
		Assert.assertNotNull(unTablero.obtenerCasillaEn(4, 4));
		Assert.assertNotNull(unTablero.obtenerCasillaEn(0, 0));
		
		thrown.expect(Excepcion.class);
		unTablero.obtenerCasillaEn(5, 5);
	}
	
	@Test
	public void noPuedoDefinirAreaFueraDeRango() throws Excepcion {
		Tablero unTablero = new Tablero();
		
		thrown.expect(Excepcion.class);
		Area area = unTablero.definirArea(0, 0, 16, 16);
		Assert.assertNull(area);
	}
	
	@Test
	public void noSePuedeMoverUnidadesFueraDelMapa() throws Excepcion {
		//16x16
		Tablero unTablero = new Tablero();
		Area espacioBorde = unTablero.definirArea(15,15,15,15);
		
		Aldeano unAldeano = new Aldeano(espacioBorde);
		Assert.assertNotNull(espacioBorde);
		Assert.assertNotNull(unAldeano);
		
		thrown.expect(Excepcion.class);
		unTablero.moverDerecha(unAldeano);
	}
	
}
