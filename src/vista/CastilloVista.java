package vista;

import java.io.File;

import controlador.TextoHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.Aldeano;
import modelo.ArmaDeAsedio;
import modelo.Castillo;
import modelo.Tablero;
import modelo.Unidad;
import modelo.excepciones.NoSePuedeConstruirTanLejosError;

public class CastilloVista extends EdificioVista{
	
	public CastilloVista(int x, int y, Castillo unModelo, JuegoVista unJuego) {
		super(x,y,unModelo, unJuego);
	}

	@Override
	protected void prepararBotones() {
        Image iconoArmaDeAsedio = new Image("resources/images/elementosJuego/panelInferior/izquierdo/botones/crearArmaDeAsedio.png");
        ImageView iconoArmaDeAsedioView = new ImageView(iconoArmaDeAsedio);
        BotonVistaPersonalizado construirArmaDeAsedio = new BotonVistaPersonalizado(iconoArmaDeAsedioView);
        construirArmaDeAsedio.setOnMousePressed(e->CrearArmaDeAsedio());
		
		acciones.getChildren().addAll(construirArmaDeAsedio);
	}
	
	private void CrearArmaDeAsedio() {
		try {
			int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
			int y0 = elJuego.casillaSeleccionada().modelo().ejeY();

			elJuego.cobrarAJugadorActual(200);
            Unidad armaDeAsedio = ((Castillo) modelo).crearCatapulta(x0, y0);
            if (armaDeAsedio != null) {
            	playAccion();
                ArmaDeAsedioVista armaVisu = new ArmaDeAsedioVista(x0, y0, armaDeAsedio, elJuego);
                elJuego.agregar(armaVisu);
            }
            else {
            	elJuego.cobrarAJugadorActual(-200);
            }
		}catch (Exception e){

    		elJuego.playError();
            TextoError textoError = new TextoError("Error al crear un arma de asedio");
            textoError.setOnMouseMoved(new TextoHandler(textoError));
            elJuego.getChildren().add(textoError);
        }
	}
	
	@Override
	protected void crearRepresentacion() {
		//-----------------------------------------
 		Image image = new Image("resources/images/4x4/castilloAzul.png");
 		construidoViewAzul = new ImageView(image);
 		construidoViewAzul.setFitHeight(120);
 		construidoViewAzul.setFitWidth(110);
		//-----------------------------------------
 		image = new Image("resources/images/4x4/castilloRojo.png");
 		construidoViewRojo = new ImageView(image);
 		construidoViewRojo.setFitHeight(120);
 		construidoViewRojo.setFitWidth(110);
		//-----------------------------------------
 		image = new Image("resources/images/4x4/enConstruccion3.png");
 		enConstruccionView = new ImageView(image);
		//-----------------------------------------
 		construidoView = construidoViewAzul;
 		construidoView.setVisible(!modelo.enConstruccion());
		getChildren().addAll(construidoView);
	}

	@Override
	protected void configurarSonidos() {
		String seleccion = "src/resources/sound/seleccion/castillo.wav"; 
		Media seleccionSound = new Media(new File(seleccion).toURI().toString());
		sonidoSeleccionar = new MediaPlayer(seleccionSound);
		
		String muerte = "src/resources/sound/destruido/buildingdeath3.wav"; 
		Media muerteSound = new Media(new File(muerte).toURI().toString());
		sonidoMuerte = new MediaPlayer(muerteSound);
		
		String accion = "src/resources/sound/accion/crearSoldado.wav"; 
		Media accionSound = new Media(new File(accion).toURI().toString());
		sonidoAccion = new MediaPlayer(accionSound);
	}

	
}
