
public abstract class Pieza{
	
	protected int vida;
	protected int costo;
	
	public void recibirDanio(int danio) {
		vida -= danio;
		if(vida <= 0) {
			//destruir/morir/perder
		}
	}
	
}
