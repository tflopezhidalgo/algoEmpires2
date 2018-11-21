package modelo;

import modelo.excepciones.Excepcion;

public abstract class Edificio extends Pieza {

	protected int vidaMaxima;
	protected int tiempoDeConstruccion;
	protected int cantidadDeCuracion;
	
	public Edificio(Area areaAOcupar) throws Excepcion {
		super(areaAOcupar);
	}

	public void reparar() {
		vida += cantidadDeCuracion;
		if(vida >= vidaMaxima) {
			vida = vidaMaxima;
			// liberar al aldeano de su labor
		}
	}
	
	public boolean necesitaReparacion() {
		return(vida < vidaMaxima);
	}
	
	public boolean enConstruccion() {
		return(tiempoDeConstruccion > 0);
	}
	
	public void construir() {
		if(enConstruccion()) {
			tiempoDeConstruccion --;
		}
	}
	
	public int tamanioArea() {
		return espacioOcupado.obtenerTamanio();
	}

}
