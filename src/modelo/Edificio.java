package modelo;

import modelo.excepciones.EdificioTieneOtroAldeanoAsignado;

public abstract class Edificio extends Pieza {

	protected int tiempoDeConstruccion;
	protected int cantidadDeCuracion;

	protected Aldeano aldeanoAsignado;
	
	public Edificio(Area areaAOcupar) {
	    super(areaAOcupar);

	    this.vidaMaxima = 0;
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
        if (vida >= vidaMaxima) {
            this.aldeanoAsignado = null;
            vida = vidaMaxima;
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

	    return (vida < vidaMaxima);
	}

	public boolean necesitaReparacion(){

	    return (vida < vidaMaxima);
    }

	public void recibirDanioDe(Arquero unArquero){

	    this.recibirDanio(10);
    }

    public void recibirDanioDe(Espadachin unEspadachin){

	    this.recibirDanio(15);
    }
}
