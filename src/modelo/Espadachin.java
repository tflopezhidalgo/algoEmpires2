package modelo;

public class Espadachin extends Unidad  implements Atacante{
	
    final int VIDA = 100;
    final int COSTO = 50;
    final int DISTANCIA_ATK = 1;

    /*     -Espadachin-
     *
     *      Distancia de ataque: 1
     *      Vida: 100
     *      Costo: 50
     */

	public Espadachin(Area unEspacio) {

		super(unEspacio);
		vidaMaxima = VIDA;
		vida = vidaMaxima;
		costo = COSTO;
	}

	public void atacar(Pieza unaPieza){

        siYaJugoElTurnoError();

        if(enRango(unaPieza, this.DISTANCIA_ATK)) {

            unaPieza.recibirDanioDe(this);
            turnoJugado = true;
        }
    }

}
