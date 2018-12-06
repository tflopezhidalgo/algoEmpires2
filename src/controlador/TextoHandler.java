package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import vista.TextoError;


public class TextoHandler implements EventHandler<MouseEvent> {

    private Text texto;

    public TextoHandler(Text texto){

        this.texto = texto;
    }


    @Override
    public void handle(MouseEvent e){

        texto.setVisible(false);
    }


}
