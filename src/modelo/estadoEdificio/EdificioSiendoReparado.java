package modelo.estadoEdificio;

import modelo.excepciones.EdificioYaEstaSiendoReparadoError;

public class EdificioSiendoReparado extends EstadoEdificio{

	public boolean necesitaReparacion(int vidaActual, int vidaMax) {
		return false;
	}

	@Override
	public EstadoEdificio reparar() {
		throw new EdificioYaEstaSiendoReparadoError();
	}
	
}
