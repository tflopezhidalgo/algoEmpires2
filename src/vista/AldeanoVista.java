package vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class AldeanoVista extends StackPane{

	public static int TAMANIO_CASILLA = CasillaVista.TAMANIO_CASILLA;
	
	public AldeanoVista(int x, int y) {
		
		setWidth(TAMANIO_CASILLA*4);
		setHeight(TAMANIO_CASILLA*4);
		
		//calcula la ubicacion
		int ultimaX = x * TAMANIO_CASILLA;
		int ultimaY = y * TAMANIO_CASILLA;
		
		//ubica la pieza en la pantalla
		relocate(ultimaX, ultimaY);
		
		//le da forma a la pieza
		Rectangle rectangulo = new Rectangle(TAMANIO_CASILLA*0.95, TAMANIO_CASILLA*0.95);
		//TODO colocar color del equipo que representa ? o.. no colocar ningun color remplazar por imagen?
		rectangulo.setFill(Color.ORANGE);
		
		//Le hace un borde negro a la ficha
		rectangulo.setStroke(Color.BLACK);
		rectangulo.setStrokeWidth(TAMANIO_CASILLA* 0.05);
		
		getChildren().addAll(rectangulo);
	}
	
	public void reubicar(int x, int y) {
		//calcula la ubicacion
		int ultimaX = x * TAMANIO_CASILLA;
		int ultimaY = y * TAMANIO_CASILLA;
		
		//ubica la pieza en la pantalla
		relocate(ultimaX, ultimaY);
	}
}
