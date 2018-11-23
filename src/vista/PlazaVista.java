package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Aldeano;
import modelo.Area;
import modelo.Arquero;
import modelo.Cuartel;
import modelo.Espadachin;
import modelo.Plaza;

public class PlazaVista extends EdificioVista {
	
	public PlazaVista(int x, int y, Plaza unModelo, JuegoVista unJuego) {
		super(x,y,unModelo, unJuego);
	}

	@Override
	protected void crearRepresentacion() {
 		Image image = new Image("plazaA.png");
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

		MenuItem crearAldeano = new MenuItem("Crear Aldeano");
		crearAldeano.setOnAction(e -> crearAldeano());

		menuHabilidades.getItems().addAll(crearAldeano);
		acciones.getMenus().add(menuHabilidades);
	}

	//------------------------------------------------------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//------------------------------------------------------------------------------------
	private void crearAldeano() {
		try {
			int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
			int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
			
			//TODO los mismos comentarios que en construir Plaza
			Area espacioAldeano = elJuego.obtenerTablero().definirArea(x0, y0, x0, y0);
			Aldeano aldeano = ((Plaza)modelo).crearAldeano(espacioAldeano);
			if(aldeano != null) {
				AldeanoVista aldeanoVista = new AldeanoVista(x0,y0,aldeano,elJuego);
				elJuego.aniadirPieza(aldeanoVista);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	//----------------------------------   FIN    ----------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//----------------------------------   FIN    ----------------------------------------

	
}
