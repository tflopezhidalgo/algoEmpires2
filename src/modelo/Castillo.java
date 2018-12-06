package modelo;

import modelo.excepciones.CasillaYaEstaLibreError;
import modelo.excepciones.NoSePuedeConstruirTanLejosError;

import java.util.List;

public class Castillo extends Edificio {
	
	public static final int TAMANIO_LADO = 4;
    public static final int DISTANCIA_ATK = 3;

	private CastilloListener castilloListener;

	public Castillo(int x0, int y0) {

		super(1000, 0);

		this.castilloListener = null;
		tiempoDeConstruccion = 0;
		cantidadDeCuracion = 15;
		
		espacioOcupado = Tablero.INSTANCIA.definirArea(x0, y0, TAMANIO_LADO - 1 + x0, TAMANIO_LADO- 1 + y0);
		espacioOcupado.ocupar();
	}

	private void atacarPiezasCercanas(List<Pieza> piezasEnemigas){

	    for(int i = 0; i < piezasEnemigas.size(); i++)
	        if(distanciaMinimaA(piezasEnemigas.get(i).espacioOcupado) <= DISTANCIA_ATK)
	        	try {
	        		piezasEnemigas.get(i).recibirDanio(20);	        		
	        	}
	    catch(CasillaYaEstaLibreError e) {
	    	//TODO PORQUE SE LIBERA ANTES , FIJARSE EL RECORRIDO DE ELIMINAR UNA PIEZA CON UN CASTILLO
	    }

    }

    @Override
    public void nuevoTurno(){

	    this.atacarPiezasCercanas(castilloListener.getJugadorEnemigo().getPiezas());

        this.turnoJugado = false;
    }

	
	public Unidad crearCatapulta(int x0, int y0) {
	    siYaJugoElTurnoError();
	    
        Casilla supuestaUbicacion = new Casilla(x0, y0); 
        if(distanciaMinimaA(supuestaUbicacion) > 1) {
            throw  new NoSePuedeConstruirTanLejosError();
        }
        
		ArmaDeAsedio unaArmaDeAsedio = new ArmaDeAsedio(x0, y0);

		turnoJugado = true;
		return unaArmaDeAsedio;
	} 

	public void setCastilloListener(Juego unJuego){
	    this.castilloListener = unJuego;
    }

	@Override
    public void recibirDanio(int danio) {
        vida = vida - danio;
        if(vida <= 0) {
            this.castilloListener.castilloFueDestruido();
            this.liberarUbicacion();
        }
    }

}
