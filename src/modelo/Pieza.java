package modelo;

import modelo.excepciones.PiezaYaJugoEnTurnoActualError;

public abstract class Pieza {
	
	protected int vida;
	protected int costo;
	protected Area espacioOcupado;
	protected boolean turnoJugado;

    protected void liberarUbicacion() {espacioOcupado.liberar(); }

    protected void siYaJugoElTurnoError(){

        if(turnoJugado){

            throw new PiezaYaJugoEnTurnoActualError();
        }
    }

    protected boolean enRango(Pieza piezaEnemiga, int distanciaMaxima){

        int distanciaAPieza = distanciaMinimaA(piezaEnemiga.obtenerAreaOcupada());

        if(distanciaAPieza > distanciaMaxima) {
            return false;
        }
        return true;
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

        vida = 0;
        costo = 0;
        espacioOcupado = null;
        turnoJugado = false;
    }

	public Pieza(Area espacioAOcupar) {

		espacioOcupado = espacioAOcupar;
		espacioOcupado.ocupar();
		turnoJugado = false;
		vida = 0;
		costo = 0;
	}

	public Area obtenerAreaOcupada() { return espacioOcupado; }

	public void recibirDanio(int danio) {
		vida = vida - danio;
		if(vida <= 0) {
			vida = 0;
			this.liberarUbicacion();
		}
	}

	public void nuevoTurno() {

		turnoJugado = false;
	}
	
	public boolean estaDestruida() { return (vida == 0); }

	public abstract void recibirDanioDe(Arquero unArquero);
	public abstract void recibirDanioDe(Espadachin unEspadachin);
}
