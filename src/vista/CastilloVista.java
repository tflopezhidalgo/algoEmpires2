package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Aldeano;
import modelo.Area;
import modelo.ArmaDeAsedio;
import modelo.Castillo;
import modelo.Cuartel;

public class CastilloVista extends EdificioVista{
	
	public CastilloVista(int x, int y, Castillo unModelo, JuegoVista unJuego) {
		super(x,y,unModelo, unJuego);
	}

	@Override
	protected void crearRepresentacion() {
 		Image image = new Image("building_castle.png");
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(120);
		imageView.setFitWidth(110);
		
		//-----------------------------------------
		//-----------------------------------------
		getChildren().add(imageView);
	}

	@Override
	protected void prepararBotones() {		
		Menu menuHabilidades = new Menu("Habilidades");
		//menu.setGraphic(new ImageView("file:imagen.png"));

		MenuItem crearArmaDeAsedio = new MenuItem("Crear Arma De Asedio");
		crearArmaDeAsedio.setOnAction(e -> crearArmaDeAsedio());

		menuHabilidades.getItems().addAll(crearArmaDeAsedio);
		acciones.getMenus().add(menuHabilidades);
	}
	
	//------------------------------------------------------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//------------------------------------------------------------------------------------
	private void crearArmaDeAsedio() {
		try {
			int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
			int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
			
			//TODO los mismos comentarios que en construir Plaza
			Area espacioArmaDeAsedio = elJuego.obtenerTablero().definirArea(x0, y0, x0, y0);
			ArmaDeAsedio armaDeAsedio = ((Castillo)modelo).crearCatapulta(espacioArmaDeAsedio);
			if(armaDeAsedio != null) {
				ArmaDeAsedioVista armaVisu = new ArmaDeAsedioVista(x0,y0,armaDeAsedio,elJuego);
				elJuego.aniadirPieza(armaVisu);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	//----------------------------------   FIN    ----------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//----------------------------------   FIN    ----------------------------------------

	
}
