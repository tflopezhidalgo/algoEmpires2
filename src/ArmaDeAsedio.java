public class ArmaDeAsedio extends Unidad {
	
	ArmaDeAsedio(Casilla unaCasilla) throws ErrorBasico {
		super(unaCasilla);
		vida = 150;
		costo = 200;
	}
	
	//estado de accionado (se puede mover/atacar)
	public void accionar() {
		ocupado = !ocupado;
	}
	
	//distancia de ataque = 5
	
	//TODO check si esta bien hacer ese casteo
	public void atacar(Casilla unaCasilla) throws ErrorBasico {
		enModoAtaque();
		
		Pieza unaPieza = unaCasilla.obtenerPieza();
		
		if(unaPieza instanceof Edificio) {
			enRangoDeAtaque((Edificio)unaPieza);
			unaPieza.recibirDanio(75);
		}
		
		if(unaPieza.estaDestruida()) {
			unaPieza = null;
		}
	}
	
	private void enRangoDeAtaque(Edificio unEdificio) throws ErrorBasico {
		int distancia = unEdificio.areaOcupada().distanciaMinimaA(obtenerUbicacion());

		if(distancia > 5) {
			//TODO error
			throw new ErrorBasico("ERROR: Objetivo fuera de area de ataque.");
		}
	}
	
	private void enModoAtaque() throws ErrorBasico {
		if(!ocupado) {
			//TODO error
			throw new ErrorBasico("ERROR: ArmaDeAsedio no esta en Modo Ataque.");
		}
	}
	
}
