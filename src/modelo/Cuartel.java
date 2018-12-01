package modelo;

import modelo.excepciones.*;
import modelo.factoryCuartel.*;

public class Cuartel extends Edificio {

    public static final int TAMANIO_LADO = 2;
	
	public Cuartel(int xInicial, int yInicial) {

	    Area areaAOcupar = Tablero.INSTANCIA.definirArea(xInicial, yInicial, TAMANIO_LADO-1, TAMANIO_LADO-1);

		super(areaAOcupar, 250, 50);

		vida = super.VIDA_MAX;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 50;
	}

	public Unidad crearGuerrero(Area unEspacio, TipoGuerrero tipoDeseado){
        siYaJugoElTurnoError();

        if(distanciaMinimaA(unEspacio) > 1)
            throw  new NoSePuedeConstruirTanLejosError();

        if(enConstruccion() == true)
            throw  new NoSePuedeCrearUnidadesDuranteConstruccionError();

        turnoJugado = true;
        return FactoryGuerrero.crearGuerrero(unEspacio, tipoDeseado);
        
    }

	
}
