import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


class CuartelTest {
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
    
    @Test
    public void cuartelCreaEspadachin() throws ErrorBasico {

        Casilla miniTablero[][] = new Casilla[5][5];

        for(int y = 0; y < 5; y++ ) {
            for(int x = 0; x < 5; x++ ) {
                Posicion unaPosicion = new Posicion(x,y);
                Casilla casilla = new Casilla(unaPosicion);

                miniTablero[x][y] = casilla;
            }
        }

        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();

        //voy a ocupar a partir de la (0,0)
        for(int y = 0; y < Cuartel.TAMANIO_LADO; y++) {
            for(int x = 0; x < Cuartel.TAMANIO_LADO; x++) {
                casillasParaConstruccion.add(miniTablero[x][y]);
            }
        }

        Area zonaDeConstruccion = new Area(casillasParaConstruccion);
        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);

        Casilla casillaEspadachin = miniTablero[1][2];
        Assert.assertEquals(false,casillaEspadachin.estaOcupada());
        
        Espadachin nuevoEspadachin = unCuartel.crearEspadachin(casillaEspadachin);
        Assert.assertEquals(true,casillaEspadachin.estaOcupada());
        

        nuevoEspadachin.moverArriba();
        Casilla casillaOtroEspadachin = miniTablero[1][3];
        Assert.assertEquals(false,casillaEspadachin.estaOcupada());
        Assert.assertEquals(true,casillaOtroEspadachin.estaOcupada());
        
        /*//tira error
        Assert.assertThrows(ErrorBasico.class,
                ()->{
                	Espadachin otroEspadachin = unCuartel.crearEspadachin(casillaOtroEspadachin);
                });*/
        
    }
    
    @Test
    public void cuartelCreaArquero() throws ErrorBasico {

        Casilla miniTablero[][] = new Casilla[5][5];

        for(int y = 0; y < 5; y++ ) {
            for(int x = 0; x < 5; x++ ) {
                Posicion unaPosicion = new Posicion(x,y);
                Casilla casilla = new Casilla(unaPosicion);

                miniTablero[x][y] = casilla;
            }
        }

        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();

        //voy a ocupar a partir de la (0,0)
        for(int y = 0; y < Cuartel.TAMANIO_LADO; y++) {
            for(int x = 0; x < Cuartel.TAMANIO_LADO; x++) {
                casillasParaConstruccion.add(miniTablero[x][y]);
            }
        }

        Area zonaDeConstruccion = new Area(casillasParaConstruccion);
        Cuartel unCuartel = new Cuartel(zonaDeConstruccion);

        Casilla casillaArquero = miniTablero[1][2];
        Assert.assertEquals(false,casillaArquero.estaOcupada());
        
        Arquero nuevoArquero = unCuartel.crearArquero(casillaArquero);
        Assert.assertEquals(true,casillaArquero.estaOcupada());
        

        nuevoArquero.moverArriba();
        Casilla casillaOtroArquero = miniTablero[1][3];
        Assert.assertEquals(false,casillaArquero.estaOcupada());
        Assert.assertEquals(true,casillaOtroArquero.estaOcupada());
        
        /*//tira error
        Assert.assertThrows(ErrorBasico.class,
                ()->{
                	Arquero otroArquero = unCuartel.crearArquero(casillaOtroArquero);
                });*/
        
    }
}
