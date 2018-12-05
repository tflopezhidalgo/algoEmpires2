package vista;

import java.io.File;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MenuVista extends BorderPane {

	private MediaPlayer menuSoundtrackPlayer;

    public MenuVista(Stage stagePrincipal){
    	//-------------------------------------------------------
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
        elBotonComenzar.setOnMousePressed(event ->{
        	stagePrincipal.getScene().setRoot(new ConfiguracionVista(stagePrincipal, menuSoundtrackPlayer));
        });

        Image imagenSalir = new Image("resources/images/ElementosMenu/Botones/salir3.png");
        ImageView salir = new ImageView(imagenSalir);
        salir.setFitWidth(300);
        salir.setFitHeight(37);
        
        BotonVistaPersonalizado elBotonSalir = new BotonVistaPersonalizado(salir);
        elBotonSalir.setOnMousePressed(event ->{
        	menuSoundtrackPlayer.stop();
        	stagePrincipal.close();
        });
    	
        botones.getChildren().addAll(elBotonComenzar, elBotonSalir);
        panel.getChildren().add(botones);
        botones.setTranslateY(primaryScreenBounds.getHeight()*0.6);        
        //------------------ Sonidos ----------------------------
        configurarSonidos();
    }
    
    private void configurarSonidos() {		
        String menuSoundtrack = "src/resources/sound/menu/menuSoundtrack.mp3";
        Media menuSoundtrackSound = new Media(new File(menuSoundtrack).toURI().toString());
		menuSoundtrackPlayer.play();
		menuSoundtrackPlayer.setOnEndOfMedia(new Runnable() {
		    @Override
		    public void run() {
		    	menuSoundtrackPlayer.play();
		    }
		});
    }

}
