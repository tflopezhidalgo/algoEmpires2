import junit.framework.Assert;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class PlazaCentralTest {

    @Test
    public void ColocarPlaza() throws ErrorBasico { 
    	Tablero unTablero = new Tablero(5,5);

        //voy a ocupar a partir de la (2,2)
        //se ocuparan las casillas en (2,2) (2,3) (3,2) (3,3)
        Area zonaDeConstruccion = unTablero.definirArea(2, 2, Plaza.TAMANIO_LADO+1, Plaza.TAMANIO_LADO+1);
        Assert.assertEquals(true, zonaDeConstruccion.estaLibre());

        Plaza unaPlaza = new Plaza(zonaDeConstruccion);
        Assert.assertEquals(false, zonaDeConstruccion.estaLibre());
        Assert.assertEquals(false, unaPlaza.areaOcupada().estaLibre());
        Assert.assertEquals(zonaDeConstruccion, unaPlaza.areaOcupada());

        //Las casillas adyacentes deberian estar libres
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(1,1).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(4,4).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(2,1).estaOcupada());
        Assert.assertEquals(false, unTablero.obtenerCasillaEn(3,4).estaOcupada());
    }

    @Test
    public void PlazaCentralCreaAldeano() throws ErrorBasico{

        Tablero unTablero = new Tablero(5,5);

        Casilla unaCasilla = unTablero.obtenerCasillaEn(0,0);

        List<Casilla> unasCasillas = new ArrayList<Casilla>();

        for(int y = 0; y < Plaza.TAMANIO_LADO; y++) {
            for(int x = 0; x < Plaza.TAMANIO_LADO; x++) {
                unasCasillas.add(unTablero.obtenerCasillaEn(1+x, 1+y));
            }
        }

        Plaza unaPlaza = new Plaza(new Area(unasCasillas), true);

        Assert.assertNotNull(unaPlaza.crearAldeano(unaCasilla));
    }
}
