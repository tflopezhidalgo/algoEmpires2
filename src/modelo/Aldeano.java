package modelo;

import modelo.estadoAldeano.AldeanoLibre;
import modelo.estadoAldeano.EstadoAldeano;
import modelo.excepciones.NoSePuedeConstruirTanLejosError;

public class Aldeano extends Unidad {

    final int VIDA = 50;
    final int COSTO = 25;

	private EstadoAldeano estadoActual;
	
	public Aldeano(Area unEspacio){
		super(unEspacio);

		estadoActual = new AldeanoLibre();
		vidaMaxima = VIDA;
		vida = vidaMaxima;
		costo = COSTO;
	}

	@Override
    public void mover(Area nuevaArea) {
	    estadoActual.mover();
        espacioOcupado.liberar();
        espacioOcupado.ocupar();
        espacioOcupado = nuevaArea;
        turnoJugado = true;
    }

	public void reparar(Edificio unEdificio) {
	    siYaJugoElTurnoError();

		if(enRango(unEdificio,1))  {

			estadoActual = estadoActual.reparar(unEdificio, this);
			turnoJugado = true;
		}
	}
	
	public Plaza crearPlaza(Area areaDeConstruccion) {
		siYaJugoElTurnoError();

        if(distanciaMinimaA(areaDeConstruccion) > 1)
            throw new NoSePuedeConstruirTanLejosError();

        estadoActual = estadoActual.construirPlaza(areaDeConstruccion, this);
        turnoJugado = true;

        return (Plaza)estadoActual.obtenerEdificioObjetivo();
	}
	
	public Cuartel crearCuartel(Area areaDeConstruccion) {
        siYaJugoElTurnoError();

        if(distanciaMinimaA(areaDeConstruccion) > 1)
            throw new NoSePuedeConstruirTanLejosError();

        estadoActual = estadoActual.construirCuartel(areaDeConstruccion, this);
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
