package modelo.factoryCuartel;

import modelo.Area;
import modelo.Arquero;
import modelo.Espadachin;
import modelo.Unidad;
import modelo.excepciones.NoSePuedeConstruirTanLejosError;
import modelo.excepciones.NoSePuedeCrearUnidadesDuranteConstruccionError;
import modelo.excepciones.TipoDeGuerreroInvalidoError;

public class FactoryGuerrero {

    public static Unidad crearGuerrero(Area unEspacio, TipoGuerrero tipoDeseado){

        if(tipoDeseado == TipoGuerrero.ESPADACHIN)
            return new Espadachin(unEspacio);

        else if(tipoDeseado == TipoGuerrero.ARQUERO)
            return new Arquero(unEspacio);

        else
            throw  new TipoDeGuerreroInvalidoError();
    }
}
