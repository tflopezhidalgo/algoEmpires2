public class ArmaDeAsedio extends Unidad {
	
	ArmaDeAsedio(Casilla unaCasilla) throws ErrorBasico {
		super(unaCasilla);
		vida = 150;
		costo = 200;
	}


    //estado de accionado (se puede mover/atacar) proximamente pasar a patrón state
	public void accionar() {
		ocupado = !ocupado;
	}
	
	//distancia de ataque = 5

	public void atacar(Edificio edificioEnemigo) throws ErrorBasico {
		enModoAtaque();
		
		enRango(edificioEnemigo,5);
		edificioEnemigo.recibirDanio(75);
		
		if(edificioEnemigo.estaDestruida()) {
			edificioEnemigo = null;
		}
	}
	
	private void enModoAtaque() throws ErrorBasico {
		if(!ocupado) {
			throw new ErrorBasico("ERROR: ArmaDeAsedio no esta en Modo Ataque.");
		}
	}
	
}
