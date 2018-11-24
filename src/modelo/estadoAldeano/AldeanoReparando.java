package modelo.estadoAldeano;

import modelo.*;
import modelo.excepciones.*;

public class AldeanoReparando extends EstadoAldeano {

    public AldeanoReparando(Edificio unEdificio){
        this.edificioObjetivo = unEdificio;
    }

    public EstadoAldeano reparar(Edificio unEdificio){
        return this;
    }

    public EstadoAldeano construir(Edificio unEdificio){
    	return this;
    }

    public EstadoAldeano realizarTrabajoDeTurno() {
        //TODO: Buscar la forma de sacar estos if's.
        if(edificioObjetivo.necesitaReparacion()){
            edificioObjetivo.reparar();
            if(edificioObjetivo.necesitaReparacion()){
                return this;
            }
        }
        return (new AldeanoLibre());
    }

}
