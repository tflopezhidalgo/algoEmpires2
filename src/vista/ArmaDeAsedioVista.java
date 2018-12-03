package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.ArmaDeAsedio;
import modelo.Unidad;
import vista.estadoArmaDeAsedioVista.CatapultaVistaDesarmada;
import vista.estadoArmaDeAsedioVista.EstadoCatapultaVista;

public class ArmaDeAsedioVista extends UnidadVista{

	public static int TAMANIO_CASILLA = CasillaVista.TAMANIO_CASILLA;

	private EstadoCatapultaVista estadoActual;
	private ImageView viewMover;
	private ImageView viewAtaque;
	
	public ArmaDeAsedioVista(int x, int y, Unidad unModelo, JuegoVista unMapa){
		super(x,y,unModelo, unMapa);
		estadoActual = new CatapultaVistaDesarmada();
	}

	@Override
	protected void prepararBotones() {
        Image iconoAccionar = new Image("resources/images/elementosJuego/botones/accionarCatapulta.png");
        ImageView iconoAccionarView = new ImageView(iconoAccionar);
        BotonVistaPersonalizado accionar = new BotonVistaPersonalizado(iconoAccionarView);
        accionar.setOnMousePressed( e ->{
			//TODO aca hay un casteo pero no creo que se facil de eliminar
			((ArmaDeAsedio)modelo).accionar();
			estadoActual = estadoActual.cambiarEstado(viewMover,viewAtaque);
		});
		
		acciones.getChildren().add(accionar);
	} 
	
	/*
	private EventHandler<ActionEvent> accionar() {
		estadoActual = estadoActual.cambiarEstado(viewMover,viewAtaque);
		return (new AccionarArmaDeAsedioHandler(this));
	}*/

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
