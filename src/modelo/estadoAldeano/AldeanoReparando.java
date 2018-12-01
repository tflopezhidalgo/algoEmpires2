package modelo.estadoAldeano;

import modelo.Aldeano;
import modelo.Area;
import modelo.Edificio;
import modelo.excepciones.AldeanoOcupadoConOtroEdificioError;
import modelo.excepciones.AldeanoReparandoNoPuedeConstruir;

public class AldeanoReparando extends EstadoAldeano {

    public AldeanoReparando(Edificio unEdificio){

        this.edificioObjetivo = unEdificio;
    }

    public EstadoAldeano reparar(Edificio unEdificio, Aldeano unAldeano){

        throw new AldeanoOcupadoConOtroEdificioError();
    }

	public EstadoAldeano construirCuartel(int x0, int y0, Aldeano unAldeano) {

    	throw new AldeanoReparandoNoPuedeConstruir();
	}

	public EstadoAldeano construirPlaza(int x0, int y0, Aldeano unAldeano){

        throw new AldeanoReparandoNoPuedeConstruir();
    }

    public EstadoAldeano realizarTrabajoDeTurno() {
        edificioObjetivo.reparar();

        if(edificioObjetivo.vidaBaja()) {
            return this;
        }
        return (new AldeanoLibre());
    }

}
