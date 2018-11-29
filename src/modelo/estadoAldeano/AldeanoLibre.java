package modelo.estadoAldeano;

import modelo.*;

public class AldeanoLibre extends EstadoAldeano {

    public AldeanoLibre(){

        this.edificioObjetivo = null;
    }

	public EstadoAldeano reparar(Edificio unEdificio, Aldeano unAldeano){

        unEdificio.setAldeanoAsignado(unAldeano);
        return (new AldeanoReparando(unEdificio));
	}

	public EstadoAldeano construirCuartel(Area area, Aldeano unAldeano){

        Edificio unEdificio = new Cuartel(area);
        unEdificio.setAldeanoAsignado(unAldeano);
        return (new AldeanoConstruyendo(unEdificio));
    }

    public EstadoAldeano construirPlaza(Area area, Aldeano unAldeano){

        Edificio unEdificio = new Plaza(area);
        unEdificio.setAldeanoAsignado(unAldeano);
        return (new AldeanoConstruyendo(unEdificio));
    }
	
	public EstadoAldeano realizarTrabajoDeTurno(){
		return this;
	}

	@Override
	public int generarOro(){ return 20;}

	@Override
    public void mover(){

    }

    @Override
    public Edificio obtenerEdificioObjetivo(){ return null; }

}
