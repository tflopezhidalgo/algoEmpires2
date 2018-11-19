package modelo;

import javafx.beans.binding.ObjectExpression;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jugador {

    static final int POBLACION_MAX = 50;

    private List<Pieza> piezas;
    private String nombreJugador;
    private int cantidadDeOro;
    private int poblacion;

    public Jugador(String unNombre){

        this.nombreJugador = unNombre;
        this.piezas = new ArrayList<>();
        this.cantidadDeOro = 100;
        this.poblacion = 0;
    }

    public void asignarPiezas(List<Pieza> piezas){

        this.piezas = piezas;

        Iterator iterador = piezas.iterator();
        while(iterador.hasNext())
            if(iterador.next() instanceof Unidad)
                this.poblacion++;

        //TODO: Chequear que la cantidad de Unidades iniciales son correctas.
    }

    public boolean castilloFueDestruido(){

        Iterator iterator = piezas.iterator();

        while(iterator.hasNext())
            if(iterator.next() instanceof Castillo)
                return false;

        return true;

    }

    public void recolectarOro() throws Exception{

        int oroRecolectado = 0;

        Iterator iterador = piezas.iterator();
        while(iterador.hasNext())
            if(iterador.next() instanceof Aldeano)
                oroRecolectado = oroRecolectado + ((Aldeano) iterador.next()).realizarTrabajoDeTurno();

    }

    //public void crearAldeano(Area)

}
