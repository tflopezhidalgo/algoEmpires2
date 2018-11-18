package modelo;

public class AldeanoConstruyendo implements EstadoAldeano{
	
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
