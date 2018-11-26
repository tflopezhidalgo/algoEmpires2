package vista;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.EventListener;

import static javafx.scene.layout.StackPane.setAlignment;

public class MenuVista extends Pane {


    public MenuVista(){


        Image unaImagen = new Image("builingsTemp\\fiubamenu.JPG");
        ImageView unaVista = new ImageView(unaImagen);

        setPrefSize(unaImagen.getWidth(),unaImagen.getHeight());

        getChildren().addAll(unaVista);

        /*
        StackPane panel = new StackPane();
        panel.setPrefSize(200,30);
        Image botonComenzar = new Image("builingsTemp\\botoncomenzar.png");
        ImageView botonVista = new ImageView(botonComenzar);
        panel.getChildren().add(botonVista);
        panel.relocate(unaImagen.getWidth()/2 - botonComenzar.getWidth()/2,unaImagen.getHeight()/2 - botonComenzar.getHeight()/2 );


        Label labelIniciar = new Label("Comenzar");
        Rectangle seleccion = new Rectangle(200, 30);
        seleccion.setFill(Color.TRANSPARENT);
        seleccion.setStroke(Color.rgb(250, 150, 150, .30));
        seleccion.setStrokeWidth(200 * 0.025);
        seleccion.setVisible(true);
        panel.getChildren().addAll(seleccion,labelIniciar);

        getChildren().add(panel);
        */



    }

}
