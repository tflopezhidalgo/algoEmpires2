package vista;

import javafx.scene.layout.HBox;
import modelo.Jugador;

public class PanelInferior  extends HBox {
	
	private PanelInferiorIzquierdo panelIzquierdo;
	private PanelInferiorCentro panelCentro;
	private PanelInferiorDerecho panelDerecho;
	//---------- Jugadores ----------------------
	private Jugador jugador1;
	private Jugador jugador2;
	
	private JuegoVista elJuego;
	
	public PanelInferior(JuegoVista elJuego,Jugador jugador1,Jugador jugador2) {
		this.elJuego = elJuego;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		//Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		
		panelIzquierdo = new PanelInferiorIzquierdo();
		panelCentro = new PanelInferiorCentro(this.jugador1, this.jugador2);
		panelDerecho = new PanelInferiorDerecho(this.elJuego);
		
		getChildren().addAll(panelIzquierdo,panelCentro,panelDerecho);
	}
	
	public void actualizarPanel() {
		panelCentro.actualizarContadores();
	}
	
    public void asignarMenuAcciones(HBox acciones) {
    	panelIzquierdo.asignarMenuAcciones(acciones);
    }

}
