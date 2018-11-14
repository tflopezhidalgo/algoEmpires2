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
	
	public void construir(Edificio unEdificio) throws ErrorBasico {
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
	
	public void agregarCasilla(Casilla unaCasilla) throws ErrorBasico {
		if(unaCasilla == null) {
			throw new ErrorBasico("ERROR: Casilla inexistente.");
		}
		casillasDelArea.add(unaCasilla);
	}
	
	public int distanciaMinimaA(Casilla unaCasilla) {
		int minimaDistancia = Integer.MAX_VALUE; // TODO ver si hay una mejor manera de arreglar esto
		int distanciaNueva;
		for (int i = 0; i < casillasDelArea.size(); i++) {
			Casilla casillaActual = casillasDelArea.get(i);
			
			distanciaNueva = distanciaEntre(casillaActual, unaCasilla);
			if(distanciaNueva < minimaDistancia) {
				minimaDistancia = distanciaNueva;
			}
		}
		return minimaDistancia;
	}
	
	private int distanciaEntre(Casilla casillaA, Casilla casillaB) {
		Posicion posicionA = casillaA.obtenerPosicion();
		Posicion posicionB = casillaB.obtenerPosicion();
		
		int distancia = posicionA.calcularDistanciaA(posicionB);
		return distancia;
	}
	
}
