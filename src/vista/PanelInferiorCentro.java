package vista;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import modelo.Jugador;

public class PanelInferiorCentro extends StackPane{
	
	//---------- Panel Inferior Central ----------------------
	Label nombreJugador1;
	Label nombreJugador2;
	
	Label oro1;
	Label oro2;
	
	Label edificios1;
	Label edificios2;
	
	Label hpCastillo1;
	Label hpCastillo2;
	
	Label aldeanos1;
	Label aldeanos2;
	
	Label soldados1;
	Label soldados2;
	
	Label poblacion1;
	Label poblacion2;
	//---------- Jugadores ----------------------
	private Jugador jugador1;
	private Jugador jugador2;
	
	public PanelInferiorCentro(Jugador jugador1,Jugador jugador2) {
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;

    	Image central = new Image("resources/images/elementosJuego/panelInferior/centro/background2.png");
    	ImageView panelCentralView = new ImageView(central);
    	panelCentralView.setFitWidth(screenBounds.getWidth()*0.39);
    	panelCentralView.setFitHeight(screenBounds.getHeight()*0.2);
    	getChildren().add(panelCentralView);
    	
    	configurarCuadrosDeTexto(panelCentralView);
	}
	
    private void configurarCuadrosDeTexto(ImageView imagenReferencia) {
    	nombreJugador1 = new Label(jugador1.obtenerNombre());
    	nombreJugador2 = new Label(jugador2.obtenerNombre());
    	
    	oro1 = new Label(Integer.toString(jugador1.obtenerOro()));
    	oro2 = new Label(Integer.toString(jugador2.obtenerOro()));
    	
    	edificios1 = new Label(Integer.toString(jugador1.cantidadEdificios()));
    	edificios2 = new Label(Integer.toString(jugador2.cantidadEdificios()));
    	
    	hpCastillo1 = new Label(Integer.toString(jugador1.hpCastillo()));
    	hpCastillo2 = new Label(Integer.toString(jugador2.hpCastillo()));
    	
    	aldeanos1 = new Label(Integer.toString(jugador1.cantidadAldeanos()));
    	aldeanos2 = new Label(Integer.toString(jugador2.cantidadAldeanos()));
    	
    	soldados1 = new Label(Integer.toString(jugador1.cantidadSoldados()));
    	soldados2 = new Label(Integer.toString(jugador2.cantidadSoldados()));
    	
    	poblacion1 = new Label(Integer.toString(jugador1.getPoblacion()));
    	poblacion2 = new Label(Integer.toString(jugador2.getPoblacion()));
    	
    	getChildren().addAll(nombreJugador1, oro1, edificios1, hpCastillo1, aldeanos1, soldados1, poblacion1);
    	getChildren().addAll(nombreJugador2, oro2, edificios2, hpCastillo2, aldeanos2, soldados2, poblacion2);
  

    	colocarTextoEn(90,60,imagenReferencia,oro1);
    	colocarTextoEn(90,115,imagenReferencia,edificios1);
    	colocarTextoEn(90,170, imagenReferencia,hpCastillo1);
    	colocarTextoEn(270,60,imagenReferencia,aldeanos1);
    	colocarTextoEn(270,115,imagenReferencia,soldados1);
    	colocarTextoEn(270,170,imagenReferencia,poblacion1);
    	
    	colocarTextoEn(545,60,imagenReferencia,oro2);
    	oro2.setAlignment(Pos.CENTER);
    	colocarTextoEn(545,115,imagenReferencia,edificios2);
    	edificios2.setAlignment(Pos.CENTER);
    	colocarTextoEn(545,170, imagenReferencia,hpCastillo2);
    	hpCastillo2.setAlignment(Pos.CENTER);
    	colocarTextoEn(355,60,imagenReferencia,aldeanos2);
    	aldeanos2.setAlignment(Pos.CENTER);
    	colocarTextoEn(355,115,imagenReferencia,soldados2);
    	soldados2.setAlignment(Pos.CENTER);
    	colocarTextoEn(355,170,imagenReferencia,poblacion2);
    	poblacion2.setAlignment(Pos.CENTER);
    	
    	colocarTextoEn(110,30,imagenReferencia,nombreJugador1);
    	colocarTextoEn(550,30,imagenReferencia,nombreJugador2);
    	nombreJugador2.setAlignment(Pos.CENTER);
    }
    
    
    private void colocarTextoEn(int x, int y, ImageView referencia, Label texto) {
    	texto.setManaged(false);
    	
    	x = (int)(referencia.getFitWidth()*((double)x/750));
    	y = (int)(referencia.getFitHeight()*((double)y/219));
    	
    	texto.resizeRelocate(x, y, 120, 30);
    	texto.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");
    }
    
    public void actualizarContadores() {
    	oro1.setText(Integer.toString(jugador1.obtenerOro()));
    	oro2.setText(Integer.toString(jugador2.obtenerOro()));
    	
    	edificios1.setText(Integer.toString(jugador1.cantidadEdificios()));
    	edificios2.setText(Integer.toString(jugador2.cantidadEdificios()));
    	
    	hpCastillo1.setText(Integer.toString(jugador1.hpCastillo()));
    	hpCastillo2.setText(Integer.toString(jugador2.hpCastillo()));
    	
    	aldeanos1.setText(Integer.toString(jugador1.cantidadAldeanos()));
    	aldeanos2.setText(Integer.toString(jugador2.cantidadAldeanos()));
    	
    	soldados1.setText(Integer.toString(jugador1.cantidadSoldados()));
    	soldados2.setText(Integer.toString(jugador2.cantidadSoldados()));
    	
    	poblacion1.setText(Integer.toString(jugador1.getPoblacion()));
    	poblacion2.setText(Integer.toString(jugador2.getPoblacion()));
    }
	

}
