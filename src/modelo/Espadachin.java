package modelo;

public class Espadachin extends Unidad{

    /*     -Espadachin-
     *
     *      Distancia de ataque: 1
     *      Vida: 100
     *      Costo: 50
     */
	public static final int COSTO = 50;
	public static final int VIDA_MAX = 100;

	public Espadachin(int x0, int y0) {
		super(100);
		
		vida = VIDA_MAX;
		this.DANIO_EDIFICIOS = 15;
		this.DANIO_UNIDADES = 25;
		this.DISTANCIA_ATK = 1;

		espacioOcupado = Tablero.INSTANCIA.definirArea(x0, y0, x0, y0);
		espacioOcupado.ocupar();
	}

}
