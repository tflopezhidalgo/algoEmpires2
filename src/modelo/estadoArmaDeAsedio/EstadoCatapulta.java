package modelo.estadoArmaDeAsedio;

import modelo.*;

public abstract class EstadoCatapulta {

    public abstract EstadoCatapulta cambiarEstado();

    public abstract void atacar(Edificio edificioEnemigo);

    public abstract void mover();
}
