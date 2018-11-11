
public class Castillo extends Edificio implements Atacante{
	
	static final int TAMANIO_LADO = 4;
	
	Castillo(Area areaAOcupar){
		vida = 1000;
		vidaMaxima = vida;
		costo = 0;
		tiempoDeConstruccion = 0;
		cantidadDeCuracion = 15;
		
		casillasOcupadas = areaAOcupar;
		areaAOcupar.contruir(this);
	}

	public int atacar(Pieza unaPieza) {
		return 20;
	}
	
	public Catapulta crearCatapulta(Casilla ubicacion) {
		Catapulta unaCatapulta = new Catapulta(ubicacion);
		return unaCatapulta;
	}

}
