package modelo;

public class Espadachin extends Unidad{

    /*     -Espadachin-
     *
     *      Distancia de ataque: 1
     *      Vida: 100
     *      Costo: 50
     */

	public Espadachin(int x0, int y0) {
		super();
		
		this.COSTO = 50;
		this.VIDA_MAX = 100;
		vida = VIDA_MAX;
		this.DANIO_EDIFICIOS = 15;
		this.DANIO_UNIDADES = 25;
		this.DISTANCIA_ATK = 1;

		espacioOcupado = Tablero.INSTANCIA.definirArea(x0, y0, x0, y0);
		espacioOcupado.ocupar();
	}

}
