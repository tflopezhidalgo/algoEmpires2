package modelo.estadoAldeano;

import modelo.*;

public abstract class EstadoAldeano {

    protected Edificio edificioObjetivo;

    public abstract EstadoAldeano reparar(Edificio unEdificio);

    public abstract EstadoAldeano construir(Edificio nuevoEdificio);

	public abstract EstadoAldeano realizarTrabajoDeTurno();

	public Edificio obtenerEdificioObjetivo(){ return this.edificioObjetivo; }

	public int generarOro(){

        return 0;
    }

}

