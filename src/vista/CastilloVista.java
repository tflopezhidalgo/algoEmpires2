package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Area;
import modelo.Castillo;
import modelo.Unidad;

public class CastilloVista extends EdificioVista{
	
	public CastilloVista(int x, int y, Castillo unModelo, JuegoVista unMapa) {
		super(x,y,unModelo, unMapa);
	}

	@Override
	protected void prepararBotones() {
        Image iconoArmaDeAsedio = new Image("resources/images/elementosJuego/botones/crearArmaDeAsedio.png");
        ImageView iconoArmaDeAsedioView = new ImageView(iconoArmaDeAsedio);
        BotonVistaPersonalizado construirArmaDeAsedio = new BotonVistaPersonalizado(iconoArmaDeAsedioView);
        construirArmaDeAsedio.setOnMousePressed(e->CrearArmaDeAsedio());
		
		acciones.getChildren().addAll(construirArmaDeAsedio);
	}
	
	private void CrearArmaDeAsedio() {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		Unidad armaDeAsedio = ((Castillo)modelo).crearCatapulta(x0, y0);
		if(armaDeAsedio != null) {
			ArmaDeAsedioVista armaVisu = new ArmaDeAsedioVista(x0,y0,armaDeAsedio,elMapa);
			elMapa.aniadirPieza(armaVisu);
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
