package modelo.estadoAldeano;

import modelo.*;
import modelo.excepciones.*;

public class AldeanoConstruyendo extends EstadoAldeano {

    public AldeanoConstruyendo(Edificio unEdificio){

        this.edificioObjetivo = unEdificio;
    }

    public EstadoAldeano reparar(Edificio unEdificio) {

        throw new AldeanoConstruyendoNoPuedeReparar();
    }

    public EstadoAldeano construir(Edificio unEdificio){

        if(unEdificio != this.edificioObjetivo)
            throw new AldeanoOcupadoConOtroEdificioError();

        this.edificioObjetivo = unEdificio;
        unEdificio.construir();
        return this;
    }

    public EstadoAldeano realizarTrabajoDeTurno() {
        if(this.edificioObjetivo.enConstruccion()) {

            edificioObjetivo.construir();
            return this;
        }else

            return (new AldeanoLibre());
    }

}
