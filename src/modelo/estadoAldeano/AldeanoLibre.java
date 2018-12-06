package modelo.estadoAldeano;

import modelo.Aldeano;
import modelo.Cuartel;
import modelo.Edificio;
import modelo.Plaza;

public class AldeanoLibre extends EstadoAldeano {

    public AldeanoLibre(){

        this.edificioObjetivo = null;
    }

	public EstadoAldeano reparar(Edificio unEdificio, Aldeano unAldeano){

        unEdificio.setAldeanoAsignado(unAldeano);
        return (new AldeanoReparando(unEdificio));
	}

	public EstadoAldeano construirCuartel(int x0, int y0, Aldeano unAldeano){

        Edificio unEdificio = new Cuartel(x0, y0);
        unEdificio.setAldeanoAsignado(unAldeano);
        return (new AldeanoConstruyendo(unEdificio));
    }

    public EstadoAldeano construirPlaza(int x0, int y0, Aldeano unAldeano){

        Edificio unEdificio = new Plaza(x0, y0);
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
