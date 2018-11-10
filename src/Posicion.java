
public class Posicion {
	
    private int posicionX;

    private int posicionY;
    
    public Posicion(){

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

    public void incrementarX(){ 
    	posicionX++; 
    }

    public void incrementarY(){ 
    	posicionY++;
    }

    public void decrementarX(){ 
    	posicionX--;
    }

    public void decrementarY(){ 
    	posicionY--; 
    }

}
