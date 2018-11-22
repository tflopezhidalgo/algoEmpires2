package modelo.estadoAldeano;

import modelo.*;
import modelo.excepciones.*;

public class AldeanoLibre implements EstadoAldeano {
	
	public EstadoAldeano reparar(Edificio unEdificio){

		unEdificio.reparar();
		return (new AldeanoReparando());
	}

	public Plaza crearPlaza(Area areaDeConstruccion) throws CasillaOcupadaError {

		Plaza nuevaPlaza = new Plaza(areaDeConstruccion);
		nuevaPlaza.construir();
		
		return nuevaPlaza;
	}

	public Cuartel crearCuartel(Area areaDeConstruccion) throws Exception {

		Cuartel nuevoCuartel = new Cuartel(areaDeConstruccion);
		nuevoCuartel.construir();

		return nuevoCuartel;
	}
	
	public EstadoAldeano realizarTrabajoDeTurno(Edificio edificioObjetivo){
		//ocupado = false;
		//turnoJugado = true;
		//return 20;
		return this;
	}	

}
