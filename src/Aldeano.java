public class Aldeano {

    private Posicion posicionAldeano;
    private int vida;

    public Aldeano(){

        this.posicionAldeano = new Posicion();
        this.vida = 50;
    }

    public Aldeano(Posicion nuevaPosicion){

        this.posicionAldeano = nuevaPosicion;
    }

    public Posicion obtenerPosicion(){ return posicionAldeano; }

    public void moverArriba(){ this.posicionAldeano.incrementarY(); }

    public void moverDerecha(){ this.posicionAldeano.incrementarX(); }

    public void moverAbajo(){ this.posicionAldeano.decrementarY(); }

    public void moverIzquierda() { this.posicionAldeano.decrementarX(); }

    public void moverArribaDerecha(){

        this.moverArriba();
        this.moverDerecha();
    }

    public void moverArribaIzquierda(){

        this.moverArriba();
        this.moverIzquierda();
    }

    public void moverAbajoIzquierda(){

        this.moverAbajo();
        this.moverIzquierda();
    }

    public void moverAbajoDerecha(){

        this.moverAbajo();
        this.moverDerecha();
    }
}
