package modelo;

import modelo.excepciones.*;
import modelo.factoryCuartel.*;

public class Cuartel extends Edificio {

    public static final int TAMANIO_LADO = 2;
	
	public Cuartel(Area areaAOcupar) {

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

        return FactoryGuerrero.crearGuerrero(unEspacio, tipoDeseado);
    }


	public Espadachin crearEspadachin(Area unEspacio) {

	    return null;
	}
	
	public Arquero crearArquero(Area unEspacio) {

	    return null;
	}
	
}
