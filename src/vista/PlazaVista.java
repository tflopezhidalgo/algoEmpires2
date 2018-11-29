package vista;

import controlador.CrearAldeanoHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Plaza;

public class PlazaVista extends EdificioVista {
	
	public PlazaVista(int x, int y, Plaza unModelo, MapaVista unMapa) {
		super(x,y,unModelo, unMapa);
	}

	@Override
	protected void crearRepresentacion() {
		((Plaza)modelo).enConstruccion();
		//-----------------------------------------
 		Image image = new Image("resources/images/2x2/enConstruccion3.png");
 		enConstruccionView = new ImageView(image);
 		enConstruccionView.setFitHeight(37);
 		enConstruccionView.setFitWidth(60);
 		enConstruccionView.setVisible(((Plaza)modelo).enConstruccion());
		getChildren().add(enConstruccionView);
		//-----------------------------------------
 		image = new Image("resources/images/2x2/plaza.png");
 		construidoView = new ImageView(image);
 		construidoView.setFitHeight(60);
 		construidoView.setFitWidth(60);
 		construidoView.setVisible(!((Plaza)modelo).enConstruccion());
		getChildren().add(construidoView);
		//-----------------------------------------
	}

	@Override
	protected void prepararBotones() {
		Menu menuHabilidades = new Menu("Habilidades");
		//menu.setGraphic(new ImageView("file:imagen.png"));

		MenuItem crearAldeano = new MenuItem("Crear Aldeano");
		crearAldeano.setOnAction( new CrearAldeanoHandler(elMapa,modelo));

		menuHabilidades.getItems().addAll(crearAldeano);
		acciones.getMenus().add(menuHabilidades);
	}

	@Override
	public void actualizarVisualizacon(){
		super.actualizarVisualizacon();
 		enConstruccionView.setVisible(((Plaza)modelo).enConstruccion());
 		construidoView.setVisible(!((Plaza)modelo).enConstruccion());
	}
	
}
