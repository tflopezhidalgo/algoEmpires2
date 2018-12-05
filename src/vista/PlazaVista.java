package vista;

import controlador.TextoHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        Image iconoAldeano = new Image("resources/images/elementosJuego/panelInferior/izquierdo/botones/crearAldeano.png");
        ImageView iconoAldeanoView = new ImageView(iconoAldeano);
        BotonVistaPersonalizado crearAldeano = new BotonVistaPersonalizado(iconoAldeanoView);

        crearAldeano.setOnMousePressed(e -> CrearAldeano());
        acciones.getChildren().add(crearAldeano);

	}
	
	private void CrearAldeano(){

		int x0 = elJuego.casillaSeleccionada().modelo().ejeX(); 
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
        try {
            Aldeano aldeano = ((Plaza) modelo).crearAldeano(x0, y0);

            elJuego.cobrarAJugadorActual(aldeano.COSTO);

            if(aldeano != null) {
                AldeanoVista aldeanoVista = new AldeanoVista(x0, y0, aldeano, elJuego);
                elJuego.agregar(aldeanoVista);
            }
        }catch(NoSePuedeConstruirTanLejosError e){

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
