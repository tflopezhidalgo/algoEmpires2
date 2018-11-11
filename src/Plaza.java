public class Plaza extends Edificio {
	
	static final int TAMANIO_LADO = 2;
	
	Plaza(Area areaAOcupar){
		vida = 450;
		vidaMaxima = vida;
		costo = 100;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 25;
		
		casillasOcupadas = areaAOcupar;
		areaAOcupar.contruir(this);
	}
	
	public Aldeano crearAldeano(Casilla ubicacion) {
		Aldeano unAldeano = new Aldeano(ubicacion);
		return unAldeano;
	}

	
}