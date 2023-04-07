package proyecto;

import proyecto.gui.Controlador;
import proyecto.gui.Modelo;
import proyecto.gui.Vista;

import javax.swing.*;

public class Ejecutar {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(vista, modelo);
    }
}
