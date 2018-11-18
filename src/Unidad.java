public abstract class Unidad extends Pieza {

	protected boolean ocupado;
	
	public Unidad(Area unEspacio) throws Exception  {
		espacioOcupado = unEspacio;
		espacioOcupado.ocupar();
		turnoJugado = false;
		ocupado = false;
	}
	
	public boolean estaOcupado() {
		return ocupado;
	}

	public void mover(Area nuevoEspacio) throws Exception {
        if (!ocupado & nuevoEspacio.estaLibre()) {
            espacioOcupado.liberar();
            espacioOcupado = nuevoEspacio;
            espacioOcupado.ocupar();
        }
	}
	
	protected void siEstaOcupadoDaError() throws Exception {
		if(ocupado) {
			throw new Exception("ERROR: Pieza ocupada");
		}
	}

}
