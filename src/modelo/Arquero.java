package modelo;

import modelo.excepciones.Excepcion;

public class Arquero extends Unidad {

    /*      -Arquero-
     *
     *      Vida: 75
     *      Costo: 75
     *      Distancia de ataque: 3
     */

	public Arquero(Area unEspacio) throws Excepcion {
		super(unEspacio);
		vida = 75;
		costo = 75;
	}

	public void atacar(Edificio edificioEnemigo) throws Excepcion {
		siYaJugoElTurnoError();
		
		if(enRango(edificioEnemigo,3)) {
			edificioEnemigo.recibirDanio(10);
			turnoJugado = true;
		}
		
		if(edificioEnemigo.estaDestruida()) {
			edificioEnemigo = null;
		}
	}
	
	public void atacar(Unidad unidadEnemiga) throws Excepcion {
		siYaJugoElTurnoError();
		
		if(enRango(unidadEnemiga,3)) {
			unidadEnemiga.recibirDanio(15);
			turnoJugado = true;
		}
			
		if(unidadEnemiga.estaDestruida()) {
			unidadEnemiga = null;
		}
	}
	
}
