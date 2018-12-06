package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.excepciones.CasillaInvalidaError;
import modelo.excepciones.JugadorSinCastilloError;
import modelo.excepciones.PoblacionLimiteSuperadaError;

public class Jugador {

    static final int POBLACION_MAX = 50;

    //------------------------------------------
    private Castillo elCastillo;
    private List<Aldeano> losAldeanos = new ArrayList<>();
    private List<Edificio> losEdificios = new ArrayList<>();
    private List<Unidad> losSoldados = new ArrayList<>();
    //------------------------------------------
    private String nombreJugador;
    private int cantidadDeOro;
    private int poblacion;

    /*          Constructor         */

    public Jugador(){

        this.nombreJugador = " ";
        this.cantidadDeOro = 0;
        this.poblacion = 0;
        this.elCastillo = null;
    }

    public Jugador(String unNombre){

    	this.nombreJugador = unNombre;
    	this.cantidadDeOro = 100;
    	this.poblacion = 0;
    	this.elCastillo = null;
    }

    private void finalizarTurnoDePiezas() {
        for(int i = 0; i < losAldeanos.size(); i++) {
            Aldeano aldeanoActual = losAldeanos.get(i);
            cantidadDeOro += aldeanoActual.generarOro();
            aldeanoActual.nuevoTurno();
        }
        
        for(int i = 0; i < losEdificios.size(); i++) {
            Edificio edificioActual = losEdificios.get(i);
            edificioActual.nuevoTurno();
        }
        
        for(int i = 0; i < losSoldados.size(); i++) {
            Unidad soldadoActual = losSoldados.get(i);
            soldadoActual.nuevoTurno();
        }

        elCastillo.nuevoTurno();
    }
    
    public int hpCastillo() {

        return elCastillo.getVidaActual();
    }
    
    public int cantidadSoldados() {
    	return losSoldados.size();
    }
    
    public int cantidadAldeanos() {
    	return losAldeanos.size();
    }
    
    public int cantidadEdificios() {
    	return losEdificios.size();
    }

    public int getPoblacion(){
        return this.poblacion;
    }

    public void finalizarTurno(){

        finalizarTurnoDePiezas();
    }
    
    public String obtenerNombre() {
    	return nombreJugador;
    }

    public int obtenerOro(){
        return this.cantidadDeOro;
    }

	public void setListener(Juego unJuego){
        if(elCastillo == null)
            throw new JugadorSinCastilloError();

	    elCastillo.setCastilloListener(unJuego);    
	}

    public void cobrar(int monto) {
    	if(this.cantidadDeOro < monto) {
    		throw new CasillaInvalidaError();
    	}
    	
    	cantidadDeOro -= monto;
    }
    
    public List<Pieza> getPiezas(){

        List<Pieza> piezasTotales = new ArrayList<>();

        piezasTotales.addAll(this.losAldeanos);
        piezasTotales.addAll(this.losEdificios);
        piezasTotales.addAll(this.losSoldados);

        return piezasTotales;
    }
	//----------------------------------------------------------------------------
	//---------------------      Manejo de Piezas     ----------------------------
    
    public void agregar(Castillo unCastillo) {
    	//borra el castillo anterior si habia y asigna el nuevo
    	if(elCastillo != null) {
    		elCastillo.recibirDanio(1000);
    	}
    	elCastillo = unCastillo;
    }
    
    public void agregar(Unidad soldado) {
		if(soldado instanceof Aldeano) {
			agregar((Aldeano) soldado);
			actualizarPoblacion();
		}
		else {
	    	int poblacionLibre = POBLACION_MAX - poblacion;
	    	
	    	if(poblacionLibre < 1) {
	            throw new PoblacionLimiteSuperadaError();
	    	}
	    	
			losSoldados.add(soldado);
			actualizarPoblacion();
		}
    }
    
    public void agregar(Edificio edificio) {

        losEdificios.add(edificio);
    }

    public void agregar(Aldeano aldeano){
    	int poblacionLibre = POBLACION_MAX - poblacion;
    	
    	if(poblacionLibre < 1) {
            throw new PoblacionLimiteSuperadaError();
    	}
    	
		losAldeanos.add(aldeano);
		actualizarPoblacion();
    }
    
    public void remover(Aldeano aldeano){

		losAldeanos.remove(aldeano);
		actualizarPoblacion();
    }

    public void remover(Edificio edificio){

		losEdificios.remove(edificio);
    }
    
    public void remover(Unidad soldado){

    	if(soldado instanceof Aldeano) {
            remover((Aldeano) soldado);
        }
    	else {
    		losSoldados.remove(soldado);
    		actualizarPoblacion();
    	}
    }
    
	public boolean contieneA(Pieza unaPieza) {
		boolean laContiene, a, b, c, d;
		
		a = losSoldados.contains(unaPieza);
		b = losEdificios.contains(unaPieza);
		c = losAldeanos.contains(unaPieza);
		d = elCastillo.equals(unaPieza);
		
		laContiene = (a | b | c | d);
		
    	System.out.println(nombreJugador + " contiene a la pieza: " + laContiene); //TODO BORRAR
		return laContiene;
	}

	//---------------------      Fin Manejo de Piezas     ------------------------
	//----------------------------------------------------------------------------
      
    private void actualizarPoblacion(){

    	poblacion = losSoldados.size();
    	poblacion += losAldeanos.size();
    }

    public boolean tieneCastilloDestruido(){

        return (this.elCastillo.getVidaActual() <= 0);
    }

}
