package modelo;

public abstract class Unidad extends Pieza {

    protected int DANIO_UNIDADES;
    protected int DANIO_EDIFICIOS;
    protected int DISTANCIA_ATK;
    private final int VIDA_MAX;

	public Unidad(int vidaMax) {
	    super();
	    this.VIDA_MAX = vidaMax;
	}

	public void mover(Area nuevoEspacio){

	    this.siYaJugoElTurnoError();

	    nuevoEspacio.ocupar();  //Si esta ocupado se lanza excepcion CasillaOcupadaError.
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

        //Edificios no atacan a las unidades.
    }

    public void recibirDanioDe(Unidad unaUnidad){

        this.recibirDanio(unaUnidad.DANIO_UNIDADES);
    }
    
    public double porcentajeVidaActual() {
        return ((double)vida/VIDA_MAX);
    }

}
