package vista;

import modelo.excepciones.Excepcion;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.*;


enum Estado {NO_COMENZADO, JUEGA_JUGADOR1, JUEGA_JUGADOR2, TERMINADO};

public class JuegoVista extends Application{
	
	public static final int TAMANIO_CASILLA = CasillaVista.TAMANIO_CASILLA;
	public static final int ANCHO = 16;
	public static final int ALTO = 16;
	
	public Group grupoCasillas = new Group();
	public Group grupoPiezas = new Group();
	
	private Tablero elTablero;

    private Parent crearContenido() throws Excepcion {
    	
    	Pane root = new Pane();
    	root.setPrefSize(ANCHO*TAMANIO_CASILLA, ALTO*TAMANIO_CASILLA);
    	
    	//TODO ocupar las casillas con el mismo criterio que al iniciar las piezas de los equipos
    	elTablero = new Tablero();
    	for(int y = 0; y < ALTO; y++) {
    		for(int x = 0; x < ANCHO; x++) {
    			//Casilla casillaActual = elTablero.obtenerCasillaEn(x, y);
    			CasillaVista vistaCasilla = new CasillaVista(x, y);
        		//CasillaControlador unaCasilla = new CasillaControlador(casillaActual, vistaCasilla);
        		grupoCasillas.getChildren().add(vistaCasilla);	//agrego la nueva casilla a las casillas del tablero
    		}
    	}
    	
    	generarPiezasInicialesEquipo1();
    	generarPiezasInicialesEquipo2();
    	
    	root.getChildren().addAll(grupoCasillas,grupoPiezas);
    	return root;
    }
    
	public void generarPiezasInicialesEquipo1() throws Excepcion{
		//Castillo
		CastilloVista castillo = new CastilloVista(1,1);
		//-------------------
		grupoPiezas.getChildren().add(castillo);
		//Plaza
		PlazaVista plaza = new PlazaVista(7,1);
		//-------------------
		grupoPiezas.getChildren().add(plaza);
		//Aldeanosx3
		AldeanoVista aldeano1 = new AldeanoVista(6,4);
		grupoPiezas.getChildren().add(aldeano1);
		AldeanoVista aldeano2 = new AldeanoVista(7,4);
		grupoPiezas.getChildren().add(aldeano2);
		AldeanoVista aldeano3 = new AldeanoVista(8,4);
		grupoPiezas.getChildren().add(aldeano3);
		//-------------------
	}

	public void generarPiezasInicialesEquipo2() throws Excepcion {
		
		//Castillo
		CastilloVista castillo = new CastilloVista(ANCHO-5,ALTO-5);
		//-------------------
		grupoPiezas.getChildren().add(castillo);
		//Plaza
		PlazaVista plaza = new PlazaVista(ANCHO-9,ALTO-3);
		//-------------------
		grupoPiezas.getChildren().add(plaza);
		//Aldeanosx3
		AldeanoVista aldeano1 = new AldeanoVista(ANCHO-9,ALTO-5);
		grupoPiezas.getChildren().add(aldeano1);
		AldeanoVista aldeano2 = new AldeanoVista(ANCHO-8,ALTO-5);
		grupoPiezas.getChildren().add(aldeano2);
		AldeanoVista aldeano3 = new AldeanoVista(ANCHO-7,ALTO-5);
		grupoPiezas.getChildren().add(aldeano3);
		//-------------------
	}

    public static void main(String[] args) {
    	launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Excepcion {
    	Scene scene = new Scene(crearContenido());
    	primaryStage.setTitle("Juegazo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



}

