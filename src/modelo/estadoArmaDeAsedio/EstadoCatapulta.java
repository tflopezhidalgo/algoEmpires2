package modelo.estadoArmaDeAsedio;

public abstract class EstadoCatapulta {

    public abstract EstadoCatapulta cambiarEstado();

    public abstract void mover();

    public abstract void atacar();
}
