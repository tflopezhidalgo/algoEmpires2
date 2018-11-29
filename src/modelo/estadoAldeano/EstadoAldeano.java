package modelo.estadoAldeano;

import modelo.*;
import modelo.excepciones.AldeanOcupadoNoPuedeMoverse;

public abstract class EstadoAldeano {

    protected Edificio edificioObjetivo;

    public abstract EstadoAldeano reparar(Edificio unEdificio, Aldeano unAldeano);

    public abstract EstadoAldeano construirCuartel(Area unArea, Aldeano unAldeano);

    public abstract EstadoAldeano construirPlaza(Area unArea, Aldeano unAldeano);

	public abstract EstadoAldeano realizarTrabajoDeTurno();

	public Edificio obtenerEdificioObjetivo(){ return this.edificioObjetivo; }

	public int generarOro(){
        return 0;
    }

    public void mover() {

	    throw new AldeanOcupadoNoPuedeMoverse();
    }
}

