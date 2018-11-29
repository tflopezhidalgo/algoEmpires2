package vista;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Aldeano;
import modelo.Area;
import modelo.Cuartel;
import modelo.Plaza;
import modelo.excepciones.Excepcion;

public class AldeanoVista extends UnidadVista{

	public AldeanoVista(int x, int y, Aldeano unModelo, MapaVista unMapa) throws Excepcion {
		super(x,y,unModelo, unMapa);
	}

	@Override
	protected void crearRepresentacion() {
 		Image image = new Image("Imagenes/Unidades/Aldeano/aldeano.png");
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(16);
		
		//-----------------------------------------
		getChildren().add(imageView);
	}

	@Override
	protected void prepararBotones() {		
		Menu menuHabilidades = new Menu("Habilidades");
		//menu.setGraphic(new ImageView("file:imagen.png"));

		MenuItem construirCuartel = new MenuItem("Construir Cuartel");
		construirCuartel.setOnAction(e -> {
			try {construirCuartel();} 
			catch (Exception e1) {e1.printStackTrace();}
		});
		MenuItem construirPlaza = new MenuItem("Construir Plaza");
		construirPlaza.setOnAction(e -> {
			try {construirPlaza();} 
			catch (Exception e1) {e1.printStackTrace();}
		});

		menuHabilidades.getItems().addAll(construirCuartel,construirPlaza);
		acciones.getMenus().add(menuHabilidades);
	}
	
	//------------------------------------------------------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//------------------------------------------------------------------------------------
	private void construirPlaza() throws Exception{
		//TODO alguna manera de pasar coordenadas con click de mouse sin tener que llamar a un OnClick de una casilla?
		//TODO habria que instanciar un controlador creo, y que eso cree los otros 2
		//TODO ESTO ES SUPER TEMPORAL (TEST)
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();

		Area areaDeConstruccion = elMapa.obtenerTablero().definirArea(x0, y0, x0+1, y0+1);
		Plaza plaza = ((Aldeano)modelo).crearPlaza(areaDeConstruccion);
		if(plaza != null) {
			PlazaVista plazaVisu = new PlazaVista(x0,y0,plaza,elMapa);
			//TODO algo asi? o que ella misma se agregue al root ya que tiene acceso a elJuego ?
			elMapa.aniadirPieza(plazaVisu);
		}
		//TODO los visu deberian tener acceso al visu root?? no puedo agregar la nueva visu de la plaza al root
	}
	
	private void construirCuartel() throws Exception{
		int x0 = elMapa.casillaSeleccionada().modelo().ejeX();
		int y0 = elMapa.casillaSeleccionada().modelo().ejeY();
		
		//TODO los mismos comentarios que en construir Plaza
		Area areaDeConstruccion = elMapa.obtenerTablero().definirArea(x0, y0, x0+1, y0+1);
		Cuartel cuartel = ((Aldeano)modelo).crearCuartel(areaDeConstruccion);
		if(cuartel != null) {
			CuartelVista cuartelVisu = new CuartelVista(x0,y0,cuartel,elMapa);
			elMapa.aniadirPieza(cuartelVisu);
		}
	}

	//----------------------------------   FIN    ----------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//----------------------------------   FIN    ----------------------------------------

}
