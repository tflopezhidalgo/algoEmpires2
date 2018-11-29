package modelo;

import modelo.excepciones.NoSePuedeConstruirTanLejosError;

public class Castillo extends Edificio {
	
	public static final int TAMANIO_LADO = 4;
	
	public Castillo(Area areaAOcupar) {
		super(areaAOcupar);
		vidaMaxima = 1000;
		vida = vidaMaxima;
		costo = 0;
		tiempoDeConstruccion = 0;
		cantidadDeCuracion = 15;
	}

	public void atacar(Pieza piezaEnemiga){
		if(enRango(piezaEnemiga,3))

			piezaEnemiga.recibirDanio(20);
	}
	
	public ArmaDeAsedio crearCatapulta(Area unEspacio) {
	    siYaJugoElTurnoError();
	    
        if(distanciaMinimaA(unEspacio) > 1) {
            throw  new NoSePuedeConstruirTanLejosError();
        }
        
		ArmaDeAsedio unaArmaDeAsedio = new ArmaDeAsedio(unEspacio);
		turnoJugado = true;
		return unaArmaDeAsedio;
	}
}
