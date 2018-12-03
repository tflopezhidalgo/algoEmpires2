package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Aldeano;
import modelo.Area;
import modelo.Edificio;
import modelo.Plaza;

public class PlazaVista extends EdificioVista {
	
	public PlazaVista(int x, int y, Edificio unModelo, JuegoVista unMapa) {
		super(x,y,unModelo, unMapa);
	}

	protected void crearRepresentacion() {
		//-----------------------------------------
 		Image image = new Image("resources/images/2x2/enConstruccion3.png");
 		enConstruccionView = new ImageView(image);
 		enConstruccionView.setFitHeight(37);
 		enConstruccionView.setFitWidth(60);
 		enConstruccionView.setVisible(modelo.enConstruccion());
		getChildren().add(enConstruccionView);
		//-----------------------------------------
 		image = new Image("resources/images/2x2/plaza.png");
 		construidoView = new ImageView(image);
 		construidoView.setFitHeight(60);
 		construidoView.setFitWidth(60);
 		construidoView.setVisible(!modelo.enConstruccion());
		getChildren().add(construidoView);
		//-----------------------------------------
	}

	protected void prepararBotones() {
        Image iconoAldeano = new Image("resources/images/elementosJuego/botones/crearAldeano.png");
        ImageView iconoAldeanoView = new ImageView(iconoAldeano);
        BotonVistaPersonalizado crearAldeano = new BotonVistaPersonalizado(iconoAldeanoView);
        crearAldeano.setOnMousePressed(e->CrearAldeano());
		
		acciones.getChildren().add(crearAldeano);
	}
	
	private void CrearAldeano() {
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX(); 
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		//TODO los mismos comentarios que en construir Plaza
		Aldeano aldeano = ((Plaza)modelo).crearAldeano(x0, y0); 
		if(aldeano != null) {
			AldeanoVista aldeanoVista = new AldeanoVista(x0,y0,aldeano,elMapa);
			elMapa.aniadirPieza(aldeanoVista);
		}
	}

	@Override
	public void actualizarVisualizacon(){
		super.actualizarVisualizacon();
 		enConstruccionView.setVisible(modelo.enConstruccion());
 		construidoView.setVisible(!modelo.enConstruccion());
	}
	
}
