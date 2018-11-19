
public class AldeanoLibre implements EstadoAldeano{
	
	public EstadoAldeano reparar(Edificio unEdificio) throws Excepcion {
		unEdificio.reparar();
		return (new AldeanoReparando());
	}
	
	public Plaza crearPlaza(Area areaDeConstruccion) throws Excepcion {
		Plaza nuevaPlaza = new Plaza(areaDeConstruccion);
		nuevaPlaza.construir();
		
		return nuevaPlaza;

	}
	
	public Cuartel crearCuartel(Area areaDeConstruccion) throws Excepcion {
		Cuartel nuevoCuartel = new Cuartel(areaDeConstruccion);
		nuevoCuartel.construir();

		return nuevoCuartel;
	}
	
	public EstadoAldeano realizarTrabajoDeTurno(Edificio edificioObjetivo) throws Excepcion {
		//ocupado = false;
		//turnoJugado = true;
		//return 20;
		return this;
	}	
}