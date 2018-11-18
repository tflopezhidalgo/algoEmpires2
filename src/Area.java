import java.util.List;

public class Area {

	private List<Casilla> casillasDelArea;
	
	Area(List<Casilla> casillas){

		casillasDelArea = casillas;
	}
	
	public int obtenerCantidadDeCasillas(){

		return casillasDelArea.size();
	}
	
	public List<Casilla> obtenerCasillas() {

	    return casillasDelArea;
	}
	
	public void liberarCasillas() {

		for (int i = 0; i < casillasDelArea.size(); i++)
			casillasDelArea.get(i).liberar();
	}
	
	public void ocuparConPieza(Pieza unaPieza) throws Excepcion {

		for (int i = 0; i < casillasDelArea.size(); i++)
			casillasDelArea.get(i).colocar(unaPieza);
	}
	
	public boolean estaLibre() {
		
		for (int i = 0; i < casillasDelArea.size(); i++)
			if ( casillasDelArea.get(i).estaOcupada() )
				return false;
		
		return true;
	}
	
	public void agregarCasilla(Casilla unaCasilla) throws Excepcion {
		if(unaCasilla == null)
			throw new Excepcion("ERROR: Casilla inexistente.");

		casillasDelArea.add(unaCasilla);
	}

	//TODO: Refactoring .
	public int distanciaMinimaA(Casilla unaCasilla) {
		int minimaDistancia = Integer.MAX_VALUE;
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

	//TODO: Refactoring.
	private int distanciaEntre(Casilla casillaA, Casilla casillaB) {

		return casillaA.calcularDistanciaA(casillaB);
	}
	
}
