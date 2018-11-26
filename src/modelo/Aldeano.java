package modelo;

import modelo.estadoAldeano.*;
import modelo.excepciones.*;

public class Aldeano extends Unidad {

    final int VIDA_ALDEANO = 50;
    final int COSTO_ALDEANO = 25;

	private EstadoAldeano estadoActual;
	
	public Aldeano(Area unEspacio){
		super(unEspacio);
		estadoActual = new AldeanoLibre();
		vida = VIDA_ALDEANO;
		costo = COSTO_ALDEANO;
	}

	@Override
    public void mover(Area nuevaArea) {
	    estadoActual.mover();
        if (nuevaArea.estaLibre()) {
            espacioOcupado.liberar();
            espacioOcupado = nuevaArea;
            espacioOcupado.ocupar();
            turnoJugado = true;
        }
    }

	public void reparar(Edificio unEdificio) {

	    siYaJugoElTurnoError();
		
		if(enRango(unEdificio,1) & unEdificio.necesitaReparacion()) {
			estadoActual = estadoActual.reparar(unEdificio);
			turnoJugado = true;
		}

	}
	
	public Plaza crearPlaza(Area areaDeConstruccion) {
		siYaJugoElTurnoError();

        if(distanciaMinimaA(areaDeConstruccion) > 1)
            throw new NoSePuedeConstruirTanLejosError();

        estadoActual = estadoActual.construir(new Plaza(areaDeConstruccion));
        turnoJugado = true;

        return (Plaza)estadoActual.obtenerEdificioObjetivo();

	}
	
	public Cuartel crearCuartel(Area areaDeConstruccion) {
        siYaJugoElTurnoError();

        if(distanciaMinimaA(areaDeConstruccion) > 1)
            throw new NoSePuedeConstruirTanLejosError();

        estadoActual = estadoActual.construir(new Cuartel(areaDeConstruccion));
        turnoJugado = true;

        return (Cuartel)estadoActual.obtenerEdificioObjetivo();
	}

	public void realizarTrabajoDeTurno() {

		estadoActual = estadoActual.realizarTrabajoDeTurno();
		turnoJugado = true;
	}

	public int generarOro(){

	    return (estadoActual.generarOro());
    }
	
	@Override
	public void nuevoTurno() {

		realizarTrabajoDeTurno();
		super.nuevoTurno();
	}
	
}
