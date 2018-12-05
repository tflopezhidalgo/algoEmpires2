package vista;

import javafx.geometry.VPos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextoError extends Text {

    public TextoError(String mensaje){

        super(mensaje);
        this.setFill(Color.RED);
        this.setFont(new Font("Arial Black", 30));
        this.setTextOrigin(VPos.CENTER);
        this.relocate(500, 600);
    }

    public void borrar(){

        this.setVisible(false);
    }

}
