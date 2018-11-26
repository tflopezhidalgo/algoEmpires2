package modelo.estadoCasilla;

import modelo.excepciones.CasillaOcupadaError;

public class CasillaOcupada extends EstadoCasilla {

    public EstadoCasilla ocupar(){

        throw new CasillaOcupadaError();
    }

    public EstadoCasilla liberar(){

        return (new CasillaLibre());
    }

    public boolean estaOcupada(){

        return true;
    }
}
