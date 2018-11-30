package modelo;

import modelo.estadoArmaDeAsedio.*;

public class ArmaDeAsedio extends Unidad implements Atacante{

    final int VIDA = 150;
    final int COSTO = 200;
    final int DISTANCIA_ATK = 5;

    private EstadoCatapulta estado;

    /*     -Arma de asedio-
     *
     *      Vida: 150
     *      Costo: 200
     *      Distancia de ataque: 5
     */

	public ArmaDeAsedio(Area unEspacio) {

		super(unEspacio);
		vidaMaxima = VIDA;
		vida = vidaMaxima;
		costo = COSTO;
		estado = new CatapultaDesarmada();
	}

	public void accionar() {

        siYaJugoElTurnoError();

		estado = estado.cambiarEstado();

		turnoJugado = true;
	}

    public void mover(Area nuevaArea){

	    estado.mover();

        super.mover(nuevaArea);
    }

	public void atacar(Pieza piezaEnemiga){

        siYaJugoElTurnoError();

        if(enRango(piezaEnemiga, 5)) {

            piezaEnemiga.recibirDanioDe(this);
            turnoJugado = true;
        }
	}
}
