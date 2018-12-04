package modelo;

import modelo.estadoArmaDeAsedio.CatapultaDesarmada;
import modelo.estadoArmaDeAsedio.EstadoCatapulta;

public class ArmaDeAsedio extends Unidad{

    private EstadoCatapulta estado;

    /*     -Arma de asedio-
     *
     *      Vida: 150
     *      Costo: 200
     *      Distancia de ataque: 5
     */
	public static final int COSTO = 200;
	public static final int VIDA_MAX = 150;

	public ArmaDeAsedio(int x0, int y0) {
		super(150);

		vida = VIDA_MAX;
		this.DANIO_EDIFICIOS = 75;
		this.DANIO_UNIDADES = 0;
		this.DISTANCIA_ATK = 5;
		
		estado = new CatapultaDesarmada();

		espacioOcupado = Tablero.INSTANCIA.definirArea(x0, y0, x0, y0);
		espacioOcupado.ocupar();
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
