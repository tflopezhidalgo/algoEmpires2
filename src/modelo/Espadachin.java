package modelo;

public class Espadachin extends Unidad  implements Atacante{

    final int DISTANCIA_ATK = 1;

    /*     -Espadachin-
     *
     *      Distancia de ataque: 1
     *      Vida: 100
     *      Costo: 50
     */

	public Espadachin(Area unEspacio) {

		super(unEspacio, 100, 50);

		vida = VIDA_MAX;
	}

	public void atacar(Pieza unaPieza){

        siYaJugoElTurnoError();

        chequearRango(unaPieza, DISTANCIA_ATK);

        unaPieza.recibirDanioDe(this);
        turnoJugado = true;
    }

}
