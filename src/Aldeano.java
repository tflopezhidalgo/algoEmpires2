public class Aldeano extends Unidad {

    /*      -Aldeano-
     *
     *       Vida: 50
     *       Costo: 25
     */

	private Edificio edificioObjetivo;


	Aldeano(Area unArea) throws Excepcion{
		super(unArea);
		edificioObjetivo = null;
		vida = 50;
		costo = 25;
	}

	public void reparar(Edificio unEdificio) throws Excepcion {
		siEstaOcupadoDaError();
		siYaJugoElTurnoError();
		enRango(unEdificio,1);
		
		if(unEdificio.necesitaReparacion()) {
			ocupado = true;
			jugoEnTurno = true;
			unEdificio.reparar();
			edificioObjetivo = unEdificio;
		}
	}
	
	private int generarOro() throws Excepcion {	//hago una funcion o multiplico por cantidad de aldeanos libres?
		siYaJugoElTurnoError();
		
		if(!ocupado) {
			jugoEnTurno = true;
			return 25;
		}
		else {
			return 0;
		}
	}
	
	public boolean estaOcupado() {
		return ocupado;
	}
	
	public Plaza crearPlaza(Area areaDeConstruccion) throws Excepcion {
		siEstaOcupadoDaError();
		siYaJugoElTurnoError();
		
		//TODO no lo puedo declarar 1 vez por turno tengo  que 
		//guardarlo en algun lado y seguir el trabajo despues
		if(areaDeConstruccion.estaLibre()) {
			ocupado = true;
			jugoEnTurno = true;
			Plaza nuevaPlaza = new Plaza(areaDeConstruccion);
			edificioObjetivo = nuevaPlaza;
			edificioObjetivo.construir();
			return nuevaPlaza;
		}
		else {
			throw new Excepcion("ERROR: Zona de construccion ocupada.");
		}
	}
	
	public Cuartel crearCuartel(Area areaDeConstruccion) throws Excepcion {
		siEstaOcupadoDaError();
		siYaJugoElTurnoError();
		
		//TODO no lo puedo declarar 1 vez por turno tengo  que 
		//guardarlo en algun lado y seguir el trabajo despues
		if(areaDeConstruccion.estaLibre()) {
			ocupado = true;
			jugoEnTurno = true;
			Cuartel nuevoCuartel = new Cuartel(areaDeConstruccion);
			edificioObjetivo = nuevoCuartel;
			edificioObjetivo.construir();

			return nuevoCuartel;
		}
		else {
			throw new Excepcion("ERROR: Zona de construccion ocupada.");
		}
	}

	public int realizarTrabajoDeTurno() throws Excepcion {
		siYaJugoElTurnoError();
		
		//el aldeano :
		// Genera oro, contruye o repara
		//TODO quedo un switch de mierda, ver si se puede cambiar
		if(edificioObjetivo != null) {
			if(edificioObjetivo.enConstruccion() | edificioObjetivo.necesitaReparacion()) {
				edificioObjetivo.construir();
				edificioObjetivo.reparar();
				jugoEnTurno = true;
				return 0;
			}
			else {
				ocupado = false;
				edificioObjetivo = null;
				return generarOro();
			}
		}
		else {
			return generarOro();
		}
	}	
	
}

