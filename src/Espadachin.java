public class Espadachin extends Unidad {

    /*     -Espadachín-
     *
     *      Distancia de ataque: 1
     *      Vida: 100
     *      Costo: 50
     */

	Espadachin(Area unEspacio) throws Excepcion {
		super(unEspacio);
		vida = 100;
		costo = 50;
	}

	public void atacar(Edificio edificioEnemigo) throws Excepcion {
		if(enRango(edificioEnemigo,1)) {
			edificioEnemigo.recibirDanio(15);
		}
		
		if(edificioEnemigo.estaDestruida()) {
			edificioEnemigo = null;
		}
	}
	
	public void atacar(Unidad unidadEnemiga) throws Excepcion {
		if(enRango(unidadEnemiga,1)) {
			unidadEnemiga.recibirDanio(25);
		}
		
		if(unidadEnemiga.estaDestruida()) {
			unidadEnemiga = null;
		}
	}

}
