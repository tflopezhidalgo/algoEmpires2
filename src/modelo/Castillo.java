package modelo;

import modelo.excepciones.NoSePuedeConstruirTanLejosError;

public class Castillo extends Edificio {
	
	public static final int TAMANIO_LADO = 4;
    public static final int DISTANCIA_ATK = 3;

	private CastilloListener castilloListener;

	public Castillo(int xInicial, int yInicial) {

		Area areaAOcupar = Tablero.INSTANCIA.definirArea(xInicial, yInicial, TAMANIO_LADO-1, TAMANIO_LADO-1);

		super(areaAOcupar, 1000, 0);

		vida = VIDA_MAX;
		tiempoDeConstruccion = 0;
		cantidadDeCuracion = 15;
	}

	@Override
	public void atacar(Pieza piezaEnemiga){

	    chequearRango(piezaEnemiga, DISTANCIA_ATK);
	    piezaEnemiga.recibirDanio(20);
	}
	
	public Unidad crearCatapulta(Area unEspacio) {
	    siYaJugoElTurnoError();
	    
        if(distanciaMinimaA(unEspacio) > 1) {
            throw  new NoSePuedeConstruirTanLejosError();
        }
        
		ArmaDeAsedio unaArmaDeAsedio = new ArmaDeAsedio(unEspacio);

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
