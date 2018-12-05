package vista;

import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
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
import javafx.stage.Stage;

public class ConfiguracionVista extends Pane{

    public ConfiguracionVista(Stage primaryStage, MediaPlayer menuSoundtrackPlayer) {

        Image imagenFondo = new Image("resources/images/ElementosMenu/fondoPergamino.png");
        ImageView fondoVista = new ImageView(imagenFondo);

        ImageView guerreroFondo1 = new ImageView(new Image("resources/images/ElementosMenu/img1.png"));
        guerreroFondo1.relocate(500, 100);

        ImageView guereroFondo2 = new ImageView(new Image("resources/images/ElementosMenu/img2.png"));
        guereroFondo2.relocate(750, 50);

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

        Text botonIniciarJuego = new Text("¡Iniciar Juego!");
        botonIniciarJuego.setFont(Font.loadFont("file:src/resources/fonts/ringBearer.TTF", 40));
        botonIniciarJuego.setFill(Color.WHITE);
        botonIniciarJuego.relocate(1100, 700);

        botonIniciarJuego.setOnMouseClicked(
                e -> {
                    primaryStage.getScene().setRoot(new JuegoVista(jugador1.getText(), jugador2.getText(), primaryStage));
                    menuSoundtrackPlayer.stop();
                });

        this.getChildren().addAll(fondoVista, campoInformacion, titulo, guereroFondo2, guerreroFondo1, botonIniciarJuego);
    }

}
