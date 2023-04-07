package proyecto.gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Controlador implements ActionListener, WindowListener, EventListener {
    private Vista vista;
    private Modelo modelo;

    private final List<Object> crucesMonedas = new ArrayList<>(Arrays.asList("De Soles a Dólares","De Dólares a Soles",
            "De Soles a Euros","De Euros a Soles","De Soles a Libras","De Libras a Soles","De Soles a Yenes","De Yenes a Soles",
            "De Soles a Dólares Canadienses","De Dólares Canadienses a Soles","De Soles a Pesos Chilenos","De Pesos Chilenos a Soles"));
    private final List<Object> crucesMedidas = new ArrayList<>(Arrays.asList("De Celcius a Kelvin","De Celcius a Fahrenheit",
            "De Kelvin a Celcius","De Kelvin a Fahrenheit","De Fahrenheit a Celcius","De Fahrenheit a Kelvin"));

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;

        anadirWindowListeners(this);
    }


    public void convertir(){
        if (vista.jComboBoxTConversor.getSelectedItem().equals("Conversor de moneda")){
            String resultadoMoneda = modelo.ConvertirMoneda((String) vista.jComboBoxOpciones.getSelectedItem(),vista.jTextFieldCantidad.getText());
            vista.jTextFieldResultado.setText(resultadoMoneda);
        } else {
            String resultadoTemperatura = modelo.ConvertirTemperatura((String) vista.jComboBoxOpciones.getSelectedItem(),Double.parseDouble(vista.jTextFieldCantidad.getText()));
            vista.jTextFieldResultado.setText(resultadoTemperatura);
        }
    }
    public void listenersPersonalizados(){
        vista.jComboBoxTConversor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jComboBoxConversorPerformed(e);
            }
        });

        vista.jComboBoxTConversor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1){
                    vista.jComboBoxTConversor.setModel(new DefaultComboBoxModel<>(new Object[]{"Conversor de moneda", "Conversor de temperatura"}));
                    vista.jComboBoxTConversor.setPopupVisible(true);
                }
            }
        });

        vista.jTextFieldCantidad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    boolean validacion = vista.jTextFieldCantidad.getText().matches("^[0-9]+([.])?([0-9]+)?$");
                    if (validacion){
                        convertir();
                    }else{
                        JOptionPane.showMessageDialog(vista.jFrameVentana,"Solo se permite números");
                    }
                }
            }
        });
    }

    private void jComboBoxConversorPerformed(ActionEvent e) {
        vista.jComboBoxOpciones.removeAllItems();

        if (vista.jComboBoxTConversor.getSelectedItem().equals("Conversor de moneda")){
            for (Object cruceMoneda : crucesMonedas){
                vista.jComboBoxOpciones.addItem(cruceMoneda);
            }
        }else{
            for (Object cruceMedida : crucesMedidas){
                vista.jComboBoxOpciones.addItem(cruceMedida);
            }
        }
    }

    private void anadirWindowListeners(WindowListener listener){
        vista.jFrameVentana.addWindowListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {
        listenersPersonalizados();

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
