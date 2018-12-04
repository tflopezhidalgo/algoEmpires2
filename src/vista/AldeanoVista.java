package vista;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Aldeano;
import modelo.Cuartel;
import modelo.Edificio;
import modelo.Plaza;
import modelo.excepciones.Excepcion;

public class AldeanoVista extends UnidadVista{

	public AldeanoVista(int x, int y, Aldeano unModelo, JuegoVista unJuego) throws Excepcion {
		super(x,y,unModelo, unJuego);
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
        Image iconoPlaza = new Image("resources/images/elementosJuego/panelInferior/izquierdo/botones/construirPlaza.png");
        ImageView iconoPlazaView = new ImageView(iconoPlaza);
        BotonVistaPersonalizado construirPlaza = new BotonVistaPersonalizado(iconoPlazaView);
        construirPlaza.setOnMousePressed(event -> ConstruirPlaza());
        
        Image iconoCuartel = new Image("resources/images/elementosJuego/panelInferior/izquierdo/botones/construirCuartel.png");
        ImageView iconoCuartelView = new ImageView(iconoCuartel);
        BotonVistaPersonalizado construirCuartel = new BotonVistaPersonalizado(iconoCuartelView);
        construirCuartel.setOnMousePressed(event -> ConstruirCuartel());
		
		acciones.getChildren().addAll(construirPlaza,construirCuartel);
	}
	
	private void ConstruirCuartel() {
		int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
		
		elJuego.cobrarAJugadorActual(Cuartel.COSTO);
		Edificio cuartel = ((Aldeano)modelo).crearCuartel(x0, y0);
		if(cuartel != null) {
			CuartelVista cuartelVisu = new CuartelVista(x0,y0,cuartel,elJuego);
			elJuego.agregar(cuartelVisu);
		}
	}
	
	private void ConstruirPlaza() {
		int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
		
		elJuego.cobrarAJugadorActual(Plaza.COSTO);
		Edificio plaza = ((Aldeano)modelo).crearPlaza(x0, y0);
		if(plaza != null) {
			PlazaVista plazaVisu = new PlazaVista(x0,y0,plaza,elJuego);
			elJuego.agregar(plazaVisu);
		}
	}
	
}
