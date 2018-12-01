package modelo;

import modelo.estadoArmaDeAsedio.*;

public class ArmaDeAsedio extends Unidad{

    private EstadoCatapulta estado;

    /*     -Arma de asedio-
     *
     *      Vida: 150
     *      Costo: 200
     *      Distancia de ataque: 5
     */

	public ArmaDeAsedio(int xInicial, int yInicial) {

		Area unEspacio = Tablero.INSTANCIA.definirArea(xInicial, yInicial, xInicial, yInicial);

		super(unEspacio, 150, 200, 0,75, 5);

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

	public void atacar(Pieza unaPieza) {

	    estado.atacar();

	    super.atacar(unaPieza);
	}
}
