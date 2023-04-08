package proyecto.gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Controlador implements ActionListener, WindowListener, EventListener {
    private final Vista vista;
    private final Modelo modelo;

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
        if (Objects.equals(vista.jComboBoxTConversor.getSelectedItem(), "Conversor de moneda")){
            String resultadoMoneda = modelo.ConvertirMoneda((String) vista.jComboBoxOpciones.getSelectedItem(),vista.jTextFieldCantidad.getText());
            vista.jTextFieldResultado.setText(resultadoMoneda);
        } else {
            String resultadoTemperatura = modelo.ConvertirTemperatura((String) vista.jComboBoxOpciones.getSelectedItem(),Double.parseDouble(vista.jTextFieldCantidad.getText()));
            vista.jTextFieldResultado.setText(resultadoTemperatura);
        }
    }

    public void setearComboBox(){
        vista.jComboBoxTConversor.setModel(new DefaultComboBoxModel<>(new Object[]{"Conversor de moneda", "Conversor de temperatura"}));
        vista.jComboBoxTConversor.setPopupVisible(true);
        vista.jTextFieldCantidad.setText(null);
        vista.jTextFieldResultado.setText(null);
    }

    public void listenersPersonalizados(){

        vista.jComboBoxTConversor.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (e.getID()==1004){
                    setearComboBox();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        vista.jComboBoxTConversor.addActionListener(e -> {

            vista.jComboBoxOpciones.removeAllItems();
            vista.jComboBoxOpciones.setEnabled(true);

            if (Objects.equals(vista.jComboBoxTConversor.getSelectedItem(), "Conversor de moneda")){
                for (Object cruceMoneda : crucesMonedas){
                    vista.jComboBoxOpciones.addItem(cruceMoneda);
                }
            }else{
                for (Object cruceMedida : crucesMedidas){
                    vista.jComboBoxOpciones.addItem(cruceMedida);
                }
            }
        });

        vista.jTextFieldCantidad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    boolean validarConverSelec = vista.jComboBoxTConversor.getSelectedItem() == "Elige un conversor";
                    boolean validacion = vista.jTextFieldCantidad.getText().matches("^[0-9]+([.])?([0-9]+)?$");
                    if (validarConverSelec){
                        JOptionPane.showMessageDialog(vista.jFrameVentana,"Debes seleccionar un conversor");
                    } else if (validacion) {
                        convertir();
                    } else{
                        JOptionPane.showMessageDialog(vista.jFrameVentana,"Solo se permite números");
                        vista.jTextFieldCantidad.setText(null);
                        vista.jTextFieldResultado.setText(null);
                    }
                }
            }
        });
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
