package vista;


import controlador.FinalizarTurnoHandler;
import controlador.HerramientasMapa;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import modelo.Juego;
import modelo.Tablero;

public class JuegoVista extends BorderPane {

    final double SCALE_DELTA = 1.1;
	double ultimoX;
	double ultimoY;

	public static final int TAMANIO_CASILLA = CasillaVista.TAMANIO_CASILLA;
	
	//--------------------------
	
	private HBox botones;
	
	private Tablero elTablero;
	
	
	private PiezaVista piezaSeleccionada;
	private CasillaVista casillaSeleccionada;
	private Group grupoCasillas = new Group(); 
	private Group grupoPiezas = new Group();
	private Pane mapa;

    public JuegoVista(Juego juegoNuevo){
    	piezaSeleccionada = null;
    	casillaSeleccionada = null;
    	
        //juegoNuevo.iniciarJuego();
    	
    	crearMapa();
    	crearPanelSuperior();
    	crearPanelInferior();
    	crearFuncionalidades();
    }
    
    private void crearMapa(){
    	mapa = new Pane();
    	ScrollPane mapaSC = new ScrollPane();
    	
    	mapaSC.addEventFilter(ScrollEvent.SCROLL, event -> {
			  zoomPane(event); // zoom en el panel en vez de scroll
		      event.consume();
    		});
    	
    	elTablero = HerramientasMapa.crearMapa(this,grupoCasillas, grupoPiezas);
    	
    	mapa.getChildren().addAll(grupoCasillas,grupoPiezas);
    	mapaSC.setContent(mapa);
    	setCenter(mapaSC);
    }
    
    private void crearPanelSuperior() {
    	
    	System.out.println("Min: "+mapa.getMinWidth() +" Max: " +mapa.getMaxWidth() +" Pref: " + mapa.getMaxWidth()+" Normal: "+ mapa.getWidth());
    	System.out.println("B-Min: "+mapa.minWidthProperty() +" Max: " +mapa.maxWidthProperty() +" Pref: " + mapa.prefWidthProperty()+" Other: "+ mapa.widthProperty());
    	System.out.println("C-COMPUTED: "+ USE_COMPUTED_SIZE +" PREF: " + USE_PREF_SIZE);    	
    	
    	StackPane panel = new StackPane();
    	Image background = new Image("resources/images/ElementosMenu/mapa/panelSuperior/background.png");
    	ImageView backgroundView = new ImageView(background);
    	backgroundView.setFitWidth(this.getMaxWidth());
    	backgroundView.setFitHeight(30);
    	panel.getChildren().add(backgroundView);
    	
    	setTop(panel);
    }
    
    private void crearPanelInferior() {
    	HBox contenedor = new HBox();
    	StackPane panelIzquierdo = new StackPane();
    	StackPane panelCentro = new StackPane();
    	StackPane panelDerecho = new StackPane();
    	contenedor.getChildren().addAll(panelIzquierdo, panelCentro, panelDerecho);
    	
    	Image background = new Image("resources/images/ElementosMenu/mapa/panelInferior/background.png");
    	ImageView backgroundView = new ImageView(background);
    	panelCentro.getChildren().add(backgroundView);

    	MenuBar menuAcciones = new MenuBar();
    	Button botonFinTurno = new Button("Finalizar Turno");
    	botonFinTurno.setOnAction( new FinalizarTurnoHandler(grupoPiezas));
    	botones = new HBox(botonFinTurno, menuAcciones);
    	panelCentro.getChildren().add(botones);
    	
    	setBottom(contenedor);	
    }
    
    private void zoomPane(ScrollEvent event){
    	event.consume();
        if (event.getDeltaY() == 0) {
            return;
        }

        double scaleFactor
                = (event.getDeltaY() > 0)
                        ? SCALE_DELTA
                        : 1 / SCALE_DELTA;

        grupoCasillas.setScaleX(grupoCasillas.getScaleX() * scaleFactor);
        grupoCasillas.setScaleY(grupoCasillas.getScaleY() * scaleFactor);
        grupoPiezas.setScaleX(grupoPiezas.getScaleX() * scaleFactor);
        grupoPiezas.setScaleY(grupoPiezas.getScaleY() * scaleFactor);
    }
    
	private void crearFuncionalidades() {
		//------------------	ZOOM	---------------------
    	grupoCasillas.setAutoSizeChildren(true);
    	grupoPiezas.setAutoSizeChildren(true);
    	
        setOnScroll(e-> zoomPane(e));
		//------------------	FIN ZOOM	---------------------

        /*setOnMousePressed(e->{
        	ultimoX = e.getSceneX();
        	ultimoY = e.getSceneY();
        });
        
        setOnMouseDragged(e -> {
            setManaged(false);
            setTranslateX(e.getScreenX() - ultimoX);
            setTranslateY(e.getScreenY() - ultimoY);
            e.consume();
        });*/
	}
	
	public Tablero obtenerTablero() {
		return elTablero;
	}
	
	public void aniadirPieza(PiezaVista piezaVista) {
		grupoPiezas.getChildren().add(piezaVista);
	}
    
    public void asignarMenuAcciones(MenuBar acciones) {
    	botones.getChildren().remove(1);
    	botones.getChildren().add(acciones);
    }

	public PiezaVista piezaSeleccionada() {
		return piezaSeleccionada;
	}
	
	public CasillaVista casillaSeleccionada() {
		return casillaSeleccionada;
	}

	public void seleccionarPieza(PiezaVista piezaVista) {
		piezaSeleccionada = piezaVista;
	}

	public void seleccionarCasilla(CasillaVista casillaVista) {
		casillaSeleccionada = casillaVista;
	}

	public void removerPieza(PiezaVista piezaVista) {
		grupoPiezas.getChildren().remove(piezaVista);
	}


}