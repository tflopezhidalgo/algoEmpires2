package vista;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.Aldeano;
import modelo.Area;
import modelo.Cuartel;
import modelo.Edificio;
import modelo.Pieza;
import modelo.Plaza;
import modelo.excepciones.Excepcion;

public class AldeanoVista extends UnidadVista{

	public AldeanoVista(int x, int y, Aldeano unModelo, JuegoVista unJuego) throws Excepcion {
		super(x,y,unModelo, unJuego);
	}

	@Override
	protected void crearRepresentacion() {
 		Image image = new Image("unit_villager-male.png");
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(16);
		
		//-----------------------------------------
		//-----------------------------------------
		getChildren().add(imageView);
	}

	@Override
	protected void prepararBotones() {		
		Menu menuHabilidades = new Menu("Habilidades");
		//menu.setGraphic(new ImageView("file:imagen.png"));

		MenuItem reparar = new MenuItem("Reparar");
		reparar.setOnAction(e -> reparar());
		MenuItem construirCuartel = new MenuItem("Construir Cuartel");
		construirCuartel.setOnAction(e -> construirCuartel());
		MenuItem construirPlaza = new MenuItem("Construir Plaza");
		construirPlaza.setOnAction(e -> construirPlaza());

		menuHabilidades.getItems().addAll(reparar,construirCuartel,construirPlaza);
		acciones.getMenus().add(menuHabilidades);
	}
	
	//------------------------------------------------------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//------------------------------------------------------------------------------------
	private void construirPlaza(){
		try {
			//TODO alguna manera de pasar coordenadas con click de mouse sin tener que llamar a un OnClick de una casilla?
			//TODO habria que instanciar un controlador creo, y que eso cree los otros 2
			//TODO ESTO ES SUPER TEMPORAL (TEST)
			int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
			int y0 = elJuego.casillaSeleccionada().modelo().ejeY();

			Area areaDeConstruccion = elJuego.obtenerTablero().definirArea(x0, y0, x0+1, y0+1);
			Plaza plaza = ((Aldeano)modelo).crearPlaza(areaDeConstruccion);
			if(plaza != null) {
				PlazaVista plazaVisu = new PlazaVista(x0,y0,plaza,elJuego);
				//TODO algo asi? o que ella misma se agregue al root ya que tiene acceso a elJuego ?
				elJuego.aniadirPieza(plazaVisu);
			}
			//TODO los visu deberian tener acceso al visu root?? no puedo agregar la nueva visu de la plaza al root
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private void construirCuartel(){
		try {
			int x0 = elJuego.casillaSeleccionada().modelo().ejeX();
			int y0 = elJuego.casillaSeleccionada().modelo().ejeY();
			
			//TODO los mismos comentarios que en construir Plaza
			Area areaDeConstruccion = elJuego.obtenerTablero().definirArea(x0, y0, x0+1, y0+1);
			Cuartel cuartel = ((Aldeano)modelo).crearCuartel(areaDeConstruccion);
			if(cuartel != null) {
				CuartelVista cuartelVisu = new CuartelVista(x0,y0,cuartel,elJuego);
				elJuego.aniadirPieza(cuartelVisu);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private void reparar() {
		//TODO ESTO ES CUALQUIER COSA SUPER MAL - REHACER
		Pieza unaPieza = elJuego.piezaSeleccionada().modelo();
		if(unaPieza instanceof Edificio) {
			try {
				((Aldeano)modelo).reparar((Edificio)elJuego.piezaSeleccionada().modelo());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	//----------------------------------   FIN    ----------------------------------------
	//--------------------- FUNCIONALIDAD DE LOS BOTONES DEL MENU ------------------------
	//----------------------------------   FIN    ----------------------------------------
}
