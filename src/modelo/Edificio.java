package modelo;

import modelo.excepciones.EdificioTieneOtroAldeanoAsignado;

public abstract class Edificio extends Pieza {

	protected int tiempoDeConstruccion;
	protected int cantidadDeCuracion;

	protected Aldeano aldeanoAsignado;
	

	public Edificio(int vidaMax, int costo) {

	    super(vidaMax, costo);

	    this.tiempoDeConstruccion = 0;
	    this.cantidadDeCuracion = 0;
	    this.aldeanoAsignado = null;
	}

	public void setAldeanoAsignado(Aldeano unAldeano){
        if(this.aldeanoAsignado == null)
	        this.aldeanoAsignado = unAldeano;

        else if(this.aldeanoAsignado != unAldeano)
            throw new EdificioTieneOtroAldeanoAsignado();
    }

	public void reparar() {

	    vida = vida + cantidadDeCuracion;
        if (vida >= VIDA_MAX) {
            this.aldeanoAsignado = null;
            vida = VIDA_MAX;
        }
	}

    public void construir() {

        tiempoDeConstruccion--;
        if(tiempoDeConstruccion <= 0){
            this.aldeanoAsignado = null;
            tiempoDeConstruccion = 0;
        }
    }

	public boolean enConstruccion(){

	    return (tiempoDeConstruccion > 0);
    }

	public boolean vidaBaja() {

	    return this.necesitaReparacion();
	}

	public boolean necesitaReparacion(){

	    return (vida < VIDA_MAX);
    }

    public void atacar(Pieza unaPieza){


    }

    public void recibirDanioDe(Edificio unEdificio){

	    //Los edificios no se atacan entre si
    }

    public void recibirDanioDe(Unidad unaUnidad){

    	this.recibirDanio(unaUnidad.DANIO_EDIFICIOS);
    }

}
