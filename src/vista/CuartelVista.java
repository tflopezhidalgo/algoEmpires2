package vista;

import java.io.File;

import controlador.TextoHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.Cuartel;
import modelo.Edificio;
import modelo.Unidad;
import modelo.excepciones.NoSePuedeConstruirTanLejosError;
import modelo.factoryCuartel.TipoGuerrero;


public class CuartelVista extends EdificioVista{
	
	public CuartelVista(int x, int y, Edificio unModelo, JuegoVista unJuego) {
		super(x,y,unModelo, unJuego);
	}

	protected void crearRepresentacion() {
		//-----------------------------------------
 		Image image = new Image("resources/images/2x2/enConstruccion3.png");
 		enConstruccionView = new ImageView(image);
 		enConstruccionView.setFitHeight(37);
 		enConstruccionView.setFitWidth(60);
		//-----------------------------------------
 		image = new Image("resources/images/2x2/cuartelAzul.png");
 		construidoViewAzul = new ImageView(image);
 		construidoViewAzul.setFitHeight(60);
 		construidoViewAzul.setFitWidth(60);
		//-----------------------------------------
 		image = new Image("resources/images/2x2/cuartelRojo.png");
 		construidoViewRojo = new ImageView(image);
 		construidoViewRojo.setFitHeight(60);
 		construidoViewRojo.setFitWidth(60);
		//-----------------------------------------
 		construidoView = construidoViewAzul;
 		construidoView.setVisible(!modelo.enConstruccion());
		getChildren().addAll(enConstruccionView, construidoView);

	}

	protected void prepararBotones() {	
        Image iconoEspadachin = new Image("resources/images/elementosJuego/panelInferior/izquierdo/botones/crearEspadachin.png");
        ImageView iconoEspadachinView = new ImageView(iconoEspadachin);
        BotonVistaPersonalizado construirEspadachin = new BotonVistaPersonalizado(iconoEspadachinView);
        construirEspadachin.setOnMousePressed(e->CrearEspadachin());
        
        Image iconoArquero = new Image("resources/images/elementosJuego/panelInferior/izquierdo/botones/crearArquero.png");
        ImageView iconoArqueroView = new ImageView(iconoArquero);
        BotonVistaPersonalizado construirArquero = new BotonVistaPersonalizado(iconoArqueroView);
        construirArquero.setOnMousePressed(e->CrearArquero());
		
		acciones.getChildren().addAll(construirEspadachin,construirArquero);
	}
	
	private void CrearArquero(){
		try {
			int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
			int y0 = elJuego.casillaSeleccionada().modelo().ejeY();

			elJuego.cobrarAJugadorActual(75);
            Unidad arquero = ((Cuartel) modelo).crearGuerrero(x0, y0, TipoGuerrero.ARQUERO);
        	playAccion();
            ArqueroVista arqueroVista = new ArqueroVista(x0,y0,arquero,elJuego);
            elJuego.agregar(arqueroVista);
        }catch (Exception e){

        	elJuego.playError();
			elJuego.cobrarAJugadorActual(-75);
            TextoError textoError = new TextoError("Error al crear un arquero");
            textoError.setOnMouseMoved(new TextoHandler(textoError));
            elJuego.getChildren().add(textoError);
        }
	}
	
	private void CrearEspadachin() {
		try {
			int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
			int y0 = elJuego.casillaSeleccionada().modelo().ejeY();

			elJuego.cobrarAJugadorActual(50);
            Unidad espadachin = ((Cuartel) modelo).crearGuerrero(x0, y0, TipoGuerrero.ESPADACHIN);
        	playAccion();
            EspadachinVista espadachinVista = new EspadachinVista(x0, y0, espadachin, elJuego);
            elJuego.agregar(espadachinVista);
        }catch (Exception e){

        	elJuego.playError();
			elJuego.cobrarAJugadorActual(-50);
            TextoError textoError = new TextoError("Error al crear un espadachin");
            textoError.setOnMouseMoved(new TextoHandler(textoError));
            elJuego.getChildren().add(textoError);
        }
	}

	@Override
	public void actualizarVisualizacon(){

		super.actualizarVisualizacon();
 		enConstruccionView.setVisible(modelo.enConstruccion());
 		construidoView.setVisible(!modelo.enConstruccion());
	}

	@Override
	protected void configurarSonidos() {
		String seleccion = "src/resources/sound/seleccion/cuartel.wav"; 
		Media seleccionSound = new Media(new File(seleccion).toURI().toString());
		sonidoSeleccionar = new MediaPlayer(seleccionSound);
		
		String muerte = "src/resources/sound/destruido/buildingdeath4.wav"; 
		Media muerteSound = new Media(new File(muerte).toURI().toString());
		sonidoMuerte = new MediaPlayer(muerteSound);
		
		String accion = "src/resources/sound/accion/crearSoldado.wav"; 
		Media accionSound = new Media(new File(accion).toURI().toString());
		sonidoAccion = new MediaPlayer(accionSound);
	}
}
