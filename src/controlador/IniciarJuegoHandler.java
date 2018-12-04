package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import vista.JuegoVista;

public class IniciarJuegoHandler implements EventHandler<ActionEvent> {

    private String nombreJugador1;
    private String nombreJugador2;
    private Stage primaryStage;
    
    public IniciarJuegoHandler(String nombreJugador1, String nombreJugador2, Stage primaryStage) {        
    	this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
        this.primaryStage = primaryStage;
    }
	
    @Override
    public void handle(ActionEvent event){
        primaryStage.getScene().setRoot(new JuegoVista(nombreJugador1, nombreJugador2, primaryStage));
    }

}
