package TemperatureConverter.command;

import javax.swing.JFrame;

import TemperatureConverter.ConverterModel;

public class ExitCommand extends Command{
private JFrame frame;

    public ExitCommand(ConverterModel converterModelRemote, JFrame jFrame) {
        super(converterModelRemote);
        this.frame = jFrame;
    }

    @Override
    public void execute() {
        frame.dispose();
    }
}
