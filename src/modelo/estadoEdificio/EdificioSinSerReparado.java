package modelo.estadoEdificio;

public class EdificioSinSerReparado extends EstadoEdificio{

	public boolean necesitaReparacion(int vidaActual, int vidaMax) {
		return (vidaActual < vidaMax);
	}

	@Override
	public EstadoEdificio reparar() {
		return (new EdificioSiendoReparado());
	}
	
}
