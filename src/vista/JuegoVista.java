package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JuegoVista extends Application{

    public static void main(String[] args) {
    	launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	Scene escenaMapa = new Scene(new MapaVista());
    	Scene escenaInicial = new Scene(new MenuVista(escenaMapa, primaryStage));
    	primaryStage.setTitle("Juegazo");
    	//primaryStage.initStyle(StageStyle.UNDECORATED);
    	
        primaryStage.setScene(escenaInicial);
        primaryStage.show();
    }

}