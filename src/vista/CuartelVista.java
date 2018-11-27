package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Area;
import modelo.Arquero;
import modelo.Cuartel;
import modelo.Espadachin;

public class CuartelVista extends EdificioVista{
	
	public CuartelVista(int x, int y, Cuartel unModelo, JuegoVista unJuego) {
		super(x,y,unModelo, unJuego);
	}
	
	@Override
	protected void crearRepresentacion() {
		//-----------------------------------------
 		Image image = new Image("Imagenes\\2x2\\enConstruccion3.png");
 		enConstruccionView = new ImageView(image);
 		enConstruccionView.setFitHeight(60);
 		enConstruccionView.setFitWidth(60);
		getChildren().add(enConstruccionView);
		//-----------------------------------------
 		image = new Image("Imagenes\\2x2\\cuartel.png");
 		construidoView = new ImageView(image);
 		construidoView.setFitHeight(60);
 		construidoView.setFitWidth(60);
 		construidoView.setVisible(false);
		getChildren().add(construidoView);
		//-----------------------------------------
	}
	
	@Override
	protected void prepararBotones() {		
		Menu menuHabilidades = new Menu("Habilidades");
		//menu.setGraphic(new ImageView("file:imagen.png"));

		MenuItem crearEspadachin = new MenuItem("Crear Espadachin");
		crearEspadachin.setOnAction(e -> {
			try {crearEspadachin();} 
			catch (Exception e1) {e1.printStackTrace();}
		});
		MenuItem crearArquero = new MenuItem("Crear Arquero");
		crearArquero.setOnAction(e -> {
			try {crearArquero();} 
			catch (Exception e1) {e1.printStackTrace();}
		});

		menuHabilidades.getItems().addAll(crearEspadachin,crearArquero);
		acciones.getMenus().add(menuHabilidades);
	}
	
	//------------------------------------------------------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//------------------------------------------------------------------------------------
	private void crearEspadachin() throws Exception {
		int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
		
		//TODO los mismos comentarios que en construir Plaza
		Area espacioEspadachin = elJuego.obtenerTablero().definirArea(x0, y0, x0, y0);
		Espadachin espadachin = ((Cuartel)modelo).crearEspadachin(espacioEspadachin);
		if(espadachin != null) {
			EspadachinVista espadachinVista = new EspadachinVista(x0,y0,espadachin,elJuego);
			elJuego.aniadirPieza(espadachinVista);
		}
	}
	
	private void crearArquero() throws Exception {
		int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
		int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
		
		//TODO los mismos comentarios que en construir Plaza
		Area espacioArquero = elJuego.obtenerTablero().definirArea(x0, y0, x0, y0);
		Arquero arquero = ((Cuartel)modelo).crearArquero(espacioArquero);
		if(arquero != null) {
			ArqueroVista arqueroVista = new ArqueroVista(x0,y0,arquero,elJuego);
			elJuego.aniadirPieza(arqueroVista);
		}
	}
	//----------------------------------   FIN    ----------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//----------------------------------   FIN    ----------------------------------------


}
