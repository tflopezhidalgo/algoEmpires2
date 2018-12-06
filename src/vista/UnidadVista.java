package vista;

import java.io.File;

import controlador.UnidadRealizarAccion;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.Unidad;

public abstract class UnidadVista extends PiezaVista {
	
	protected Unidad modelo;
	
	public UnidadVista(int x, int y, Unidad unModelo, JuegoVista elJuego){
		super(x,y,unModelo,elJuego);
		modelo = unModelo;
		crearRepresentacion();
	}
	
	public Unidad modelo() {
		return modelo;
	}
	
	public void reubicar(int x, int y) {
		//calcula la ubicacion
		ultimaX = x;
		ultimaY = y;
		
		//ubica la pieza en la pantalla
		relocate(ultimaX* TAMANIO_CASILLA, ultimaY* TAMANIO_CASILLA);
	}
	
	protected void configurarSonidos() {
		String seleccion = "src/resources/sound/seleccion/selectUnidad.wav"; 
		Media seleccionSound = new Media(new File(seleccion).toURI().toString());
		sonidoSeleccionar = new MediaPlayer(seleccionSound);
		
		String muerte = "src/resources/sound/destruido/maledeath5.wav"; 
		Media muerteSound = new Media(new File(muerte).toURI().toString());
		sonidoMuerte = new MediaPlayer(muerteSound);
	}
	
	protected abstract void prepararBotones();
	
	protected abstract void crearRepresentacion();
	
	@Override
	public void actualizarVisualizacon() {
		double porcentaje = modelo.porcentajeVidaActual();
		barraVidaActual.setWidth(TAMANIO_CASILLA*ancho*porcentaje);
		if(porcentaje == 0) {
			elJuego.remover(this);
		}
	}
	
	@Override
	public void realizarAccionSobrePieza() {
		new UnidadRealizarAccion(elJuego, this);
	}

}
