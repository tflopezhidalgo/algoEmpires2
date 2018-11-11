
public class Catapulta extends Unidad{
	
	Catapulta(Casilla unaCasilla){
		super(unaCasilla);
		vida = 150;
		costo = 200;
	}
	
	//estado de accionado (se puede mover/atacar)
	
	//distancia de ataque = 5
	
	public int atacar(Pieza piezaEnemiga) {
		if(piezaEnemiga instanceof Edificio) {
			return atacarEdificio();
		}
		return 0; //TODO tirar error/no permitir ataque
	}
	
	public int atacarEdificio() {
		return 75;
	}
	
}