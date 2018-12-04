package modelo;

public class Arquero extends Unidad {

    /*      -Arquero-
     *
     *      Vida: 75
     *      Costo: 75
     *      Distancia de ataque: 3
     */
	public static final int COSTO = 75;
	public static final int VIDA_MAX = 75;


	public Arquero(int x0, int y0) {
		super(75);

		vida = VIDA_MAX;
		this.DANIO_EDIFICIOS = 10;
		this.DANIO_UNIDADES = 15;
		this.DISTANCIA_ATK = 3;

		espacioOcupado = Tablero.INSTANCIA.definirArea(x0, y0, x0, y0);
		espacioOcupado.ocupar();
	}


}
