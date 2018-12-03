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

	public AldeanoVista(int x, int y, Aldeano unModelo, JuegoVista unMapa) throws Excepcion {
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
        Image iconoPlaza = new Image("resources/images/elementosJuego/botones/construirPlaza.png");
        ImageView iconoPlazaView = new ImageView(iconoPlaza);
        BotonVistaPersonalizado construirPlaza = new BotonVistaPersonalizado(iconoPlazaView);
        construirPlaza.setOnMousePressed(event -> ConstruirPlaza());
        
        Image iconoCuartel = new Image("resources/images/elementosJuego/botones/construirCuartel.png");
        ImageView iconoCuartelView = new ImageView(iconoCuartel);
        BotonVistaPersonalizado construirCuartel = new BotonVistaPersonalizado(iconoCuartelView);
        construirCuartel.setOnMousePressed(event -> ConstruirCuartel());
		
		acciones.getChildren().addAll(construirPlaza,construirCuartel);
	}
	
	private void ConstruirCuartel() {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		//TODO chk: almaceno en Cuartel y casteo o almaceno en Edificio?
		Edificio cuartel = ((Aldeano)modelo).crearCuartel(x0, y0);
		if(cuartel != null) {
			CuartelVista cuartelVisu = new CuartelVista(x0,y0,cuartel,elMapa);
			elMapa.aniadirPieza(cuartelVisu);
		}
	}
	
	private void ConstruirPlaza() {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		//TODO chk: almaceno en Plaza y casteo o almaceno en Edificio?
		Edificio plaza = ((Aldeano)modelo).crearPlaza(x0, y0);
		if(plaza != null) {
			PlazaVista plazaVisu = new PlazaVista(x0,y0,plaza,elMapa);
			elMapa.aniadirPieza(plazaVisu);
		}
	}
	
}
