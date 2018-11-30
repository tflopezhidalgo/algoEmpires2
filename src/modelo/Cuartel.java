package modelo;

import modelo.excepciones.*;

public class Cuartel extends Edificio {

    public enum tipoGuerrero {ARQUERO, ESPADACHIN}

    public static final int TAMANIO_LADO = 2;
	public static final int COSTO = 50;
	
	public Cuartel(Area areaAOcupar) {

		super(areaAOcupar);
		vidaMaxima = 250;
		vida = vidaMaxima;
		costo = COSTO;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 50;
	}

	public Unidad crearGuerrero(Area unEspacio, tipoGuerrero tipoDeseado){
        siYaJugoElTurnoError();

        if(distanciaMinimaA(unEspacio) > 1)
            throw  new NoSePuedeConstruirTanLejosError();

        if(enConstruccion() == true)
            throw  new NoSePuedeCrearUnidadesDuranteConstruccionError();

        if(tipoDeseado == tipoGuerrero.ESPADACHIN)
            return new Espadachin(unEspacio);

        else if(tipoDeseado == tipoGuerrero.ARQUERO)
            return new Arquero(unEspacio);

        else
            throw  new TipoDeGuerreroInvalidoError();

    }


	public Espadachin crearEspadachin(Area unEspacio) {

	    return null;
	}
	
	public Arquero crearArquero(Area unEspacio) {

	    return null;
	}
	
}
