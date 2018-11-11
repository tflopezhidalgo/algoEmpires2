import junit.framework.Assert;
import org.junit.Test;

public class ArqueroTest {

    @Test
    void ataqueArqueroADistancia() throws ErrorBasico {

        Casilla miniTablero[][] = new Casilla[4][4];

        for(int y = 0; y < 4; y++ ) {
            for(int x = 0; x < 4; x++ ) {
                Posicion unaPosicion = new Posicion(x,y);
                Casilla casilla = new Casilla(unaPosicion);

                miniTablero[x][y] = casilla;
            }
        }

        Casilla casillaAldeano = miniTablero[0][0];
        Aldeano unAldeano = new Aldeano(casillaAldeano);

        Casilla casillaArquero = miniTablero[0][3];
        Arquero unArquero = new Arquero(casillaArquero);

        //vida del aldeano == 35
        unArquero.atacar(casillaAldeano);
        //o tambien usando
        //vida del aldeano == 20
        unArquero.atacar(unAldeano.obtenerUbicacion());

        assertEquals(false,unAldeano.estaDestruida());
        assertEquals(true,casillaAldeano.estaOcupada());

        //vida del aldeano == 5
        unArquero.atacar(casillaAldeano);
        //vida del aldeano == 0
        unArquero.atacar(casillaAldeano);

        assertEquals(false,casillaAldeano.estaOcupada());
        assertEquals(true,unAldeano.estaDestruida());
    }

    @Test
    void ataqueArqueroFueraDeRango() throws ErrorBasico {

        Casilla miniTablero[][] = new Casilla[5][5];

        for(int y = 0; y < 5; y++ ) {
            for(int x = 0; x < 5; x++ ) {
                Posicion unaPosicion = new Posicion(x,y);
                Casilla casilla = new Casilla(unaPosicion);

                miniTablero[x][y] = casilla;
            }
        }

        Casilla casillaAldeano = miniTablero[0][0];
        Aldeano unAldeano = new Aldeano(casillaAldeano);

        Casilla casillaArquero = miniTablero[0][4];
        Arquero unArquero = new Arquero(casillaArquero);

        //vida del aldeano == 50
        //TODO deberia tirar error (NO SE COMO CHEQUEAR EXCEPCIONES)
        //unArquero.atacar(casillaAldeano);
        //o tambien usando
        //vida del aldeano == 50
        //TODO deberia tirar error (NO SE COMO CHEQUEAR EXCEPCIONES)
        //unArquero.atacar(unAldeano.obtenerUbicacion());


        assertEquals(true,casillaAldeano.estaOcupada());
        assertEquals(false,unAldeano.estaDestruida());
    }


}
