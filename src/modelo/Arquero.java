package modelo;

import modelo.excepciones.CasillaOcupadaError;
import modelo.excepciones.Excepcion;

public class Arquero extends Unidad {

    /*      -Arquero-
     *
     *      Vida: 75
     *      Costo: 75
     *      Distancia de ataque: 3
     */

	public Arquero(Area unEspacio) throws CasillaOcupadaError {

		super(unEspacio);
		vida = 75;
		costo = 75;
	}


	//TODO: CODIGO REPETIDO!!

	public void atacar(Edificio edificioEnemigo) throws Exception {
		siYaJugoElTurnoError();
		
		if(enRango(edificioEnemigo,3)) {
			edificioEnemigo.recibirDanio(10);
			turnoJugado = true;
		}
		
		if(edificioEnemigo.estaDestruida())
			edificioEnemigo = null;
	}
	
	public void atacar(Unidad unidadEnemiga) throws Exception {
		siYaJugoElTurnoError();
		
		if(enRango(unidadEnemiga,3)) {
			unidadEnemiga.recibirDanio(15);
			turnoJugado = true;
		}
			
		if(unidadEnemiga.estaDestruida())
			unidadEnemiga = null;

	}
	
}
