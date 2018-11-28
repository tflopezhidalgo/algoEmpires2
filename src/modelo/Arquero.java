package modelo;

public class Arquero extends Unidad implements Atacante {

    final int VIDA = 75;
    final int COSTO = 75;
	
    /*      -Arquero-
     *
     *      Vida: 75
     *      Costo: 75
     *      Distancia de ataque: 3
     */

	public Arquero(Area unEspacio) {
		super(unEspacio);
		vidaMaxima = VIDA;
		vida = vidaMaxima;
		costo = COSTO;
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
