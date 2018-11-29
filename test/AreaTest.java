import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;
import modelo.*;
import modelo.excepciones.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")

public class AreaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void calculoDeLaDistanciaMinimaDelAreaAUnaCasilla() throws Exception{

        Casilla unaCasilla = new Casilla(2,2);
        List<Casilla> unasCasillas = new ArrayList<Casilla>();
        Casilla casilla1 = new Casilla(0,0);
        Casilla casilla2 = new Casilla(0,1);
        Casilla casilla3 = new Casilla(1,0);
        Casilla casilla4 = new Casilla(1,1);

        unasCasillas.add(casilla1);
        unasCasillas.add(casilla2);
        unasCasillas.add(casilla3);
        unasCasillas.add(casilla4);

        Area unArea = new Area(unasCasillas,0,0,1,1);

        Assert.assertEquals(1, unArea.distanciaMinimaA(unaCasilla));
    }

    @Test
    public void cantidadDeCasillasQuePoseeUnArea() throws Exception{
        Casilla unaCasilla = new Casilla(2,2);
        List<Casilla> unasCasillas = new ArrayList<Casilla>();
        Casilla casilla1 = new Casilla(0,0);
        Casilla casilla2 = new Casilla(0,1);
        Casilla casilla3 = new Casilla(1,0);
        Casilla casilla4 = new Casilla(1,1);

        unasCasillas.add(casilla1);
        unasCasillas.add(casilla2);
        unasCasillas.add(casilla3);
        unasCasillas.add(casilla4);

        Area unArea = new Area(unasCasillas,0,0,1,1);

        Assert.assertEquals(4, unArea.obtenerCantidadDeCasillas());
    }

    @Test
    public void liberar() throws Exception{

        Casilla unaCasilla = new Casilla(2,2);
        List<Casilla> unasCasillas = new ArrayList<Casilla>();
        Casilla casilla1 = new Casilla(0,0);
        Casilla casilla2 = new Casilla(0,1);
        Casilla casilla3 = new Casilla(1,0);
        Casilla casilla4 = new Casilla(1,1);

        unasCasillas.add(casilla1);
        unasCasillas.add(casilla2);
        unasCasillas.add(casilla3);
        unasCasillas.add(casilla4);

        Area unArea = new Area(unasCasillas,0,0,1,1);

        unArea.ocupar();
        Assert.assertEquals(false, unArea.estaLibre());

        unArea.liberar();
        Assert.assertEquals(true, unArea.estaLibre());

    }

    @Test
    public void ocupar() throws Exception{
        Casilla unaCasilla = new Casilla(2,2);
        List<Casilla> unasCasillas = new ArrayList<Casilla>();
        Casilla casilla1 = new Casilla(0,0);
        Casilla casilla2 = new Casilla(0,1);
        Casilla casilla3 = new Casilla(1,0);
        Casilla casilla4 = new Casilla(1,1);

        unasCasillas.add(casilla1);
        unasCasillas.add(casilla2);
        unasCasillas.add(casilla3);
        unasCasillas.add(casilla4);

        Area unArea = new Area(unasCasillas,0,0,1,1);

        Assert.assertEquals(true, unArea.estaLibre());

        unArea.ocupar();
        Assert.assertEquals(false, unArea.estaLibre());
    }
}
