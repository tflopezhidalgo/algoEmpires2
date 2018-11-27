package modelo.estadoCasilla;

public abstract class EstadoCasilla {


    public abstract EstadoCasilla ocupar();

    public abstract EstadoCasilla liberar();

    public abstract boolean estaOcupada();
}
