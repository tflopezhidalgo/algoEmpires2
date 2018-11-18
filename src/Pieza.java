import java.util.List;

public abstract class Pieza {
	
	protected int vida;
	protected int costo; //No sé si una pieza debería saber su costo
	protected Area espacioOcupado;
	protected boolean turnoJugado;

	public Area obtenerAreaOcupada(){
	    return espacioOcupado;
    	}

	public void recibirDanio(int danio) {
		vida -= danio;
		if(vida <= 0) {
			vida = 0;
			//TODO destruir/morir/perder
			liberarUbicacion();
		}
	}

	public void nuevoTurno() {
		turnoJugado = false;
	}
	
	public boolean estaDestruida() {
		return (vida == 0);
	}
	
	protected void liberarUbicacion() {
		espacioOcupado.liberar();
	}
	
	public Area espacioOcupado() {
		return espacioOcupado;
	}	

	/*          Métodos protected.          */
    //TODO: Sacar estos métodos falopas.
    protected void siYaJugoElTurnoError() throws Excepcion {
        if(turnoJugado) {

            throw new Excepcion("ERROR: Turno ya jugado.");
        }
    }

    protected boolean enRango(Pieza pieza, int distanciaMaxima) throws Excepcion {
	Area espacioEnemigo = pieza.espacioOcupado();
	int distanciaMinima = distanciaMinimaA(espacioEnemigo);

	if(distanciaMinima > distanciaMaxima) {
		return false;
	}
	return true;
    }

	protected int distanciaMinimaA(Area area){
		int minimaDistancia = Integer.MAX_VALUE; // TODO ver si hay una mejor manera de arreglar esto
		int distanciaNueva;
		List<Casilla> casillasEnemigas = area.obtenerCasillas();
		for (int i = 0; i < area.obtenerTamanio(); i++) {
			Casilla casillaActual = casillasEnemigas.get(i);

			distanciaNueva = espacioOcupado().distanciaMinimaA(casillaActual);
			if(distanciaNueva < minimaDistancia) {
				minimaDistancia = distanciaNueva;
			}
		}
		return minimaDistancia;
	}
}
