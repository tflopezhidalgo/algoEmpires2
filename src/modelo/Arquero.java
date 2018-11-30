package modelo;

public class Arquero extends Unidad implements Atacante {

    final public int DISTANCIA_ATK = 3;

    /*      -Arquero-
     *
     *      Vida: 75
     *      Costo: 75
     *      Distancia de ataque: 3
     */

	public Arquero(Area unEspacio) {

		super(unEspacio, 75, 75);

		vida = VIDA_MAX;
	}

	public void atacar(Pieza unaPieza){

        siYaJugoElTurnoError();

       chequearRango(unaPieza, DISTANCIA_ATK);

       unaPieza.recibirDanioDe(this);
       turnoJugado = true;
    }
	
}
