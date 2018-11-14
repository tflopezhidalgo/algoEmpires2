public class Arquero extends Unidad {

	Arquero() throws ErrorBasico {
	    super(new Casilla(0, 0));
		vida = 75;
		costo = 72;
	}

	Arquero(Casilla unaCasilla) throws ErrorBasico {
		super(unaCasilla);
		vida = 75;
		costo = 75;
	}
	
	//distancia de ataque = 3

	public void atacar(Edificio edificioEnemigo) throws ErrorBasico {
		enRango(edificioEnemigo,3);
		edificioEnemigo.recibirDanio(10);
		
		if(edificioEnemigo.estaDestruida()) {
			edificioEnemigo = null;
		}
	}
	
	public void atacar(Unidad unidadEnemiga) throws ErrorBasico {
		enRango(unidadEnemiga,3);
		unidadEnemiga.recibirDanio(15);
			
		if(unidadEnemiga.estaDestruida()) {
			unidadEnemiga = null;
		}
	}
	
}
