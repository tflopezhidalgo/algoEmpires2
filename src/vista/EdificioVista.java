package vista;

import modelo.Edificio;

public abstract class EdificioVista extends PiezaVista{
	
	public EdificioVista(int x, int y, Edificio unModelo, JuegoVista unJuego) {
		super(x, y, unModelo, unJuego);
	}

	protected abstract void prepararBotones();

	protected abstract void crearRepresentacion();
	
}
