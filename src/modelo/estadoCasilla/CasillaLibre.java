package modelo.estadoCasilla;


import modelo.excepciones.CasillaYaEstaLibreError;

public class CasillaLibre extends EstadoCasilla {

    public EstadoCasilla ocupar(){

        return (new CasillaOcupada());
    }

    public EstadoCasilla liberar(){

        throw new CasillaYaEstaLibreError();
    }

    public boolean estaOcupada(){

        return false;
    }
}
