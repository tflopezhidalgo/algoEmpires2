package vista;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class BotonPersonalizado extends StackPane {

    public BotonPersonalizado(ImageView unaImagen) {

        getChildren().add(unaImagen);

    }

}
