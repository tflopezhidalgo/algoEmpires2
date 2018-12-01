package controlador;

import javafx.scene.Group;
import modelo.Aldeano;
import modelo.Area;
import modelo.Casilla;
import modelo.Castillo;
import modelo.Plaza;
import modelo.Tablero;
import vista.AldeanoVista;
import vista.CasillaVista;
import vista.CastilloVista;
import vista.MapaVista;
import vista.PlazaVista;

public class HerramientasMapa {
	
	private static int ANCHO = 32;
	private static int ALTO = 20;
	private static Tablero elTablero;
	private static Group grupoPiezas;
	private static MapaVista elMapa;
	
	public static Tablero crearMapa(MapaVista mapa,Group casillas, Group piezas) {
		grupoPiezas = piezas;
		elMapa = mapa;
		
		System.out.println("Herramientas: mapa: "+ (mapa ==null));
    	//Si cambias esto tenes que cambiar el ANCHO y ALTO (+16)
    	elTablero = new Tablero(16,4);
    	for(int y = 0; y < ALTO; y++) {
    		for(int x = 0; x < ANCHO; x++) {
    			Casilla casillaActual = elTablero.obtenerCasillaEn(x, y);
    			CasillaVista vistaCasilla = new CasillaVista(x, y, casillaActual, elMapa);
    			//CasillaControlador unaCasilla = new CasillaControlador(casillaActual, vistaCasilla);
    			casillas.getChildren().add(vistaCasilla);	//agrego la nueva casilla a las casillas del tablero
    		}
    	}
    	
    	generarPiezasInicialesEquipo1();
    	generarPiezasInicialesEquipo2();
    	
    	return elTablero;
	}
	
	public static void generarPiezasInicialesEquipo1(){
		//Castillo
		Castillo castillo = new Castillo(1,1);
		CastilloVista castilloVisu = new CastilloVista(1,1,castillo,elMapa);
		//-------------------
		grupoPiezas.getChildren().add(castilloVisu);
		//Plaza
		Plaza plaza = new Plaza(7,1,true);
		PlazaVista plazaVisu = new PlazaVista(7,1,plaza,elMapa);
		//-------------------
		grupoPiezas.getChildren().add(plazaVisu);
		//Aldeanosx3
		Aldeano aldeano1 = new Aldeano(6,4);
		AldeanoVista aldeanoVisu1 = new AldeanoVista(6,4,aldeano1,elMapa);
		grupoPiezas.getChildren().add(aldeanoVisu1);
		Aldeano aldeano2 = new Aldeano(7,4);
		AldeanoVista aldeanoVisu2 = new AldeanoVista(7,4,aldeano2,elMapa);
		grupoPiezas.getChildren().add(aldeanoVisu2);
		Aldeano aldeano3 = new Aldeano(8,4);
		AldeanoVista aldeanoVisu3 = new AldeanoVista(8,4,aldeano3,elMapa);
		grupoPiezas.getChildren().add(aldeanoVisu3);
		//-------------------
	}

	public static void generarPiezasInicialesEquipo2(){
		//Castillo
		Castillo castillo = new Castillo(ANCHO-5, ALTO-5);
		CastilloVista castilloVisu = new CastilloVista(ANCHO-5,ALTO-5,castillo,elMapa);
		//-------------------
		grupoPiezas.getChildren().add(castilloVisu);
		//Plaza
		Plaza plaza = new Plaza(ANCHO-9,ALTO-3,true);
		PlazaVista plazaVisu = new PlazaVista(ANCHO-9,ALTO-3,plaza,elMapa);
		//-------------------
		grupoPiezas.getChildren().add(plazaVisu);
		//Aldeanosx3
		Aldeano aldeano1 = new Aldeano(ANCHO-9,ALTO-5);
		AldeanoVista aldeanoVisu1 = new AldeanoVista(ANCHO-9,ALTO-5,aldeano1,elMapa);
		grupoPiezas.getChildren().add(aldeanoVisu1);
		Aldeano aldeano2 = new Aldeano(ANCHO-8,ALTO-5);
		AldeanoVista aldeanoVisu2 = new AldeanoVista(ANCHO-8,ALTO-5,aldeano2,elMapa);
		grupoPiezas.getChildren().add(aldeanoVisu2);
		Aldeano aldeano3 = new Aldeano(ANCHO-7,ALTO-5);
		AldeanoVista aldeanoVisu3 = new AldeanoVista(ANCHO-7,ALTO-5,aldeano3,elMapa);
		grupoPiezas.getChildren().add(aldeanoVisu3);
		//-------------------
	}

}
