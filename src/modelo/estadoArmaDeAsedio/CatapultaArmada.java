package modelo.estadoArmaDeAsedio;

import modelo.Edificio;
import modelo.excepciones.CatapultaArmadaNoPuedeMoverseError;

public class CatapultaArmada extends EstadoCatapulta {

    public EstadoCatapulta cambiarEstado(){
        return (new CatapultaDesarmada());
    }

    public void atacar(Edificio edificioEnemigo){
    	edificioEnemigo.recibirDanio(75);
    }

    public void mover(){
        throw new CatapultaArmadaNoPuedeMoverseError();
    }


}
