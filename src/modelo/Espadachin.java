package modelo;

public class Espadachin extends Unidad{

    /*     -Espadachin-
     *
     *      Distancia de ataque: 1
     *      Vida: 100
     *      Costo: 50
     */

	public Espadachin(Area unEspacio) {

		super(unEspacio, 100, 50, 25, 15, 1);

		vida = VIDA_MAX;
	}

}
