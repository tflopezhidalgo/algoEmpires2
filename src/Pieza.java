
public abstract class Pieza {
	
	protected int vida;
	protected int costo;
	protected boolean turnoJugado;
	
	public void recibirDanio(int danio) {
		vida -= danio;
		if(vida <= 0) {
			vida = 0;
			//TODO destruir/morir/perder
			liberarUbicacion();
		}
	}
	
	protected void siYaJugoElTurnoError() throws ErrorBasico {
		if(turnoJugado) {
			//TODO error
			throw new ErrorBasico("ERROR: Turno ya jugado.");
		}
	}
	
	public void nuevoTurno() {
		turnoJugado = false;
	}
	
	public boolean estaDestruida() {
		return vida == 0;
	}
	
	protected abstract void liberarUbicacion();
	
}
