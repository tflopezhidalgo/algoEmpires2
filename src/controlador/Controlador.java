package controlador;

import modelo.Juego;
import vista.VistaPrincipal;

public class Controlador {

    private VistaPrincipal vista;
    private Juego modelo;

    public void setJuego(Juego unJuego){

        this.modelo = unJuego;
    }

    public void setVista(VistaPrincipal unaVista){

        this.vista = unaVista;
    }


}
