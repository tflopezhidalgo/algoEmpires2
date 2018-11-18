public class ArmaDeAsedio extends Unidad {

    /*     -Arma de asedio-
     *
     *      Vida: 150
     *      Costo: 200
     *      Distancia de ataque: 5
     */

	ArmaDeAsedio(Area unArea) throws Excepcion {
		super(unArea);
		vida = 150;
		costo = 200;
	}

	public void accionar() {
		ocupado = !ocupado;
	}

	public void atacar(Pieza piezaEnemiga) throws Excepcion {
		enModoAtaque();
		
		enRango(piezaEnemiga,5);
		piezaEnemiga.recibirDanio(75);
		
		if(piezaEnemiga.estaDestruida()) {
			piezaEnemiga = null;
		}
	}
	
	private void enModoAtaque() throws Excepcion {
		if(!ocupado) {
			throw new Excepcion("ERROR: ArmaDeAsedio no esta en Modo Ataque.");
		}
	}
	
}
