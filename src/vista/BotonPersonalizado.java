package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class BotonPersonalizado extends StackPane {

    public BotonPersonalizado(Image unaImagen) {

        ImageView botonVista = new ImageView(unaImagen);

        setPrefSize(unaImagen.getWidth(),unaImagen.getHeight());

        getChildren().add(botonVista);

    }

}
