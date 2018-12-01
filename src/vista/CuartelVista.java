package vista;

import controlador.CrearArqueroHandler;
import controlador.CrearEspadachinHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Cuartel;
import modelo.Edificio;

public class CuartelVista extends EdificioVista{
	
	public CuartelVista(int x, int y, Edificio unModelo, MapaVista unMapa) {
		super(x,y,unModelo, unMapa);
	}

	protected void crearRepresentacion() {
		//-----------------------------------------
 		Image image = new Image("resources/images/2x2/enConstruccion3.png");
 		enConstruccionView = new ImageView(image);
 		enConstruccionView.setFitHeight(37);
 		enConstruccionView.setFitWidth(60);
		getChildren().add(enConstruccionView);
		//-----------------------------------------
 		image = new Image("resources/images/2x2/cuartel.png");
 		construidoView = new ImageView(image);
 		construidoView.setFitHeight(60);
 		construidoView.setFitWidth(60);
 		construidoView.setVisible(false);
		getChildren().add(construidoView);
		//-----------------------------------------
	}

	protected void prepararBotones() {		
		Menu menuHabilidades = new Menu("Habilidades");

		MenuItem crearEspadachin = new MenuItem("Crear Espadachin");
		crearEspadachin.setOnAction( new CrearEspadachinHandler(elMapa, modelo));
		MenuItem crearArquero = new MenuItem("Crear Arquero");
		crearArquero.setOnAction( new CrearArqueroHandler(elMapa, modelo));

		menuHabilidades.getItems().addAll(crearEspadachin,crearArquero);
		acciones.getMenus().add(menuHabilidades);
	}

	@Override
	public void actualizarVisualizacon(){
		super.actualizarVisualizacon();
 		enConstruccionView.setVisible(modelo.enConstruccion());
 		construidoView.setVisible(!modelo.enConstruccion());
	}
}
