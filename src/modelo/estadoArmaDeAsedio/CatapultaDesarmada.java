package modelo.estadoArmaDeAsedio;

import modelo.*;
import modelo.excepciones.CatapultaDesarmadaNoPuedeAtacarError;

public class CatapultaDesarmada extends EstadoCatapulta {

    public EstadoCatapulta cambiarEstado(){

        return (new CatapultaArmada());
    }

    public void atacar(Edificio edificioEnemigo){

        throw new CatapultaDesarmadaNoPuedeAtacarError();
    }

    public void mover(){


    }


}
