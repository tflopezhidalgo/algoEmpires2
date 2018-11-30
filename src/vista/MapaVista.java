package vista;


import controlador.CrearMapa;
import controlador.FinalizarTurnoHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import modelo.Juego;
import modelo.Tablero;

public class MapaVista extends BorderPane {

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

    public MapaVista(Juego juegoNuevo){
    	piezaSeleccionada = null;
    	casillaSeleccionada = null;
    	
        try {juegoNuevo.iniciarJuego();}
        catch (Exception e){}
    	System.out.print(juegoNuevo.getJugadorActual().obtenerNombre()); //TODO BORRAR
    	
    	crearMapa();
    	crearPanelBotones();
    	crearFuncionalidades();
    }
    
    private void crearMapa(){
    	Pane mapa = new Pane();
    	mapa.setPrefSize(1280,770);
    	
    	//TODO esto del controlador va asi? Euge aiudaa new y no asigno?
    	//hacer la clase static asi no necesito instanciar?
    	new CrearMapa(this,grupoCasillas, grupoPiezas);
    	
    	mapa.getChildren().addAll(grupoCasillas,grupoPiezas);
    	
    	setCenter(mapa);
    }
    
    private void crearPanelBotones() {
    	MenuBar menuAcciones = new MenuBar();
    	Button botonFinTurno = new Button("Finalizar Turno");
    	botonFinTurno.setOnAction( new FinalizarTurnoHandler(grupoPiezas));
    	botones = new HBox(botonFinTurno, menuAcciones);
    	
    	setBottom(botones);	
    }
    
	private void crearFuncionalidades() {
		//------------------	ZOOM	---------------------
    	grupoCasillas.setAutoSizeChildren(true);
    	grupoPiezas.setAutoSizeChildren(true);
    	
        setOnScroll(e -> {
            e.consume();
            if (e.getDeltaY() == 0) {
                return;
            }

            double scaleFactor
                    = (e.getDeltaY() > 0)
                            ? SCALE_DELTA
                            : 1 / SCALE_DELTA;

            grupoCasillas.setScaleX(grupoCasillas.getScaleX() * scaleFactor);
            grupoCasillas.setScaleY(grupoCasillas.getScaleY() * scaleFactor);
            grupoPiezas.setScaleX(grupoPiezas.getScaleX() * scaleFactor);
            grupoPiezas.setScaleY(grupoPiezas.getScaleY() * scaleFactor);
        });
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