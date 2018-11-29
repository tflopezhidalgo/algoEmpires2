package modelo;

import modelo.estadoEdificio.EdificioSiendoReparado;
import modelo.estadoEdificio.EdificioSinSerReparado;
import modelo.estadoEdificio.EstadoEdificio;

public abstract class Edificio extends Pieza {

	protected int tiempoDeConstruccion;
	protected int cantidadDeCuracion;
	
	protected EstadoEdificio estado;
	
	public Edificio(Area areaAOcupar) {
	    super(areaAOcupar);
	    this.vidaMaxima = 0;
	    this.tiempoDeConstruccion = 0;
	    this.cantidadDeCuracion = 0;
	    estado = new EdificioSinSerReparado();
	}

	public void reparar() {
		vida = vida + cantidadDeCuracion;
		if(!vidaBaja()) {
			estado = new EdificioSinSerReparado();
			vida = vidaMaxima;
			// liberar al aldeano de su labor
		}
	}
	
	public boolean necesitaReparacion() {
		return (estado.necesitaReparacion(vida, vidaMaxima));
	}
	
	public boolean vidaBaja() {
		return vida<vidaMaxima;
	}
	
	public boolean enConstruccion() {
		return(tiempoDeConstruccion > 0);
	}
	
	public void construir() {
		if(enConstruccion()) {
			tiempoDeConstruccion--;
		}
	}
	
	public int tamanioArea() {
		return espacioOcupado.obtenerCantidadDeCasillas();
	}

	public void recibirDanioDe(Arquero unArquero){
	    this.recibirDanio(10);
    }

    public void recibirDanioDe(Espadachin unEspadachin){
	    this.recibirDanio(15);
    }

	public void comenzarReparacion() {
		estado = new EdificioSiendoReparado();
	}
}
