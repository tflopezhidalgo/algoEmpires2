package modelo.estadoAldeano;

import modelo.*;
import modelo.excepciones.AldeanoConstruyendoNoPuedeReparar;
import modelo.excepciones.AldeanoOcupadoConOtroEdificioError;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class AldeanoConstruyendo extends EstadoAldeano {

    public AldeanoConstruyendo(Edificio unEdificio){

        this.edificioObjetivo = unEdificio;
    }

    public EstadoAldeano reparar(Edificio unEdificio, Aldeano unAldeano) {

    	throw new AldeanoConstruyendoNoPuedeReparar();
    }

	public EstadoAldeano construirCuartel(Area unArea, Aldeano unAldeano) {

    	throw new AldeanoOcupadoConOtroEdificioError();
	}

	public EstadoAldeano construirPlaza(Area unArea, Aldeano unAldeano){

        throw new AldeanoOcupadoConOtroEdificioError();
    }


    public EstadoAldeano realizarTrabajoDeTurno() {

        edificioObjetivo.construir();

        if(this.edificioObjetivo.enConstruccion())
            return this;

        return (new AldeanoLibre());
    }

}
