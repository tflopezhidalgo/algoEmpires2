import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CuartelTest {

    @Test
    public void ColocarCuartel() throws ErrorBasico {

        Casilla miniTablero[][] = new Casilla[5][5];

        for(int y = 0; y < 5; y++ ) {
            for(int x = 0; x < 5; x++ ) {
                Posicion unaPosicion = new Posicion(x,y);
                Casilla casilla = new Casilla(unaPosicion);

                miniTablero[x][y] = casilla;
            }
        }

        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();

        //voy a ocupar a partir de la (2,2)
        //se ocuparan las casillas en (2,2) (2,3) (3,2) (3,3)
        for(int y = 0; y < Cuartel.TAMANIO_LADO; y++) {
            for(int x = 0; x < Cuartel.TAMANIO_LADO; x++) {
                casillasParaConstruccion.add(miniTablero[2+x][2+y]);
            }
        }

        Area zonaDeConstruccion = new Area(casillasParaConstruccion);
        Assert.assertEquals(true, zonaDeConstruccion.estaLibre());

        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);
        Assert.assertEquals(false, zonaDeConstruccion.estaLibre());

        //Las casillas adyacentes deberian estar libres
        Assert.assertEquals(false, miniTablero[1][1].estaOcupada());
        Assert.assertEquals(false, miniTablero[4][4].estaOcupada());
        Assert.assertEquals(false, miniTablero[2][1].estaOcupada());
        Assert.assertEquals(false, miniTablero[3][4].estaOcupada());
    }

}
