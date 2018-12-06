package vista;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
        Image iconoAccionar = new Image("resources/images/elementosJuego/panelInferior/izquierdo/botones/accionarCatapulta.png");
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
	
	@Override
	protected void configurarSonidos() {
		String seleccion = "src/resources/sound/seleccion/armaDeAsedio.wav"; 
		Media seleccionSound = new Media(new File(seleccion).toURI().toString());
		sonidoSeleccionar = new MediaPlayer(seleccionSound);
		
		String muerte = "src/resources/sound/destruido/armaDeAsedio.wav"; 
		Media muerteSound = new Media(new File(muerte).toURI().toString());
		sonidoMuerte = new MediaPlayer(muerteSound);
		
		String accion = "src/resources/sound/accion/armaDeAsedio.wav"; 
		Media accionSound = new Media(new File(accion).toURI().toString());
		sonidoAccion = new MediaPlayer(accionSound);
	}
	
}
