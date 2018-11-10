import junit.framework.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

public class AldeanoTest {

    @Test
    public void seCreaUnAldeano(){

        Aldeano unAldeano = new Aldeano(new Posicion());
        Assert.assertNotNull(unAldeano);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaArriba(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(0, 1);

        unAldeano.moverArriba();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaAbajo(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(0, -1);

        unAldeano.moverAbajo();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaDerecha(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(1, 0);

        unAldeano.moverDerecha();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
    }

    @Test
    public void moverAldeanoUnaPosicionHaciaIzquierda(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(-1, 0);

        unAldeano.moverIzquierda();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
    }

    @Test
    public void moverAldeanoUnaPosicionArribaDerecha(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(1, 1);

        unAldeano.moverArribaDerecha();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
    }

    @Test
    public void moverAldeanoUnaPosicionArribaIzquierda(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(-1, 1);

        unAldeano.moverArribaIzquierda();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoIzquierda(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(-1, -1);

        unAldeano.moverAbajoIzquierda();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
    }

    @Test
    public void moverAldeanoUnaPosicionAbajoDerecha(){

        Aldeano unAldeano = new Aldeano(new Posicion());

        Posicion posicionAldeanoMovido = new Posicion(1, -1);

        unAldeano.moverAbajoDerecha();

        Assert.assertEquals(unAldeano.obtenerPosicion(), posicionAldeanoMovido);
    }



}

