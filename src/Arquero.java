
public class Arquero extends Unidad{
	
	Arquero(Casilla unaCasilla){
		super(unaCasilla);
		vida = 75;
		costo = 75;
	}
	
	//distancia de ataque = 3

	//TODO check si esta bien hacer ese casteo
	public void atacar(Casilla unaCasilla) throws ErrorBasico {
		Pieza unaPieza = unaCasilla.obtenerPieza();
		
		if(unaPieza instanceof Edificio) {
			enRangoDeAtaque((Edificio)unaPieza);
			unaPieza.recibirDanio(10);
		}
		else {
			enRangoDeAtaque(unaCasilla);
			unaPieza.recibirDanio(15);
		}
		
		if(unaPieza.estaDestruida()) {
			unaPieza = null;
		}
	}

	
	private void enRangoDeAtaque(Casilla casillaDeUnidad) throws ErrorBasico {
		Posicion posicionA = casillaDeUnidad.obtenerPosicion();
		Posicion posicionB = obtenerUbicacion().obtenerPosicion();
		
		int distancia = Posicion.calcularDistancia(posicionA, posicionB);
		if(distancia > 3) {
			//TODO error
			throw new ErrorBasico("ERROR: Objetivo fuera de area de ataque.");
		}
	}
	
	private void enRangoDeAtaque(Edificio unEdificio) throws ErrorBasico {
		int distancia = unEdificio.areaOcupada().distanciaMinimaA(obtenerUbicacion());

		if(distancia > 3) {
			//TODO error
			throw new ErrorBasico("ERROR: Objetivo fuera de area de ataque.");
		}
	}
	
}