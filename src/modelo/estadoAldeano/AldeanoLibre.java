package modelo.estadoAldeano;

import modelo.*;

public class AldeanoLibre extends EstadoAldeano {

    public AldeanoLibre(){

        this.edificioObjetivo = null;
    }

	public EstadoAldeano reparar(Edificio unEdificio){
		return (new AldeanoReparando(unEdificio));
	}

	public EstadoAldeano construir(Edificio unEdificio){
        return (new AldeanoConstruyendo(unEdificio));
    }
	
	public EstadoAldeano realizarTrabajoDeTurno(){
		return this;
	}

	@Override
	public int generarOro(){ return 20;}

	@Override
    public Edificio obtenerEdificioObjetivo(){ return null; }

}
