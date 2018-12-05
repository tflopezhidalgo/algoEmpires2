package modelo.estadoAldeano;

import modelo.Aldeano;
import modelo.Edificio;
import modelo.excepciones.AldeanoConstruyendoNoPuedeReparar;
import modelo.excepciones.AldeanoOcupadoConOtroEdificioError;

public class AldeanoConstruyendo extends EstadoAldeano {

    public AldeanoConstruyendo(Edificio unEdificio){

        this.edificioObjetivo = unEdificio;
    }

    public EstadoAldeano reparar(Edificio unEdificio, Aldeano unAldeano) {

    	throw new AldeanoConstruyendoNoPuedeReparar();
    }

	public EstadoAldeano construirCuartel(int x0, int y0, Aldeano unAldeano) {

    	throw new AldeanoOcupadoConOtroEdificioError();
	}

	public EstadoAldeano construirPlaza(int x0, int y0, Aldeano unAldeano){

        throw new AldeanoOcupadoConOtroEdificioError();
    }


    public EstadoAldeano realizarTrabajoDeTurno() {

        edificioObjetivo.construir();

        if(this.edificioObjetivo.enConstruccion())
            return this;

        return (new AldeanoLibre());
    }

}
