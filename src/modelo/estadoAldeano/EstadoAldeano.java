package modelo.estadoAldeano;

import modelo.Aldeano;
import modelo.Edificio;
import modelo.excepciones.AldeanOcupadoNoPuedeMoverse;

public abstract class EstadoAldeano {

    protected Edificio edificioObjetivo;

    public abstract EstadoAldeano reparar(Edificio unEdificio, Aldeano unAldeano);

    public abstract EstadoAldeano construirCuartel(int x0, int y0, Aldeano unAldeano);

    public abstract EstadoAldeano construirPlaza(int x0, int y0, Aldeano unAldeano);

	public abstract EstadoAldeano realizarTrabajoDeTurno();

	public Edificio obtenerEdificioObjetivo(){ return this.edificioObjetivo; }

	public int generarOro(){
        return 0;
    }

    public void mover() {

	    throw new AldeanOcupadoNoPuedeMoverse();
    }
}

