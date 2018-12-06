package vista;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.Unidad;
import modelo.excepciones.Excepcion;

public class ArqueroVista extends UnidadVista{
	
	public ArqueroVista(int x, int y, Unidad unModelo, JuegoVista unMapa) throws Excepcion {
		super(x,y,unModelo, unMapa);
	}

	@Override
	protected void crearRepresentacion() {
 		Image image = new Image("resources/images/Unidades/Arquero/arquero.png");
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(22);
		imageView.setFitHeight(30);
		//-----------------------------------------
		getChildren().add(imageView);
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
		String accion = "src/resources/sound/accion/arrow.wav"; 
		Media accionSound = new Media(new File(accion).toURI().toString());
		sonidoAccion = new MediaPlayer(accionSound);
	}
}
