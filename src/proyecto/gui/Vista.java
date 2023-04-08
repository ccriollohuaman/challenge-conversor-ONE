package proyecto.gui;

import javax.swing.*;
import java.awt.*;

public class Vista {

    JFrame jFrameVentana;
    JPanel jPanelSelectores;
    JPanel jPanelDatoRes;
    JLabel jLabelTitulo;
    JComboBox<Object> jComboBoxTConversor;
    JLabel jLabelCantidad;
    JTextField jTextFieldCantidad;
    JComboBox<Object> jComboBoxOpciones;
    JLabel jLabelResultado;
    JTextField jTextFieldResultado;

    public Vista() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        inicializarComponentes();
        estilizarComponentes();
    }

    public void inicializarComponentes() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        jFrameVentana = new JFrame("Conversor - Challenge");
        jPanelSelectores = new JPanel();
        jLabelTitulo = new JLabel();
        jComboBoxTConversor = new JComboBox<>();
        jComboBoxOpciones = new JComboBox<>();
        jPanelDatoRes = new JPanel();
        jLabelCantidad = new JLabel();
        jTextFieldCantidad = new JTextField();
        jLabelResultado = new JLabel();
        jTextFieldResultado = new JTextField();
        jPanelSelectores.add(jLabelTitulo);
        jPanelSelectores.add(jComboBoxTConversor);
        jPanelSelectores.add(jComboBoxOpciones);
        jPanelDatoRes.add(jLabelCantidad);
        jPanelDatoRes.add(jTextFieldCantidad);
        jPanelDatoRes.add(jLabelResultado);
        jPanelDatoRes.add(jTextFieldResultado);
        jFrameVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrameVentana.setVisible(true);
    }

    public void estilizarComponentes() {
        jFrameVentana.setSize(400,225);
        jFrameVentana.setResizable(false);
        jFrameVentana.setLocationRelativeTo(null);
        jFrameVentana.setLayout(new GridLayout(2,1));
        Container contenedorSelectores = jFrameVentana.getContentPane();
        Container contenedorDatoRes = jFrameVentana.getContentPane();
        jPanelSelectores.setLayout(new GridLayout(3,1));
        jPanelDatoRes.setLayout(new GridLayout(2,2));
        jPanelSelectores.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        jPanelDatoRes.setBorder(BorderFactory.createEmptyBorder(5,15,5,15));
        jLabelTitulo.setText("Conversor - Challenge ONE");
        jLabelTitulo.setFont(new Font("Arial", Font.BOLD,15));
        jLabelTitulo.setHorizontalAlignment(JTextField.CENTER);
        jLabelCantidad.setText("Ingrese una cantidad: ");
        jLabelCantidad.setFont(new Font("Arial", Font.BOLD,13));
        jTextFieldCantidad.setHorizontalAlignment(4);
        jLabelResultado.setText("Resultado: ");
        jLabelResultado.setFont(new Font("Arial", Font.BOLD,13));
        jTextFieldResultado.setHorizontalAlignment(4);
        jTextFieldResultado.setEnabled(false);
        jTextFieldResultado.setDisabledTextColor(Color.BLACK);
        jComboBoxTConversor.setModel(new DefaultComboBoxModel<>(new Object[]{"Elige un conversor"}));
        jComboBoxOpciones.setModel(new DefaultComboBoxModel<>(new Object[]{"Opciones disponibles"}));
        jComboBoxOpciones.setEnabled(false);
        contenedorSelectores.add(jPanelSelectores);
        contenedorDatoRes.add(jPanelDatoRes);

    }

}
