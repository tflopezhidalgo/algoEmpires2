package modelo;

import modelo.excepciones.*;

public abstract class Pieza {

    public final int VIDA_MAX;
    public final int COSTO;

	protected int vida;
	protected boolean turnoJugado;
    protected Area espacioOcupado;

	/*          Constructor             */
	public Pieza(int vidaMax, int costo) {

	    this.COSTO = costo;
	    this.vida = vidaMax;
	    this.VIDA_MAX = vidaMax;
		turnoJugado = false;

	}
	
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
    
    protected int distanciaMinimaA(Casilla casilla) {

    	int minimaDistancia = obtenerAreaOcupada().distanciaMinimaA(casilla);
        return minimaDistancia;
    }

    protected void liberarUbicacion() {espacioOcupado.liberar(); }

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

    public abstract double porcentajeVidaActual();

    public abstract void atacar(Pieza piezaEnemiga);

	public abstract void recibirDanioDe(Unidad unaUnidad);

	public abstract void recibirDanioDe(Edificio unEdificio);

    public Area obtenerAreaOcupada() { return espacioOcupado; }

    public int getVidaActual(){

        return this.vida;
    }

}
