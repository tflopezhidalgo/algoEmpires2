public abstract class Unidad extends Pieza {

	protected boolean ocupado;
	protected Casilla casillaActual;
	
	public Unidad(Casilla unaCasilla) throws ErrorBasico  {
		casillaActual = unaCasilla;
		casillaActual.colocar(this);
		turnoJugado = false;
		ocupado = false;
	}

	public void mover(Casilla nuevaCasilla) throws ErrorBasico {//habria que indicar una de las 8 direcciones posibles
		if(!ocupado) {
            if (nuevaCasilla.estaOcupada()) {
                //TODO ERROR CASILLA OCUPADA
                throw new java.lang.Error("ERROR: Casilla Ocupada.");
            }
            siEstaOcupadoDaError();

            casillaActual.liberar();
            casillaActual = nuevaCasilla;
            casillaActual.colocar(this);
        }
	}
	
	public Casilla obtenerUbicacion() {
		return casillaActual;
	}

	//----------------PRIVATE------------------
	protected void siEstaOcupadoDaError() throws ErrorBasico {
		if(ocupado) {
			//TODO ERROR
			throw new ErrorBasico("ERROR: La unidad esta ocupada.");
		}
	}
	
	protected void liberarUbicacion() {
		casillaActual.liberar();
	}
	
	/*public Posicion obtenerPosicion() {
		return casillaActual.obtenerPosicion();
	}*/
	
	//TODO eso es necesario para ARMADEASEDIO,ARQUERO,ESPADACHIN y ALDEANO
	protected void  enRango(Edificio edificioEnemigo, int distanciaMaxima) throws ErrorBasico {
		Area areaDelEdificio = edificioEnemigo.areaOcupada();
		int minimaDistancia = areaDelEdificio.distanciaMinimaA(obtenerUbicacion());

		if(minimaDistancia > distanciaMaxima) {
			throw new ErrorBasico("ERROR: Objetivo fuera de rango.");
		}
	}

	//TODO eso es necesario para ARQUERO y ESPADACHIN
	protected void enRango(Unidad unidadEnemiga, int distanciaMaxima) throws ErrorBasico {
		/*Posicion posicionA = unidadEnemiga.obtenerPosicion();
		Posicion posicionB = this.obtenerPosicion();*/

		int distancia = unidadEnemiga.obtenerUbicacion().calcularDistanciaA(this.obtenerUbicacion());

		/*int distancia = posicionA.calcularDistanciaA(posicionB);*/
		if(distancia > distanciaMaxima) {
			throw new ErrorBasico("ERROR: Objetivo fuera de rango.");
		}
	}

}
