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
		if(vida >= vidaMaxima) {
			return false;
		}
		return true;
	}
	
	public boolean enConstruccion() {
		if(tiempoDeConstruccion > 0) {
			return true;
		}
		return false;
	}
	
	public void construir() {
		if(enConstruccion()) {
			tiempoDeConstruccion --;
		}
	}
	
	public Area areaOcupada() {
		return casillasOcupadas;
	}
	
	protected void liberarUbicacion() {
		casillasOcupadas.liberar();
	}
}
