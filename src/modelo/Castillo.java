package modelo;

import modelo.excepciones.Excepcion;

public class Castillo extends Edificio {
	
	public static final int TAMANIO_LADO = 4;
	
	public Castillo(Area areaAOcupar) throws Excepcion {
		super(areaAOcupar);
		vida = 1000;
		vidaMaxima = vida;
		costo = 0;
		tiempoDeConstruccion = 0;
		cantidadDeCuracion = 15;
	}

	//ATACA 1 VEZ A CADA OBJETIVO QUE ESTE EN RANGO NO IMPORTA SI YA JUGO EL TURNO
	//TODO hacer una lista de objetivos en rango y pasarsela asi ataca solo 1 vez a cada uno
	public void atacar(Pieza piezaEnemiga) throws Excepcion {
		if(enRango(piezaEnemiga,3)) {
			piezaEnemiga.recibirDanio(20);
		}
		
		if(piezaEnemiga.estaDestruida()) {
			piezaEnemiga = null;
		}
	}
	
	public ArmaDeAsedio crearCatapulta(Area unEspacio)  throws Excepcion {
		siYaJugoElTurnoError();

		if(!unEspacio.estaLibre()) {
			throw new Excepcion("ERROR: La ubicacion para colocar al soldado esta ocupada.");
		}
		
		turnoJugado = true;
		ArmaDeAsedio unaArmaDeAsedio = new ArmaDeAsedio(unEspacio);
		return unaArmaDeAsedio;
	}
}
