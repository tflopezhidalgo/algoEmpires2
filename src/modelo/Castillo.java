package modelo;

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

	public void atacar(Pieza piezaEnemiga) throws Excepcion {
		if(enRango(piezaEnemiga,3)) {
			piezaEnemiga.recibirDanio(20);
		}
		
		if(piezaEnemiga.estaDestruida()) {
			piezaEnemiga = null;
		}
	}
	
	public ArmaDeAsedio crearCatapulta(Area unEspacio)  throws Excepcion {
		ArmaDeAsedio unaArmaDeAsedio = new ArmaDeAsedio(unEspacio);
		return unaArmaDeAsedio;
	}
}
