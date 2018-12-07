package vista;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

public class PanelInferiorIzquierdo extends StackPane {
	
	private StackPane botones;
	
	public PanelInferiorIzquierdo() {
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    	
    	Image izquierdo = new Image("resources/images/elementosJuego/panelInferior/izquierdo/background.png");
    	ImageView panelIzquierdoView = new ImageView(izquierdo);
    	panelIzquierdoView.setFitWidth(screenBounds.getWidth()*0.27);
    	panelIzquierdoView.setFitHeight(screenBounds.getHeight()*0.2);
    	getChildren().add(panelIzquierdoView);
    	
    	HBox menuPanelIzquierdo = new HBox();
    	botones = new StackPane(menuPanelIzquierdo);
    	getChildren().add(botones);
    	botones.setAlignment(Pos.CENTER);
    	botones.setTranslateX(85);
	}
	
    public void asignarMenuAcciones(HBox acciones) {
    	botones.getChildren().remove(0);
    	botones.getChildren().add(acciones);
    }
}
