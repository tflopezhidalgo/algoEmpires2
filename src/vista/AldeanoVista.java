package vista;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Aldeano;
import modelo.Area;
import modelo.Edificio;
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
		construirCuartel.setOnAction( //new ConstruirCuartelHandler(elMapa,modelo));
				e->ConstruirCuartel());
		MenuItem construirPlaza = new MenuItem("Construir Plaza");
		construirPlaza.setOnAction( //new ConstruirPlazaHandler(elMapa,modelo));
				e->ConstruirPlaza());

		menuHabilidades.getItems().addAll(construirCuartel,construirPlaza);
		acciones.getMenus().add(menuHabilidades);
	}
	
	private void ConstruirCuartel() {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();

		Area areaDeConstruccion = elMapa.obtenerTablero().definirArea(x0, y0, x0+1, y0+1);
		
		//TODO chk: almaceno en Cuartel y casteo o almaceno en Edificio?
		Edificio cuartel = ((Aldeano)modelo).crearCuartel(areaDeConstruccion);
		if(cuartel != null) {
			CuartelVista cuartelVisu = new CuartelVista(x0,y0,cuartel,elMapa);
			elMapa.aniadirPieza(cuartelVisu);
		}
	}
	
	private void ConstruirPlaza() {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();

		Area areaDeConstruccion = elMapa.obtenerTablero().definirArea(x0, y0, x0+1, y0+1);
		
		//TODO chk: almaceno en Plaza y casteo o almaceno en Edificio?
		Edificio plaza = ((Aldeano)modelo).crearPlaza(areaDeConstruccion);
		if(plaza != null) {
			PlazaVista plazaVisu = new PlazaVista(x0,y0,plaza,elMapa);
			elMapa.aniadirPieza(plazaVisu);
		}
	}
	
}
