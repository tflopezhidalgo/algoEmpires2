package vista;


import java.io.File;

import controlador.FinalizarTurnoHandler;
import controlador.HerramientasMapa;
import controlador.TextoHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import modelo.Juego;
import modelo.JuegoTerminadoListener;
import modelo.Jugador;
import modelo.Pieza;
import modelo.Tablero;

public class JuegoVista extends BorderPane implements JuegoTerminadoListener{

    final double SCALE_DELTA = 1.1;
	double ultimoX;
	double ultimoY;

	public static final int TAMANIO_CASILLA = CasillaVista.TAMANIO_CASILLA;
	
	//--------------------------
	private StackPane panelSuperior;
	private PanelInferior panelInferior;
	
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
	//--------------------- Sonidos ---------------------------
	private MediaPlayer ambienteInicial;
	private MediaPlayer ambienteCombate;
	private MediaPlayer error;
	private MediaPlayer finJuego;
	//---------------------------------------------------------

    public JuegoVista(String nombreJugador1, String nombreJugador2, Stage stagePrincipal){
    	piezaSeleccionada = null;
    	casillaSeleccionada = null;
    	this.stagePrincipal = stagePrincipal;
    	
    	jugador1 = new Jugador(nombreJugador1);
    	jugador2 = new Jugador(nombreJugador2);
    	
    	modelo = HerramientasMapa.crearJuego(this,grupoCasillas, grupoPiezas, jugador1, jugador2);
    	    	
    	modelo.setListenerJuegoTerminado(this);
    	
    	crearMapa();
    	crearPanelSuperior();
    	crearPanelInferior();
    	configurarSonido();
    	
    	iniciarJuego();
    }
    
