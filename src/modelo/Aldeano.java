package modelo;

import modelo.estadoAldeano.*;
import modelo.excepciones.*;

public class Aldeano extends Unidad {

    final int VIDA_ALDEANO = 50;
    final int COSTO_ALDEANO = 25;

	private EstadoAldeano estadoActual;
	
	public Aldeano(Area unEspacio) throws CasillaOcupadaError{
		super(unEspacio);
		estadoActual = new AldeanoLibre();
		vida = VIDA_ALDEANO;
		costo = COSTO_ALDEANO;
	}

	public void reparar(Edificio unEdificio) throws Exception {

	    siYaJugoElTurnoError();
		
		if(enRango(unEdificio,1) & unEdificio.necesitaReparacion()) {
			estadoActual = estadoActual.reparar(unEdificio);
			ocupado = true;     //TODO: Si esta en estadoOcupado es al pedo el boolean de ocupado
			turnoJugado = true;
		}

	}
	
	public Plaza crearPlaza(Area areaDeConstruccion) throws Exception {
		siYaJugoElTurnoError();

        if(distanciaMinimaA(areaDeConstruccion) > 1) {
            throw  new NoSePuedeConstruirTanLejosError();
        }

        estadoActual = estadoActual.construir(new Plaza(areaDeConstruccion));
        ocupado = true;
        turnoJugado = true;

        return (Plaza)estadoActual.obtenerEdificioObjetivo();

	}
	
	public Cuartel crearCuartel(Area areaDeConstruccion) throws Exception {

        siYaJugoElTurnoError();

        if(distanciaMinimaA(areaDeConstruccion) > 1) {
            throw new NoSePuedeConstruirTanLejosError();
        }

        estadoActual = estadoActual.construir(new Cuartel(areaDeConstruccion));
        ocupado = true;
        turnoJugado = true;

        return (Cuartel)estadoActual.obtenerEdificioObjetivo();
	}

	public int realizarTrabajoDeTurno() throws Exception {
		siYaJugoElTurnoError();
		
		estadoActual = estadoActual.realizarTrabajoDeTurno();
		
		if(estadoActual instanceof AldeanoLibre) {
			ocupado = false;
		}

		turnoJugado = true;

		return estadoActual.generarOro();
	}	
	
}
