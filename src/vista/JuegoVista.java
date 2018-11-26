package vista;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Aldeano;
import modelo.Area;
import modelo.Casilla;
import modelo.Castillo;
import modelo.Pieza;
import modelo.Plaza;
import modelo.Tablero;

enum Estado {NO_COMENZADO, JUEGA_JUGADOR1, JUEGA_JUGADOR2, TERMINADO};

public class JuegoVista extends Application{
	
	public static final int TAMANIO_CASILLA = CasillaVista.TAMANIO_CASILLA;
	public static final int ANCHO = 32;
	public static final int ALTO = 32;
	
	private Group grupoCasillas = new Group();
	private Group grupoPiezas = new Group();

	private HBox botones;
	
	private Tablero elTablero;
	
	private PiezaVista piezaSeleccionada;
	private CasillaVista casillaSeleccionada;

    private Parent crearContenido() throws Exception {
    	piezaSeleccionada = null;
    	casillaSeleccionada = null;
    	
    	Pane root = new Pane();
    	//le sumo 1 para que entren los botones
    	root.setPrefSize(ANCHO*TAMANIO_CASILLA, (ALTO+1)*TAMANIO_CASILLA);
    	
    	//Si cambias esto tenes que cambiar el ANCHO y ALTO (+16)
    	elTablero = new Tablero(16,16);
    	
    	for(int y = 0; y < ALTO; y++) {
    		for(int x = 0; x < ANCHO; x++) {
    			Casilla casillaActual = elTablero.obtenerCasillaEn(x, y);
    			CasillaVista vistaCasilla = new CasillaVista(x, y, casillaActual, this);
        		//CasillaControlador unaCasilla = new CasillaControlador(casillaActual, vistaCasilla);
        		grupoCasillas.getChildren().add(vistaCasilla);	//agrego la nueva casilla a las casillas del tablero
    		}
    	}
    	
    	generarPiezasInicialesEquipo1();
    	generarPiezasInicialesEquipo2();
    	
    	Button botonFinTurno = new Button("Finalizar Turno");

    	botonFinTurno.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(int i = 0; i<grupoPiezas.getChildren().size(); i++) {
                    Node nodoActual = grupoPiezas.getChildren().get(i);
                    //TODO modificar esto despues, tiene que ser para todas las PIEZAS del ultimo jugador
                    ((PiezaVista)nodoActual).nuevoTurno();
            } }}
            );
    	
    	MenuBar menuAcciones = new MenuBar();
    	botones = new HBox(botonFinTurno, menuAcciones);
    	MapaVista mapa = new MapaVista(grupoCasillas,grupoPiezas);
    	VBox paneles = new VBox(mapa,botones);

    	//mapa.getChildren().addAll(grupoCasillas,grupoPiezas);
    	root.getChildren().add(paneles);
    	return root;
    }
    
	public void generarPiezasInicialesEquipo1() throws Exception{
		//Castillo
		Area areaCastillo = elTablero.definirArea(1,1, 4, 4);
		Castillo castillo = new Castillo(areaCastillo);
		CastilloVista castilloVisu = new CastilloVista(1,1,castillo,this);
		//-------------------
		grupoPiezas.getChildren().add(castilloVisu);
		//Plaza
		Area areaPlaza = elTablero.definirArea(7,1,8,2);
		Plaza plaza = new Plaza(areaPlaza,true);
		PlazaVista plazaVisu = new PlazaVista(7,1,plaza,this);
		//-------------------
		grupoPiezas.getChildren().add(plazaVisu);
		//Aldeanosx3
		Area espacioAldeano1 = elTablero.definirArea(6,4,6,4);
		Aldeano aldeano1 = new Aldeano(espacioAldeano1);
		AldeanoVista aldeanoVisu1 = new AldeanoVista(6,4,aldeano1,this);
		grupoPiezas.getChildren().add(aldeanoVisu1);
		Area espacioAldeano2 = elTablero.definirArea(7,4,7,4);
		Aldeano aldeano2 = new Aldeano(espacioAldeano2);
		AldeanoVista aldeanoVisu2 = new AldeanoVista(7,4,aldeano2,this);
		grupoPiezas.getChildren().add(aldeanoVisu2);
		Area espacioAldeano3 = elTablero.definirArea(8,4,8,4);
		Aldeano aldeano3 = new Aldeano(espacioAldeano3);
		AldeanoVista aldeanoVisu3 = new AldeanoVista(8,4,aldeano3,this);
		grupoPiezas.getChildren().add(aldeanoVisu3);
		//-------------------
	}

	public void generarPiezasInicialesEquipo2() throws Exception{
		
		//Castillo
		Area areaCastillo = elTablero.definirArea(ANCHO-5, ALTO-5, ANCHO-2, ALTO-2);
		Castillo castillo = new Castillo(areaCastillo);
		CastilloVista castilloVisu = new CastilloVista(ANCHO-5,ALTO-5,castillo,this);
		//-------------------
		grupoPiezas.getChildren().add(castilloVisu);
		//Plaza
		Area areaPlaza = elTablero.definirArea(ANCHO-9,ALTO-3,ANCHO-8,ALTO-2);
		Plaza plaza = new Plaza(areaPlaza,true);
		PlazaVista plazaVisu = new PlazaVista(ANCHO-9,ALTO-3,plaza,this);
		//-------------------
		grupoPiezas.getChildren().add(plazaVisu);
		//Aldeanosx3
		Area espacioAldeano1 = elTablero.definirArea(ANCHO-9,ALTO-5,ANCHO-9,ALTO-5);
		Aldeano aldeano1 = new Aldeano(espacioAldeano1);
		AldeanoVista aldeanoVisu1 = new AldeanoVista(ANCHO-9,ALTO-5,aldeano1,this);
		grupoPiezas.getChildren().add(aldeanoVisu1);
		Area espacioAldeano2 = elTablero.definirArea(ANCHO-8,ALTO-5,ANCHO-8,ALTO-5);
		Aldeano aldeano2 = new Aldeano(espacioAldeano2);
		AldeanoVista aldeanoVisu2 = new AldeanoVista(ANCHO-8,ALTO-5,aldeano2,this);
		grupoPiezas.getChildren().add(aldeanoVisu2);
		Area espacioAldeano3 = elTablero.definirArea(ANCHO-7,ALTO-5,ANCHO-7,ALTO-5);
		Aldeano aldeano3 = new Aldeano(espacioAldeano3);
		AldeanoVista aldeanoVisu3 = new AldeanoVista(ANCHO-7,ALTO-5,aldeano3,this);
		grupoPiezas.getChildren().add(aldeanoVisu3);
		//-------------------
	}
	
	public Tablero obtenerTablero() {
		return elTablero;
	}
	
	public void aniadirPieza(PiezaVista piezaVista) {
		grupoPiezas.getChildren().add(piezaVista);
	}

    public static void main(String[] args) {
    	launch(args);
    }
    
    public void asignarMenuAcciones(MenuBar acciones) {
    	botones.getChildren().remove(1);
    	botones.getChildren().add(acciones);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene escenaMapa = new Scene(crearContenido());
        Pane menu = new MenuVista();
        //Button unBoton  = new Button("Comenzar");
        //unBoton.setOnAction(event -> primaryStage.setScene(escenaMapa));

        Image botonComenzar = new Image("builingsTemp\\botoncomenzar.png");
        BotonPersonalizado elBotonComenzar = new BotonPersonalizado(botonComenzar);
        elBotonComenzar.relocate(menu.getPrefWidth()/2 - elBotonComenzar.getPrefWidth()/2,menu.getPrefHeight()/2 - elBotonComenzar.getPrefHeight()/2 );
        elBotonComenzar.setOnMousePressed(event -> primaryStage.setScene(escenaMapa));

        Image botonSalir = new Image("builingsTemp\\botonsalir.png");
        BotonPersonalizado elBotonSalir = new BotonPersonalizado(botonSalir);
        elBotonSalir.relocate(menu.getPrefWidth()/2 - elBotonSalir.getPrefWidth()/2,menu.getPrefHeight()/2 + elBotonSalir.getPrefHeight() );
        elBotonSalir.setOnMousePressed(event ->  primaryStage.close());

        //menu.getChildren().add(elBotonComenzar);
        menu.getChildren().addAll(elBotonComenzar, elBotonSalir);

        Scene pantallaInicial = new Scene(menu);
        primaryStage.setTitle("Algo Empires 2");
    	//primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(pantallaInicial);
        primaryStage.show();
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

