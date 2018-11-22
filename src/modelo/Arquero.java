package modelo;

import modelo.excepciones.*;

public class Arquero extends Unidad {

    /*      -Arquero-
     *
     *      Vida: 75
     *      Costo: 75
     *      Distancia de ataque: 3
     */


    //TODO: El arquero tiene varios estados, uno es atacando a unidad y otro atacando a edificio.
	public Arquero(Area unEspacio) {

		super(unEspacio);
		vida = 75;
		costo = 75;
	}


	//TODO: CODIGO REPETIDO!!

	public void atacar(Edificio edificioEnemigo) {
		siYaJugoElTurnoError();
		
		if(enRango(edificioEnemigo,3)) {
			edificioEnemigo.recibirDanio(10);
			turnoJugado = true;
		}
		
		if(edificioEnemigo.estaDestruida())
			edificioEnemigo = null;
	}
	
	public void atacar(Unidad unidadEnemiga) {
		siYaJugoElTurnoError();
		
		if(enRango(unidadEnemiga,3)) {
			unidadEnemiga.recibirDanio(15);
			turnoJugado = true;
		}
			
		if(unidadEnemiga.estaDestruida())
			unidadEnemiga = null;

	}
	
}
