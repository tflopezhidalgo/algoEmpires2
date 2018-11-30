package modelo;

import modelo.excepciones.PiezaFueraDeAlcanceError;
import modelo.excepciones.PiezaYaJugoEnTurnoActualError;

public abstract class Pieza {

    final public int COSTO;
    final public int VIDA_MAX;

	protected int vida;
	protected Area espacioOcupado;
	protected boolean turnoJugado;

    protected void liberarUbicacion() {espacioOcupado.liberar(); }

    protected void siYaJugoElTurnoError(){

        if(turnoJugado){

            throw new PiezaYaJugoEnTurnoActualError();
        }
    }

    protected void chequearRango(Pieza piezaEnemiga, int distanciaMaxima){

        int distanciaAPieza = distanciaMinimaA(piezaEnemiga.obtenerAreaOcupada());

        if(distanciaAPieza > distanciaMaxima)
            throw new PiezaFueraDeAlcanceError();
    }

    protected int distanciaMinimaA(Area area) {

        int minimaDistancia = Integer.MAX_VALUE; // TODO ver si hay una mejor manera de arreglar esto
        int distanciaNueva = 0;

        for (int i = 0; i < area.obtenerCantidadDeCasillas(); i++) {
            Casilla casillaActual = area.obtenerCasillas().get(i);

            distanciaNueva = obtenerAreaOcupada().distanciaMinimaA(casillaActual);
            if(distanciaNueva < minimaDistancia) {
                minimaDistancia = distanciaNueva;
            }
        }
        return minimaDistancia;
    }

	/*          Constructor             */

	public Pieza(){

        espacioOcupado = null;
        turnoJugado = false;

        VIDA_MAX = 0;
        COSTO = 0;
    }

	public Pieza(Area espacioAOcupar, int vidaMaxima, int costo) {

        espacioAOcupar.ocupar();
	    espacioOcupado = espacioAOcupar;
		turnoJugado = false;

		VIDA_MAX = vidaMaxima;
		COSTO = costo;
	}

	public Area obtenerAreaOcupada() { return espacioOcupado; }

	public void recibirDanio(int danio) {
		vida = (vida - danio);
		if(vida <= 0) {
			vida = 0;
			this.liberarUbicacion();
		}
	}

	public void nuevoTurno() {

		turnoJugado = false;
	}
	
	public boolean estaDestruida() { return (vida == 0); }

    public double porcentajeVidaActual() {
        return ((double)vida/VIDA_MAX);
    }

    public abstract void atacar(Pieza unaPiza);

    public abstract void recibirDanioDe(Edificio unEdificio);

	public abstract void recibirDanioDe(Unidad unaUnidad);

}
