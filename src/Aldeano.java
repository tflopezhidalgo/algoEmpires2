public class Aldeano extends Unidad {
	
	private Edificio edificioObjectivo;
	
	Aldeano(Casilla unaCasilla) throws ErrorBasico  {
		super(unaCasilla);
		edificioObjectivo = null;
		vida = 50;
		costo = 25;
	}

	public void reparar(Edificio unEdificio) throws ErrorBasico {
		siEstaOcupadoDaError();
		siYaJugoElTurnoError();
		enRango(unEdificio,1);
		
		if(unEdificio.necesitaReparacion()) {
			ocupado = true;
			turnoJugado = true;
			unEdificio.reparar();
			edificioObjectivo = unEdificio;
		}
	}
	
	private int generarOro() throws ErrorBasico {	//hago una funcion o multiplico por cantidad de aldeanos libres?
		siYaJugoElTurnoError();
		
		if(!ocupado) {
			turnoJugado = true;
			return 25;
		}
		else {
			return 0;
		}
	}
	
	public boolean estaOcupado() {
		return ocupado;
	}
	
	public Plaza crearPlaza(Area areaDeConstruccion) throws ErrorBasico {
		siEstaOcupadoDaError();
		siYaJugoElTurnoError();
		
		//TODO no lo puedo declarar 1 vez por turno tengo  que 
		//guardarlo en algun lado y seguir el trabajo despues
		if(areaDeConstruccion.estaLibre()) {
			ocupado = true;
			turnoJugado = true;
			Plaza nuevaPlaza = new Plaza(areaDeConstruccion);
			edificioObjectivo = nuevaPlaza;
			edificioObjectivo.construir();
			return nuevaPlaza;
		}
		else {
			throw new ErrorBasico("ERROR: Zona de construccion ocupada.");
		}
	}
	
	public Cuartel crearCuartel(Area areaDeConstruccion) throws ErrorBasico {
		siEstaOcupadoDaError();
		siYaJugoElTurnoError();
		
		//TODO no lo puedo declarar 1 vez por turno tengo  que 
		//guardarlo en algun lado y seguir el trabajo despues
		if(areaDeConstruccion.estaLibre()) {
			ocupado = true;
			turnoJugado = true;
			Cuartel nuevoCuartel = new Cuartel(areaDeConstruccion);
			edificioObjectivo = nuevoCuartel;
			edificioObjectivo.construir();

			return nuevoCuartel;
		}
		else {
			throw new ErrorBasico("ERROR: Zona de construccion ocupada.");
		}
	}
	
	
	public int realizarTrabajoDeTurno() throws ErrorBasico {
		siYaJugoElTurnoError();
		
		//el aldeano :
		// Genera oro, contruye o repara
		//TODO quedo un switch de mierda, ver si se puede cambiar
		if(edificioObjectivo != null) {
			if(edificioObjectivo.enConstruccion() | edificioObjectivo.necesitaReparacion()) {
				edificioObjectivo.construir();
				edificioObjectivo.reparar();
				turnoJugado = true;
				return 0;
			}
			else {
				ocupado = false;
				edificioObjectivo = null;
				return generarOro();
			}
		}
		else {
			return generarOro();
		}
	}	
	
}

