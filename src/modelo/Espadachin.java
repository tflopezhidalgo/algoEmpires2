package modelo;

import modelo.excepciones.Excepcion;

public class Espadachin extends Unidad {

    /*     -Espadachín-
     *
     *      Distancia de ataque: 1
     *      Vida: 100
     *      Costo: 50
     */

	public Espadachin(Area unEspacio) throws Excepcion {
		super(unEspacio);
		vida = 100;
		costo = 50;
	}

	public void atacar(Edificio edificioEnemigo) throws Excepcion {
		siYaJugoElTurnoError();
		
		if(enRango(edificioEnemigo,1)) {
			edificioEnemigo.recibirDanio(15);
			turnoJugado = true;
		}
		
		if(edificioEnemigo.estaDestruida()) {
			edificioEnemigo = null;
		}
	}
	
	public void atacar(Unidad unidadEnemiga) throws Excepcion {
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
