package vista;


import controlador.FinalizarTurnoHandler;
import controlador.HerramientasMapa;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Juego;
import modelo.Jugador;
import modelo.Pieza;
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
	private StackPane botonesPanelIzquierdo;
	
	private Juego modelo;
	private Stage stagePrincipal;
	private Tablero elTablero;
	private Pane mapa;
	
	private Jugador jugador1;
	private Jugador jugador2;
	
	private PiezaVista piezaSeleccionada;
	private CasillaVista casillaSeleccionada;
	private Group grupoCasillas = new Group(); 
	private Group grupoPiezas = new Group();
	
	//---------- Panel Inferior Central ----------------------
	Label nombreJugador1;
	Label nombreJugador2;
	
	Label oro1;
	Label oro2;
	
	Label edificios1;
	Label edificios2;
	
	Label hpCastillo1;
	Label hpCastillo2;
	
	Label aldeanos1;
	Label aldeanos2;
	
	Label soldados1;
	Label soldados2;
	
	Label poblacion1;
	Label poblacion2;
	//---------------------------------------------------------


    public JuegoVista(String nombreJugador1, String nombreJugador2, Stage stagePrincipal){
    	piezaSeleccionada = null;
    	casillaSeleccionada = null;
    	this.stagePrincipal = stagePrincipal;
    	
    	jugador1 = new Jugador(nombreJugador1);
    	jugador2 = new Jugador(nombreJugador2);
    	
    	modelo = HerramientasMapa.crearJuego(this,grupoCasillas, grupoPiezas, jugador1, jugador2);
    	    	
    	crearMapa();
    	crearPanelSuperior();
    	crearPanelInferior();
    	
    	modelo.iniciarJuego();
    }
    
    public Juego modelo() {
    	return modelo;
    }

    public void cobrarAJugadorActual(int monto){
    	modelo.getJugadorActual().cobrar(monto);
    }
    
    public void agregarTablero(Tablero unTablero) {
    	elTablero = unTablero;
    }
    
    private void crearMapa(){
    	mapa = new Pane();
    	ScrollPane mapaSC = new ScrollPane();

    	mapa.getChildren().addAll(grupoCasillas,grupoPiezas);
    	mapaSC.setContent(mapa);
    	setCenter(mapaSC);
    }
    
    private void crearPanelSuperior() {   	
    	this.panelSuperior = new StackPane();
    	Image background = new Image("resources/images/elementosJuego/panelSuperior/panelSuperior.png");
    	ImageView backgroundView = new ImageView(background);
    	backgroundView.fitWidthProperty().bind(stagePrincipal.widthProperty());
    	backgroundView.setFitHeight(30);
    	panelSuperior.getChildren().add(backgroundView);
    	
    	setTop(panelSuperior);
    }
    
    private void crearPanelInferior() {
    	crearPanelInferiorIzquierdo();
    	crearPanelInferiorCentro();
    	crearPanelInferiorDerecho();
    	
    	HBox contenedor = new HBox();
    	contenedor.getChildren().addAll(panelIzquierdo, panelCentro, panelDerecho);
    	setBottom(contenedor);	
    }

    private void crearPanelInferiorIzquierdo() {
    	this.panelIzquierdo = new StackPane();
    	
    	Image izquierdo = new Image("resources/images/elementosJuego/panelInferior/izquierdo/background.png");
    	ImageView panelIzquierdoView = new ImageView(izquierdo);
    	panelIzquierdoView.fitWidthProperty().bind(stagePrincipal.widthProperty().multiply(0.27));
    	panelIzquierdoView.fitHeightProperty().bind(stagePrincipal.heightProperty().multiply(0.2));
    	panelIzquierdo.getChildren().add(panelIzquierdoView);
    	
    	HBox menuPanelIzquierdo = new HBox();
    	botonesPanelIzquierdo = new StackPane(menuPanelIzquierdo);
    	panelIzquierdo.getChildren().add(botonesPanelIzquierdo);
    	botonesPanelIzquierdo.setAlignment(Pos.CENTER);
    	botonesPanelIzquierdo.setTranslateX(85);
    }
    
    private void crearPanelInferiorCentro() {
    	panelCentro = new StackPane();
    	
    	Image central = new Image("resources/images/elementosJuego/panelInferior/centro/background2.png");
    	ImageView panelCentralView = new ImageView(central);
    	panelCentralView.fitWidthProperty().bind(stagePrincipal.widthProperty().multiply(0.39));
    	panelCentralView.fitHeightProperty().bind(stagePrincipal.heightProperty().multiply(0.2));
    	panelCentro.getChildren().add(panelCentralView);
    	
    	configurarCuadrosDeTexto();
    }
    
    private void crearPanelInferiorDerecho() {
    	this.panelDerecho = new StackPane();
    	
    	Image derecho = new Image("resources/images/elementosJuego/panelInferior/derecho/background.png");
    	ImageView panelDerechoView = new ImageView(derecho);
    	panelDerechoView.fitWidthProperty().bind(stagePrincipal.widthProperty().multiply(0.34));
    	panelDerechoView.fitHeightProperty().bind(stagePrincipal.heightProperty().multiply(0.2));
    	panelDerecho.getChildren().add(panelDerechoView);
    	
    	Button botonFinTurno = new Button("Finalizar Turno");
    	botonFinTurno.setOnAction( new FinalizarTurnoHandler(this, grupoPiezas));
    	Button botonSalir = new Button("Salir");
    	botonSalir.setOnAction(event ->  stagePrincipal.close());
    	
    	VBox menuPanelDerecho = new VBox(10);
    	menuPanelDerecho.getChildren().addAll(botonFinTurno, botonSalir);
    	panelDerecho.getChildren().add(menuPanelDerecho);
    	menuPanelDerecho.setAlignment(Pos.CENTER);
    }
    
    private void configurarCuadrosDeTexto() {
    	nombreJugador1 = new Label(jugador1.obtenerNombre());    	
    	nombreJugador2 = new Label(jugador2.obtenerNombre());
    	
    	oro1 = new Label(Integer.toString(jugador1.obtenerOro()));
    	oro2 = new Label(Integer.toString(jugador2.obtenerOro()));
    	
    	edificios1 = new Label(Integer.toString(jugador1.cantidadEdificios()));
    	edificios2 = new Label(Integer.toString(jugador2.cantidadEdificios()));
    	
    	hpCastillo1 = new Label(Integer.toString(jugador1.hpCastillo()));
    	hpCastillo2 = new Label(Integer.toString(jugador2.hpCastillo()));
    	
    	aldeanos1 = new Label(Integer.toString(jugador1.cantidadAldeanos()));
    	aldeanos2 = new Label(Integer.toString(jugador2.cantidadAldeanos()));
    	
    	soldados1 = new Label(Integer.toString(jugador1.cantidadSoldados()));
    	soldados2 = new Label(Integer.toString(jugador2.cantidadSoldados()));
    	
    	poblacion1 = new Label(Integer.toString(jugador1.getPoblacion()));
    	poblacion2 = new Label(Integer.toString(jugador2.getPoblacion()));
    	
    	panelCentro.getChildren().addAll(nombreJugador1, oro1, edificios1, hpCastillo1, aldeanos1, soldados1, poblacion1);
    	panelCentro.getChildren().addAll(nombreJugador2, oro2, edificios2, hpCastillo2, aldeanos2, soldados2, poblacion2);
    	
    	oro1.setManaged(false);
    	oro1.resizeRelocate(90, 60, 120, 30);
    	oro1.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
    	edificios1.setManaged(false);
    	edificios1.resizeRelocate(90, 115, 120, 30);  
    	edificios1.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
    	hpCastillo1.setManaged(false);
    	hpCastillo1.resizeRelocate(90, 170, 120, 30);  
    	hpCastillo1.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
    	aldeanos1.setManaged(false);
    	aldeanos1.resizeRelocate(270, 60, 120, 30);  
    	aldeanos1.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
    	soldados1.setManaged(false);
    	soldados1.resizeRelocate(270, 115, 120, 30);
    	soldados1.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
    	poblacion1.setManaged(false);
    	poblacion1.resizeRelocate(270, 170, 120, 30);
    	poblacion1.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
    	
    	oro2.setManaged(false);
    	oro2.resizeRelocate(545, 60, 120, 30);
    	oro2.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
    	oro2.setAlignment(Pos.CENTER_RIGHT);
    	edificios2.setManaged(false);
    	edificios2.resizeRelocate(545, 115, 120, 30);
    	edificios2.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
    	edificios2.setAlignment(Pos.CENTER_RIGHT);
    	hpCastillo2.setManaged(false);
    	hpCastillo2.resizeRelocate(545, 170, 120, 30);
    	hpCastillo2.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
    	hpCastillo2.setAlignment(Pos.CENTER_RIGHT);
    	aldeanos2.setManaged(false);
    	aldeanos2.resizeRelocate(355, 60, 120, 30);
    	aldeanos2.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
    	aldeanos2.setAlignment(Pos.CENTER_RIGHT);
    	soldados2.setManaged(false);
    	soldados2.resizeRelocate(355, 115, 120, 30);
    	soldados2.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
    	soldados2.setAlignment(Pos.CENTER_RIGHT);
    	poblacion2.setManaged(false);
    	poblacion2.resizeRelocate(355, 170, 120, 30);
    	poblacion2.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
    	poblacion2.setAlignment(Pos.CENTER_RIGHT);
    	
    	nombreJugador1.setManaged(false);
    	nombreJugador1.resizeRelocate(110, 30, 120, 30);
    	nombreJugador1.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
    	nombreJugador2.setManaged(false);
    	nombreJugador2.resizeRelocate(550, 30, 120, 30);
    	nombreJugador2.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
    }
    
    public void actualizarContadores() {
    	oro1.setText(Integer.toString(jugador1.obtenerOro()));
    	oro2.setText(Integer.toString(jugador2.obtenerOro()));
    	
    	edificios1.setText(Integer.toString(jugador1.cantidadEdificios()));
    	edificios2.setText(Integer.toString(jugador2.cantidadEdificios()));
    	
    	hpCastillo1.setText(Integer.toString(jugador1.hpCastillo()));
    	hpCastillo2.setText(Integer.toString(jugador2.hpCastillo()));
    	
    	aldeanos1.setText(Integer.toString(jugador1.cantidadAldeanos()));
    	aldeanos2.setText(Integer.toString(jugador2.cantidadAldeanos()));
    	
    	soldados1.setText(Integer.toString(jugador1.cantidadSoldados()));
    	soldados2.setText(Integer.toString(jugador2.cantidadSoldados()));
    	
    	poblacion1.setText(Integer.toString(jugador1.getPoblacion()));
    	poblacion2.setText(Integer.toString(jugador2.getPoblacion()));
    }

	public Tablero obtenerTablero() {
		return elTablero;
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
	
	//----------------------------------------------------------------------------
	//---------------------      Manejo de Piezas     ----------------------------
	public void agregar(AldeanoVista unAldeano) {
		modelo.getJugadorActual().agregar(unAldeano.modelo());
		grupoPiezas.getChildren().add(unAldeano);
		actualizarContadores();
	}
	
	public void agregar(CastilloVista unCastillo) {
		modelo.getJugadorActual().agregar(unCastillo.modelo());
		grupoPiezas.getChildren().add(unCastillo);
		actualizarContadores();
	}
	
	public void agregar(EdificioVista unEdificio) {
		modelo.getJugadorActual().agregar(unEdificio.modelo());
		grupoPiezas.getChildren().add(unEdificio);
		actualizarContadores();
	}
	
	public void agregar(UnidadVista unaUnidad) {
		if(unaUnidad instanceof AldeanoVista) {
			agregar((AldeanoVista) unaUnidad);
		}
		else {
			modelo.getJugadorActual().agregar(unaUnidad.modelo());
			grupoPiezas.getChildren().add(unaUnidad);
		}
		actualizarContadores();
	}
	
	//TODO necesito un remover para castillo o el programa corta muy rapido que no ?
	
	public void remover(UnidadVista unidadVista) {
		if(unidadVista instanceof AldeanoVista) {
			remover((AldeanoVista)unidadVista);
		}
		else {
			modelo.getJugadorEnemigo().remover(unidadVista.modelo());
		}
		grupoPiezas.getChildren().remove(unidadVista);
		actualizarContadores();
	}
	
	public void remover(EdificioVista edificioVista) {
		modelo.getJugadorEnemigo().remover(edificioVista.modelo());
		grupoPiezas.getChildren().remove(edificioVista);
	}
	
	public void remover(AldeanoVista aldeanoVista) {
		modelo.getJugadorEnemigo().remover(aldeanoVista.modelo());
		grupoPiezas.getChildren().remove(aldeanoVista);
		actualizarContadores();
	}
	
	public boolean enemigoContieneA(Pieza unaPieza) {
		return modelo.getJugadorEnemigo().contieneA(unaPieza);
	}
	
	public boolean aliadoContieneA(Pieza unaPieza) {
		return modelo.getJugadorActual().contieneA(unaPieza);
	}

	//---------------------      Fin Manejo de Piezas     ------------------------
	//----------------------------------------------------------------------------


}