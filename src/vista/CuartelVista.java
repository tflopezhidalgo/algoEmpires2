package vista;

import controlador.TextoHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
		getChildren().add(enConstruccionView);
		//-----------------------------------------
 		image = new Image("resources/images/2x2/cuartel.png");
 		construidoView = new ImageView(image);
 		construidoView.setFitHeight(60);
 		construidoView.setFitWidth(60);
 		construidoView.setVisible(false);
		getChildren().add(construidoView);
		//-----------------------------------------
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
		int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();

		try {

            Unidad arquero = ((Cuartel) modelo).crearGuerrero(x0, y0, TipoGuerrero.ARQUERO);
            elJuego.cobrarAJugadorActual(arquero.COSTO);
            if(arquero != null) {
                ArqueroVista arqueroVista = new ArqueroVista(x0,y0,arquero,elJuego);
                elJuego.agregar(arqueroVista);
            }
        }catch (NoSePuedeConstruirTanLejosError e){

            TextoError textoError = new TextoError("No se puede construir tan lejos");
            textoError.setOnMouseMoved(new TextoHandler(textoError));
            elJuego.getChildren().add(textoError);
        }

	}
	
	private void CrearEspadachin() {
		int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();

		try {
            Unidad espadachin = ((Cuartel) modelo).crearGuerrero(x0, y0, TipoGuerrero.ESPADACHIN);
            elJuego.cobrarAJugadorActual(espadachin.COSTO);
            if (espadachin != null) {
                EspadachinVista espadachinVista = new EspadachinVista(x0, y0, espadachin, elJuego);
                elJuego.agregar(espadachinVista);
            }
        }catch (NoSePuedeConstruirTanLejosError e){

            TextoError textoError = new TextoError("No se puede construir tan lejos");
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
}
