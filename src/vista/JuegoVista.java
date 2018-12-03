package vista;


import controlador.FinalizarTurnoHandler;
import controlador.HerramientasMapa;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import modelo.Juego;
import modelo.Tablero;

public class JuegoVista extends BorderPane {

    final double SCALE_DELTA = 1.1;
	double ultimoX;
	double ultimoY;

	public static final int TAMANIO_CASILLA = CasillaVista.TAMANIO_CASILLA;
	
	//--------------------------
	private StackPane panelSuperior;
	private StackPane panelIzquierdo;
	private StackPane panelCentro;
	private StackPane panelDerecho;	
	private Pane botonesPanelIzquierdo;
	
	private Stage stagePrincipal;
	private Tablero elTablero;
	private Pane mapa;

	private PiezaVista piezaSeleccionada;
	private CasillaVista casillaSeleccionada;
	private Group grupoCasillas = new Group(); 
	private Group grupoPiezas = new Group();

    public JuegoVista(Juego juegoNuevo, Stage stagePrincipal){
    	piezaSeleccionada = null;
    	casillaSeleccionada = null;
    	this.stagePrincipal = stagePrincipal;
    	
        //juegoNuevo.iniciarJuego();
    	
    	crearMapa();
    	crearPanelSuperior();
    	crearPanelInferior();
    	crearFuncionalidades();
    }
    
    private void crearMapa(){
    	mapa = new Pane();
    	ScrollPane mapaSC = new ScrollPane();
    	
    	//Bloquea el scrolling para el ScrollPanel
    	/*mapaSC.addEventFilter(ScrollEvent.SCROLL, event -> {
			  zoomPane(event); // zoom en el panel en vez de scroll
		      event.consume();
    		});*/
    	
    	elTablero = HerramientasMapa.crearMapa(this,grupoCasillas, grupoPiezas);
    	
    	mapa.getChildren().addAll(grupoCasillas,grupoPiezas);
    	mapaSC.setContent(mapa);
    	setCenter(mapaSC);
    }
    
    private void crearPanelSuperior() {   	
    	this.panelSuperior = new StackPane();
    	Image background = new Image("resources/images/elementosJuego/mapa/panelSuperior/panelSuperior.png");
    	ImageView backgroundView = new ImageView(background);
    	backgroundView.fitWidthProperty().bind(stagePrincipal.widthProperty());
    	backgroundView.setFitHeight(30);
    	panelSuperior.getChildren().add(backgroundView);
    	
    	setTop(panelSuperior);
    }
    
    private void crearPanelInferior() {
    	HBox contenedor = new HBox();
    	this.panelIzquierdo = new StackPane();
    	this.panelCentro = new StackPane();
    	this.panelDerecho = new StackPane();
    	contenedor.getChildren().addAll(panelIzquierdo, panelCentro, panelDerecho);
    	
    	Image izquierdo = new Image("resources/images/elementosJuego/mapa/panelInferior/panelInferiorIzquierdo.png");
    	ImageView panelIzquierdoView = new ImageView(izquierdo);
    	panelIzquierdoView.fitWidthProperty().bind(stagePrincipal.widthProperty().multiply(0.27));
    	panelIzquierdoView.fitHeightProperty().bind(stagePrincipal.heightProperty().multiply(0.2));
    	panelIzquierdo.getChildren().add(panelIzquierdoView);
    	
    	Image central = new Image("resources/images/elementosJuego/mapa/panelInferior/panelInferiorCentro.png");
    	ImageView panelCentralView = new ImageView(central);
    	panelCentralView.fitWidthProperty().bind(stagePrincipal.widthProperty().multiply(0.39));
    	panelCentralView.fitHeightProperty().bind(stagePrincipal.heightProperty().multiply(0.2));
    	panelCentro.getChildren().add(panelCentralView);
    	
    	Image derecho = new Image("resources/images/elementosJuego/mapa/panelInferior/panelInferiorDerecho.png");
    	ImageView panelDerechoView = new ImageView(derecho);
    	panelDerechoView.fitWidthProperty().bind(stagePrincipal.widthProperty().multiply(0.34));
    	panelDerechoView.fitHeightProperty().bind(stagePrincipal.heightProperty().multiply(0.2));
    	panelDerecho.getChildren().add(panelDerechoView);

    	Button botonFinTurno = new Button("Finalizar Turno");
    	botonFinTurno.setOnAction( new FinalizarTurnoHandler(grupoPiezas));
    	panelDerecho.getChildren().add(botonFinTurno);
    	StackPane.setAlignment(botonFinTurno, Pos.CENTER);
    	
    	HBox menuAcciones = new HBox();
    	botonesPanelIzquierdo = new Pane(menuAcciones);
    	panelIzquierdo.getChildren().add(botonesPanelIzquierdo);
    	botonesPanelIzquierdo.setTranslateX(85);
    	botonesPanelIzquierdo.setTranslateY(40);

    	//StackPane.setAlignment(botonesPanelIzquierdo, Pos.CENTER);
    	
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
		/*//------------------	ZOOM	---------------------
    	grupoCasillas.setAutoSizeChildren(true);
    	grupoPiezas.setAutoSizeChildren(true);
    	
        setOnScroll(e-> zoomPane(e));
		//------------------	FIN ZOOM	---------------------

		//--------------	ARRASTRAR PANEL	    ---------------------
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
		//-------------	  FIN ARRASTRAR PANEL 	---------------------
	}
	
	public Tablero obtenerTablero() {
		return elTablero;
	}
	
	public void aniadirPieza(PiezaVista piezaVista) {
		grupoPiezas.getChildren().add(piezaVista);
	}
    
    public void asignarMenuAcciones(HBox acciones) {
    	botonesPanelIzquierdo.getChildren().remove(0);
    	botonesPanelIzquierdo.getChildren().add(acciones);
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