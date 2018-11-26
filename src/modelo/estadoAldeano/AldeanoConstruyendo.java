package modelo.estadoAldeano;

import modelo.*;
import modelo.excepciones.*;

public class AldeanoConstruyendo extends EstadoAldeano {

    public AldeanoConstruyendo(Edificio unEdificio){
        this.edificioObjetivo = unEdificio;
    }

    public EstadoAldeano reparar(Edificio unEdificio) {
        return this;
    }

    public EstadoAldeano construir(Edificio unEdificio){
        return this;
    }

    public EstadoAldeano realizarTrabajoDeTurno() {
        if(this.edificioObjetivo.enConstruccion()) {
            edificioObjetivo.construir();
            if(this.edificioObjetivo.enConstruccion()) {
                return this;
            }
        }
        return (new AldeanoLibre());
    }


}
