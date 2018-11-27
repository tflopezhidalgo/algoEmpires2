package vista.estadoArmaDeAsedioVista;

import javafx.scene.image.ImageView;

public class CatapultaVistaArmada extends EstadoCatapultaVista {

	public void atacar() {
		// TODO Auto-generated method stub
	}

	public void mover() {
        //throw new CatapultaArmadaNoPuedeMoverseError();
	}

	public EstadoCatapultaVista cambiarEstado(ImageView viewMover, ImageView viewAtaque) {
		viewAtaque.setVisible(false);
		viewMover.setVisible(true);
        return (new CatapultaVistaDesarmada());
	}

}
