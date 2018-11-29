package vista;

import controlador.EdificioRealizarAccion;
import javafx.scene.image.ImageView;
import modelo.Edificio;

public abstract class EdificioVista extends PiezaVista{
	
	protected ImageView enConstruccionView;
	protected ImageView construidoView;

	
	public EdificioVista(int x, int y, Edificio unModelo, MapaVista unMapa) {
		super(x, y, unModelo, unMapa);
	}

	@Override
	public void realizarAccionSobrePieza() {
		new EdificioRealizarAccion(elMapa,this);
	}
	
	protected abstract void prepararBotones();

	protected abstract void crearRepresentacion();
	
}
