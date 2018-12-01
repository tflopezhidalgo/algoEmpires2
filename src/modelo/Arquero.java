package modelo;

public class Arquero extends Unidad {

    final public int DISTANCIA_ATK = 3;

    /*      -Arquero-
     *
     *      Vida: 75
     *      Costo: 75
     *      Distancia de ataque: 3
     */

	public Arquero(Area unEspacio) {

		super(unEspacio, 75, 75, 15, 10, 3);

		vida = VIDA_MAX;
	}

}
