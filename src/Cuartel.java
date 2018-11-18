public class Cuartel extends Edificio {
	
	static final int TAMANIO_LADO = 2;
	
	Cuartel(Area areaAOcupar) throws Excepcion {
		vida = 250;
		vidaMaxima = vida;
		costo = 50;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 50;
		
		casillasOcupadas = areaAOcupar;
		areaAOcupar.ocupar();
	}
	
	//TODO ELIMINAR ESTO - es solo para realizar en AldeanoTest "AldeanoVuelveASumarOroLuegoDeFinalizarUnaReparacion"
	Cuartel(Area areaAOcupar, boolean yaConstruida) throws Excepcion {
		vida = 250;
		vidaMaxima = vida;
		costo = 50;
		
		tiempoDeConstruccion = 3;
		if(yaConstruida) {
			tiempoDeConstruccion = 0;
		}
		
		cantidadDeCuracion = 50;
		
		espacioOcupado = areaAOcupar;
		areaAOcupar.ocupar();
	}


	public Espadachin crearEspadachin(Area unEspacio) throws Excepcion {
		if(!unEspacio.estaLibre()) {
			throw new Excepcion("ERROR: La ubicacion para colocar al soldado esta ocupada.");
		}
		
		Espadachin unEspadachin = new Espadachin(unEspacio);
		return unEspadachin;
	}
	
	public Arquero crearArquero(Area unEspacio) throws Excepcion {
		if(!unEspacio.estaLibre()) {
			throw new Excepcion("ERROR: La ubicacion para colocar al soldado esta ocupada.");
		}
		
		Arquero unArquero = new Arquero(unEspacio);
		return unArquero;
	}
	
}
