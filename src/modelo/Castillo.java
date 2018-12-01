package modelo;

import modelo.excepciones.NoSePuedeConstruirTanLejosError;

public class Castillo extends Edificio {
	
	public static final int TAMANIO_LADO = 4;
    public static final int DISTANCIA_ATK = 3;

	private CastilloListener castilloListener;

	public Castillo(int x0, int y0) {
		super();
		
		this.COSTO = 0;
		this.VIDA_MAX = 1000;
		vida = VIDA_MAX;
		tiempoDeConstruccion = 0;
		cantidadDeCuracion = 15;
		
		espacioOcupado = Tablero.INSTANCIA.definirArea(x0, y0, TAMANIO_LADO-1+x0, TAMANIO_LADO-1+y0);
    	System.out.println("Castillo: tamEsp:" + espacioOcupado.obtenerCantidadDeCasillas());
		espacioOcupado.ocupar();
	}

	@Override
	public void atacar(Pieza piezaEnemiga){

	    chequearRango(piezaEnemiga, DISTANCIA_ATK);
	    piezaEnemiga.recibirDanio(20);
	}
	
	public Unidad crearCatapulta(int x0, int y0) {
	    siYaJugoElTurnoError();
	    
        Casilla supuestaUbicacion = new Casilla(x0, y0); 
        if(distanciaMinimaA(supuestaUbicacion) > 1) {
        	System.out.println("Castillo: dist:" + distanciaMinimaA(supuestaUbicacion));
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
