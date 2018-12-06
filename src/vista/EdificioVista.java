package vista;

import controlador.EdificioRealizarAccion;
import javafx.scene.image.ImageView;
import modelo.Edificio;

public abstract class EdificioVista extends PiezaVista{
	
	protected Edificio modelo;
	//---------- Vista --------------------
	protected ImageView enConstruccionView;
	protected ImageView construidoView;
	protected ImageView construidoViewAzul;
	protected ImageView construidoViewRojo;

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
	
	@Override
	public void actualizarVisualizacon() {
		double porcentaje = modelo.porcentajeVidaActual();
		barraVidaActual.setWidth(TAMANIO_CASILLA*ancho*porcentaje);
		if(porcentaje == 0) {
			elJuego.remover(this);
		}
	}
	
	@Override
	public void colocarColor() {		
		if(elJuego.perteneceAJugador1(modelo)) {
			construidoViewRojo.setVisible(construidoView.isVisible());
			construidoViewAzul.setVisible(false);
			construidoView = construidoViewRojo;
			getChildren().addAll(construidoView);
		}		
	}
	
}
