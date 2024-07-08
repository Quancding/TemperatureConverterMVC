package TemperatureConverter;

import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TemperatureConverter.observer.Subcriber;

public class ConverterView extends JFrame implements Subcriber {
    
    private String title;
    private JPanel jPanel;
    private JLabel jLabelCelsius, jLabelFahrenheit;
    private JTextField jTextFieldCelsius, jTextFieldFahrenheit;
    private JMenuBar menuBarRemote = null;
    private ConverterModel converterModelRemote;
    private ConverterController converterControllerRemote;

    public ConverterModel getConverterModelRemote() {
        return converterModelRemote;
    }
    public JTextField getjTextFieldCelsius() {
        return jTextFieldCelsius;
    }

    public JTextField getjTextFieldFahrenheit() {
        return jTextFieldFahrenheit;
    }

    ConverterView(){
        converterModelRemote = new ConverterModel();
        converterControllerRemote = new ConverterController(this);

        converterModelRemote.subcribe(this);

        buildMenu();
        buildPanel();
        add(jPanel);
        title = "Converter Temperature";
        setTitle(title);
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void buildPanel(){
        
        jPanel = new JPanel();
        jLabelCelsius = new JLabel("Celsius");
        jTextFieldCelsius = new JTextField(10);
        jLabelFahrenheit = new JLabel("Fahrenheit");
        jTextFieldFahrenheit = new JTextField(10);
        

        jPanel.add(jLabelCelsius);
        jPanel.add(jTextFieldCelsius);
        jPanel.add(jLabelFahrenheit);
        jPanel.add(jTextFieldFahrenheit);

    }

    public void buildMenu(){
        menuBarRemote = new JMenuBar();
        setJMenuBar(menuBarRemote);

        JMenu convertMenuRemote = new JMenu("Convert");
        menuBarRemote.add(convertMenuRemote);

        JMenuItem c2fJMenuItemRemote = new JMenuItem("C2F");
        c2fJMenuItemRemote.addActionListener(converterControllerRemote);

        JMenuItem f2cJMenuItemRemote = new JMenuItem("F2C");
        f2cJMenuItemRemote.addActionListener(converterControllerRemote);

        JMenuItem exitMenuItemRemote = new JMenuItem("Exit");
        exitMenuItemRemote.addActionListener(converterControllerRemote);

        convertMenuRemote.add(c2fJMenuItemRemote);
        convertMenuRemote.add(f2cJMenuItemRemote);
        convertMenuRemote.add(exitMenuItemRemote);
    }
    @Override
    public void updateCelsius() {
        double Celsius = converterModelRemote.getCelsius();
        jTextFieldFahrenheit.setText(Celsius + "");
    }

    @Override
    public void updateFahrenheit() {
        double Fahrenheit = converterModelRemote.getFahrenheit();
        jTextFieldCelsius.setText(Fahrenheit + "");
    }
}
