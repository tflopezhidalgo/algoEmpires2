package vista;

import java.io.File;

import controlador.TextoHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.Aldeano;
import modelo.Edificio;
import modelo.Plaza;
import modelo.excepciones.*;

public class PlazaVista extends EdificioVista {
	
	public PlazaVista(int x, int y, Edificio unModelo, JuegoVista unJuego) {
		super(x,y,unModelo, unJuego);
	}

	protected void crearRepresentacion() {
		//-----------------------------------------
 		Image image = new Image("resources/images/2x2/enConstruccion3.png");
 		enConstruccionView = new ImageView(image);
 		enConstruccionView.setFitHeight(37);
 		enConstruccionView.setFitWidth(60);
		//-----------------------------------------
 		image = new Image("resources/images/2x2/plazaAzul.png");
 		construidoViewAzul = new ImageView(image);
 		construidoViewAzul.setFitHeight(60);
 		construidoViewAzul.setFitWidth(60);
		//-----------------------------------------
 		image = new Image("resources/images/2x2/plazaRojo.png");
 		construidoViewRojo = new ImageView(image);
 		construidoViewRojo.setFitHeight(60);
 		construidoViewRojo.setFitWidth(60);
		//-----------------------------------------
 		construidoView = construidoViewAzul;
 		construidoView.setVisible(!modelo.enConstruccion());
		getChildren().addAll(enConstruccionView, construidoView);
	}

	protected void prepararBotones() {
        Image iconoAldeano = new Image("resources/images/elementosJuego/panelInferior/izquierdo/botones/crearAldeano.png");
        ImageView iconoAldeanoView = new ImageView(iconoAldeano);
        BotonVistaPersonalizado crearAldeano = new BotonVistaPersonalizado(iconoAldeanoView);

        crearAldeano.setOnMousePressed(e -> CrearAldeano());
        acciones.getChildren().add(crearAldeano);
	}
	
	private void CrearAldeano(){
        try {
			int x0 = elJuego.casillaSeleccionada().modelo().ejeX(); 
			int y0 = elJuego.casillaSeleccionada().modelo().ejeY();

			elJuego.cobrarAJugadorActual(25);
            Aldeano aldeano = ((Plaza) modelo).crearAldeano(x0, y0);
            if(aldeano != null) {
            	playAccion();
                AldeanoVista aldeanoVista = new AldeanoVista(x0, y0, aldeano, elJuego);
                elJuego.agregar(aldeanoVista);
            }
            else {
            	elJuego.cobrarAJugadorActual(-25);
            }
        }catch(Exception e){

        	elJuego.playError();
            TextoError textoError = new TextoError("Error al crear un aldeano");
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
		String seleccion = "src/resources/sound/seleccion/plaza.wav";
		Media seleccionSound = new Media(new File(seleccion).toURI().toString());
		sonidoSeleccionar = new MediaPlayer(seleccionSound);
		
		String muerte = "src/resources/sound/destruido/buildingdeath1.wav"; 
		Media muerteSound = new Media(new File(muerte).toURI().toString());
		sonidoMuerte = new MediaPlayer(muerteSound);
		
		String accion = "src/resources/sound/accion/crearAldeano.wav"; 
		Media accionSound = new Media(new File(accion).toURI().toString());
		sonidoAccion = new MediaPlayer(accionSound);
	}
	
}
