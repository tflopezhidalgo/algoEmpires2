package modelo;

import modelo.excepciones.CasillaOcupadaError;
import modelo.excepciones.CastilloDeJugadorFueDestruido;
import modelo.excepciones.Excepcion;
import modelo.excepciones.PiezaYaJugoEnTurnoActualError;

public class ArmaDeAsedio extends Unidad {

    final int VIDA = 150;
    final int COSTO = 200;

    /*     -Arma de asedio-
     *
     *      Vida: 150
     *      Costo: 200
     *      Distancia de ataque: 5
     */

    //TODO: Usar state para estado Armado y Desarmado
	public ArmaDeAsedio(Area unEspacio) {

		super(unEspacio);
		vida = VIDA;
		costo = COSTO;
	}

	public void accionar() {

		ocupado = !ocupado;
	}

	public void atacar(Edificio edificioEnemigo) {
		siYaJugoElTurnoError();
		
		if(ocupado) {
			if(enRango(edificioEnemigo,5)) {
				edificioEnemigo.recibirDanio(75);
				turnoJugado = true;
			}
			
			if(edificioEnemigo.estaDestruida()) {
				edificioEnemigo = null;
			}
		}
	}	
}
