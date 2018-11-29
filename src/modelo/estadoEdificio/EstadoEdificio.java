package modelo.estadoEdificio;

public abstract class EstadoEdificio {

	public abstract boolean necesitaReparacion(int vidaActual, int vidaMax);
	
	public abstract EstadoEdificio reparar();
}
