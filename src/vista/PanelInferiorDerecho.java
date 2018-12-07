package vista;

import controlador.FinalizarTurnoHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;


public class PanelInferiorDerecho extends StackPane {

	private JuegoVista elJuego;
	
	public PanelInferiorDerecho(JuegoVista elJuego) {
		this.elJuego = elJuego;
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    	
    	Image derecho = new Image("resources/images/elementosJuego/panelInferior/derecho/background.png");
    	ImageView panelDerechoView = new ImageView(derecho);
    	panelDerechoView.setFitWidth(screenBounds.getWidth()*0.34);
    	panelDerechoView.setFitHeight(screenBounds.getHeight()*0.2);
    	getChildren().add(panelDerechoView);
    	
    	prepararBotones();
	}
	
	private void prepararBotones() {
    	Button botonFinTurno = new Button("Finalizar Turno");
    	botonFinTurno.setOnAction( new FinalizarTurnoHandler(elJuego, elJuego.getPiezas()));
    	Button botonSalir = new Button("Salir");
    	botonSalir.setOnAction(event ->  elJuego.cerrar());
    	Button botonMute = new Button("Mute Ambiente");
    	botonMute.setOnAction(event ->   elJuego.mute());
    	
    	VBox menuPanelDerecho = new VBox(10);
    	menuPanelDerecho.getChildren().addAll(botonFinTurno, botonSalir, botonMute);
    	getChildren().add(menuPanelDerecho);
    	menuPanelDerecho.setAlignment(Pos.CENTER);
	}
}
