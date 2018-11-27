package vista.estadoArmaDeAsedioVista;

import javafx.scene.image.ImageView;

public abstract class EstadoCatapultaVista {
	
	//TODO lo podemos accionar infinitas veces por turno? (depende del modelo)
	public abstract EstadoCatapultaVista cambiarEstado(ImageView viewMover, ImageView viewAtaque);
	
	public abstract void atacar();
	
	public abstract void mover();
}
