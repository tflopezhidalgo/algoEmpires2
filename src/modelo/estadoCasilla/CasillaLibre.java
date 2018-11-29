package modelo.estadoCasilla;


public class CasillaLibre extends EstadoCasilla {

    public EstadoCasilla ocupar(){

        return (new CasillaOcupada());
    }

    public EstadoCasilla liberar(){

        return this;
    }

    public boolean estaOcupada(){

        return false;
    }
}
