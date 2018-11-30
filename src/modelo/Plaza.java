package modelo;

import modelo.excepciones.NoSePuedeConstruirTanLejosError;
import modelo.excepciones.NoSePuedeCrearUnidadesDuranteConstruccionError;

public class Plaza extends Edificio {
	
	public static final int TAMANIO_LADO = 2;
	
	public Plaza(Area areaAOcupar) {
		super(areaAOcupar, 450, 100);

		vida = VIDA_MAX;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 25;
	}
	
	public Plaza(Area areaAOcupar, boolean yaConstruida) {
		super(areaAOcupar, 450, 100);

		vida = VIDA_MAX;
		
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
