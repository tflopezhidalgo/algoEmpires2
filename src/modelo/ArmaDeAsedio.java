package modelo;

import modelo.estadoArmaDeAsedio.*;

public class ArmaDeAsedio extends Unidad{

    final public int DISTANCIA_ATK = 5;

    private EstadoCatapulta estado;

    /*     -Arma de asedio-
     *
     *      Vida: 150
     *      Costo: 200
     *      Distancia de ataque: 5
     */

	public ArmaDeAsedio(Area unEspacio) {

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
    
    @Override
	public void atacar(Pieza unaPieza) {
	    this.siYaJugoElTurnoError();

	    chequearRango(unaPieza, DISTANCIA_ATK);
	    
        estado.atacar(unaPieza,this);

	    turnoJugado = true;
	}
}
