package modelo.estadoAldeano;

import modelo.*;
import modelo.excepciones.*;

public interface EstadoAldeano {

    EstadoAldeano reparar(Edificio unEdificio) throws Excepcion;
	
    Plaza crearPlaza(Area areaDeConstruccion) throws CasillaOcupadaError;
	
	Cuartel crearCuartel(Area areaDeConstruccion) throws Exception;
	
	EstadoAldeano realizarTrabajoDeTurno(Edificio edificioObjetivo);

}

