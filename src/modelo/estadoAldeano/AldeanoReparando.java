package modelo.estadoAldeano;

import modelo.*;
import modelo.excepciones.Excepcion;

public class AldeanoReparando implements EstadoAldeano {
	
	public EstadoAldeano reparar(Edificio unEdificio) throws Excepcion {
		return this;
	}
	
	public Plaza crearPlaza(Area areaDeConstruccion) throws Excepcion {
		return null;
	}
	
	public Cuartel crearCuartel(Area areaDeConstruccion) throws Excepcion {
		return null;
	}
	
	public EstadoAldeano realizarTrabajoDeTurno(Edificio edificioObjetivo) throws Excepcion {
		if(edificioObjetivo.necesitaReparacion()) {
			//turnoJugado = true;
			//return 0;
			edificioObjetivo.reparar();
			return this;
		}
		else {
			//ocupado = false;
			//turnoJugado = true;
			//return 20;
			return (new AldeanoLibre());
		}
	}	

}
