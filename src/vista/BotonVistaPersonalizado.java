package vista;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class BotonVistaPersonalizado extends StackPane {

    public BotonVistaPersonalizado(ImageView unaImagen) {

        getChildren().add(unaImagen);

    }

}
