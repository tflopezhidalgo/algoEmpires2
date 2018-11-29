package modelo;

import modelo.excepciones.NoSePuedeConstruirTanLejosError;
import modelo.excepciones.NoSePuedeCrearUnidadesDuranteConstruccionError;

public class Cuartel extends Edificio {
	
	public static final int TAMANIO_LADO = 2;
	
	public Cuartel(Area areaAOcupar) {
		super(areaAOcupar);
		vidaMaxima = 250;
		vida = vidaMaxima;
		costo = 50;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 50;

	}
	
	//TODO: ELIMINAR ESTO - es solo para realizar en AldeanoTest "AldeanoVuelveASumarOroLuegoDeFinalizarUnaReparacion"
	public Cuartel(Area areaAOcupar, boolean yaConstruida) {
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

	public Espadachin crearEspadachin(Area unEspacio) {
		siYaJugoElTurnoError();
		
        if(distanciaMinimaA(unEspacio) > 1) {
            throw  new NoSePuedeConstruirTanLejosError();
        }
        
        if(enConstruccion() == true) {
        	throw  new NoSePuedeCrearUnidadesDuranteConstruccionError();
        }
		
		Espadachin unEspadachin = new Espadachin(unEspacio);
		turnoJugado = true;
		return unEspadachin;
	}
	
	public Arquero crearArquero(Area unEspacio) {
		siYaJugoElTurnoError();
		
        if(distanciaMinimaA(unEspacio) > 1) {
            throw  new NoSePuedeConstruirTanLejosError();
        }
        
        if(enConstruccion() == true) {
        	throw  new NoSePuedeCrearUnidadesDuranteConstruccionError();
        }
		
		turnoJugado = true;
		Arquero unArquero = new Arquero(unEspacio);
		return unArquero;
	}
	
}
