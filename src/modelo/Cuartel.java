package modelo;

import modelo.excepciones.NoSePuedeConstruirTanLejosError;
import modelo.excepciones.NoSePuedeCrearUnidadesDuranteConstruccionError;
import modelo.factoryCuartel.FactoryGuerrero;
import modelo.factoryCuartel.TipoGuerrero;

public class Cuartel extends Edificio {

    public static final int TAMANIO_LADO = 2;
	
	public Cuartel(int x0, int y0) {
	    super();
	    
		this.COSTO = 50;
		this.VIDA_MAX = 250;
		vida = VIDA_MAX;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 50;

	    espacioOcupado = Tablero.INSTANCIA.definirArea(x0, y0, TAMANIO_LADO-1+x0, TAMANIO_LADO-1+y0);
	    espacioOcupado.ocupar();
	}

	public Unidad crearGuerrero(int x0, int y0, TipoGuerrero tipoDeseado){
        siYaJugoElTurnoError();

        Casilla supuestaUbicacion = new Casilla(x0, y0); 
        if(distanciaMinimaA(supuestaUbicacion) > 1)
            throw  new NoSePuedeConstruirTanLejosError();

        if(enConstruccion() == true)
            throw  new NoSePuedeCrearUnidadesDuranteConstruccionError();

        turnoJugado = true;
        return FactoryGuerrero.crearGuerrero(x0, y0, tipoDeseado);
        
    }

}
