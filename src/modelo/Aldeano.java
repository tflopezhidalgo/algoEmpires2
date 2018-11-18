public class Aldeano extends Unidad {
	
	private Edificio edificioObjetivo;
	private EstadoAldeano estadoActual;
	
	public Aldeano(Area unEspacio) throws ErrorBasico  {
		super(unEspacio);
		estadoActual = new AldeanoLibre();
		edificioObjetivo = null;
		vida = 50;
		costo = 25;
	}

	public void reparar(Edificio unEdificio) throws ErrorBasico {
		siYaJugoElTurnoError();
		
		if(enRango(unEdificio,1) & unEdificio.necesitaReparacion()) {
			estadoActual = estadoActual.reparar(unEdificio);
			if(estadoActual instanceof AldeanoReparando ) {
				edificioObjetivo = unEdificio;
				ocupado = true;
				turnoJugado = true;
			}
		}
	}
	
	public Plaza crearPlaza(Area areaDeConstruccion) throws ErrorBasico {
		siYaJugoElTurnoError();

		if(!ocupado & areaDeConstruccion.estaLibre() & distanciaMinimaA(areaDeConstruccion) == 1) {
			edificioObjetivo = estadoActual.crearPlaza(areaDeConstruccion);
			if(edificioObjetivo != null) {
				ocupado = true;
				turnoJugado = true;
				estadoActual = new AldeanoConstruyendo();
                return (Plaza)edificioObjetivo;
			}
		}
		return null;
	}
	
	public Cuartel crearCuartel(Area areaDeConstruccion) throws ErrorBasico {
		siYaJugoElTurnoError();
		
		if(!ocupado & areaDeConstruccion.estaLibre() & distanciaMinimaA(areaDeConstruccion) == 1) {
			edificioObjetivo = estadoActual.crearCuartel(areaDeConstruccion);
			if(edificioObjetivo != null) {
				ocupado = true;
				turnoJugado = true;
				estadoActual = new AldeanoConstruyendo();
				return (Cuartel)edificioObjetivo;
			}
		}
		return null;
	}
	
	
	public int realizarTrabajoDeTurno() throws ErrorBasico {
		siYaJugoElTurnoError();
		
		estadoActual = estadoActual.realizarTrabajoDeTurno(edificioObjetivo);
		
		if(estadoActual instanceof AldeanoLibre) {
			edificioObjetivo = null;
			ocupado = false;
			return 20;
		}
		turnoJugado = true;
		return 0;
	}	
	
}

