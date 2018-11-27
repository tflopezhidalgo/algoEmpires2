package vista;

import javafx.scene.image.ImageView;
import modelo.Aldeano;
import modelo.Atacante;
import modelo.Edificio;

public abstract class EdificioVista extends PiezaVista{
	
	protected ImageView enConstruccionView;
	protected ImageView construidoView;

	
	public EdificioVista(int x, int y, Edificio unModelo, JuegoVista unJuego) {
		super(x, y, unModelo, unJuego);
	}

	@Override
	protected void realizarAccionSobrePieza() {
		PiezaVista piezaSeleccionada = elJuego.piezaSeleccionada();
		if(piezaSeleccionada.modelo() instanceof Atacante) {
			//Edificio esta siendo atacado
			((Atacante)(piezaSeleccionada).modelo()).atacar(modelo);
			
			if(modelo.estaDestruida()) {
				elJuego.removerPieza(this);
			}
		}
		
		if(piezaSeleccionada.modelo() instanceof Aldeano) {
			//Edificio esta siendo reparado
			((Aldeano)(piezaSeleccionada).modelo()).reparar((Edificio)modelo);
		}
	}
	
	protected abstract void prepararBotones();

	protected abstract void crearRepresentacion();
	
}
