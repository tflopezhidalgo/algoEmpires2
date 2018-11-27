package modelo.estadoAldeano;

import modelo.Area;
import modelo.Cuartel;
import modelo.Edificio;
import modelo.Plaza;
import modelo.excepciones.AldeanoConstruyendoNoPuedeReparar;
import modelo.excepciones.AldeanoOcupadoConOtroEdificioError;

public class AldeanoConstruyendo extends EstadoAldeano {

    public AldeanoConstruyendo(Edificio unEdificio){
        this.edificioObjetivo = unEdificio;
    }

    public EstadoAldeano reparar(Edificio unEdificio) {
    	throw new AldeanoConstruyendoNoPuedeReparar();
    }

	public EstadoAldeano construir(Cuartel nuevoCuartel, Area areaDeConstruccion) {
    	throw new AldeanoOcupadoConOtroEdificioError();
	}

	public EstadoAldeano construir(Plaza nuevaPlaza, Area areaDeConstruccion) {
    	throw new AldeanoOcupadoConOtroEdificioError();
	}

    public EstadoAldeano realizarTrabajoDeTurno() {
        edificioObjetivo.construir();
        if(this.edificioObjetivo.enConstruccion()) {
            return this;
        }
        return (new AldeanoLibre());
    }

}
