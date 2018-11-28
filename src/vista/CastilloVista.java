package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Area;
import modelo.ArmaDeAsedio;
import modelo.Castillo;

public class CastilloVista extends EdificioVista{
	
	public CastilloVista(int x, int y, Castillo unModelo, MapaVista unMapa) {
		super(x,y,unModelo, unMapa);
	}

	@Override
	protected void prepararBotones() {		
		Menu menuHabilidades = new Menu("Habilidades");
		//menu.setGraphic(new ImageView("file:imagen.png"));

		MenuItem crearArmaDeAsedio = new MenuItem("Crear Arma De Asedio");
		crearArmaDeAsedio.setOnAction(e -> {
			try {crearArmaDeAsedio();} 
			catch (Exception e1) {e1.printStackTrace();}
		});

		menuHabilidades.getItems().addAll(crearArmaDeAsedio);
		acciones.getMenus().add(menuHabilidades);
	}
	
	@Override
	protected void crearRepresentacion() {
		//-----------------------------------------
 		Image image = new Image("Imagenes/4x4/castillo.png");
 		construidoView = new ImageView(image);
 		construidoView.setFitHeight(120);
 		construidoView.setFitWidth(110);
		getChildren().add(construidoView);
		//-----------------------------------------
 		image = new Image("Imagenes/4x4/enConstruccion3.png");
 		enConstruccionView = new ImageView(image);
 		enConstruccionView.setVisible(false);
	}
	
	//------------------------------------------------------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//------------------------------------------------------------------------------------
	private void crearArmaDeAsedio() throws Exception {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		//TODO los mismos comentarios que en construir Plaza
		Area espacioArmaDeAsedio = elMapa.obtenerTablero().definirArea(x0, y0, x0, y0);
		ArmaDeAsedio armaDeAsedio = ((Castillo)modelo).crearCatapulta(espacioArmaDeAsedio);
		if(armaDeAsedio != null) {
			ArmaDeAsedioVista armaVisu = new ArmaDeAsedioVista(x0,y0,armaDeAsedio,elMapa);
			elMapa.aniadirPieza(armaVisu);
		}
	}
	//----------------------------------   FIN    ----------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//----------------------------------   FIN    ----------------------------------------

	
}
