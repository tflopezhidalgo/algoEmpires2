import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArmaDeAsedioTest {

    @Test
    void ataqueCatapultaAUnidadNoHaceDanio() throws ErrorBasico {

        Casilla miniTablero[][] = new Casilla[7][7];

        for(int y = 0; y < 7; y++ ) {
            for(int x = 0; x < 7; x++ ) {
                Posicion unaPosicion = new Posicion(x,y);
                Casilla casilla = new Casilla(unaPosicion);

                miniTablero[x][y] = casilla;
            }
        }

        Casilla casillaAldeano = miniTablero[0][0];
        Aldeano unAldeano = new Aldeano(casillaAldeano);

        Casilla casillaCatapulta = miniTablero[0][5];
        Catapulta unaCatapulta = new Catapulta(casillaCatapulta);

        //vida del aldeano == 50
        unaCatapulta.atacar(casillaAldeano);
        //o tambien usando
        //vida del aldeano == 50
        unaCatapulta.atacar(unAldeano.obtenerUbicacion());


        Assert.assertEquals(true,casillaAldeano.estaOcupada());
        Assert.assertEquals(false,unAldeano.estaDestruida());
    }

    @Test
    void ataqueCatapultaAEdificio() throws ErrorBasico {

        Casilla miniTablero[][] = new Casilla[7][7];

        for(int y = 0; y < 7; y++ ) {
            for(int x = 0; x < 7; x++ ) {
                Posicion unaPosicion = new Posicion(x,y);
                Casilla casilla = new Casilla(unaPosicion);

                miniTablero[x][y] = casilla;
            }
        }


        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
        for(int y = 0; y < Plaza.TAMANIO_LADO; y++) {
            for(int x = 0; x < Plaza.TAMANIO_LADO; x++) {
                casillasParaConstruccion.add(miniTablero[5+x][5+y]);
            }
        }
        Area zonaDeConstruccion = new Area(casillasParaConstruccion);
        Plaza unaPlaza = new Plaza(zonaDeConstruccion);

        Casilla casillaCatapulta = miniTablero[0][0];
        Catapulta unaCatapulta = new Catapulta(casillaCatapulta);

        //vida de la plaza == 375
        //Aunque la casilla que indico esta fuera del rango, el edificio que la ocupa no lo esta
        //ya que, por ej tambien ocupa la casilla (5,5) que si esta en rango
        unaCatapulta.atacar(miniTablero[6][6]);

        Assert.assertEquals(true,unaPlaza.necesitaReparacion());
        Assert.assertEquals(false,unaPlaza.estaDestruida());

        //vida de la plaza == 300
        unaCatapulta.atacar(miniTablero[5][5]);
        //vida de la plaza == 225
        unaCatapulta.atacar(miniTablero[6][5]);
        //vida de la plaza == 150
        unaCatapulta.atacar(miniTablero[5][6]);
        //vida de la plaza == 75
        unaCatapulta.atacar(miniTablero[6][6]);
        //vida de la plaza == 0
        unaCatapulta.atacar(miniTablero[5][5]);

        Assert.assertEquals(true,unaPlaza.estaDestruida());
        Assert.assertEquals(true,zonaDeConstruccion.estaLibre());
    }

    @Test
    void ataqueCatapultaAEdificioFueraDeRango() throws ErrorBasico {

        Casilla miniTablero[][] = new Casilla[10][10];

        for(int y = 0; y < 10; y++ ) {
            for(int x = 0; x < 10; x++ ) {
                Posicion unaPosicion = new Posicion(x,y);
                Casilla casilla = new Casilla(unaPosicion);

                miniTablero[x][y] = casilla;
            }
        }


        List<Casilla> casillasParaConstruccion = new ArrayList<Casilla>();
        for(int y = 0; y < Plaza.TAMANIO_LADO; y++) {
            for(int x = 0; x < Plaza.TAMANIO_LADO; x++) {
                casillasParaConstruccion.add(miniTablero[6+x][6+y]);
            }
        }
        Area zonaDeConstruccion = new Area(casillasParaConstruccion);
        Plaza unaPlaza = new Plaza(zonaDeConstruccion);

        Casilla casillaCatapulta = miniTablero[0][0];
        Catapulta unaCatapulta = new Catapulta(casillaCatapulta);

        //vida de la plaza == 450
        //TODO deberia tirar error (NO SE COMO CHEQUEAR EXCEPCIONES)
        //unaCatapulta.atacar(miniTablero[6][6]);

        Assert.assertEquals(false,unaPlaza.necesitaReparacion());
        Assert.assertEquals(false,unaPlaza.estaDestruida());

    }



}
