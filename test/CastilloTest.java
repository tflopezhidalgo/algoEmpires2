import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CastilloTest {

    @Test
    void castilloCreaCatapulta() {


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
        assertEquals(true, miniTablero[3][3].estaOcupada());

        Casilla casillaParaCatapulta = miniTablero[4][4];
        assertEquals(false, casillaParaCatapulta.estaOcupada());

        Catapulta nuevaCatapulta = unCastillo.crearCatapulta(casillaParaCatapulta);
        assertEquals(true, casillaParaCatapulta.estaOcupada());
        assertEquals(casillaParaCatapulta, nuevaCatapulta.obtenerUbicacion());

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
        assertEquals(true, zonaDeConstruccion.estaLibre());

        Castillo unCastillo = new Castillo(zonaDeConstruccion);
        assertEquals(false, zonaDeConstruccion.estaLibre());


        assertEquals(true, miniTablero[3][4].estaOcupada());
        assertEquals(true, miniTablero[4][4].estaOcupada());
        //Las casillas adyacentes deberian estar libres
        assertEquals(false, miniTablero[0][0].estaOcupada());
        assertEquals(false, miniTablero[0][2].estaOcupada());
        assertEquals(false, miniTablero[0][3].estaOcupada());
        assertEquals(false, miniTablero[0][4].estaOcupada());

    }


}
