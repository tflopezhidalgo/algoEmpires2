package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Area;
import modelo.Cuartel;
import modelo.Edificio;
import modelo.Unidad;
import modelo.factoryCuartel.TipoGuerrero;

public class CuartelVista extends EdificioVista{
	
	public CuartelVista(int x, int y, Edificio unModelo, JuegoVista unMapa) {
		super(x,y,unModelo, unMapa);
	}

	protected void crearRepresentacion() {
		//-----------------------------------------
 		Image image = new Image("resources/images/2x2/enConstruccion3.png");
 		enConstruccionView = new ImageView(image);
 		enConstruccionView.setFitHeight(37);
 		enConstruccionView.setFitWidth(60);
		getChildren().add(enConstruccionView);
		//-----------------------------------------
 		image = new Image("resources/images/2x2/cuartel.png");
 		construidoView = new ImageView(image);
 		construidoView.setFitHeight(60);
 		construidoView.setFitWidth(60);
 		construidoView.setVisible(false);
		getChildren().add(construidoView);
		//-----------------------------------------
	}

	protected void prepararBotones() {	
        Image iconoEspadachin = new Image("resources/images/elementosJuego/botones/crearEspadachin.png");
        ImageView iconoEspadachinView = new ImageView(iconoEspadachin);
        BotonVistaPersonalizado construirEspadachin = new BotonVistaPersonalizado(iconoEspadachinView);
        construirEspadachin.setOnMousePressed(e->CrearEspadachin());
        
        Image iconoArquero = new Image("resources/images/elementosJuego/botones/crearArquero.png");
        ImageView iconoArqueroView = new ImageView(iconoArquero);
        BotonVistaPersonalizado construirArquero = new BotonVistaPersonalizado(iconoArqueroView);
        construirArquero.setOnMousePressed(e->CrearArquero());
		
		acciones.getChildren().addAll(construirEspadachin,construirArquero);
	}
	
	private void CrearArquero() {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		Unidad arquero = ((Cuartel)modelo).crearGuerrero(x0, y0, TipoGuerrero.ARQUERO);
		if(arquero != null) {
			ArqueroVista arqueroVista = new ArqueroVista(x0,y0,arquero,elMapa);
			elMapa.aniadirPieza(arqueroVista);
		}
	}
	
	private void CrearEspadachin() {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		//TODO chk: almaceno en Espadachin y casteo o almaceno en Unidad?
		Unidad espadachin = ((Cuartel)modelo).crearGuerrero(x0, y0, TipoGuerrero.ESPADACHIN);
		if(espadachin != null) {
			EspadachinVista espadachinVista = new EspadachinVista(x0,y0,espadachin,elMapa);
			elMapa.aniadirPieza(espadachinVista);
		}
	}

	@Override
	public void actualizarVisualizacon(){
		super.actualizarVisualizacon();
 		enConstruccionView.setVisible(modelo.enConstruccion());
 		construidoView.setVisible(!modelo.enConstruccion());
	}
}
