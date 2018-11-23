package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Area;
import modelo.ArmaDeAsedio;
import modelo.Arquero;
import modelo.Castillo;
import modelo.Cuartel;
import modelo.Espadachin;

public class CuartelVista extends EdificioVista{
	
	public CuartelVista(int x, int y, Cuartel unModelo, JuegoVista unJuego) {
		super(x,y,unModelo, unJuego);
	}
	
	@Override
	protected void crearRepresentacion() {
		Image image = new Image("barrack.png");
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(60);
		imageView.setFitWidth(60);
		
		//-----------------------------------------
		//-----------------------------------------
		getChildren().add(imageView);		
	}
	
	@Override
	protected void prepararBotones() {		
		Menu menuHabilidades = new Menu("Habilidades");
		//menu.setGraphic(new ImageView("file:imagen.png"));

		MenuItem crearEspadachin = new MenuItem("Crear Espadachin");
		crearEspadachin.setOnAction(e -> crearEspadachin());
		MenuItem crearArquero = new MenuItem("Crear Arquero");
		crearArquero.setOnAction(e -> crearArquero());

		menuHabilidades.getItems().addAll(crearEspadachin,crearArquero);
		acciones.getMenus().add(menuHabilidades);
	}
	
	//------------------------------------------------------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//------------------------------------------------------------------------------------
	private void crearEspadachin() {
		try {
			int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
			int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
			
			//TODO los mismos comentarios que en construir Plaza
			Area espacioEspadachin = elJuego.obtenerTablero().definirArea(x0, y0, x0, y0);
			Espadachin espadachin = ((Cuartel)modelo).crearEspadachin(espacioEspadachin);
			if(espadachin != null) {
				EspadachinVista espadachinVista = new EspadachinVista(x0,y0,espadachin,elJuego);
				elJuego.aniadirPieza(espadachinVista);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private void crearArquero() {
		try {
			int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
			int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
			
			//TODO los mismos comentarios que en construir Plaza
			Area espacioArquero = elJuego.obtenerTablero().definirArea(x0, y0, x0, y0);
			Arquero arquero = ((Cuartel)modelo).crearArquero(espacioArquero);
			if(arquero != null) {
				ArqueroVista arqueroVista = new ArqueroVista(x0,y0,arquero,elJuego);
				elJuego.aniadirPieza(arqueroVista);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	//----------------------------------   FIN    ----------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//----------------------------------   FIN    ----------------------------------------


}
