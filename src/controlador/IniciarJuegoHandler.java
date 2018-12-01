package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Juego;
import vista.MapaVista;

public class IniciarJuegoHandler implements EventHandler<ActionEvent> {

    private String nombreJugador1;
    private String nombreJugador2;
    private Scene escenaSiguiente;
    private Stage primaryStage;
    
    public IniciarJuegoHandler(String nombreJugador1, String nombreJugador2, Stage primaryStage) {
    	this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
        this.primaryStage = primaryStage;
    }
	
    @Override
    public void handle(ActionEvent event){
        prepararEscenaSiguiente(new Juego(nombreJugador1, nombreJugador2));
        primaryStage.setScene(escenaSiguiente);
    }
	
    public void prepararEscenaSiguiente(Juego unJuego){
        this.escenaSiguiente = new Scene(new MapaVista(unJuego));
    }
    
}
