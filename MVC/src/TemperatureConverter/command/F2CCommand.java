package TemperatureConverter.command;

import TemperatureConverter.ConverterModel;

public class F2CCommand extends Command{

    private double fahrenheit;

    public F2CCommand(ConverterModel converterModelRemote, double f) {
        super(converterModelRemote);
        this.fahrenheit = f;
    }

    @Override
    public void execute() {
        converterModelRemote.convertF2C(fahrenheit);
    }
}
