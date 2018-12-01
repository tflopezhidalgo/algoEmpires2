package modelo;

public class Arquero extends Unidad {

    final public int DISTANCIA_ATK = 3;

    /*      -Arquero-
     *
     *      Vida: 75
     *      Costo: 75
     *      Distancia de ataque: 3
     */

	public Arquero(int xInicial, int yInicial) {

		super(75, 75, 15, 10, 3);

		Area espacioAOcupar = Tablero.INSTANCIA.definirArea(xInicial, yInicial, xInicial, yInicial);
		espacioAOcupar.ocupar();
		espacioOcupado = espacioAOcupar;

		vida = VIDA_MAX;
	}


}
