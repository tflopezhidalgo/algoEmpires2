public class ArmaDeAsedio extends Unidad {

    /*     -Arma de asedio-
     *
     *      Vida: 150
     *      Costo: 200
     *      Distancia de ataque: 5
     */

	ArmaDeAsedio(Area unEspacio) throws Excepcion {
		super(unEspacio);
		vida = 150;
		costo = 200;
	}

	public void accionar() {
		ocupado = !ocupado;
	}
	
	//distancia de ataque = 5

	public void atacar(Edificio edificioEnemigo) throws Excepcion {
		if(ocupado) {
			if(enRango(edificioEnemigo,5)) {
				edificioEnemigo.recibirDanio(75);
			}
			
			if(edificioEnemigo.estaDestruida()) {
				edificioEnemigo = null;
			}
		}
	}	
}
