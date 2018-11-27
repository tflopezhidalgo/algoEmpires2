package modelo.estadoAldeano;

import modelo.Area;
import modelo.Cuartel;
import modelo.Edificio;
import modelo.Plaza;

public class AldeanoLibre extends EstadoAldeano {

    public AldeanoLibre(){
        this.edificioObjetivo = null;
    }

	public EstadoAldeano reparar(Edificio unEdificio){
		return (new AldeanoReparando(unEdificio));
	}

	public EstadoAldeano construir(Plaza unaPlaza, Area areaDeConstruccion){
		unaPlaza = new Plaza(areaDeConstruccion);
        return (new AldeanoConstruyendo(unaPlaza));
    }
	
	public EstadoAldeano construir(Cuartel unCuartel, Area areaDeConstruccion){
		unCuartel = new Cuartel(areaDeConstruccion);
        return (new AldeanoConstruyendo(unCuartel));
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
