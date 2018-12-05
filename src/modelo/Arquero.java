package modelo;

public class Arquero extends Unidad {

    /*      -Arquero-
     *
     *      Vida: 75
     *      Costo: 75
     *      Distancia de ataque: 3
     */

	public Arquero(int x0, int y0) {
	    
		super(75, 75, 15,10,3);

		espacioOcupado = Tablero.INSTANCIA.definirArea(x0, y0, x0, y0);
		espacioOcupado.ocupar();
	}


}
