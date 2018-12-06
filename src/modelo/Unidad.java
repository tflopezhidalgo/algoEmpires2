package modelo;

public abstract class Unidad extends Pieza {

    public final int DANIO_UNIDADES;
    public final int DANIO_EDIFICIOS;
    public final int DISTANCIA_ATK;

	public Unidad(int vidaMax, int costo, int danioUnidades, int danioEdificios, int distanciaAtk) {

	    super(vidaMax, costo);

	    this.DANIO_UNIDADES = danioUnidades;
	    this.DANIO_EDIFICIOS = danioEdificios;
	    this.DISTANCIA_ATK = distanciaAtk;
	}

	public void mover(Area nuevoEspacio){

	    this.siYaJugoElTurnoError();

	    nuevoEspacio.ocupar();
        espacioOcupado.liberar();
        espacioOcupado = nuevoEspacio;
        turnoJugado = true;
	}

	public void atacar(Pieza unaPieza){

	    this.siYaJugoElTurnoError();

	    chequearRango(unaPieza, DISTANCIA_ATK);

        unaPieza.recibirDanioDe(this);

	    turnoJugado = true;
    }

    public void recibirDanioDe(Edificio edificio){

    }

    public void recibirDanioDe(Unidad unaUnidad){

        this.recibirDanio(unaUnidad.DANIO_UNIDADES);
    }
    
    public double porcentajeVidaActual() {
        return ((double)vida/VIDA_MAX);
    }

}
