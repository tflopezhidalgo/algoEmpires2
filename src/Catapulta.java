
public class Catapulta extends Unidad{
	
	Catapulta(Casilla unaCasilla){
		super(unaCasilla);
		vida = 150;
		costo = 200;
	}
	
	//estado de accionado (se puede mover/atacar)
	
	//distancia de ataque = 5
	
	//TODO check si esta bien hacer ese casteo
	public void atacar(Casilla unaCasilla) throws ErrorBasico {
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
	
}