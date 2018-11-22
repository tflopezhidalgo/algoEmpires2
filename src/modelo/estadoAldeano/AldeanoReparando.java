package modelo.estadoAldeano;

import modelo.*;
import modelo.excepciones.*;

public class AldeanoReparando extends EstadoAldeano {

    public AldeanoReparando(Edificio unEdificio){

        this.edificioObjetivo = unEdificio;
    }

    public EstadoAldeano reparar(Edificio unEdificio){

        if(unEdificio != this.edificioObjetivo)
            throw new AldeanoOcupadoConOtroEdificioError();

        this.edificioObjetivo = unEdificio;
        unEdificio.reparar();
        return this;
    }

    public EstadoAldeano construir(Edificio unEdificio){

        throw new AldeanoReparandoNoPuedeConstruir();
    }

    public EstadoAldeano realizarTrabajoDeTurno() {
        //TODO: Buscar la forma de sacar estos if's.
        if(edificioObjetivo.necesitaReparacion()){

            edificioObjetivo.reparar();
            return this;
        }else

            return (new AldeanoLibre());
    }

}
