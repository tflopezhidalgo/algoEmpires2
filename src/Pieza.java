import java.util.List;

public abstract class Pieza {
	
	protected int vida;
	protected int costo; //No sé si una pieza debería saber su costo
    protected Area areaOcupada;
	protected boolean jugoEnTurno;

	public Pieza(Area unArea) throws Excepcion{
	    this.vida = 0;
	    this.costo = 0;
	    this.areaOcupada = unArea;
	    this.areaOcupada.ocuparConPieza(this);
	    this.jugoEnTurno = false;
    }

	public Area obtenerAreaOcupada(){

	    return this.areaOcupada;
    }

    public void mover(Area unArea) throws Excepcion {

        areaOcupada.liberarCasillas();
        areaOcupada = unArea;
        areaOcupada.ocuparConPieza(this);
        // TODO: No tiene mucho sentido pasarle la pieza a la casilla/area si total no la conoce.
    }

	public void recibirDanio(int danio) {

		this.vida = this.vida - danio;

		if(vida <= 0) {

			vida = 0;
			//TODO destruir/morir/perder
			areaOcupada.liberarCasillas();
		}
	}

	public void nuevoTurno() {

		jugoEnTurno = false;
	}
	
	public boolean estaDestruida() {

		return (vida == 0);
	}

	/*          Métodos protected.          */
    //TODO: Sacar estos métodos falopas.
    protected void siYaJugoElTurnoError() throws Excepcion {

        if(this.jugoEnTurno) {

            throw new Excepcion("ERROR: Turno ya jugado.");
        }
    }

    protected boolean enRango(Pieza pieza, int distanciaMaxima) throws Excepcion {

        int distanciaMinima = distanciaMinimaA(pieza.obtenerAreaOcupada());

        if(distanciaMinima > distanciaMaxima)
            return false;

        return true;
    }

    protected int distanciaMinimaA(Area area){
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
}
