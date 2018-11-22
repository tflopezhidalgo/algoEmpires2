package modelo;

import modelo.excepciones.CasillaOcupadaError;

public abstract class Edificio extends Pieza {

	protected int vidaMaxima;
	protected int tiempoDeConstruccion;
	protected int cantidadDeCuracion;
	
	public Edificio(Area areaAOcupar) {
	    super(areaAOcupar);
	    this.vidaMaxima = 0;
	    this.tiempoDeConstruccion = 0;
	    this.cantidadDeCuracion = 0;
	}

	public void reparar() {
		vida = vida + cantidadDeCuracion;
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
			tiempoDeConstruccion--;
		}
	}
	
	public int tamanioArea() {

		return espacioOcupado.obtenerCantidadDeCasillas();
	}

}
