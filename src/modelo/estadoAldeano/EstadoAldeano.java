package modelo.estadoAldeano;

import modelo.Area;
import modelo.Cuartel;
import modelo.Edificio;
import modelo.Plaza;
import modelo.excepciones.AldeanOcupadoNoPuedeMoverse;

public abstract class EstadoAldeano {

    protected Edificio edificioObjetivo;

    public abstract EstadoAldeano reparar(Edificio unEdificio);

    public abstract EstadoAldeano construir(Cuartel nuevoCuartel, Area areaDeConstruccion);

    public abstract EstadoAldeano construir(Plaza nuevaPlaza, Area areaDeConstruccion);

	public abstract EstadoAldeano realizarTrabajoDeTurno();

	public Edificio obtenerEdificioObjetivo(){ return this.edificioObjetivo; }

	public int generarOro(){
        return 0;
    }

    public void mover() {
	    throw new AldeanOcupadoNoPuedeMoverse();
    }
}

