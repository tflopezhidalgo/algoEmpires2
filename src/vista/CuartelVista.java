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
	
	public CuartelVista(int x, int y, Edificio unModelo, MapaVista unMapa) {
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
		Menu menuHabilidades = new Menu("Habilidades");

		MenuItem crearEspadachin = new MenuItem("Crear Espadachin");
		crearEspadachin.setOnAction( //new CrearEspadachinHandler(elMapa, modelo));
				e->CrearEspadachin());
		MenuItem crearArquero = new MenuItem("Crear Arquero");
		crearArquero.setOnAction( //new CrearArqueroHandler(elMapa, modelo));
				e->CrearArquero());

		menuHabilidades.getItems().addAll(crearEspadachin,crearArquero);
		acciones.getMenus().add(menuHabilidades);
	}
	
	private void CrearArquero() {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		Area espacioArquero = elMapa.obtenerTablero().definirArea(x0, y0, x0, y0);
		Unidad arquero = ((Cuartel)modelo).crearGuerrero(espacioArquero, TipoGuerrero.ARQUERO);
		if(arquero != null) {
			ArqueroVista arqueroVista = new ArqueroVista(x0,y0,arquero,elMapa);
			elMapa.aniadirPieza(arqueroVista);
		}
	}
	
	private void CrearEspadachin() {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		Area espacioEspadachin = elMapa.obtenerTablero().definirArea(x0, y0, x0, y0);
		
		//TODO chk: almaceno en Espadachin y casteo o almaceno en Unidad?
		Unidad espadachin = ((Cuartel)modelo).crearGuerrero(espacioEspadachin, TipoGuerrero.ESPADACHIN);
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
