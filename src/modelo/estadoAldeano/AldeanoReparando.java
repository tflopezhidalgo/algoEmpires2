package modelo.estadoAldeano;

import modelo.Area;
import modelo.Cuartel;
import modelo.Edificio;
import modelo.Plaza;
import modelo.excepciones.AldeanoOcupadoConOtroEdificioError;
import modelo.excepciones.AldeanoReparandoNoPuedeConstruir;

public class AldeanoReparando extends EstadoAldeano {

    public AldeanoReparando(Edificio unEdificio){
        this.edificioObjetivo = unEdificio;
    }

    public EstadoAldeano reparar(Edificio unEdificio){
    	throw new AldeanoOcupadoConOtroEdificioError();
    }

	public EstadoAldeano construir(Cuartel nuevoCuartel, Area areaDeConstruccion) {
    	throw new AldeanoReparandoNoPuedeConstruir();
	}

	public EstadoAldeano construir(Plaza nuevaPlaza, Area areaDeConstruccion) {
    	throw new AldeanoReparandoNoPuedeConstruir();
	}

    public EstadoAldeano realizarTrabajoDeTurno() {
        edificioObjetivo.reparar();
        if(edificioObjetivo.vidaBaja()){
            return this;
        }
        return (new AldeanoLibre());
    }

}
