package modelo;

import modelo.excepciones.NoSePuedeConstruirTanLejosError;
import modelo.excepciones.NoSePuedeCrearUnidadesDuranteConstruccionError;

public class Plaza extends Edificio {
	
	public static final int TAMANIO_LADO = 2;
	
	public Plaza(int x0, int y0) {
		super(450, 100);

		vida = VIDA_MAX;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 25;
		
		espacioOcupado = Tablero.INSTANCIA.definirArea(x0, y0, TAMANIO_LADO-1+x0, TAMANIO_LADO-1+y0);
		espacioOcupado.ocupar();
	}
	
	//TODO borrar el otro constructor y dejar este ?
	public Plaza(int x0, int y0, boolean yaConstruida) {

		super(450, 100);

		vida = VIDA_MAX;
		cantidadDeCuracion = 25;
		
		tiempoDeConstruccion = 3;
		if(yaConstruida) {
			tiempoDeConstruccion = 0;
		}
		
		espacioOcupado = Tablero.INSTANCIA.definirArea(x0, y0, TAMANIO_LADO-1+x0, TAMANIO_LADO-1+y0);
		espacioOcupado.ocupar();
	}

	public Aldeano crearAldeano(int x0, int y0) {
		siYaJugoElTurnoError();
		
		
		Casilla supuestaUbicacion = new Casilla(x0, y0); 
        if(distanciaMinimaA(supuestaUbicacion) > 1) {
            throw new NoSePuedeConstruirTanLejosError();
        }
        
        if(enConstruccion() == true) {
        	throw new NoSePuedeCrearUnidadesDuranteConstruccionError();
        }
		
		Aldeano unAldeano = new Aldeano(x0, y0);
		turnoJugado = true;
		return unAldeano;
	}

}
