package modelo.estadoArmaDeAsedio;

import modelo.ArmaDeAsedio;
import modelo.Edificio;
import modelo.Pieza;
import modelo.excepciones.CatapultaArmadaNoPuedeMoverseError;

public class CatapultaArmada extends EstadoCatapulta {

    public EstadoCatapulta cambiarEstado(){

        return (new CatapultaDesarmada());
    }

    public void atacar(Pieza edificioEnemigo, ArmaDeAsedio catapulta){

    	edificioEnemigo.recibirDanioDe(catapulta);
    }

    public void mover(){

        throw new CatapultaArmadaNoPuedeMoverseError();
    }


}
