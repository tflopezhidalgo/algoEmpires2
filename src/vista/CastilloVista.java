package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Aldeano;
import modelo.ArmaDeAsedio;
import modelo.Castillo;
import modelo.Unidad;

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
		int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
		
		elJuego.cobrarAJugadorActual(ArmaDeAsedio.COSTO);
		Unidad armaDeAsedio = ((Castillo)modelo).crearCatapulta(x0, y0);
		if(armaDeAsedio != null) {
			ArmaDeAsedioVista armaVisu = new ArmaDeAsedioVista(x0,y0,armaDeAsedio,elJuego);
			elJuego.agregar(armaVisu);
		}
	}
	
	@Override
	protected void crearRepresentacion() {
		//-----------------------------------------
 		Image image = new Image("resources/images/4x4/castillo.png");
 		construidoView = new ImageView(image);
 		construidoView.setFitHeight(120);
 		construidoView.setFitWidth(110);
		getChildren().add(construidoView);
		//-----------------------------------------
 		image = new Image("resources/images/4x4/enConstruccion3.png");
 		enConstruccionView = new ImageView(image);
 		enConstruccionView.setVisible(false);
	}

	
}
