package vista.estadoArmaDeAsedioVista;

import javafx.scene.image.ImageView;

public class CatapultaVistaDesarmada extends EstadoCatapultaVista {
	
	public CatapultaVistaDesarmada() {
		System.out.println("construyendo...");
	}

	public void atacar() {
		
	}

	public void mover() {
		
	}

	public EstadoCatapultaVista cambiarEstado(ImageView viewMover, ImageView viewAtaque) {
		viewAtaque.setVisible(true);
		viewMover.setVisible(false);
        return (new CatapultaVistaArmada());
	}

}
