
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
}
