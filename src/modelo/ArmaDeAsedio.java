package modelo;

import modelo.estadoArmaDeAsedio.CatapultaDesarmada;
import modelo.estadoArmaDeAsedio.EstadoCatapulta;

public class ArmaDeAsedio extends Unidad {

    final int VIDA = 150;
    final int COSTO = 200;

    private EstadoCatapulta estado;

    /*     -Arma de asedio-
     *
     *      Vida: 150
     *      Costo: 200
     *      Distancia de ataque: 5
     */

	public ArmaDeAsedio(Area unEspacio) {

		super(unEspacio);
		vida = VIDA;
		costo = COSTO;
		estado = new CatapultaDesarmada();
	}

	public void accionar() {

		estado = estado.cambiarEstado();
	}

	@Override
    public void mover(Area nuevaArea){

	    estado.mover();
        if( nuevaArea.estaLibre()) {
            espacioOcupado.liberar();
            espacioOcupado = nuevaArea;
            espacioOcupado.ocupar();
            turnoJugado = true;
        }

    }

	public void atacar(Edificio edificioEnemigo) {

        siYaJugoElTurnoError();

        if(enRango(edificioEnemigo,5)) {
            estado.atacar(edificioEnemigo);
			turnoJugado = true;
        }

        if(edificioEnemigo.estaDestruida()) {
            edificioEnemigo = null;
        }
	}	
}
