package TemperatureConverter.command;

import TemperatureConverter.ConverterModel;

public class C2FCommand extends Command {

    private double Celsius;

    public C2FCommand(ConverterModel converterModelRemote, double Celsius) {
        super(converterModelRemote);
        this.Celsius = Celsius;
    }

    @Override
    public void execute() {
        converterModelRemote.convertC2F(Celsius);
    }
}
