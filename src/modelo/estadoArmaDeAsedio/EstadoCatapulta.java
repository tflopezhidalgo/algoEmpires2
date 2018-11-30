package modelo.estadoArmaDeAsedio;

import modelo.ArmaDeAsedio;
import modelo.Pieza;

public abstract class EstadoCatapulta {

    public abstract EstadoCatapulta cambiarEstado();

    public abstract void atacar(Pieza edificioEnemigo, ArmaDeAsedio catapulta);

    public abstract void mover();
}
