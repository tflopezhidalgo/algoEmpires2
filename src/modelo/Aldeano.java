package modelo;

import modelo.estadoAldeano.AldeanoLibre;
import modelo.estadoAldeano.EstadoAldeano;
import modelo.excepciones.NoSePuedeConstruirTanLejosError;

public class Aldeano extends Unidad {

	private EstadoAldeano estadoActual;
	
	public Aldeano(int xInicial, int yInicial){

		Area unEspacio = Tablero.INSTANCIA.definirArea(xInicial, yInicial, xInicial, yInicial);

		super(unEspacio, 50, 25,0,0,1);

		estadoActual = new AldeanoLibre();
		vida = VIDA_MAX;
	}

	@Override
    public void atacar(Pieza unaPieza){


    }

	@Override
    public void mover(Area nuevaArea) {
	    estadoActual.mover();
        super.mover(nuevaArea);
    }

	public void reparar(Edificio unEdificio) {
	    siYaJugoElTurnoError();

		chequearRango(unEdificio, DISTANCIA_ATK);
		estadoActual = estadoActual.reparar(unEdificio, this);
		turnoJugado = true;
	}

	//TODO: Retornar clases madres (Edificio)

	public Edificio crearPlaza(Area areaDeConstruccion) {
		siYaJugoElTurnoError();

        if(distanciaMinimaA(areaDeConstruccion) > DISTANCIA_ATK)
            throw new NoSePuedeConstruirTanLejosError();

        estadoActual = estadoActual.construirPlaza(areaDeConstruccion, this);
        turnoJugado = true;

        return estadoActual.obtenerEdificioObjetivo();
	}
	
	public Edificio crearCuartel(Area areaDeConstruccion) {
        siYaJugoElTurnoError();

        if(distanciaMinimaA(areaDeConstruccion) > DISTANCIA_ATK)
            throw new NoSePuedeConstruirTanLejosError();

        estadoActual = estadoActual.construirCuartel(areaDeConstruccion, this);
        turnoJugado = true;

        return estadoActual.obtenerEdificioObjetivo();
	}

	public void realizarTrabajoDeTurno() {

		estadoActual = estadoActual.realizarTrabajoDeTurno();
		turnoJugado = true;
	}

	public int generarOro(){

	    return (estadoActual.generarOro());
    }
	
	@Override
	public void nuevoTurno() {

		realizarTrabajoDeTurno();
		super.nuevoTurno();
	}
	
}