    private void iniciarJuego() {

    	modelo.iniciarJuego(); 	
    	
    	BorderPane panelTransparente = new BorderPane();
    	panelTransparente.setManaged(false);
    	Text jugadorInicial = new Text("Comienza: " + modelo.getJugadorActual().obtenerNombre());
    	jugadorInicial.setFont(Font.loadFont("file:src/resources/fonts/Mairon.ttf", 40));
    	jugadorInicial.setFill(Color.GOLD);
    	jugadorInicial.setOnMouseMoved(new TextoHandler(jugadorInicial));
        //Centrar esto, no se como
    	panelTransparente.setCenter(jugadorInicial);
        mapa.getChildren().add(panelTransparente);
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
    
    public void decirGanador(){
    	Text unTexto = new Text("NUEVO GANADOR " + modelo.seleccionarGanador().obtenerNombre() + " !");
		unTexto.setFont(Font.loadFont("file:src/resources/fonts/Mairon.ttf", 50));
		unTexto.setTextAlignment(TextAlignment.CENTER);
		//Esto es para calcular las dimensiones de pantalla pero no funciona me parece
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		unTexto.relocate(screenBounds.getWidth() / 2 , screenBounds.getHeight() / 2);
		unTexto.setOnMouseMoved(new TextoHandler(unTexto));
		getChildren().add(unTexto);
	}
    
    private void crearMapa(){
    	mapa = new Pane();
    	mapa.getChildren().addAll(grupoCasillas,grupoPiezas);
    	
    	ScrollPane mapaSC = new ScrollPane();
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
    	this.panelInferior = new PanelInferior(this,jugador1,jugador2);
    	setBottom(panelInferior);	
    }
    
    private void configurarSonido(){
		String ambiente = "src/resources/sound/ambiente/ambiente.mp3"; 
		Media ambienteSound = new Media(new File(ambiente).toURI().toString());
		ambienteInicial = new MediaPlayer(ambienteSound);
		ambienteInicial.setVolume(0.7);
		
		ambiente = "src/resources/sound/ambiente/ambienteCombate.mp3"; 
		Media ambienteCombateSound = new Media(new File(ambiente).toURI().toString());
		ambienteCombate = new MediaPlayer(ambienteCombateSound);
		ambienteCombate.setVolume(0.7);
		
		String errorUrl = "src/resources/sound/ambiente/error.wav"; 
		Media errorSound = new Media(new File(errorUrl).toURI().toString());
		error = new MediaPlayer(errorSound);
		
		String victoria = "src/resources/sound/ambiente/victory.wav"; 
		Media victoriaSound = new Media(new File(victoria).toURI().toString());
		finJuego = new MediaPlayer(victoriaSound);
		
		ambienteInicial.play();
		ambienteInicial.setOnEndOfMedia(new Runnable() {
		    @Override
		    public void run() {
		    	ambienteInicial.stop();
		    	ambienteCombate.play();
		    }
		});
		ambienteCombate.setOnEndOfMedia(new Runnable() {
		    @Override
		    public void run() {
		    	ambienteCombate.stop();
		    	ambienteInicial.play();
		    }
		});
	}
    
    public void playError() {
    	error.stop();
    	error.play();
    }
    
    public void playFinJuego() {
    	finJuego.stop();
    	finJuego.play();
    }
    
    public void actualizarContadores() {
    	panelInferior.actualizarPanel();
    }

	public Tablero obtenerTablero() {
		return elTablero;
	}
	
    public void asignarMenuAcciones(HBox acciones) {
    	panelInferior.asignarMenuAcciones(acciones);
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
		unAldeano.colocarColor();
		grupoPiezas.getChildren().add(unAldeano);
		actualizarContadores();
	}
	
	public void agregar(CastilloVista unCastillo) {
		modelo.getJugadorActual().agregar(unCastillo.modelo());
		unCastillo.colocarColor();
		grupoPiezas.getChildren().add(unCastillo);
		actualizarContadores();
	}
	
	public void agregar(EdificioVista unEdificio) {
		modelo.getJugadorActual().agregar(unEdificio.modelo());
		unEdificio.colocarColor();
		grupoPiezas.getChildren().add(unEdificio);
		actualizarContadores();
	}
	
	public void agregar(UnidadVista unaUnidad) {
		if(unaUnidad instanceof AldeanoVista) {
			agregar((AldeanoVista) unaUnidad);
		}
		else {
			modelo.getJugadorActual().agregar(unaUnidad.modelo());
			unaUnidad.colocarColor();
			grupoPiezas.getChildren().add(unaUnidad);
			actualizarContadores();
		}
	}
	
	//TODO necesito un remover para castillo o el programa corta muy rapido que no ?
	
	public void remover(UnidadVista unidadVista) {
		if(unidadVista instanceof AldeanoVista) {
			remover((AldeanoVista)unidadVista);
		}
		else {
			modelo.getJugadorEnemigo().remover(unidadVista.modelo());
			grupoPiezas.getChildren().remove(unidadVista);
			panelInferior.actualizarPanel();
		}
	}
	
	public void remover(EdificioVista edificioVista) {
		modelo.getJugadorEnemigo().remover(edificioVista.modelo());
		grupoPiezas.getChildren().remove(edificioVista);
	}
	
	public void remover(AldeanoVista aldeanoVista) {
		modelo.getJugadorEnemigo().remover(aldeanoVista.modelo());
		grupoPiezas.getChildren().remove(aldeanoVista);
		panelInferior.actualizarPanel();
	}
	
	public boolean enemigoContieneA(Pieza unaPieza) {
		return modelo.getJugadorEnemigo().contieneA(unaPieza);
	}
	
	public boolean aliadoContieneA(Pieza unaPieza) {
		return modelo.getJugadorActual().contieneA(unaPieza);
	}
	
    public boolean perteneceAJugador1(Pieza unaPieza) {
    	return jugador1.contieneA(unaPieza);
    }

	//---------------------      Fin Manejo de Piezas     ------------------------
	//----------------------------------------------------------------------------
    
    public Group getPiezas() {
    	return grupoPiezas;
    }
    
    public void cerrar() {
    	stagePrincipal.close();
    }
    
    public void mute() {
		ambienteInicial.setMute(!ambienteInicial.isMute());
		ambienteCombate.setMute(!ambienteCombate.isMute());
    }

}