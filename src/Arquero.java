
public class Arquero extends Unidad implements Atacante{
	
	Arquero(Casilla unaCasilla){
		super(unaCasilla);
		vida = 75;
		costo = 75;
	}
	
	//distancia de ataque = 3
	
	public int atacar(Pieza unaPieza) {
		if(unaPieza instanceof Edificio) {
			return atacarEdificio();
		}
		return atacarUnidad();
	}
	
	private int atacarUnidad() {
		return 15;
	}
	
	private int atacarEdificio() {
		return 10;
	}
	
}