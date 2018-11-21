package modelo;

import modelo.excepciones.Excepcion;

public class Cuartel extends Edificio {
	
	public static final int TAMANIO_LADO = 2;
	
	public Cuartel(Area areaAOcupar) throws Excepcion {
		super(areaAOcupar);
		vida = 250;
		vidaMaxima = vida;
		costo = 50;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 50;
	}
	
	//TODO ELIMINAR ESTO - es solo para realizar en AldeanoTest "AldeanoVuelveASumarOroLuegoDeFinalizarUnaReparacion"
	public Cuartel(Area areaAOcupar, boolean yaConstruida) throws Excepcion {
		super(areaAOcupar);
		vida = 250;
		vidaMaxima = vida;
		costo = 50;
		
		tiempoDeConstruccion = 3;
		if(yaConstruida) {
			tiempoDeConstruccion = 0;
		}
		
		cantidadDeCuracion = 50;
	}


	public Espadachin crearEspadachin(Area unEspacio) throws Excepcion {
		siYaJugoElTurnoError();
		
		if(!unEspacio.estaLibre()) {
			throw new Excepcion("ERROR: La ubicacion para colocar al soldado esta ocupada.");
		}
		
		turnoJugado = true;
		Espadachin unEspadachin = new Espadachin(unEspacio);
		return unEspadachin;
	}
	
	public Arquero crearArquero(Area unEspacio) throws Excepcion {
		siYaJugoElTurnoError();

		if(!unEspacio.estaLibre()) {
			throw new Excepcion("ERROR: La ubicacion para colocar al soldado esta ocupada.");
		}
		
		turnoJugado = true;
		Arquero unArquero = new Arquero(unEspacio);
		return unArquero;
	}
	
}
