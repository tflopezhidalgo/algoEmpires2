package modelo;

import modelo.excepciones.NoSePuedeConstruirTanLejosError;
import modelo.excepciones.NoSePuedeCrearUnidadesDuranteConstruccionError;

public class Plaza extends Edificio {
	
	public static final int TAMANIO_LADO = 2;
	
	public Plaza(Area areaAOcupar) {
		super(areaAOcupar);
		vidaMaxima = 450;
		vida = vidaMaxima;
		costo = 100;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 25;
	}
	
	public Plaza(Area areaAOcupar, boolean yaConstruida) {
		super(areaAOcupar);
		vida = 450;
		vidaMaxima = vida;
		costo = 100;
		
		tiempoDeConstruccion = 3;
		if(yaConstruida) {
			tiempoDeConstruccion = 0;
		}
		
		cantidadDeCuracion = 25;
	}

	public Aldeano crearAldeano(Area unEspacio) {
		siYaJugoElTurnoError();
		
        if(distanciaMinimaA(unEspacio) > 1) {
            throw new NoSePuedeConstruirTanLejosError();
        }
        
        if(enConstruccion() == true) {
        	throw new NoSePuedeCrearUnidadesDuranteConstruccionError();
        }
		
		Aldeano unAldeano = new Aldeano(unEspacio);
		turnoJugado = true;
		return unAldeano;
	}
}
