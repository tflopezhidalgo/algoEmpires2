package controlador;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.excepciones.PiezaNoEstaEnEquipoEnemigo;
import vista.JuegoVista;
import vista.PiezaVista;
import vista.UnidadVista;

public class UnidadRealizarAccion {

	public UnidadRealizarAccion(JuegoVista unJuego, UnidadVista unidad) {
		//Unidad esta siendo atacada
		
		if(!unJuego.enemigoContieneA(unidad.modelo())) {
			throw new PiezaNoEstaEnEquipoEnemigo();
		}
		
		PiezaVista piezaAtacante = unJuego.piezaSeleccionada();
		
		piezaAtacante.modelo().atacar(unidad.modelo());
		String musicFile = "src/resources/sound/Accion/fight2.wav";
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		
		if(unidad.modelo().estaDestruida()) {
			unJuego.remover(unidad);
		}
			
		unidad.actualizarVisualizacon();
	}
}
