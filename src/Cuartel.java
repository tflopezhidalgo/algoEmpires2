public class Cuartel extends Edificio {
	
	static final int TAMANIO_LADO = 2;
	
	Cuartel(Area areaAOcupar) throws Excepcion {
		vida = 250;
		vidaMaxima = vida;
		costo = 50;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 50;
		
		casillasOcupadas = areaAOcupar;
		areaAOcupar.construir(this);
	}
	
/*	//TODO ELIMINAR ESTO
	Cuartel(Area areaAOcupar, boolean yaConstruida) throws Excepcion {
		vida = 250;
		vidaMaxima = vida;
		costo = 50;
		
		tiempoDeConstruccion = 3;
		if(yaConstruida) {
			tiempoDeConstruccion = 0;
		}
		
		cantidadDeCuracion = 50;
		
		casillasOcupadas = areaAOcupar;
		areaAOcupar.construir(this);
	}
*/
	Cuartel(Area areaAOcupar, boolean yaConstruida) throws Excepcion {
		vida = 250;
		vidaMaxima = vida;
		costo = 50;
		tiempoDeConstruccion = 3;
		if(yaConstruida){
			tiempoDeConstruccion=0;
		}
		cantidadDeCuracion = 50;

		casillasOcupadas = areaAOcupar;
		areaAOcupar.construir(this);
	}

	public Espadachin crearEspadachin(Casilla ubicacion) throws Excepcion {
		if(ubicacion.estaOcupada()) {
			throw new Excepcion("ERROR: La ubicacion para colocar al soldado esta ocupada.");
		}
		
		Espadachin unEspadachin = new Espadachin(ubicacion);
		return unEspadachin;
	}
	
	public Arquero crearArquero(Casilla ubicacion) throws Excepcion {
		if(ubicacion.estaOcupada()) {
			throw new Excepcion("ERROR: La ubicacion para colocar al soldado esta ocupada.");
		}
		
		Arquero unArquero = new Arquero(ubicacion);
		return unArquero;
	}
	
}
