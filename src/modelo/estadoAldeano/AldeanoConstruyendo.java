package modelo.estadoAldeano;

import modelo.*;
import modelo.excepciones.Excepcion;

public class AldeanoConstruyendo implements EstadoAldeano {
	
	public EstadoAldeano reparar(Edificio unEdificio){

		return this;
	}
	
	public Plaza crearPlaza(Area areaDeConstruccion){

		return null;
	}
	
	public Cuartel crearCuartel(Area areaDeConstruccion) {

		return null;
	}
	
	public EstadoAldeano realizarTrabajoDeTurno(Edificio edificioObjetivo) {
		if(edificioObjetivo.enConstruccion()) {
			//turnoJugado = true;
			//return 0;
			edificioObjetivo.construir();
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
