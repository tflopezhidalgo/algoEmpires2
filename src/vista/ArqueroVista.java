package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Arquero;
import modelo.excepciones.Excepcion;

public class ArqueroVista extends UnidadVista{
	
	public ArqueroVista(int x, int y, Arquero unModelo, JuegoVista unJuego) throws Excepcion {
		super(x,y,unModelo, unJuego);
	}

	@Override
	protected void crearRepresentacion() {
 		Image image = new Image("unitsTemp\\arquero.png");
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(22);
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
