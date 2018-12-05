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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConfiguracionVista extends Pane{

    public ConfiguracionVista(Stage primaryStage){

        Image imagenFondo = new Image("resources/images/ElementosMenu/fondoPergamino.png");
        ImageView fondoVista = new ImageView(imagenFondo);

        fondoVista.fitWidthProperty().bind(primaryStage.widthProperty());
        fondoVista.fitHeightProperty().bind(primaryStage.heightProperty());

        this.prefHeightProperty();
        this.prefWidthProperty();

        GridPane campoInformacion = new GridPane();

        campoInformacion.setPadding(new Insets(2,2,2,2));
        campoInformacion.setHgap(10);
        campoInformacion.setVgap(10);

        campoInformacion.relocate(200, 200);
        campoInformacion.add(new Label("Jugador 1:"), 0, 0);
        TextField jugador1 = new TextField();
        campoInformacion.add(jugador1, 1,0);
        campoInformacion.add(new Label("Jugador 2:"), 0,1);
        TextField jugador2 = new TextField();
        campoInformacion.add(jugador2, 1,1);

        Text titulo = new Text(200, 100,"Configuracion");
        titulo.setTextOrigin(VPos.CENTER);

        //titulo.setFont(Font.loadFont("file:src/resources/fonts/Mairon.ttf", 30));

        Button botonIniciarJuego = new Button("Iniciar Juego!");
        botonIniciarJuego.relocate(1000, 600);

        botonIniciarJuego.setOnAction(//new IniciarJuegoHandler(jugador1.getText(), jugador2.getText(), primaryStage));
        		e-> primaryStage.getScene().setRoot(new JuegoVista(jugador1.getText(), jugador2.getText(), primaryStage)));

        this.getChildren().addAll(fondoVista, campoInformacion, titulo, botonIniciarJuego);
    }

}
