package vista;


import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;

public class MapaVista extends AnchorPane {

    final double SCALE_DELTA = 1.1;

	private Group grupoCasillas = new Group();
	private Group grupoPiezas = new Group();
	
	double ultimoX;
	double ultimoY;

    public MapaVista(Group unasCasillas,Group unasPiezas) {
    	grupoCasillas = unasCasillas;
    	grupoPiezas = unasPiezas;
    	getChildren().addAll(grupoCasillas,grupoPiezas);
    	grupoCasillas.setAutoSizeChildren(true);
    	grupoPiezas.setAutoSizeChildren(true);
    	
        setOnScroll(e -> {
            e.consume();
            if (e.getDeltaY() == 0) {
                return;
            }

            double scaleFactor
                    = (e.getDeltaY() > 0)
                            ? SCALE_DELTA
                            : 1 / SCALE_DELTA;

            grupoCasillas.setScaleX(grupoCasillas.getScaleX() * scaleFactor);
            grupoCasillas.setScaleY(grupoCasillas.getScaleY() * scaleFactor);
            grupoPiezas.setScaleX(grupoPiezas.getScaleX() * scaleFactor);
            grupoPiezas.setScaleY(grupoPiezas.getScaleY() * scaleFactor);
        });
        
    	//------------------------------------------------------------------------------------
    	//--------------------- FUNCIONALIDAD ARRASTRAR Y ZOOM ------------------------
    	//------------------------------------------------------------------------------------
        /*setOnMousePressed(e->{
        	ultimoX = e.getSceneX();
        	ultimoY = e.getSceneY();
        });
        
        setOnMouseDragged(e -> {
            setManaged(false);
            setTranslateX(e.getScreenX() - ultimoX);
            setTranslateY(e.getScreenY() - ultimoY);
            e.consume();
        });*/
    	//----------------------------------   FIN    ----------------------------------------
    	//--------------------- FUNCIONALIDAD ARRASTRAR Y ZOOM ------------------------
    	//----------------------------------   FIN    ----------------------------------------

    }

}