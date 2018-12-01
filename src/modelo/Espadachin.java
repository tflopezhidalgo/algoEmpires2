package modelo;

public class Espadachin extends Unidad{

    /*     -Espadachin-
     *
     *      Distancia de ataque: 1
     *      Vida: 100
     *      Costo: 50
     */

	public Espadachin(int xInicial, int yInicial) {

		super(100, 50, 25, 15, 1);

		Area espacioAOcupar = Tablero.INSTANCIA.definirArea(xInicial, yInicial, xInicial, yInicial);
		espacioAOcupar.ocupar();
		espacioOcupado = espacioAOcupar;

		vida = VIDA_MAX;
	}

}
