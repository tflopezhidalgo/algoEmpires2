
public abstract class Edificio extends Pieza {
	

	protected Area casillasOcupadas;
	protected int vidaMaxima;
	protected int tiempoDeConstruccion;
	protected int cantidadDeCuracion;
	protected boolean enReparacion;
	protected int tamanioDelLado;

	/*
	public void curarse() {
		vida += cantidadDeCuracion;
		if(vida >= vidaMaxima) {
			vida = vidaMaxima;
			// liberar al aldeano de su labor
		}
	}*/
}
