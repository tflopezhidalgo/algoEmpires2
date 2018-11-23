package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Espadachin;
import modelo.excepciones.Excepcion;

public class EspadachinVista extends UnidadVista{
	
	public EspadachinVista(int x, int y, Espadachin unModelo, JuegoVista unJuego) throws Excepcion {
		super(x,y,unModelo, unJuego);
	}

	@Override
	protected void crearRepresentacion() {
 		Image image = new Image("unitsTemp\\espadachin.png");
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(27);
		imageView.setFitHeight(30);
		
		//-----------------------------------------
		//-----------------------------------------
		getChildren().add(imageView);
	}

	@Override
	protected void prepararBotones() {
		// TODO Auto-generated method stub
		
	}	

}
