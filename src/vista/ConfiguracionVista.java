package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.control.Button;
import modelo.Juego;
import modelo.Tablero;

public class ConfiguracionVista extends Pane{

    private String nombreJugador1;
    private String nombreJugador2;
    private Juego unJuego;

    private Scene escenaSiguiente;

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

        titulo.setFont(Font.loadFont("file:src/resources/fonts/Mairon.ttf", 30));

        Button botonIniciarJuego = new Button("Iniciar Juego!");
        botonIniciarJuego.relocate(1000, 600);

        botonIniciarJuego.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){

                nombreJugador1 = jugador1.getText();
                nombreJugador2 = jugador2.getText();
                prepararEscenaSiguiente(new Juego(nombreJugador1, nombreJugador2));
                primaryStage.setScene(escenaSiguiente);
            }
        });

        this.getChildren().addAll(fondoVista, campoInformacion, titulo, botonIniciarJuego);
    }

    public void prepararEscenaSiguiente(Juego unJuego){

        this.escenaSiguiente = new Scene(new MapaVista(unJuego));
    }
}
