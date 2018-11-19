package modelo;

public interface EstadoAldeano {

	public EstadoAldeano reparar(Edificio unEdificio) throws Excepcion;
	
	public Plaza crearPlaza(Area areaDeConstruccion) throws Excepcion;
	
	public Cuartel crearCuartel(Area areaDeConstruccion) throws Excepcion;
	
	public EstadoAldeano realizarTrabajoDeTurno(Edificio edificioObjetivo) throws Excepcion;
		

}

