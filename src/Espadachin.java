
public class Espadachin extends Unidad{
	
	Espadachin(Casilla unaCasilla){
		super(unaCasilla);
		vida = 100;
		costo = 50;
	}
	
	//distancia de ataque = 1
	
	//TODO check si esta bien hacer ese casteo
	public void atacar(Casilla unaCasilla) throws ErrorBasico {
		Pieza unaPieza = unaCasilla.obtenerPieza();
		
		if(unaPieza instanceof Edificio) {
			enRangoDeAtaque((Edificio)unaPieza);
			unaPieza.recibirDanio(15);
		}
		else {
			enRangoDeAtaque(unaCasilla);
			unaPieza.recibirDanio(25);
		}
		
		if(unaPieza.estaDestruida()) {
			unaPieza = null;
		}
	}
	
	private void enRangoDeAtaque(Casilla casillaDeUnidad) throws ErrorBasico {
		Posicion posicionA = casillaDeUnidad.obtenerPosicion();
		Posicion posicionB = obtenerUbicacion().obtenerPosicion();
		
		int distancia = Posicion.calcularDistancia(posicionA, posicionB);
		if(distancia > 1) {
			//TODO error
			throw new ErrorBasico("ERROR: Objetivo fuera de area de ataque.");
		}
	}
	
	private void enRangoDeAtaque(Edificio unEdificio) throws ErrorBasico {
		int distancia = unEdificio.areaOcupada().distanciaMinimaA(obtenerUbicacion());

		if(distancia > 1) {
			//TODO error
			throw new ErrorBasico("ERROR: Objetivo fuera de area de ataque.");
		}
	}

}
