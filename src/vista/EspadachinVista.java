package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Espadachin;
import modelo.excepciones.Excepcion;

public class EspadachinVista extends UnidadVista{
	
	public EspadachinVista(int x, int y, Espadachin unModelo, MapaVista unMapa) throws Excepcion {
		super(x,y,unModelo, unMapa);
	}

	@Override
	protected void crearRepresentacion() {
 		Image image = new Image("Imagenes\\Unidades\\Espadachin\\espadachin.png");
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(27);
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
