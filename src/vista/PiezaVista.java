package vista;

import controlador.ClickPiezaHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.Pieza;

public abstract class PiezaVista extends StackPane {

	private Pieza modelo;
	protected JuegoVista elJuego;
	
	protected Rectangle seleccion;
	protected Rectangle barraVidaActual;
	
	protected HBox acciones;
	
	public static int TAMANIO_CASILLA = CasillaVista.TAMANIO_CASILLA;
	protected int ultimaX;
	protected int ultimaY;
	protected int alto;
	protected int ancho;
	
	//---------- Sonidos -------------
	protected MediaPlayer sonidoSeleccionar;
	protected MediaPlayer sonidoMuerte;
	protected MediaPlayer sonidoAccion;
	
	public PiezaVista(int x, int y, Pieza unModelo, JuegoVista unJuego) {
		modelo = unModelo;
		elJuego = unJuego;
		
		acciones = new HBox(10);

		//-----------------------------------------
		ancho = modelo.obtenerAreaOcupada().x1() - modelo.obtenerAreaOcupada().x0() + 1;
		alto = modelo.obtenerAreaOcupada().y1() - modelo.obtenerAreaOcupada().y0() + 1;
		setWidth(TAMANIO_CASILLA*ancho);
		setHeight(TAMANIO_CASILLA*alto);
		
		ultimaX = x;
		ultimaY = y;
		
		//ubica la pieza en la pantalla
		relocate(ultimaX* TAMANIO_CASILLA, ultimaY* TAMANIO_CASILLA);
		
		//-----------------------------------------
		//-----------------------------------------
		configurarExtras();
		prepararBotones();
		configurarSonidos();
		
		setOnMousePressed(new ClickPiezaHandler(elJuego, this));
	}
	
	protected abstract void configurarSonidos();
	
	private void configurarExtras(){
		//Cuadro de Seleccion
		seleccion = new Rectangle(TAMANIO_CASILLA*(ancho-0.05), TAMANIO_CASILLA*(alto-0.05));
		seleccion.setFill(Color.TRANSPARENT);
		seleccion.setStroke(Color.rgb(150, 250, 50, .99));
		seleccion.setStrokeWidth(TAMANIO_CASILLA * 0.05);
		seleccion.setVisible(false);
		//-----------------------------------------
		//Barra de vida
		Rectangle backgroundVida = new Rectangle(TAMANIO_CASILLA*ancho,2);
		backgroundVida.setFill(Color.RED);
		barraVidaActual = new Rectangle(TAMANIO_CASILLA*ancho,2);
		barraVidaActual.setFill(Color.LIMEGREEN);
		StackPane.setAlignment(barraVidaActual, Pos.BOTTOM_LEFT );
		StackPane.setAlignment(backgroundVida, Pos.BOTTOM_LEFT );
		
		getChildren().addAll(backgroundVida,barraVidaActual,seleccion);
	}

	public void desSeleccionar() {
		seleccion.setVisible(false);
	}
	
	public void seleccionar() {
		seleccion.setVisible(true);
		elJuego.asignarMenuAcciones(acciones);
	}
	
	public abstract Pieza modelo();
	
	public void nuevoTurno() {
		actualizarVisualizacon();
	}
	
	protected abstract void prepararBotones();
	
	protected abstract void crearRepresentacion();
	
	//Esta pieza es atacada, o reparada.
	//Reparada si: piezaSeleccionada es un Aldeano y esta Pieza es un Edificio
	//Atacada si: piezaSeleccionada es Espadachin/Arquero/Castillo o ArmaDeAsedio y estaPieza es un Edificio
	public abstract void realizarAccionSobrePieza();
	
	public void actualizarVisualizacon(){
		double porcentaje = modelo.porcentajeVidaActual();
		barraVidaActual.setWidth(TAMANIO_CASILLA*ancho*porcentaje);
	}
	
	public abstract void colocarColor();
	
	public void playSeleccionar() {
	    sonidoSeleccionar.stop();
	    sonidoSeleccionar.play();
	}
	
	public void playMuerte() {
		sonidoMuerte.stop();
		sonidoMuerte.play();
	}
	
	public void playAccion() {
		sonidoAccion.stop();
		sonidoAccion.play();
	}
	

}
