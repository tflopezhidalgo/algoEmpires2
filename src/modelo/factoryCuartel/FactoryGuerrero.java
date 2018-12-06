package modelo.factoryCuartel;

import modelo.Arquero;
import modelo.Espadachin;
import modelo.Unidad;
import modelo.excepciones.TipoDeGuerreroInvalidoError;

public class FactoryGuerrero {

    public static Unidad crearGuerrero(int x0, int y0, TipoGuerrero tipoDeseado){

        if(tipoDeseado == TipoGuerrero.ESPADACHIN)
            return new Espadachin(x0, y0);

        else if(tipoDeseado == TipoGuerrero.ARQUERO)
            return new Arquero(x0, y0);

        else
            throw  new TipoDeGuerreroInvalidoError();
    }
}
