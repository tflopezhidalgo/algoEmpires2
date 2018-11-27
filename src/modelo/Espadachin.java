package modelo;

public class Espadachin extends Unidad {

    /*     -Espadachin-
     *
     *      Distancia de ataque: 1
     *      Vida: 100
     *      Costo: 50
     */

	public Espadachin(Area unEspacio) {
		super(unEspacio);
		vida = 100;
		costo = 50;
	}

	public void atacar(Pieza unaPieza){

        siYaJugoElTurnoError();

        if(enRango(unaPieza,1)) {

            unaPieza.recibirDanioDe(this);
            turnoJugado = true;
        }

        if(unaPieza.estaDestruida()) {
            unaPieza = null;
        }
    }

}
