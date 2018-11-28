package modelo;

import modelo.estadoAldeano.AldeanoLibre;
import modelo.estadoAldeano.EstadoAldeano;
import modelo.excepciones.NoSePuedeConstruirTanLejosError;

public class Aldeano extends Unidad {

    final int VIDA_ALDEANO = 50;
    final int COSTO_ALDEANO = 25;

	private EstadoAldeano estadoActual;
	//ahora si, anda donde habias hecho la prueba
	public Aldeano(Area unEspacio){
		super(unEspacio);
		estadoActual = new AldeanoLibre();
		vida = VIDA_ALDEANO;
		costo = COSTO_ALDEANO;
	}

	@Override
    public void mover(Area nuevaArea) {
	    estadoActual.mover(); //TODO esto es para cortar con un error nadamas, no hace nada
        espacioOcupado.liberar();
        espacioOcupado = nuevaArea;
        espacioOcupado.ocupar();
        turnoJugado = true;
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
        Plaza nuevaPlaza = null;
        estadoActual = estadoActual.construir(nuevaPlaza, areaDeConstruccion);
        turnoJugado = true;
        //nadamas hace return en caso de ser llamado el metodo en las condiciones apropiadas
        //en cualquier otro caso corta por error , no devuelve NI null
        return (Plaza)estadoActual.obtenerEdificioObjetivo();

	}
	
	public Cuartel crearCuartel(Area areaDeConstruccion) {
        siYaJugoElTurnoError();

        if(distanciaMinimaA(areaDeConstruccion) > 1) {
            throw new NoSePuedeConstruirTanLejosError();
        }
        Cuartel nuevoCuartel = null;
        estadoActual = estadoActual.construir(nuevoCuartel, areaDeConstruccion);
        turnoJugado = true;
        //nadamas hace return en caso de ser llamado el metodo en las condiciones apropiadas
        //en cualquier otro caso corta por error , no devuelve NI null
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
