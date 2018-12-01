package modelo.estadoArmaDeAsedio;

import modelo.excepciones.CatapultaDesarmadaNoPuedeAtacarError;

public class CatapultaDesarmada extends EstadoCatapulta {

    public EstadoCatapulta cambiarEstado(){

        return (new CatapultaArmada());
    }

    public void mover(){

    }

    public void atacar(){

        throw new CatapultaDesarmadaNoPuedeAtacarError();
    }


}
