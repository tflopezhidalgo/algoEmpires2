package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Juego;

public class JuegoVista extends Application{

    public static void main(String[] args) {

    	launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Scene escenaInicial = new Scene(new MenuVista(primaryStage));

    	primaryStage.setTitle("Algo Empires 2");

        primaryStage.setScene(escenaInicial);
        primaryStage.show();
    }

}