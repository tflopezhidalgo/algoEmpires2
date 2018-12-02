package controlador;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import vista.JuegoVista;
import vista.PiezaVista;

public class UnidadRealizarAccion {

	public UnidadRealizarAccion(JuegoVista unMapa, PiezaVista unidad) {
		//Unidad esta siendo atacada
		PiezaVista piezaAtacante = unMapa.piezaSeleccionada();
		
		piezaAtacante.modelo().atacar(unidad.modelo());
		String musicFile = "src\\Sonido\\Generales\\fight2.wav"; 
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		
		if(unidad.modelo().estaDestruida()) {
			unMapa.removerPieza(unidad);
		}
			
		unidad.actualizarVisualizacon();
	}
}
