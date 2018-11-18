
public class AldeanoLibre implements EstadoAldeano{
	
	public EstadoAldeano reparar(Edificio unEdificio) throws ErrorBasico {
		unEdificio.reparar();
		return (new AldeanoReparando());
	}
	
	public Plaza crearPlaza(Area areaDeConstruccion) throws ErrorBasico {
		Plaza nuevaPlaza = new Plaza(areaDeConstruccion);
		nuevaPlaza.construir();
		
		return nuevaPlaza;

	}
	
	public Cuartel crearCuartel(Area areaDeConstruccion) throws ErrorBasico {
		Cuartel nuevoCuartel = new Cuartel(areaDeConstruccion);
		nuevoCuartel.construir();

		return nuevoCuartel;
	}
	
	public EstadoAldeano realizarTrabajoDeTurno(Edificio edificioObjetivo) throws ErrorBasico {
		//ocupado = false;
		//turnoJugado = true;
		//return 20;
		return this;
	}	
}