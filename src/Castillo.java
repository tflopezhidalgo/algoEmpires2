import java.util.List;

public class Castillo extends Edificio {
	
	static final int TAMANIO_LADO = 4;
	
	Castillo(Area areaAOcupar) throws ErrorBasico {
		vida = 1000;
		vidaMaxima = vida;
		costo = 0;
		tiempoDeConstruccion = 0;
		cantidadDeCuracion = 15;
		
		casillasOcupadas = areaAOcupar;
		areaAOcupar.construir(this);
	}

	public void atacar(Edificio edificioEnemigo) throws ErrorBasico {
		enRangoDeAtaque(edificioEnemigo);
		edificioEnemigo.recibirDanio(20);
		
		if(edificioEnemigo.estaDestruida()) {
			edificioEnemigo = null;
		}
	}
	
	public void atacar(Unidad unidadEnemiga) throws ErrorBasico {
		enRangoDeAtaque(unidadEnemiga);
		unidadEnemiga.recibirDanio(20);
		
		if(unidadEnemiga.estaDestruida()) {
			unidadEnemiga = null;
		}
	}
	
	public ArmaDeAsedio crearCatapulta(Casilla ubicacion)  throws ErrorBasico {
		ArmaDeAsedio unaArmaDeAsedio = new ArmaDeAsedio(ubicacion);
		return unaArmaDeAsedio;
	}
	
	//-------------PRIVADOS----------
	
	private void enRangoDeAtaque(Unidad unidadEnemiga) throws ErrorBasico {
		int distancia = areaOcupada().distanciaMinimaA(unidadEnemiga.obtenerUbicacion());

		if(distancia > 3) {
			throw new ErrorBasico("ERROR: Objetivo fuera de area de ataque.");
		}
	}
	
	private void enRangoDeAtaque(Edificio edificioEnemigo) throws ErrorBasico {
		Area areaEnemiga = edificioEnemigo.areaOcupada();
		int distanciaMinima = distanciaMinimaA(areaEnemiga);

		if(distanciaMinima > 3) {
			throw new ErrorBasico("ERROR: Objetivo fuera de area de ataque.");
		}
	}
	
	private int distanciaMinimaA(Area areaEnemiga){
		int minimaDistancia = Integer.MAX_VALUE; // TODO ver si hay una mejor manera de arreglar esto
		int distanciaNueva;
		List<Casilla> casillasEnemigas = areaEnemiga.obtenerCasillas();
		for (int i = 0; i < areaEnemiga.obtenerTamanio(); i++) {
			
			Casilla casillaActual = casillasEnemigas.get(i);
			
			distanciaNueva = areaOcupada().distanciaMinimaA(casillaActual);
			if(distanciaNueva < minimaDistancia) {
				minimaDistancia = distanciaNueva;
			}
		}
		
		return minimaDistancia;
	}

}
