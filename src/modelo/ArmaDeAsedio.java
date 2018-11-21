package modelo;

import modelo.excepciones.Excepcion;

public class ArmaDeAsedio extends Unidad {

    /*     -Arma de asedio-
     *
     *      Vida: 150
     *      Costo: 200
     *      Distancia de ataque: 5
     */

	public ArmaDeAsedio(Area unEspacio) throws Excepcion {
		super(unEspacio);
		vida = 150;
		costo = 200;
	}

	public void accionar() {
		ocupado = !ocupado;
	}
	
	//distancia de ataque = 5

	public void atacar(Edificio edificioEnemigo) throws Excepcion {
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
