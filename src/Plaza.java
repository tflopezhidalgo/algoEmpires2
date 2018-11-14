public class Plaza extends Edificio {
	
	static final int TAMANIO_LADO = 2;
	
	Plaza(Area areaAOcupar) throws ErrorBasico {
		vida = 450;
		vidaMaxima = vida;
		costo = 100;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 25;
		
		casillasOcupadas = areaAOcupar;
		areaAOcupar.construir(this);
	}
	
	Plaza(Area areaAOcupar, boolean yaConstruida) throws ErrorBasico {
		vida = 450;
		vidaMaxima = vida;
		costo = 100;
		
		tiempoDeConstruccion = 3;
		if(yaConstruida) {
			tiempoDeConstruccion = 0;
		}
		
		cantidadDeCuracion = 25;
		
		casillasOcupadas = areaAOcupar;
		areaAOcupar.construir(this);
	}
	
	public Aldeano crearAldeano(Casilla ubicacion) throws ErrorBasico {
		if(ubicacion.estaOcupada()) {
			throw new ErrorBasico("ERROR: La ubicacion para colocar al aldeano esta ocupada.");
		}
		Aldeano unAldeano = new Aldeano(ubicacion);
		return unAldeano;
	}

	
}
