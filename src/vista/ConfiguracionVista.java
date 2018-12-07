package vista;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ConfiguracionVista extends Pane{

    public ConfiguracionVista(Stage primaryStage, MediaPlayer menuSoundtrackPlayer) {
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        Image imagenFondo = new Image("resources/images/ElementosMenu/fondoPergamino.png");
        ImageView fondoVista = new ImageView(imagenFondo);

        ImageView guerreroFondo1 = new ImageView(new Image("resources/images/ElementosMenu/img1.png"));
        guerreroFondo1.resizeRelocate(screenBounds.getWidth()*0.26, screenBounds.getHeight()*0.1, guerreroFondo1.getFitWidth()*0.26, guerreroFondo1.getFitHeight()*0.83);

        ImageView guerreroFondo2 = new ImageView(new Image("resources/images/ElementosMenu/img2.png"));
        guerreroFondo2.resizeRelocate(screenBounds.getWidth()*0.4, screenBounds.getHeight()*0.046, guerreroFondo2.getFitWidth()*0.5, guerreroFondo2.getFitHeight()*1.8);

        fondoVista.fitWidthProperty().bind(primaryStage.widthProperty());
        fondoVista.fitHeightProperty().bind(primaryStage.heightProperty());

        this.prefHeightProperty();
        this.prefWidthProperty();

        GridPane campoInformacion = new GridPane();

        campoInformacion.setPadding(new Insets(2, 2, 2, 2));
        campoInformacion.setHgap(10);
        campoInformacion.setVgap(10);

        campoInformacion.relocate(200, 200);

        campoInformacion.add(new Label("Jugador 1:"), 0, 0);
        TextField jugador1 = new TextField();

        campoInformacion.add(new Label("Jugador 2:"), 0, 1);
        TextField jugador2 = new TextField();

        campoInformacion.add(jugador1, 1, 0);
        campoInformacion.add(jugador2, 1, 1);

        Text titulo = new Text(200, 100, "Configuracion");
        titulo.setFont(Font.loadFont("file:src/resources/fonts/ringBearer.TTF", 40));
        titulo.setTextOrigin(VPos.CENTER);

        Text botonIniciarJuego = new Text("Iniciar Juego!");
        botonIniciarJuego.setFont(Font.loadFont("file:src/resources/fonts/ringBearer.TTF", 40));
        botonIniciarJuego.setFill(Color.WHITE);
        botonIniciarJuego.relocate(screenBounds.getWidth()*0.70, screenBounds.getHeight()*0.9);


        botonIniciarJuego.setOnMouseClicked(
                e -> {
                    primaryStage.getScene().setRoot(new JuegoVista(jugador1.getText(), jugador2.getText(), primaryStage));
                    menuSoundtrackPlayer.stop();
                });

        this.getChildren().addAll(fondoVista, campoInformacion, titulo, guerreroFondo2, guerreroFondo1, botonIniciarJuego);
    }

}
