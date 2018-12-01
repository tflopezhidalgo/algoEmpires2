package vista;

import controlador.CrearAldeanoHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Edificio;
import modelo.Plaza;

public class PlazaVista extends EdificioVista {
	
	public PlazaVista(int x, int y, Edificio unModelo, MapaVista unMapa) {
		super(x,y,unModelo, unMapa);
		System.out.println("PlazaView: modelo: " + (modelo == null) + " modelo2: " + (unModelo == null) ); //TODO BORRAR
	}

	protected void crearRepresentacion() {
		//-----------------------------------------
 		Image image = new Image("resources/images/2x2/enConstruccion3.png");
 		enConstruccionView = new ImageView(image);
 		enConstruccionView.setFitHeight(37);
 		enConstruccionView.setFitWidth(60);
 		enConstruccionView.setVisible(modelo.enConstruccion());
		getChildren().add(enConstruccionView);
		//-----------------------------------------
 		image = new Image("resources/images/2x2/plaza.png");
 		construidoView = new ImageView(image);
 		construidoView.setFitHeight(60);
 		construidoView.setFitWidth(60);
 		construidoView.setVisible(!modelo.enConstruccion());
		getChildren().add(construidoView);
		//-----------------------------------------
	}

	protected void prepararBotones() {
		Menu menuHabilidades = new Menu("Habilidades");
		//menu.setGraphic(new ImageView("file:imagen.png"));

		MenuItem crearAldeano = new MenuItem("Crear Aldeano");
		System.out.println("PlazaView: modelo: " + (modelo == null) +  " mapa: " + (elMapa == null) ); //TODO BORRAR
		crearAldeano.setOnAction( new CrearAldeanoHandler(elMapa,modelo));

		menuHabilidades.getItems().addAll(crearAldeano);
		acciones.getMenus().add(menuHabilidades);
	}

	@Override
	public void actualizarVisualizacon(){
		super.actualizarVisualizacon();
 		enConstruccionView.setVisible(modelo.enConstruccion());
 		construidoView.setVisible(!modelo.enConstruccion());
	}
	
}
