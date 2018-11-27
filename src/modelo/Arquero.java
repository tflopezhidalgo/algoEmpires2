package modelo;

public class Arquero extends Unidad {

    /*      -Arquero-
     *
     *      Vida: 75
     *      Costo: 75
     *      Distancia de ataque: 3
     */

	public Arquero(Area unEspacio) {
		super(unEspacio);
		vida = 75;
		costo = 75;
	}

	public void atacar(Pieza unaPieza){

        siYaJugoElTurnoError();

        if(enRango(unaPieza,3)) {
            unaPieza.recibirDanioDe(this);
            turnoJugado = true;
        }

        if(unaPieza.estaDestruida()) {
            unaPieza = null;
        }
    }
	
}
