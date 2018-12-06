package vista;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.Unidad;
import modelo.excepciones.Excepcion;

public class EspadachinVista extends UnidadVista{
	
	private ImageView azul;
	private ImageView rojo;

	public EspadachinVista(int x, int y, Unidad unModelo, JuegoVista unMapa) throws Excepcion {
		super(x,y,unModelo, unMapa);
	}

	@Override
	protected void crearRepresentacion() {
 		Image image = new Image("resources/images/Unidades/Espadachin/espadachinAzul.png");
		azul = new ImageView(image);
		azul.setFitWidth(27);
		azul.setFitHeight(30);
		azul.setVisible(true);
		
 		image = new Image("resources/images/Unidades/Espadachin/espadachinRojo.png");
 		rojo = new ImageView(image);
		rojo.setFitWidth(27);
		rojo.setFitHeight(30);
		rojo.setVisible(false);
		//-----------------------------------------
		getChildren().addAll(azul,rojo);
	}

	@Override
	protected void prepararBotones() {
		//Creo que no hace falta porque:
		//Click derecho sobre casilla = mover
		//Click derecho sobre Pieza = atacar
	}	

	
	@Override
	protected void configurarSonidos() {
		super.configurarSonidos();
		String accion = "src/resources/sound/accion/fight.wav"; 
		Media accionSound = new Media(new File(accion).toURI().toString());
		sonidoAccion = new MediaPlayer(accionSound);
	}

	@Override
	public void colocarColor() {		
		if(elJuego.perteneceAJugador1(modelo)) {
			rojo.setVisible(true);
			azul.setVisible(false);
		}		
	}
}
