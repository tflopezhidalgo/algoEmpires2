public class Posicion {
	
    private int posicionX;
    private int posicionY;
    
    Posicion(){

        posicionX = 0;
        posicionY = 0;
    }
	
	Posicion(int x, int y){

		posicionX = x;
		posicionY = y;
	}
	
	public int ejeX() {
		return posicionX;
	}
	
	public int ejeY() {
		return posicionY;
	}
	
    public String aString() {
    	return ( Integer.toString(posicionX) + "I" + Integer.toString(posicionY));
    }
    
    //USO APTO PARA TODOS    
    static public String aString(int x , int y) {
    	return ( Integer.toString(x) + "I" + Integer.toString(y));
    }
    
    static public int calcularDistancia(Posicion posicionA, Posicion posicionB) {
    	
		int xFinal = posicionA.ejeX();
		int yFinal = posicionA.ejeY();
		int xInicial = posicionB.ejeX();
		int yInicial = posicionB.ejeY();
		
		int diferenciaX = Math.abs(xFinal - xInicial);
		int diferenciaY = Math.abs(yFinal - yInicial);
		
		if(diferenciaX < diferenciaY) {
			return diferenciaY;
		}
		return diferenciaX;

    }
}