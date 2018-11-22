package modelo;

import modelo.excepciones.CasillaOcupadaError;
import modelo.excepciones.Excepcion;

public class Cuartel extends Edificio {
	
	public static final int TAMANIO_LADO = 2;
	
	public Cuartel(Area areaAOcupar) throws CasillaOcupadaError {
		super(areaAOcupar);
		vida = 250;
		vidaMaxima = vida;
		costo = 50;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 50;
	}
	
	//TODO: ELIMINAR ESTO - es solo para realizar en AldeanoTest "AldeanoVuelveASumarOroLuegoDeFinalizarUnaReparacion"
	public Cuartel(Area areaAOcupar, boolean yaConstruida) throws CasillaOcupadaError {
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

	//Nota: No hace falta preguntar si unEspacio está libre porque de eso se encarga el constructor de cada Unidad.

	public Espadachin crearEspadachin(Area unEspacio) throws Exception {
		siYaJugoElTurnoError();
		
		turnoJugado = true;
		Espadachin unEspadachin = new Espadachin(unEspacio);
		return unEspadachin;
	}
	
	public Arquero crearArquero(Area unEspacio) throws Exception {
		siYaJugoElTurnoError();
		
		turnoJugado = true;
		Arquero unArquero = new Arquero(unEspacio);
		return unArquero;
	}
	
}
