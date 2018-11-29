package vista;

import controlador.AccionarArmaDeAsedioHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.ArmaDeAsedio;
import modelo.excepciones.Excepcion;
import vista.estadoArmaDeAsedioVista.CatapultaVistaDesarmada;
import vista.estadoArmaDeAsedioVista.EstadoCatapultaVista;

public class ArmaDeAsedioVista extends UnidadVista{

	public static int TAMANIO_CASILLA = CasillaVista.TAMANIO_CASILLA;

	private EstadoCatapultaVista estadoActual;
	private ImageView viewMover;
	private ImageView viewAtaque;
	
	public ArmaDeAsedioVista(int x, int y, ArmaDeAsedio unModelo, MapaVista unMapa) throws Excepcion {
		super(x,y,unModelo, unMapa);
		estadoActual = new CatapultaVistaDesarmada();
	}

	@Override
	protected void prepararBotones() {
		Menu menuHabilidades = new Menu("Habilidades");

		MenuItem accionar = new MenuItem("Accionar");
		accionar.setOnAction(e -> {
			estadoActual = estadoActual.cambiarEstado(viewMover,viewAtaque);
			new AccionarArmaDeAsedioHandler(modelo);
		});

		menuHabilidades.getItems().addAll(accionar);
		acciones.getMenus().add(menuHabilidades);
	}

	@Override
	protected void crearRepresentacion() {
		Image imagenMover = new Image("resources/images/Unidades/ArmaDeAsedio/modoMovimiento.png");
		viewMover = new ImageView(imagenMover);
		viewMover.setFitWidth(30);
		viewMover.setFitHeight(24);
		//-----------------------------------------
		Image imagenAtaque = new Image("resources/images/Unidades/ArmaDeAsedio/modoAtaque.png");
		viewAtaque = new ImageView(imagenAtaque);
		viewAtaque.setFitWidth(30);
		viewAtaque.setFitHeight(29);
		viewAtaque.setVisible(false);
		//-----------------------------------------
		getChildren().addAll(viewMover,viewAtaque);
	}
	
}
