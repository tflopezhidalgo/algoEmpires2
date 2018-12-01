package modelo;

public abstract class Unidad extends Pieza {

    public final int DANIO_UNIDADES;
    public final int DANIO_EDIFICIOS;
    public final int DISTANCIA_ATK;

	public Unidad(int vidaMax, int costo, int danioUnidades, int danioEdificios, int distancia) {

	    super(vidaMax, costo);

	    DANIO_EDIFICIOS = danioEdificios;
	    DANIO_UNIDADES = danioUnidades;
	    DISTANCIA_ATK = distancia;
	}

	public void mover(Area nuevoEspacio){

	    this.siYaJugoElTurnoError();

	    nuevoEspacio.ocupar();  //Si está ocupado se lanza excepción CasillaOcupadaError.
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

}
