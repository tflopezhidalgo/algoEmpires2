package vista;

import controlador.EdificioRealizarAccion;
import javafx.scene.image.ImageView;
import modelo.Edificio;

public abstract class EdificioVista extends PiezaVista{
	
	protected ImageView enConstruccionView;
	protected ImageView construidoView;
	protected Edificio modelo;

	public EdificioVista(int x, int y, Edificio unModelo, JuegoVista unJuego) {
		super(x, y, unModelo, unJuego);
		modelo = unModelo;
		crearRepresentacion();
	}

	@Override
	public void realizarAccionSobrePieza() {
		new EdificioRealizarAccion(elJuego,this);
	}
	
	public Edificio modelo() {
		return modelo;
	}
	
	protected abstract void prepararBotones();

	protected abstract void crearRepresentacion();
	
}
