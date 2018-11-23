package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.ArmaDeAsedio;
import modelo.excepciones.Excepcion;

public class ArmaDeAsedioVista extends UnidadVista{

	public static int TAMANIO_CASILLA = CasillaVista.TAMANIO_CASILLA;

	private ImageView viewMover;
	private ImageView viewAtaque;
	
	public ArmaDeAsedioVista(int x, int y, ArmaDeAsedio unModelo, JuegoVista unJuego) throws Excepcion {
		super(x,y,unModelo, unJuego);
	}

	@Override
	protected void prepararBotones() {
		Menu menuHabilidades = new Menu("Habilidades");
		//menu.setGraphic(new ImageView("file:imagen.png"));

		MenuItem accionar = new MenuItem("Accionar");
		//TODO cambiar imagen que lo representa
		accionar.setOnAction(e -> accionar());

		menuHabilidades.getItems().addAll(accionar);
		acciones.getMenus().add(menuHabilidades);
	}

	@Override
	protected void crearRepresentacion() {
		Image imagenMover = new Image("unitsTemp\\armaAsedioMover.png");
		viewMover = new ImageView(imagenMover);
		viewMover.setFitWidth(30);
		viewMover.setFitHeight(24);
		//-----------------------------------------
		Image imagenAtaque = new Image("unitsTemp\\armaAsedioAtaque.png");
		viewAtaque = new ImageView(imagenAtaque);
		viewAtaque.setFitWidth(30);
		viewAtaque.setFitHeight(29);
		viewAtaque.setVisible(false);
		//-----------------------------------------
		getChildren().addAll(viewMover,viewAtaque);
	}
	
	//------------------------------------------------------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//------------------------------------------------------------------------------------
	private void accionar() {
		((ArmaDeAsedio)modelo).accionar();
		//TODO IF- fue accionado exitosamente{ }
		//estaOcupado == modo ataque ESTO SE VA A MODIFICAR CON LOS ESTADOS
		if(((ArmaDeAsedio)modelo).estaOcupado()) {
			viewAtaque.setVisible(true);
			viewMover.setVisible(false);
		}
		else {
			viewAtaque.setVisible(false);
			viewMover.setVisible(true);
		}
	}
	//----------------------------------   FIN    ----------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//----------------------------------   FIN    ----------------------------------------

}
