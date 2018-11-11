public class Cuartel extends Edificio {
	
	static final int TAMANIO_LADO = 2;
	
	Cuartel(Area areaAOcupar){
		vida = 250;
		vidaMaxima = vida;
		costo = 50;
		tiempoDeConstruccion = 3;
		cantidadDeCuracion = 50;
		
		casillasOcupadas = areaAOcupar;
		areaAOcupar.contruir(this);
	}

	public Espadachin crearEspadachin(Casilla ubicacion) {
		Espadachin unEspadachin = new Espadachin(ubicacion);
		return unEspadachin;
	}
	
	public Arquero crearArquero(Casilla ubicacion) {
		Arquero unArquero = new Arquero(ubicacion);
		return unArquero;
	}
	
}
