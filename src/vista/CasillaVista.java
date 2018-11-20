package vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CasillaVista extends StackPane{
	public static int TAMANIO_CASILLA = 30;
	
	public CasillaVista(int x, int y) {
		
		setWidth(TAMANIO_CASILLA);
		setHeight(TAMANIO_CASILLA);

		//ubica la pieza en la pantalla
		relocate(x * TAMANIO_CASILLA, y * TAMANIO_CASILLA);
		
		//le da forma a la pieza
		Rectangle rectangulo = new Rectangle(TAMANIO_CASILLA, TAMANIO_CASILLA);
		if((x+y)%2 == 0) {
			rectangulo.setFill(Color.DARKGREY);
		}
		else {
			rectangulo.setFill(Color.GREY);
		}

		
		getChildren().add(rectangulo);
	}
	
	public void reubicar(int x, int y) {
		//calcula la ubicacion
		int ultimaX = x * TAMANIO_CASILLA;
		int ultimaY = y * TAMANIO_CASILLA;
		
		//ubica la pieza en la pantalla
		relocate(ultimaX, ultimaY);
	}
}
