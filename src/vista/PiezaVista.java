package vista;

import controlador.ClickPiezaHandler;
import javafx.geometry.Pos;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.Pieza;

public abstract class PiezaVista extends StackPane {

	protected Pieza modelo;
	protected MapaVista elMapa;
	
	protected Rectangle seleccion;
	protected Rectangle barraVidaActual;
	
	protected MenuBar acciones;
	
	public static int TAMANIO_CASILLA = CasillaVista.TAMANIO_CASILLA;
	protected int ultimaX;
	protected int ultimaY;
	protected int alto;
	protected int ancho;
	
	public PiezaVista(int x, int y, Pieza unModelo, MapaVista unMapa) {
		modelo = unModelo;
		elMapa = unMapa;
		
		acciones = new MenuBar();

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
		crearRepresentacion();
		
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
		//-----------------------------------------
		prepararBotones();
		//-----------------------------------------
		
		setOnMousePressed(new ClickPiezaHandler(elMapa,this));

	}
	
	protected void seleccionarPieza() {
		//sacar efecto a casilla anterior
		PiezaVista piezaAnterior = elMapa.piezaSeleccionada();
		if(piezaAnterior != null) {
			elMapa.piezaSeleccionada().desSeleccionar();
		}
		//agregar efecto a casilla actual
		seleccionar();
		elMapa.seleccionarPieza(this);
	}

	public void desSeleccionar() {
		seleccion.setVisible(false);
	}
	
	public void seleccionar() {
		seleccion.setVisible(true);
		elMapa.asignarMenuAcciones(acciones);
	}
	
	public Pieza modelo() {
		return modelo;
	}
	
	public void nuevoTurno() {
		modelo.nuevoTurno();
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
	

}
