package vista;
import controlador.ConstruirCuartelHandler;
import controlador.ConstruirPlazaHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Aldeano;
import modelo.excepciones.Excepcion;

public class AldeanoVista extends UnidadVista{

	public AldeanoVista(int x, int y, Aldeano unModelo, MapaVista unMapa) throws Excepcion {
		super(x,y,unModelo, unMapa);
	}

	@Override
	protected void crearRepresentacion() {
 		Image image = new Image("resources/images/Unidades/Aldeano/aldeano.png");
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(16);
		
		//-----------------------------------------
		getChildren().add(imageView);
	}

	@Override
	protected void prepararBotones() {		
		Menu menuHabilidades = new Menu("Habilidades");
		//menu.setGraphic(new ImageView("file:imagen.png"));

		MenuItem construirCuartel = new MenuItem("Construir Cuartel");
		construirCuartel.setOnAction( new ConstruirCuartelHandler(elMapa,modelo));
		MenuItem construirPlaza = new MenuItem("Construir Plaza");
		construirPlaza.setOnAction( new ConstruirPlazaHandler(elMapa,modelo));

		menuHabilidades.getItems().addAll(construirCuartel,construirPlaza);
		acciones.getMenus().add(menuHabilidades);
	}
	
}
