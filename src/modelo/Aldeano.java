package modelo;

import modelo.estadoAldeano.AldeanoLibre;
import modelo.estadoAldeano.EstadoAldeano;
import modelo.excepciones.NoSePuedeConstruirTanLejosError;

public class Aldeano extends Unidad {

	private EstadoAldeano estadoActual;
	
	public Aldeano(int x0, int y0){
		super();
		
		this.COSTO = 25;
		this.VIDA_MAX = 50;
		vida = VIDA_MAX;
		this.DANIO_EDIFICIOS = 0;
		this.DANIO_UNIDADES = 0;
		this.DISTANCIA_ATK = 1;

		estadoActual = new AldeanoLibre();
		
		espacioOcupado = Tablero.INSTANCIA.definirArea(x0, y0, x0, y0);
		espacioOcupado.ocupar();
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

	public Edificio crearPlaza(int x0, int y0) {
		siYaJugoElTurnoError();

		//TODO TEMPORAL hay que modificarlo (si no se entiende preguntale a ivo)
        if(!enDistanciaDeConstruccion(x0, y0))
            throw new NoSePuedeConstruirTanLejosError();

        estadoActual = estadoActual.construirPlaza(x0, y0, this);
        turnoJugado = true;

        return estadoActual.obtenerEdificioObjetivo();
	}
	
	public Edificio crearCuartel(int x0, int y0) {
        siYaJugoElTurnoError();

		//TODO TEMPORAL hay que modificarlo (si no se entiende preguntale a ivo)
		if(!enDistanciaDeConstruccion(x0, y0))
			throw new NoSePuedeConstruirTanLejosError();
		
		estadoActual = estadoActual.construirCuartel(x0, y0, this);
		turnoJugado = true;
		
		return estadoActual.obtenerEdificioObjetivo();
	}
	
	//TODO TEMPORAL despues porfa borrame (si no se entiende preguntale a ivo)
	private boolean enDistanciaDeConstruccion(int x0, int y0) {
		int x1 =  this.espacioOcupado.x0();
		int y1 =  this.espacioOcupado.y0();
		
		int difX = x1 - x0;
		int difY = y1 - y0;
		//TODO MATAME PLIZ ESTOY ULTRA HARDCOEADO
		boolean enRango = ( ((difX == 2)&(difY>=-1 & difY<=2))|((difX == -1)&(difY>=-1 & difY<=2))|
							((difY == 2)&(difX>=-1 & difX<=2))|((difY == -1)&(difX>=-1 & difX<=2)));
		return enRango;
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
