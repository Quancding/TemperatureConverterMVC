package TemperatureConverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import TemperatureConverter.command.C2FCommand;
import TemperatureConverter.command.Command;
import TemperatureConverter.command.CommandProcessor;
import TemperatureConverter.command.F2CCommand;
import TemperatureConverter.command.ExitCommand;

public class ConverterController implements ActionListener {
    private ConverterView converterViewRemote;
    private CommandProcessor commandProcessor = null;

    ConverterController(ConverterView converterViewRemote){
        commandProcessor = CommandProcessor.makeCommandProcessor();
        this.converterViewRemote = converterViewRemote;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JTextField jTextFieldCelsius = converterViewRemote.getjTextFieldCelsius();
        JTextField jTextFieldFahrenheit = converterViewRemote.getjTextFieldFahrenheit();
        

        ConverterModel converterModelRemote = converterViewRemote.getConverterModelRemote();


        Command command = null;

        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("C2F")) {
            double num1 = Double.parseDouble(jTextFieldCelsius.getText());
            command = new C2FCommand(converterModelRemote, num1);
            commandProcessor.execute(command);
        }
        if (actionCommand.equals("F2C")) {
            double num2 = Double.parseDouble(jTextFieldFahrenheit.getText());
            command = new F2CCommand(converterModelRemote, num2);
            commandProcessor.execute(command);
            
        }
        if (actionCommand.equals("Exit")) {
            command = new ExitCommand(converterModelRemote, converterViewRemote);
            commandProcessor.execute(command);
            
        }
    }

}
