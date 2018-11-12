public class Cuartel extends Edificio {
	
	static final int TAMANIO_LADO = 2;
	
	Cuartel(Area areaAOcupar) throws ErrorBasico {
		vida = 250;
		vidaMaxima = vida;
		costo = 50;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 50;
		
		casillasOcupadas = areaAOcupar;
		areaAOcupar.contruir(this);
	}

	public Espadachin crearEspadachin(Casilla ubicacion) throws ErrorBasico {
		if(ubicacion.estaOcupada()) {
			//TODO error
			throw new ErrorBasico("ERROR: La ubicacion para colocar al soldado esta ocupada.");
		}
		
		Espadachin unEspadachin = new Espadachin(ubicacion);
		return unEspadachin;
	}
	
	public Arquero crearArquero(Casilla ubicacion) throws ErrorBasico {
		if(ubicacion.estaOcupada()) {
			//TODO error
			throw new ErrorBasico("ERROR: La ubicacion para colocar al soldado esta ocupada.");
		}
		
		Arquero unArquero = new Arquero(ubicacion);
		return unArquero;
	}
	
}
