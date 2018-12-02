package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
}
