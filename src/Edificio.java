public abstract class Edificio extends Pieza {

	protected Area casillasOcupadas;
	protected int vidaMaxima;
	protected int tiempoDeConstruccion;
	protected int cantidadDeCuracion;

	
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
	
	public Area areaOcupada() {
		return casillasOcupadas;
	}
	
	public int tamanio() {
		return casillasOcupadas.obtenerTamanio();
	}
	
	protected void liberarUbicacion() {
		casillasOcupadas.liberar();
	}
}
