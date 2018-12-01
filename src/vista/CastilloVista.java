package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Area;
import modelo.Castillo;
import modelo.Unidad;

public class CastilloVista extends EdificioVista{
	
	public CastilloVista(int x, int y, Castillo unModelo, MapaVista unMapa) {
		super(x,y,unModelo, unMapa);
	}

	@Override
	protected void prepararBotones() {		
		Menu menuHabilidades = new Menu("Habilidades");
		//menu.setGraphic(new ImageView("file:imagen.png"));

		MenuItem crearArmaDeAsedio = new MenuItem("Crear Arma De Asedio");
		crearArmaDeAsedio.setOnAction( //new CrearArmaDeAsedioHandler(elMapa, modelo));
				e->CrearArmaDeAsedio());

		menuHabilidades.getItems().addAll(crearArmaDeAsedio);
		acciones.getMenus().add(menuHabilidades);
	}
	
	private void CrearArmaDeAsedio() {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		//TODO los mismos comentarios que en construir Plaza 
		Area espacioArmaDeAsedio = elMapa.obtenerTablero().definirArea(x0, y0, x0, y0);
		
		//TODO chk: almaceno en Arma de asedio y casteo o almaceno en Unidad?
		//ArmaDeAsedio armaDeAsedio = (ArmaDeAsedio)((Castillo)modelo).crearCatapulta(espacioArmaDeAsedio);
		Unidad armaDeAsedio = ((Castillo)modelo).crearCatapulta(espacioArmaDeAsedio);
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
