import java.util.List;

public class Area {

	private List<Casilla> casillasDelArea;
	
	Area(List<Casilla> casillas){
		casillasDelArea = casillas;
	}
	
	public int obtenerTamanio(){
		return casillasDelArea.size();
	}
	
	public List<Casilla> obtenerCasillas() {
		return casillasDelArea;
	}
	
	public void liberar() {
		for (int i = 0; i < casillasDelArea.size(); i++) {
			casillasDelArea.get(i).liberar();
		}
	}
	
	public void contruir(Edificio unEdificio) {
		for (int i = 0; i < casillasDelArea.size(); i++) {
			casillasDelArea.get(i).colocar(unEdificio);
		}
	}
	
	public boolean estaLibre() {
		boolean estaOcupada = false;
		
		for (int i = 0; i < casillasDelArea.size(); i++) {
			estaOcupada = casillasDelArea.get(i).estaOcupada();
			if (estaOcupada) {
				return false;
			}
		}
		
		return true;
	}
	
	public void agregarCasilla(Casilla unaCasilla) {
		casillasDelArea.add(unaCasilla);
	}
	
}
