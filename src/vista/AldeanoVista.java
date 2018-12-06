package vista;
import java.io.File;

import controlador.TextoHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.Aldeano;
import modelo.Cuartel;
import modelo.Edificio;
import modelo.Plaza;
import modelo.excepciones.Excepcion;
import modelo.excepciones.NoSePuedeConstruirTanLejosError;

public class AldeanoVista extends UnidadVista{
		
	private ImageView azul;
	private ImageView rojo;

	public AldeanoVista(int x, int y, Aldeano unModelo, JuegoVista unJuego) throws Excepcion {
		super(x,y,unModelo, unJuego);
	}

	@Override
	protected void crearRepresentacion() {
 		Image image = new Image("resources/images/Unidades/Aldeano/aldeanoAzul.png");
		azul = new ImageView(image);
		azul.setFitHeight(30);
		azul.setFitWidth(16);
		azul.setVisible(true);
		
 		image = new Image("resources/images/Unidades/Aldeano/aldeanoRojo.png");
		rojo = new ImageView(image);
		rojo.setFitHeight(30);
		rojo.setFitWidth(16);
		rojo.setVisible(false);
		//-----------------------------------------
		getChildren().addAll(azul,rojo);
	}

	@Override
	protected void prepararBotones() {
        Image iconoPlaza = new Image("resources/images/elementosJuego/panelInferior/izquierdo/botones/construirPlaza.png");
        ImageView iconoPlazaView = new ImageView(iconoPlaza);
        BotonVistaPersonalizado construirPlaza = new BotonVistaPersonalizado(iconoPlazaView);
        construirPlaza.setOnMousePressed(event -> {
        	try {ConstruirPlaza();}
        	catch (Exception e){
        		
        		elJuego.playError();
                TextoError textoError = new TextoError("Error al construir");
                textoError.setOnMouseMoved(new TextoHandler(textoError));
                elJuego.getChildren().add(textoError);
            }});
        
        Image iconoCuartel = new Image("resources/images/elementosJuego/panelInferior/izquierdo/botones/construirCuartel.png");
        ImageView iconoCuartelView = new ImageView(iconoCuartel);
        BotonVistaPersonalizado construirCuartel = new BotonVistaPersonalizado(iconoCuartelView);
        construirCuartel.setOnMousePressed(event ->  {
        	try {ConstruirCuartel();}
        	catch (Exception e){

        		elJuego.playError();
                TextoError textoError = new TextoError("Error al construir");
                textoError.setOnMouseMoved(new TextoHandler(textoError));
                elJuego.getChildren().add(textoError);
            }});
		
		acciones.getChildren().addAll(construirPlaza,construirCuartel);
	}
	
	private void ConstruirCuartel() {
		int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();

		elJuego.cobrarAJugadorActual(50);
		Edificio cuartel = ((Aldeano)modelo).crearCuartel(x0, y0);
		if(cuartel != null) {
			playAccion();
			CuartelVista cuartelVisu = new CuartelVista(x0,y0,cuartel,elJuego);
			elJuego.agregar(cuartelVisu);
		}
		else {
			elJuego.cobrarAJugadorActual(-50);
		}
	}
	
	private void ConstruirPlaza() {
		int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();

		elJuego.cobrarAJugadorActual(100);
		Edificio plaza = ((Aldeano)modelo).crearPlaza(x0, y0);
		if(plaza != null) {
			playAccion();
			PlazaVista plazaVisu = new PlazaVista(x0,y0,plaza,elJuego);
			elJuego.agregar(plazaVisu);
		}
		else {
			elJuego.cobrarAJugadorActual(-100);
		}
	}
	
	@Override
	protected void configurarSonidos() {
		super.configurarSonidos();
		String accion = "src/resources/sound/accion/construir.wav"; 
		Media accionSound = new Media(new File(accion).toURI().toString());
		sonidoAccion = new MediaPlayer(accionSound);
	}
	
	@Override
	public void colocarColor() {		
		if(elJuego.perteneceAJugador1(modelo)) {
			rojo.setVisible(true);
			azul.setVisible(false);
		}		
	}
	
}
