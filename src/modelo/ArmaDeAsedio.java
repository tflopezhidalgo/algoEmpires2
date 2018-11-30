package modelo;

import modelo.estadoArmaDeAsedio.*;

public class ArmaDeAsedio extends Unidad implements Atacante{

    final public int DISTANCIA_ATK = 5;

    private EstadoCatapulta estado;

    /*     -Arma de asedio-
     *
     *      Vida: 150
     *      Costo: 200
     *      Distancia de ataque: 5
     */

	public ArmaDeAsedio(Area unEspacio) {

		super(unEspacio, 150, 200);

		vida = VIDA_MAX;

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

        chequearRango(piezaEnemiga, DISTANCIA_ATK);

        piezaEnemiga.recibirDanioDe(this);
        turnoJugado = true;
	}
}
