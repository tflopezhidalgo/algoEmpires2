import junit.framework.Assert;
import org.junit.Test;

public class EspadachinTest {

    @Test
    void ataqueEspadachin() throws ErrorBasico {

        Casilla miniTablero[][] = new Casilla[3][3];

        for(int y = 0; y < 3; y++ ) {
            for(int x = 0; x < 3; x++ ) {
                Posicion unaPosicion = new Posicion(x,y);
                Casilla casilla = new Casilla(unaPosicion);

                miniTablero[x][y] = casilla;
            }
        }

        Casilla casillaAldeano = miniTablero[1][1];
        Aldeano unAldeano = new Aldeano(casillaAldeano);

        Casilla casillaEspadachin = miniTablero[2][1];
        Espadachin unEspadachin = new Espadachin(casillaEspadachin);

        //vida del aldeano == 25
        unEspadachin.atacar(casillaAldeano);
        //o tambien usando
        //vida del aldeano == 0
        unEspadachin.atacar(unAldeano.obtenerUbicacion());

        Assert.assertEquals(false,casillaAldeano.estaOcupada());
        Assert.assertEquals(true,unAldeano.estaDestruida());
    }

    @Test
    void ataqueEspadachinFueraDeRango() throws ErrorBasico {

        Casilla miniTablero[][] = new Casilla[3][3];

        for(int y = 0; y < 3; y++ ) {
            for(int x = 0; x < 3; x++ ) {
                Posicion unaPosicion = new Posicion(x,y);
                Casilla casilla = new Casilla(unaPosicion);

                miniTablero[x][y] = casilla;
            }
        }

        Casilla casillaAldeano = miniTablero[0][0];
        Aldeano unAldeano = new Aldeano(casillaAldeano);

        Casilla casillaEspadachin = miniTablero[0][2];
        Espadachin unEspadachin = new Espadachin(casillaEspadachin);

        //vida del aldeano == 50
        //TODO deberia tirar error (NO SE COMO CHEQUEAR EXCEPCIONES)
        //unEspadachin.atacar(casillaAldeano);
        //o tambien usando
        //vida del aldeano == 50
        //TODO deberia tirar error (NO SE COMO CHEQUEAR EXCEPCIONES)
        //unEspadachin.atacar(unAldeano.obtenerUbicacion());

        Assert.assertEquals(true,casillaAldeano.estaOcupada());
        Assert.assertEquals(false,unAldeano.estaDestruida());

    }



}
