public class Plaza extends Edificio {
	
	static final int TAMANIO_LADO = 2;
	
	Plaza(Area areaAOcupar) throws Excepcion {
		vida = 450;
		vidaMaxima = vida;
		costo = 100;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 25;
		
		espacioOcupado = areaAOcupar;
		areaAOcupar.ocupar();
	}
	
	Plaza(Area areaAOcupar, boolean yaConstruida) throws Excepcion {
		vida = 450;
		vidaMaxima = vida;
		costo = 100;
		
		tiempoDeConstruccion = 3;
		if(yaConstruida) {
			tiempoDeConstruccion = 0;
		}
		
		cantidadDeCuracion = 25;
		
		espacioOcupado = areaAOcupar;
		areaAOcupar.ocupar();
	}
	
	public Aldeano crearAldeano(Area unEspacio) throws Excepcion {
		if(!unEspacio.estaLibre()) {
			throw new Excepcion("ERROR: La ubicacion para colocar al aldeano esta ocupada.");
		}
		Aldeano unAldeano = new Aldeano(unEspacio);
		return unAldeano;
	}
}
