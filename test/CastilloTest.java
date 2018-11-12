import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CastilloTest {

    @Test
    public void castilloCreaCatapulta() {


        Casilla miniTablero[][] = new Casilla[6][6];
        for(int y = 0; y < 6; y++ ) {
            for(int x = 0; x < 6; x++ ) {
                Posicion unaPosicion = new Posicion(x,y);
                Casilla casilla = new Casilla(unaPosicion);

                miniTablero[x][y] = casilla;
            }
        }


        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
        //voy a ocupar a partir de la (0,0)
        for(int y = 0; y < Castillo.TAMANIO_LADO; y++) {
            for(int x = 0; x < Castillo.TAMANIO_LADO; x++) {
                casillasParaConstruccion.add(miniTablero[x][y]);
            }
        }
        Area zonaDeConstruccion = new Area(casillasParaConstruccion);


        Castillo unCastillo = new Castillo(zonaDeConstruccion);
        Assert.assertEquals(true, miniTablero[3][3].estaOcupada());

        Casilla casillaParaCatapulta = miniTablero[4][4];
        Assert.assertEquals(false, casillaParaCatapulta.estaOcupada());

        ArmaDeAsedio nuevaArmaDeAsedio = unCastillo.crearCatapulta(casillaParaCatapulta);
        Assert.assertEquals(true, casillaParaCatapulta.estaOcupada());
        Assert.assertEquals(casillaParaCatapulta, nuevaArmaDeAsedio.obtenerUbicacion());

    }

    @Test
    public void ColocarCastillo() {

        Casilla miniTablero[][] = new Casilla[5][5];

        for(int y = 0; y < 5; y++ ) {
            for(int x = 0; x < 5; x++ ) {
                Posicion unaPosicion = new Posicion(x,y);
                Casilla casilla = new Casilla(unaPosicion);

                miniTablero[x][y] = casilla;
            }
        }

        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();

        //voy a ocupar a partir de la (1,1) + 3 casillas de alto y 3 de ancho
        for(int y = 0; y < Castillo.TAMANIO_LADO; y++) {
            for(int x = 0; x < Castillo.TAMANIO_LADO; x++) {
                casillasParaConstruccion.add(miniTablero[1+x][1+y]);
            }
        }

        Area zonaDeConstruccion = new Area(casillasParaConstruccion);
        Assert.assertEquals(true, zonaDeConstruccion.estaLibre());

        Castillo unCastillo = new Castillo(zonaDeConstruccion);
        Assert.assertEquals(false, zonaDeConstruccion.estaLibre());


        Assert.assertEquals(true, miniTablero[3][4].estaOcupada());
        Assert.assertEquals(true, miniTablero[4][4].estaOcupada());
        //Las casillas adyacentes deberian estar libres
        Assert.assertEquals(false, miniTablero[0][0].estaOcupada());
        Assert.assertEquals(false, miniTablero[0][2].estaOcupada());
        Assert.assertEquals(false, miniTablero[0][3].estaOcupada());
        Assert.assertEquals(false, miniTablero[0][4].estaOcupada());

    }


}
