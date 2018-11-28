package modelo;

public abstract class Unidad extends Pieza {

	public Unidad(Area unEspacio) {
	    super(unEspacio);
	}

	public void mover(Area nuevoEspacio){
	    this.siYaJugoElTurnoError();

        if (nuevoEspacio.estaLibre()) {
            espacioOcupado.liberar();
            espacioOcupado = nuevoEspacio;
            espacioOcupado.ocupar();
            turnoJugado = true;
        }
	}

	public void recibirDanioDe(Arquero unArquero){
        this.recibirDanio(15);
    }

    public void recibirDanioDe(Espadachin unEspadachin){
        this.recibirDanio(25);
    }

}
