package modelo.estadoAldeano;

import modelo.*;

public abstract class EstadoAldeano {

    protected Edificio edificioObjetivo;

    public abstract EstadoAldeano reparar(Edificio unEdificio) throws Exception;

    public abstract EstadoAldeano construir(Edificio nuevoEdificio) throws Exception;

	public abstract EstadoAldeano realizarTrabajoDeTurno();

	public Edificio obtenerEdificioObjetivo(){ return this.edificioObjetivo; }

	public int generarOro(){

        return 0;
    }

}

