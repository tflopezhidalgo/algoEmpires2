public class Espadachin extends Unidad {

    /*     -Espadachín-
     *
     *      Distancia de ataque: 1
     *      Vida: 100
     *      Costo: 50
     */

	Espadachin(Area unArea) throws Excepcion {
		super(unArea);
		vida = 100;
		costo = 50;
	}

	public void atacar(Pieza piezaEnemiga) throws Excepcion{

	    enRango(piezaEnemiga, 1);
	    piezaEnemiga.recibirDanio(15);

	    if(piezaEnemiga.estaDestruida())

	        piezaEnemiga.obtenerAreaOcupada().liberarCasillas();
    }
}
