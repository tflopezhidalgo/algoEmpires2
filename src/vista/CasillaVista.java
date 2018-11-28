package vista;

import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.Casilla;
import modelo.Unidad;

public class CasillaVista extends StackPane{
	public static int TAMANIO_CASILLA = 30;
	
	private Rectangle seleccion;
	private Casilla modelo;
	private MapaVista elMapa;
	
	public CasillaVista(int x, int y, Casilla unModelo, MapaVista unMapa) {
		elMapa = unMapa;
		modelo = unModelo;
		
		setWidth(TAMANIO_CASILLA);
		setHeight(TAMANIO_CASILLA);

		//ubica la pieza en la pantalla
		relocate(x * TAMANIO_CASILLA, y * TAMANIO_CASILLA);
		
		crearRepresentacion();
		
		//------------------------------------------
		//------------------------------------------
		//------------------------------------------
		setOnMousePressed(e -> {
			if(e.getButton() == MouseButton.PRIMARY ) {
				seleccionarCasilla();
				//al hacer click sobre una casilla esto da null (des-selecciona la pieza)
			}
			if(e.getButton() == MouseButton.SECONDARY ) {
				//la casilla esta desocupada asique implica moviemiento
				try {moverPiezSeleccionada();} 
				catch (Exception e1) {e1.printStackTrace();}
			}
		});
	}
	
	private void moverPiezSeleccionada() throws Exception {
		PiezaVista piezaSeleccionada = elMapa.piezaSeleccionada();
		if(piezaSeleccionada instanceof UnidadVista) {
			int x0 = piezaSeleccionada.modelo().obtenerAreaOcupada().x0();
			int y0 = piezaSeleccionada.modelo().obtenerAreaOcupada().y0();
			int x1 = modelo.ejeX();
			int y1 = modelo.ejeY();
			
			int difX = x1 - x0;
			int difY = y1 - y0;
			if( Math.abs(difX) <=1 & Math.abs(difY) <=1 ) {
				UnidadVista unidadVista = (UnidadVista)(piezaSeleccionada);
				Unidad laUnidad = (Unidad)unidadVista.modelo();
				elMapa.obtenerTablero().moverEnDireccion(laUnidad, difX, difY);
				
				int xActual = laUnidad.obtenerAreaOcupada().x0();
				int yActual = laUnidad.obtenerAreaOcupada().y0();
				//Si el modelo efectivamente se movio, la vista se reubicara correctamente, 
				//de lo contrario se quedara en su lugar
				unidadVista.reubicar(xActual,yActual);
			}
		}
	}
	
	public Casilla modelo() {
		return modelo;
	}
	
	private void seleccionarCasilla() {
		//sacar efecto a casilla anterior
		CasillaVista casillaAnterior = elMapa.casillaSeleccionada();
		if(casillaAnterior != null) {
			elMapa.casillaSeleccionada().desSeleccionar();
		}
		//agregar efecto a casilla actual
		seleccionar();
		elMapa.seleccionarCasilla(this);
	}

	private void desSeleccionar() {
		seleccion.setVisible(false);
	}
	
	private void seleccionar() {
		seleccion.setVisible(true);
	}

	private void crearRepresentacion() {
		int colorTerreno = (int)(Math.random() * 40 + 130);
		
		//le da forma a la pieza
		Rectangle rectangulo = new Rectangle(TAMANIO_CASILLA, TAMANIO_CASILLA);
		rectangulo.setFill(Color.rgb(150, colorTerreno, 90, .99));
		getChildren().add(rectangulo);
		//------------------------------------------
		
		//efecto casilla seleccionada
		seleccion = new Rectangle(TAMANIO_CASILLA*0.95, TAMANIO_CASILLA*0.95);
		seleccion.setFill(Color.TRANSPARENT);
		seleccion.setStroke(Color.rgb(150, 50, 130, .99));
		seleccion.setStrokeWidth(TAMANIO_CASILLA * 0.05);
		seleccion.setVisible(false);
		getChildren().add(seleccion);
	}

}
