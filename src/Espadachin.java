public class Espadachin extends Unidad {
	
	Espadachin(Casilla unaCasilla) throws ErrorBasico {
		super(unaCasilla);
		vida = 100;
		costo = 50;
	}
	
	//distancia de ataque = 1

	public void atacar(Edificio edificioEnemigo) throws ErrorBasico {
		enRango(edificioEnemigo,1);
		edificioEnemigo.recibirDanio(15);
		
		if(edificioEnemigo.estaDestruida()) {
			edificioEnemigo = null;
		}
	}
	
	public void atacar(Unidad unidadEnemiga) throws ErrorBasico {
		enRango(unidadEnemiga,1);
		unidadEnemiga.recibirDanio(25);
		
		if(unidadEnemiga.estaDestruida()) {
			unidadEnemiga = null;
		}
	}

}
