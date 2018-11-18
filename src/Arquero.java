public class Arquero extends Unidad {

    /*      -Arquero-
     *
     *      Vida: 75
     *      Costo: 75
     *      Distancia de ataque: 3
     */

	Arquero(Area unArea) throws Excepcion {
		super(unArea);
		vida = 75;
		costo = 75;
	}

	public void atacar(Edificio edificioEnemigo) throws Excepcion {
		enRango(edificioEnemigo,3);
		edificioEnemigo.recibirDanio(10);
		
		if(edificioEnemigo.estaDestruida()) {
			edificioEnemigo = null;
		}
	}
	
	public void atacar(Unidad unidadEnemiga) throws Excepcion {
		enRango(unidadEnemiga,3);
		unidadEnemiga.recibirDanio(15);
			
		if(unidadEnemiga.estaDestruida()) {
			unidadEnemiga = null;
		}
	}
	
}
