
public class AldeanoReparando implements EstadoAldeano {
	
	public EstadoAldeano reparar(Edificio unEdificio) throws ErrorBasico {
		return this;
	}
	
	public Plaza crearPlaza(Area areaDeConstruccion) throws ErrorBasico {
		return null;
	}
	
	public Cuartel crearCuartel(Area areaDeConstruccion) throws ErrorBasico {
		return null;
	}
	
	public EstadoAldeano realizarTrabajoDeTurno(Edificio edificioObjetivo) throws ErrorBasico {
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