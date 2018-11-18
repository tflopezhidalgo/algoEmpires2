
public interface EstadoAldeano {

	public EstadoAldeano reparar(Edificio unEdificio) throws ErrorBasico;
	
	public Plaza crearPlaza(Area areaDeConstruccion) throws ErrorBasico;
	
	public Cuartel crearCuartel(Area areaDeConstruccion) throws ErrorBasico;
	
	public EstadoAldeano realizarTrabajoDeTurno(Edificio edificioObjetivo) throws ErrorBasico;
		
}