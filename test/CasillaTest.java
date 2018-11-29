import javafx.scene.control.Tab;
import modelo.estadoCasilla.CasillaOcupada;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;
import modelo.*;
import modelo.excepciones.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")

public class CasillaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void estaOcupada() throws Exception{
        Casilla unaCasilla = new Casilla(0,0);
        Assert.assertEquals(false, unaCasilla.estaOcupada());

        unaCasilla.ocupar();
        Assert.assertEquals(true, unaCasilla.estaOcupada());
    }

    @Test
    public void ocuparUnaCasilla() throws Exception{
        Tablero unTablero = new Tablero();
        Aldeano unAldeano = new Aldeano(unTablero.definirArea(0,0,0,0));
        Casilla unaCasilla = unTablero.obtenerCasillaEn(1,1);
        Casilla otraCasilla = unTablero.obtenerCasillaEn(0,0);

        Assert.assertEquals(false, unaCasilla.estaOcupada());
        Assert.assertEquals(true, otraCasilla.estaOcupada());
    }

    @Test
    public void liberarCasilla() throws Exception{

        Tablero unTablero = new Tablero();
        Aldeano unAldeano = new Aldeano(unTablero.definirArea(0,0,0,0));
        Casilla unaCasilla = unTablero.obtenerCasillaEn(0,0);

        Assert.assertEquals(true, unaCasilla.estaOcupada());

        unaCasilla.liberar();
        Assert.assertEquals(false, unaCasilla.estaOcupada());

    }

    @Test
    public void calcularDistanciaAOtraCasilla() throws Exception{

        Tablero unTablero = new Tablero();
        Casilla unaCasilla = unTablero.obtenerCasillaEn(1,1);
        Casilla otraCasilla = unTablero.obtenerCasillaEn(1,2);

        Assert.assertEquals(1, unaCasilla.calcularDistanciaA(otraCasilla));
    }

    @Test
    public void casillaInvalida() throws Exception{

        Tablero unTablero = new Tablero(); //es de 16x16
        Casilla casilla1 = unTablero.obtenerCasillaEn(1,1);
        Casilla casilla2 = unTablero.obtenerCasillaEn(5,5);

        boolean lanzoElError=false;
        try {
            Casilla casilla3 = unTablero.obtenerCasillaEn(18,18);
        } catch (CasillaInvalidaError e)
        {
            lanzoElError=true;
        };

        Assert.assertEquals(true, lanzoElError);
    }

    @Test
    public void casillaOcupada() throws Exception{

        Tablero unTablero = new Tablero();
        Casilla unaCasilla = unTablero.obtenerCasillaEn(1,1);

        unaCasilla.ocupar();

        boolean lanzoElError=false;
        try{
            unaCasilla.ocupar();
        } catch (CasillaOcupadaError e)
        {
            lanzoElError=true;
        }

        Assert.assertEquals(true, lanzoElError);
    }

    @Test
    public void casillaLibre() throws Exception{

        Tablero unTablero = new Tablero();
        Casilla unaCasilla = unTablero.obtenerCasillaEn(1,1);

        unaCasilla.ocupar();
        unaCasilla.liberar();

        boolean lanzoElError=false;
        try{
            unaCasilla.liberar();
        } catch (CasillaYaEstaLibreError e){
            lanzoElError=true;
        }

        Assert.assertEquals(true, lanzoElError);
    }

}
