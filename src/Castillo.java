
public class Castillo extends Edificio{
	
	static final int TAMANIO_LADO = 4;
	
	Castillo(Area areaAOcupar){
		vida = 1000;
		vidaMaxima = vida;
		costo = 0;
		tiempoDeConstruccion = 0;
		cantidadDeCuracion = 15;
		
		casillasOcupadas = areaAOcupar;
		areaAOcupar.contruir(this);
	}

	public void atacar(Casilla unaCasilla) throws ErrorBasico {
		Pieza unaPieza = unaCasilla.obtenerPieza();
		enRangoDeAtaque(unaCasilla);
		unaPieza.recibirDanio(20);
		
		if(unaPieza.estaDestruida()) {
			unaPieza = null;
		}
	}
	
	public Catapulta crearCatapulta(Casilla ubicacion) {
		Catapulta unaCatapulta = new Catapulta(ubicacion);
		return unaCatapulta;
	}
	
	private void enRangoDeAtaque(Casilla unaCasilla) throws ErrorBasico {
		int distancia = areaOcupada().distanciaMinimaA(unaCasilla);

		if(distancia > 3) {
			//TODO error
			throw new ErrorBasico("ERROR: Objetivo fuera de area de ataque.");
		}
	}

}
