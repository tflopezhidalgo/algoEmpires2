public class Posicion {

    private int posicionX;

    private int posicionY;


    public Posicion(){

        this.posicionX = 0;
        this.posicionY = 0;
    }

    public Posicion(int posicionX, int posicionY){

        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public void incrementarX(){ this.posicionX++; }

    public void incrementarY(){ this.posicionY++; }

    public void decrementarX(){ this.posicionX--; }

    public void decrementarY(){ this.posicionY--; }

}
