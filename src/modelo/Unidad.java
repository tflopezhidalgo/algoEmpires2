package modelo;

public abstract class Unidad extends Pieza {

	public Unidad(Area unEspacio, int vidaMax, int costo) {

	    super(unEspacio, vidaMax, costo);
	}

	public void mover(Area nuevoEspacio){

	    this.siYaJugoElTurnoError();

	    nuevoEspacio.ocupar();  //Si está ocupado se lanza excepción CasillaOcupadaError.
        espacioOcupado.liberar();
        espacioOcupado = nuevoEspacio;
        turnoJugado = true;
	}

	public void recibirDanioDe(Arquero unArquero){

        this.recibirDanio(15);
    }

    public void recibirDanioDe(Espadachin unEspadachin){

	    this.recibirDanio(25);
    }

    public void recibirDanioDe(ArmaDeAsedio unArmaDeAsedio){


    }
}
