package vista;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MenuVista extends BorderPane {
	
	Scene escenaSiguiente;

    public MenuVista(Stage stagePrincipal){
    	//-------------------------------------------------------
        //this.prepararEscenaSiguiente(stagePrincipal);
    	Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    	//--------------- Imagen de fondo -----------------------
        Image background = new Image("resources/images/ElementosMenu/menuBackground3.png");
        ImageView backgroundVista = new ImageView(background);
        backgroundVista.fitWidthProperty().bind(stagePrincipal.widthProperty());
        backgroundVista.fitHeightProperty().bind(stagePrincipal.heightProperty());
        
    	StackPane panel = new StackPane(backgroundVista);
        setCenter(panel);
        //--------------- Setup Botones -------------------------
        VBox botones = new VBox(40);
        
        Image imagenComenzar = new Image("resources/images/ElementosMenu/Botones/comenzar3.png");
        ImageView comenzar = new ImageView(imagenComenzar);
        comenzar.setFitWidth(300);
        comenzar.setFitHeight(37);
        
        BotonVistaPersonalizado elBotonComenzar = new BotonVistaPersonalizado(comenzar);
        elBotonComenzar.setOnMousePressed(event -> stagePrincipal.getScene().setRoot(new ConfiguracionVista(stagePrincipal)));//stagePrincipal.setScene(escenaSiguiente));
        											

        Image imagenSalir = new Image("resources/images/ElementosMenu/Botones/salir3.png");
        ImageView salir = new ImageView(imagenSalir);
        salir.setFitWidth(300);
        salir.setFitHeight(37);
        
        BotonVistaPersonalizado elBotonSalir = new BotonVistaPersonalizado(salir);
        elBotonSalir.setOnMousePressed(event ->  stagePrincipal.close());
    	
        botones.getChildren().addAll(elBotonComenzar, elBotonSalir);
        panel.getChildren().add(botones);
        botones.setTranslateY(primaryScreenBounds.getHeight()*0.6);
    }

	private void prepararEscenaSiguiente(Stage stagePrincipal){
        this.escenaSiguiente = new Scene(new ConfiguracionVista(stagePrincipal));
	}

}
