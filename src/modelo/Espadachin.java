package modelo;

import modelo.excepciones.CasillaOcupadaError;
import modelo.excepciones.Excepcion;

public class Espadachin extends Unidad {

    /*     -Espadachín-
     *
     *      Distancia de ataque: 1
     *      Vida: 100
     *      Costo: 50
     */

    //TODO: Espadachin tiene varios estados: atacar a Unidad y atacar a Edificio
	public Espadachin(Area unEspacio) {
		super(unEspacio);
		vida = 100;
		costo = 50;
	}

	//TODO: SAME ARQUERO; SOLUCIONAR!!

	public void atacar(Edificio edificioEnemigo) {
		siYaJugoElTurnoError();
		
		if(enRango(edificioEnemigo,1)) {
			edificioEnemigo.recibirDanio(15);
			turnoJugado = true;
		}
		
		if(edificioEnemigo.estaDestruida()) {
			edificioEnemigo = null;
		}
	}
	
	public void atacar(Unidad unidadEnemiga) {
		siYaJugoElTurnoError();
		
		if(enRango(unidadEnemiga,1)) {
			unidadEnemiga.recibirDanio(25);
			turnoJugado = true;
		}
		
		if(unidadEnemiga.estaDestruida()) {
			unidadEnemiga = null;
		}
	}

}
