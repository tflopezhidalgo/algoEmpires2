package modelo;

import modelo.estadoAldeano.*;
import modelo.excepciones.*;

public class Aldeano extends Unidad {

    final int VIDA_ALDEANO = 50;
    final int COSTO_ALDEANO = 25;

	private Edificio edificioObjetivo;
	private EstadoAldeano estadoActual;
	
	public Aldeano(Area unEspacio) throws CasillaOcupadaError{
		super(unEspacio);
		estadoActual = new AldeanoLibre();
		edificioObjetivo = null;
		vida = VIDA_ALDEANO;
		costo = COSTO_ALDEANO;
	}

	public void reparar(Edificio unEdificio) throws Exception {

	    siYaJugoElTurnoError();
		
		if(enRango(unEdificio,1) & unEdificio.necesitaReparacion()) {
			estadoActual = estadoActual.reparar(unEdificio);
			if(estadoActual instanceof AldeanoReparando) {
				edificioObjetivo = unEdificio;
				ocupado = true;
				turnoJugado = true;
			}
		}
	}
	
	public Plaza crearPlaza(Area areaDeConstruccion) throws Exception {
		siYaJugoElTurnoError();

		if(!ocupado & areaDeConstruccion.estaLibre() & distanciaMinimaA(areaDeConstruccion) == 1) {
			edificioObjetivo = estadoActual.crearPlaza(areaDeConstruccion);
			if(edificioObjetivo != null) {
				ocupado = true;
				turnoJugado = true;
				estadoActual = new AldeanoConstruyendo();
                return (Plaza)edificioObjetivo;
			}
		}
		return null;
	}
	
	public Cuartel crearCuartel(Area areaDeConstruccion) throws Exception {
		siYaJugoElTurnoError();
		
		if(!ocupado & areaDeConstruccion.estaLibre() & distanciaMinimaA(areaDeConstruccion) == 1) {
			edificioObjetivo = estadoActual.crearCuartel(areaDeConstruccion);
			if(edificioObjetivo != null) {
				ocupado = true;
				turnoJugado = true;
				estadoActual = new AldeanoConstruyendo();
				return (Cuartel)edificioObjetivo;
			}
		}
		return null;
	}

	public int realizarTrabajoDeTurno() throws Exception {
		siYaJugoElTurnoError();
		
		estadoActual = estadoActual.realizarTrabajoDeTurno(edificioObjetivo);
		
		if(estadoActual instanceof AldeanoLibre) {
			edificioObjetivo = null;
			ocupado = false;
			return 20;
		}
		turnoJugado = true;
		return 0;
	}	
	
}
