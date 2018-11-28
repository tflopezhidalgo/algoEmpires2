package vista;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuVista extends Pane {

    public MenuVista(Scene escenaSiguiente,Stage stagePrincipal){
    	//--------------- Imagen de fondo -----------------------
        Image background = new Image("Imagenes\\ElementosMenu\\fiubamenu.JPG");
        ImageView backgroundVista = new ImageView(background);
        setPrefSize(background.getWidth(),background.getHeight());
        //--------------- Setup Botones -------------------------
        Image botonComenzar = new Image("Imagenes\\ElementosMenu\\botoncomenzar.png");
        BotonPersonalizado elBotonComenzar = new BotonPersonalizado(botonComenzar);
        elBotonComenzar.relocate(getPrefWidth()/2 - elBotonComenzar.getPrefWidth()/2,getPrefHeight()/2 - elBotonComenzar.getPrefHeight()/2 );
        elBotonComenzar.setOnMousePressed(event -> stagePrincipal.setScene(escenaSiguiente));

        Image botonSalir = new Image("Imagenes\\ElementosMenu\\botonsalir.png");
        BotonPersonalizado elBotonSalir = new BotonPersonalizado(botonSalir);
        elBotonComenzar.setTranslateY(-(elBotonComenzar.getPrefHeight() + 20));
        elBotonSalir.relocate(getPrefWidth()/2 - elBotonSalir.getPrefWidth()/2,getPrefHeight()/2 + elBotonSalir.getPrefHeight());
        elBotonSalir.setOnMousePressed(event ->  stagePrincipal.close());
    	
        getChildren().addAll(backgroundVista, elBotonComenzar, elBotonSalir);
    }

}
