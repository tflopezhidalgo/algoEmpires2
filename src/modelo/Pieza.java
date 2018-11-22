package modelo;

import modelo.excepciones.CasillaInvalidaError;
import modelo.excepciones.CasillaOcupadaError;
import modelo.excepciones.CastilloDeJugadorFueDestruido;
import modelo.excepciones.PiezaYaJugoEnTurnoActualError;

import java.util.List;

public abstract class Pieza {
	
	protected int vida;
	protected int costo;
	protected Area espacioOcupado;
	protected boolean turnoJugado;

    protected void liberarUbicacion() { espacioOcupado.liberar(); }

    protected void siYaJugoElTurnoError() throws PiezaYaJugoEnTurnoActualError {

        if(turnoJugado)

            throw new PiezaYaJugoEnTurnoActualError();
    }

    protected boolean enRango(Pieza piezaEnemiga, int distanciaMaxima){

        Area espacioEnemigo = piezaEnemiga.obtenerAreaOcupada();
        int distanciaMinima = distanciaMinimaA(espacioEnemigo);

        if(distanciaMinima > distanciaMaxima) {
            return false;
        }
        return true;
    }

    protected int distanciaMinimaA(Area area) {

        int minimaDistancia = Integer.MAX_VALUE; // TODO ver si hay una mejor manera de arreglar esto
        int distanciaNueva;
        List<Casilla> casillasEnemigas = area.obtenerCasillas();
        for (int i = 0; i < area.obtenerCantidadDeCasillas(); i++) {
            Casilla casillaActual = casillasEnemigas.get(i);

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

	public Pieza(Area espacioAOcupar) throws CasillaOcupadaError {

		espacioOcupado = espacioAOcupar;
		espacioOcupado.ocupar();
		turnoJugado = false;
		vida = 0;
		costo = 0;
	}

	public Area obtenerAreaOcupada() { return espacioOcupado; }

	public void recibirDanio(int danio) throws CastilloDeJugadorFueDestruido {
		vida = vida - danio;
		if(vida <= 0) {

			vida = 0;
			this.liberarUbicacion();
		}
	}

	public void nuevoTurno() { turnoJugado = false; }
	
	public boolean estaDestruida() { return (vida == 0); }

}
