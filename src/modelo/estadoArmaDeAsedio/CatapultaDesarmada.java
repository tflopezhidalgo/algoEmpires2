package modelo.estadoArmaDeAsedio;

import modelo.ArmaDeAsedio;
import modelo.Edificio;
import modelo.Pieza;
import modelo.excepciones.CatapultaDesarmadaNoPuedeAtacarError;

public class CatapultaDesarmada extends EstadoCatapulta {

    public EstadoCatapulta cambiarEstado(){

        return (new CatapultaArmada());
    }

    public void atacar(Pieza edificioEnemigo, ArmaDeAsedio catapulta){

        throw new CatapultaDesarmadaNoPuedeAtacarError();
    }

    public void mover(){


    }


}
