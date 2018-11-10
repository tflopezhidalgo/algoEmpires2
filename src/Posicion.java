
public class Posicion {
	
    private int posicionX;

    private int posicionY;
    
    public Posicion(){

        this.posicionX = 0;
        this.posicionY = 0;
    }
	
	Posicion(int x, int y){
		posicionX = x;
		posicionY = y;
	}
	
	public double ejeX() {
		return posicionX;
	}
	
	public double ejeY() {
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