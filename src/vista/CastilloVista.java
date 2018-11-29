package vista;

import controlador.CrearArmaDeAsedioHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Castillo;

public class CastilloVista extends EdificioVista{
	
	public CastilloVista(int x, int y, Castillo unModelo, MapaVista unMapa) {
		super(x,y,unModelo, unMapa);
	}

	@Override
	protected void prepararBotones() {		
		Menu menuHabilidades = new Menu("Habilidades");
		//menu.setGraphic(new ImageView("file:imagen.png"));

		MenuItem crearArmaDeAsedio = new MenuItem("Crear Arma De Asedio");
		crearArmaDeAsedio.setOnAction( new CrearArmaDeAsedioHandler(elMapa, modelo));

		menuHabilidades.getItems().addAll(crearArmaDeAsedio);
		acciones.getMenus().add(menuHabilidades);
	}
	
	@Override
	protected void crearRepresentacion() {
		//-----------------------------------------
 		Image image = new Image("resources/imagenes/4x4/castillo.png");
 		construidoView = new ImageView(image);
 		construidoView.setFitHeight(120);
 		construidoView.setFitWidth(110);
		getChildren().add(construidoView);
		//-----------------------------------------
 		image = new Image("resources/imagenes/4x4/enConstruccion3.png");
 		enConstruccionView = new ImageView(image);
 		enConstruccionView.setVisible(false);
	}

	
}
