package modelo.estadoArmaDeAsedio;

import modelo.excepciones.CatapultaArmadaNoPuedeMoverseError;

public class CatapultaArmada extends EstadoCatapulta {

    public EstadoCatapulta cambiarEstado(){

        return (new CatapultaDesarmada());
    }

    public void mover(){

        throw new CatapultaArmadaNoPuedeMoverseError();
    }

    public void atacar(){


    }


}
