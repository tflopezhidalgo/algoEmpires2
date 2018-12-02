package vista;

import controlador.ClickCasillaHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.Casilla;

public class CasillaVista extends StackPane{
	public static int TAMANIO_CASILLA = 30;
	
	private Rectangle seleccion;
	private Casilla modelo;
	private JuegoVista elMapa;
	
	public CasillaVista(int x, int y, Casilla unModelo, JuegoVista unMapa) {
		elMapa = unMapa;
		modelo = unModelo;
		
		setWidth(TAMANIO_CASILLA);
		setHeight(TAMANIO_CASILLA);

		relocate(x * TAMANIO_CASILLA, y * TAMANIO_CASILLA);
		
		crearRepresentacion();
		
		setOnMousePressed( new ClickCasillaHandler(elMapa, this));
	}
	
	public Casilla modelo() {
		return modelo;
	}
	
	public void desSeleccionar() {
		seleccion.setVisible(false);
	}
	
	public void seleccionar() {
		seleccion.setVisible(true);
	}

	private void crearRepresentacion() {
		//-----------------------------------------
		int colorPasto = (int)(Math.random() * 7 + 2);	
		String URLterreno = "resources/images/pasto/pasto";
		URLterreno += colorPasto + ".png";
		
 		Image image = new Image(URLterreno);
 		ImageView terreno = new ImageView(image);
 		terreno.setFitHeight(TAMANIO_CASILLA);
 		terreno.setFitWidth(TAMANIO_CASILLA);
		getChildren().add(terreno);
		//-----------------------------------------
		/*int colorTerreno = (int)(Math.random() * 40 + 130);
		//le da forma a la pieza
		Rectangle rectangulo = new Rectangle(TAMANIO_CASILLA, TAMANIO_CASILLA);
		rectangulo.setFill(Color.rgb(150, colorTerreno, 90, .99));
		getChildren().add(rectangulo);
		//------------------------------------------*/
		
		//efecto casilla seleccionada
		seleccion = new Rectangle(TAMANIO_CASILLA*0.95, TAMANIO_CASILLA*0.95);
		seleccion.setFill(Color.TRANSPARENT);
		seleccion.setStroke(Color.rgb(150, 50, 130, .99));
		seleccion.setStrokeWidth(TAMANIO_CASILLA * 0.05);
		seleccion.setVisible(false);
		getChildren().add(seleccion);
	}

}
